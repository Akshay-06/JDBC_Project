package com.project.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Service {

	
	private int serviceId;
	private String serviceName;
	private BigDecimal serviceFee;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	private String createdBy;
	private String modifiedBy;
	
	
	@Override
	public String toString() {
		return "Service [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceFee=" + serviceFee
				+ ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + "]";
	}
	public Service(int serviceId, String serviceName, BigDecimal serviceFee, Timestamp createdAt, Timestamp modifiedAt,
			String createdBy, String modifiedBy) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceFee = serviceFee;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public BigDecimal getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
