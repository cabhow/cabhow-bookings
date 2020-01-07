package com.cabhow.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@ToString
public class Customer extends AuditModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID")
	private long id;
	// @JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "customer", allowSetters = true)
	private List<Booking> booking;
	@Column(name = "NAME")
	private String custName;
	@Column(name = "EMAIL")
	private String custEmail;
	@Column(name = "PHONE")
	private long phone;

}
