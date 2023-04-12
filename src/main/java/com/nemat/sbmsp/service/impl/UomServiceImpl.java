package com.nemat.sbmsp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemat.sbmsp.model.Uom;
import com.nemat.sbmsp.repo.UomRepo;
import com.nemat.sbmsp.service.UomService;

@Service
public class UomServiceImpl implements UomService{

	@Autowired
	private UomRepo repo;
	
	@Override
	public Integer saveUom(Uom uom) {
		// TODO Auto-generated method stub
		return repo.save(uom).getId();
	}

	@Override
	public void updateUom(Uom uom) {
		// TODO Auto-generated method stub
		repo.save(uom);
	}

	@Override
	public void deleteUom(Integer id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
		
	}

	@Override
	public Uom getOneUom(Integer id) {
		// TODO Auto-generated method stub
		Optional<Uom> ou= repo.findById(id);
		if(ou.isPresent()) {
			return ou.get();
		}
		return null;
	}

	@Override
	public List<Uom> getAllUom() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

}
