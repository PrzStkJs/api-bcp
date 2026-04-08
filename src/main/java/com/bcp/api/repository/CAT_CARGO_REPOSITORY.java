package com.bcp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bcp.api.model.CAT_CARGO;

@Repository
public interface CAT_CARGO_REPOSITORY extends JpaRepository<CAT_CARGO, Integer> {
}