package com.horaire.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.horaire.model.JourTravail;
import com.horaire.model.Semaine;
import com.horaire.model.User;

@Transactional
public interface JourTravailRepository extends JourParentRepository<JourTravail> {
	
	public JourTravail findByDateJour(Date date);
	
	@Query("select j.users from Jour j  where j.semaine.idSemaine =:idSemaine")
	public List<User> findJourUserSemaine(@Param("idSemaine") Long idSemaine);
	
	@Query("select j from Jour j inner join j.users u  where u.id =:id and j.semaine.idSemaine =:idSemaine")
	public List<JourTravail> findAllJoursTravailSeamineUser(@Param("id")Long id ,
															@Param("idSemaine")Long idSemaine);
	@Query("select j.users from Jour j where j.dateJour =:dateJour")
	public List<User> findAllUsersJourTravail(@Param("dateJour")Date dateJour);

	@Query("select j from Jour j inner join j.users u where u.id =:id and j.dateJour =:dateJour")
	public JourTravail findJourTravailOfEmploye(@Param("dateJour")Date date, @Param("id")Long id);
	
	@Query("select j.semaine from Jour j where j.dateJour =:dateJour")
	public Semaine getSemaineOfJourTravail(@Param("dateJour")Date date);

}
