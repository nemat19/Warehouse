package com.nemat.sbmsp.service;

import java.util.List;
import java.util.Optional;

import com.nemat.sbmsp.model.OrderMethod;

public interface OrderMethodService {

	public Integer saveOrderMethod(OrderMethod st);
	void updateOrderMethod(OrderMethod st);
	void deleteOrderMethod(Integer id);
	
	Optional<OrderMethod> getOneOrderMethod(Integer id);
	List<OrderMethod> getAllOrderMethod();
	boolean isOrderMethodExist( Integer id);
}
