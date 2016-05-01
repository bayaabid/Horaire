package com.horaire.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_JOUR" ,
					discriminatorType = DiscriminatorType.STRING ,length = 3)
public abstract class Jour implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idJour ;
	
	
	private JourSemaine jourSemaine ;
	
	private String heureDebut ;
	
	private String HeureFin ;
	
	private String fermeture ;
	
	@Temporal(TemporalType.DATE)
	private Date dateJour ;
	
	@ManyToOne
	@JoinColumn
	private Semaine semaine ;
	
	@ManyToMany
	@JoinTable
	private List<User>users  ;

	public Jour() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jour(JourSemaine jourSemaine, Date dateJour, Semaine semaine) {
		super();
		this.jourSemaine = jourSemaine;
		this.dateJour = dateJour;
		this.semaine = semaine;
	}

	public Long getIdJour() {
		return idJour;
	}

	public void setIdJour(Long idJour) {
		this.idJour = idJour;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return HeureFin;
	}

	public void setHeureFin(String heureFin) {
		HeureFin = heureFin;
	}

	public String getFermeture() {
		return fermeture;
	}

	public void setFermeture(String fermeture) {
		this.fermeture = fermeture;
	}

	

	public JourSemaine getJourSemaine() {
		return jourSemaine;
	}

	public void setJourSemaine(JourSemaine jourSemaine) {
		this.jourSemaine = jourSemaine;
	}

	public Date getDateJour() {
		return dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	public Semaine getSemaine() {
		return semaine;
	}

	public void setSemaine(Semaine semaine) {
		this.semaine = semaine;
	}
	
	

}
