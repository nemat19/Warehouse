package com.nemat.sbmsp.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nemat.sbmsp.model.OrderMethod;
import com.nemat.sbmsp.repo.OrderMethodRepo;
import com.nemat.sbmsp.service.OrderMethodService;

@Service
public class OrderMethodServiceImpl implements OrderMethodService {

	@Autowired
	private OrderMethodRepo repo;
	
	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		return repo.save(om).getId();
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		repo.save(om);
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<OrderMethod> getOneOrderMethod(Integer id) {
		Optional<OrderMethod> oom = repo.findById(id);
		return oom;
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethod() {
		// TODO Auto-generated method stub
		List<OrderMethod> stList = repo.findAll();
		return stList;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isOrderMethodExist(Integer id) {
		// TODO Auto-generated method stub
		Boolean exist = repo.existsById(id);
		return exist;
	}


}
