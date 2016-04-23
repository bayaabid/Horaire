package com.horaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horaire.model.Jour;

public interface JourRepository extends JpaRepository<Jour, Long>{

}
