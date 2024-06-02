package com.project.dao;

import java.math.BigDecimal;

import com.project.model.Service;

public interface ServiceDao {
	int addService(Service service);

	Service getService(String service_name);

	int updateService(Service service);
	
	int deleteService(String service_name);
}
