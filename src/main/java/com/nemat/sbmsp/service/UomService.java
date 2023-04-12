package com.nemat.sbmsp.service;

import java.util.List;

import com.nemat.sbmsp.model.Uom;

public interface UomService {

	Integer saveUom(Uom uom);
	void updateUom(Uom uom);
	void deleteUom(Integer id);
	Uom getOneUom(Integer id);
	List<Uom> getAllUom();
	
}
