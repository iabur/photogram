package com.spring5.practice.model;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tbl_country")
@Where(clause = "is_active = 1")
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "country_name", nullable = false)
	private String countryName;
	@Column(name="is_active")
	private Boolean active = true;

	public Country() {
		super();
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	@Override
	public String toString() {
		return "Country{" +
				"id=" + id +
				", countryName='" + countryName + '\'' +
				'}';
	}
}
