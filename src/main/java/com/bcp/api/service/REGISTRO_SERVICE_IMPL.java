package com.bcp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import com.bcp.api.dto.RegistroTemporalDTO;
import com.bcp.api.model.T_PERSONA;
import com.bcp.api.model.T_USUARIO;
import com.bcp.api.model.CAT_TIPO_DOCUMENTO; // Importamos la otra entidad
import com.bcp.api.repository.T_CUENTA_BANCARIA_REPOSITORY;
import com.bcp.api.repository.T_PERSONA_REPOSITORY;
import com.bcp.api.repository.T_USUARIO_REPOSITORY;



@Service
public class REGISTRO_SERVICE_IMPL implements REGISTRO_SERVICE {

@Autowired
private T_PERSONA_REPOSITORY personaRepo;

@Autowired
private T_USUARIO_REPOSITORY usuarioRepo;

@Autowired
private T_CUENTA_BANCARIA_REPOSITORY cuentaRepo;

@Override
@Transactional // Si falla el usuario, se borra la persona (Rollback)
public boolean procesarRegistro(RegistroTemporalDTO dto) {
	if (personaRepo.existsByPER_V_NUMERO_DOCUMENTO(dto.numeroDocumento)) {
        throw new RuntimeException("ERROR_DNI_REPETIDO");
    }
    // 🛡️ 2. Valida Correo (Como el correo vive en T_USUARIO, usamos usuarioRepo)
    if (usuarioRepo.existsByUSR_V_CORREO(dto.correo)) {
        throw new RuntimeException("ERROR_CORREO_REPETIDO");
    }
try {

// --- 1. CREACIÓN DE LA ENTIDAD PERSONA ---

T_PERSONA nuevaPersona = new T_PERSONA();


// Datos Obligatorios Básicos

nuevaPersona.setPER_V_NOMBRE(dto.nombres);
nuevaPersona.setPER_V_APELLIDO(dto.apellidos);
nuevaPersona.setPER_V_NUMERO_DOCUMENTO(dto.numeroDocumento);
nuevaPersona.setPER_V_ESTADO("A"); // Estado Activo obligatorio

// Fecha de Nacimiento (De String a Date)

try {

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
nuevaPersona.setPER_D_NACIMIENTO(sdf.parse(dto.fechaNacimiento));
} catch (Exception e) {
System.err.println("Formato de fecha incorrecto. Usando fecha actual.");
nuevaPersona.setPER_D_NACIMIENTO(new java.util.Date());
}


// 🔥 TRADUCCIÓN DEL TIPO DE DOCUMENTO 🔥

// Convertimos el texto que viene de Swing al ID de la BD
Integer tipoDocId = switch (dto.tipoDocumento) {
case "DNI" -> 1;
case "RUC" -> 2;
case "C.E." -> 3;
case "Pasaporte" -> 4;
default -> 1; // Si por alguna razón falla, le pone DNI por defecto
};


// Creamos el objeto del catálogo y le ponemos el ID

CAT_TIPO_DOCUMENTO cat = new CAT_TIPO_DOCUMENTO();
cat.setTDC_N_ID(tipoDocId); // Asegúrate de que el setter se llame así en esa clase

// Se lo asignamos a la persona
nuevaPersona.setTipoDocumento(cat);

// Datos Opcionales (Teléfono y Dirección)
if (dto.telefono != null && !dto.telefono.trim().isEmpty()) {
nuevaPersona.setPER_V_TELEFONO(dto.telefono);
}

if (dto.direccion != null && !dto.direccion.trim().isEmpty()) {
nuevaPersona.setPER_V_DIRECCION(dto.direccion);
}

// Guardamos en Oracle
T_PERSONA personaGuardada = personaRepo.save(nuevaPersona);



// --- 2. CREACIÓN DE LA ENTIDAD USUARIO ---

T_USUARIO nuevoUsuario = new T_USUARIO();

// Credenciales de acceso

nuevoUsuario.setUSR_V_CORREO(dto.correo);
nuevoUsuario.setUSR_V_PASSWORD(dto.password);
nuevoUsuario.setUSR_V_ESTADO("A"); // Estado Activo obligatorio


// Relación: Vinculamos el usuario con la persona recién creada
nuevoUsuario.setPersona(personaGuardada);

// 1. Guardamos el usuario y CAPTURAMOS el objeto guardado
T_USUARIO usuarioGuardado = usuarioRepo.save(nuevoUsuario);


// CAMBIO 1: Cambiamos el 1 por el 6 (El ID del rol CLIENTE que creamos en Oracle)
usuarioRepo.asignarRolDefault(usuarioGuardado.getUSR_N_ID(), 6);


// CAMBIO 2: REGISTRO EN T_CLIENT
// Detectamos si es empresa o persona natural según el documento
Integer idTipoCliente = switch (dto.tipoDocumento) {
case "RUC" -> 2; // Empresa
default -> 1; // Persona Natural (DNI, Pasaporte, etc.)
};

// Insertamos en la tabla T_CLIENTE usando la persona recién creada
usuarioRepo.registrarComoCliente(personaGuardada.getPER_N_ID(), idTipoCliente);

String ultimoNum = cuentaRepo.findMaxNumeroCuenta();
long proximoNum = (ultimoNum != null) ? Long.parseLong(ultimoNum) + 1 : 1000000001L;
registrarCuentaInicial(personaGuardada.getPER_N_ID(), String.valueOf(proximoNum));

usuarioRepo.flush();
System.out.println("[INFO] Registro exitoso, Rol 6 asignado y guardado en T_CLIENTE y CUENTA CREADA.");
return true;


} catch (Exception e) {
System.err.println("[ERROR] Falló el proceso de registro: " + e.getMessage());
e.printStackTrace();
return false;
	}
}
//Método de apoyo para insertar la cuenta (puedes ponerlo en el repo o aquí)
private void registrarCuentaInicial(Integer personaId, String numeroCuenta) {
    // Buscamos el ID del cliente que se acaba de crear para esa persona
    // (Esto es necesario porque T_CUENTA_BANCARIA apunta a CLI_N_ID)
    // Puedes usar una query nativa en tu repo para esto:
    usuarioRepo.crearCuentaNueva(personaId, numeroCuenta);
}

}
