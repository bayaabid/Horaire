package com.horaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horaire.model.Disponible;

public interface DisponibleRepository extends JpaRepository<Disponible, Long> {

}
