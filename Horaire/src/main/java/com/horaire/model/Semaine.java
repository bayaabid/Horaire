package com.horaire.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Semaine implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSemaine ; 
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut ;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin ;
	
	@OneToMany(mappedBy = "semaine")
	private List<Jour> jours ;

	public Semaine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Semaine(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getIdSemaine() {
		return idSemaine;
	}

	public void setIdSemaine(Long idSemaine) {
		this.idSemaine = idSemaine;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public List<Jour> getJours() {
		return jours;
	}

	public void setJours(List<Jour> jours) {
		this.jours = jours;
	}
	
	
	
}

