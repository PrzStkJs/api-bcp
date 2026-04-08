package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.TCB_MONEDA;
import com.bcp.api.model.TCB_MONEDA_ID;

@Repository
public interface TCB_MONEDA_REPOSITORY extends JpaRepository<TCB_MONEDA, TCB_MONEDA_ID> {
}