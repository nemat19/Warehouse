package com.nemat.sbmsp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uom {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String uomType;
	
	private String uomModel;
	private String description;
	

}
