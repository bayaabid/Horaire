package com.horaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horaire.model.HeureDebutFin;

public interface HeureDebutFinRepository extends JpaRepository<HeureDebutFin, Long> {

}
