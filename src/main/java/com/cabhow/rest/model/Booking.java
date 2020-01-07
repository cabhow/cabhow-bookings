package com.cabhow.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BOOKING")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdDate", "updatedDate" }, allowGetters = true)
@Getter
@Setter
@ToString
public class Booking extends AuditModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID")
	private long id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID", foreignKey = @ForeignKey(name = "FK_BOOKING_CUST_ID"))
	@JsonIgnoreProperties(value = "booking", allowSetters = true)
	private Customer customer;
	@Column(name = "SOURCE_CITY")
	private String sourceCity;
	// private String sourceAddress;
	@Column(name = "DEST_CITY")
	private String destinationCity;
	// private String destinationAddress;
	@Column(name = "TRIP_START_DATE")
	private Date tripStartDate;
	@Column(name = "TRIP_END_DATE")
	private Date tripEndDate;
	@Column(name = "TYPE_OF_VEHICLE")
	private int typeOfVehicle;
}
