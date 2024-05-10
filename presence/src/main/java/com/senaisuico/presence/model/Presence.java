package com.senaisuico.presence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "presence_table")
public class Presence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "date_birth", nullable = false)
    private String date_birth;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "professional_goal", nullable = false)
	private String professional_goal;
	
    @Column(name = "neighborhood", nullable = false)
    private String neighborhood;
   
    
    public Presence() {}

    public Presence(Long id, String name, String date_birth, String email, String professional_goal,
    		String neighborhood) {
		
		this.id = id;
		this.name = name;
		this.date_birth = date_birth;
		this.email = email;
		this.professional_goal = professional_goal;
		this.neighborhood = neighborhood;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_birth() {
		return date_birth;
	}

	public void setDate_birth(String date_birth) {
		this.date_birth = date_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfessional_goal() {
		return professional_goal;
	}

	public void setProfessional_goal(String professional_goal) {
		this.professional_goal = professional_goal;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
   
}