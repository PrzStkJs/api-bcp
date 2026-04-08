package com.bcp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bcp.api.dto.TransferenciaDTO;
import com.bcp.api.dto.HomeResumenDTO;
import com.bcp.api.dto.PagoServicioDTO;
import com.bcp.api.service.HomeServiceImpl;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private HomeServiceImpl homeService; 


    @GetMapping("/resumen")
    public HomeResumenDTO getResumen(@RequestParam("dni") String dni) {
        return homeService.obtenerResumen(dni);
    }
    

    @PostMapping("/aperturar")
    public String aperturarCuenta(@RequestParam("dni") String dni) {
        return homeService.aperturarCuentaCorriente(dni);
    }
    
    @PostMapping("/transferir")
    public String transferir(@RequestBody TransferenciaDTO dto) {
        try {
            return homeService.ejecutarTransferencia(dto);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    @PostMapping("/pagar-servicio")
    public String pagarServicio(@RequestBody PagoServicioDTO dto) {
        try {
            return homeService.ejecutarPagoServicio(dto);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}