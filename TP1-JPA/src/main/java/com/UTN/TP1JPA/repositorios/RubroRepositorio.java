package com.UTN.TP1JPA.repositorios;

import com.UTN.TP1JPA.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepositorio extends JpaRepository<Rubro, Long> {

}
