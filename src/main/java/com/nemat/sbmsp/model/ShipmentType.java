package com.nemat.sbmsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class ShipmentType {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 10, nullable = false)
	private String shipmentMode;
	private String shipmentCode;
	private String enableShipment;
	
	private String shipmentGrade;
	private String description;
	
}
