package com.nemat.sbmsp.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nemat.sbmsp.model.ShipmentType;
import com.nemat.sbmsp.repo.ShipmentTypeRepo;
import com.nemat.sbmsp.service.ShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements ShipmentTypeService {

	@Autowired
	private ShipmentTypeRepo repo;
	
	@Override
	@Transactional
	public Integer saveShipmetType(ShipmentType st) {
		// TODO Auto-generated method stub
		return repo.save(st).getId();
	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		repo.save(st);
	}

	@Override
	@Transactional
	public void deleteShipmentType(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ShipmentType> getOneShipmentType(Integer id) {
		Optional<ShipmentType> ost = repo.findById(id);
		return ost;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentType() {
		// TODO Auto-generated method stub
		List<ShipmentType> stList = repo.findAll();
		return stList;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isShipmentTypeExist(Integer id) {
		// TODO Auto-generated method stub
		Boolean exist = repo.existsById(id);
		return exist;
	}


}
