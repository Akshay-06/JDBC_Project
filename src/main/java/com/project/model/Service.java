package com.project.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record Service(int serviceId, String serviceName, BigDecimal serviceFee, Timestamp createdAt,
		Timestamp modifiedAt, String createdBy, String modifiedBy) {

}
