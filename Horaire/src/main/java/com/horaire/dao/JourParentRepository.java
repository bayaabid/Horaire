package com.horaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.horaire.model.Jour;

@NoRepositoryBean
public interface JourParentRepository<T extends Jour> extends JpaRepository<T, Long>{
	
	/*@Query("select u from #{#entityName} as u where u.email = ?1 ")
	  T findByEmail(String email);*/

}
