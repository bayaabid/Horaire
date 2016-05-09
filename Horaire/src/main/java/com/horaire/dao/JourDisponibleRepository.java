package com.horaire.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.horaire.model.JourDisponible;
import com.horaire.model.Semaine;
import com.horaire.model.User;

@Transactional
public interface JourDisponibleRepository extends JourParentRepository<JourDisponible> {
	
	public JourDisponible findByDateJour(Date date);
	
	@Query("select j.users from Jour j  where j.semaine.idSemaine =:idSemaine")
	public List<User> findJourUserSemaine(@Param("idSemaine") Long idSemaine);
	
	@Query("select j from Jour j inner join j.users u  where u.id =:id and j.semaine.idSemaine =:idSemaine")
	public List<JourDisponible> findAllJoursDisponibleSeamineUser(@Param("id")Long id ,
															@Param("idSemaine")Long idSemaine);
	@Query("select j.users from Jour j where j.dateJour =:dateJour")
	public List<User> findAllUsersJourDisponible(@Param("dateJour")Date dateJour);

	@Query("select j from Jour j inner join j.users u where u.id =:id and j.dateJour =:dateJour")
	public JourDisponible findJourDisponibleOfEmploye(@Param("dateJour")Date date, @Param("id")Long id);
	
	@Query("select j.semaine from Jour j where j.dateJour =:dateJour")
	public Semaine getSemaineOfJourDisponible(@Param("dateJour")Date date);

	@Query("select j.users from Jour j where j.ouverture =:ouverture")
	public List<User> findUsersOuvertureDisponible(@Param("ouverture")boolean ouverture);

	@Query("select j.users from Jour j where j.fermeture =:fermeture")
	public List<User> findUsersFermetureOfJourDisponible(@Param("fermeture")boolean fermeture);

	@Query("select j.users from Jour j where j.heureDebut =:heureDebut")
	public List<User> findUsersByHeureDebutJourDisponible(@Param("heureDebut")String heureDebut);
	
	@Query("select j.users from Jour j where j.heureFin =:heureFin")
	public List<User> findUsersByHeureFinJourDisponible(@Param("heureFin")String heureFin);
}
