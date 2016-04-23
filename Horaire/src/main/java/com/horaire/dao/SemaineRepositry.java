package com.horaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horaire.model.Semaine;

public interface SemaineRepositry extends JpaRepository<Semaine, Long> {

}
