package com.nemat.sbmsp.service;

import java.util.List;
import java.util.Optional;

import com.nemat.sbmsp.model.ShipmentType;

public interface ShipmentTypeService {
	
	public Integer saveShipmetType(ShipmentType st);
	void updateShipmentType(ShipmentType st);
	void deleteShipmentType(Integer id);
	
	Optional<ShipmentType> getOneShipmentType(Integer id);
	List<ShipmentType> getAllShipmentType();
	boolean isShipmentTypeExist( Integer id);

}
