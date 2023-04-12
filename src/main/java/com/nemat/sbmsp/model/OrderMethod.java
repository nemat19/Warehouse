package com.nemat.sbmsp.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_method")	//optional
public class OrderMethod {
	
	@Id
	@GeneratedValue(generator = "om_gen")
	@SequenceGenerator(name="om_gen",sequenceName = "om_gen_seq")
	private Integer id;

	private String orderMode;
	@Column(name = "order_code")	//optional
	private String orderCode;
	private String orderType;
	
	/*For checkbox and multi-select, a separate child table is created */
//	To provide table name : @joinColumn(name="")
//	To provide column1 name : @JoinColumn(name="")
//	To provide column2 name : @Column(name="")
	
	@ElementCollection()
	@CollectionTable(name = "ord_acpt_tab",
						joinColumns = @JoinColumn(name = "id"))	//optional
	@Column(name = "order_acpt")	//optional
	private List<String> orderAcpt;
	
	private String description;
}
