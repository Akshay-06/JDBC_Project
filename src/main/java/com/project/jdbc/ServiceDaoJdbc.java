package com.project.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.project.dao.ServiceDao;
import com.project.model.Service;

public class ServiceDaoJdbc implements ServiceDao {

	public Connection getConnection() {
		DatabaseConfig dbConfig = new DatabaseConfig();
		return dbConfig.connectToDatabase();
	}

	@Override
	public int addService(Service service) {

		String query = "insert into service(service_name,service_fee,created_by,modified_by) values (?,?,?,?)";
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, service.getServiceName());
			ps.setBigDecimal(2, service.getServiceFee());
			ps.setString(3, service.getCreatedBy());
			ps.setString(4, service.getModifiedBy());

			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Service getService(String service_name) {

		String query = "select * from service where service_name=?";
		Connection con = getConnection();
		Service service;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, service_name);

			rs = ps.executeQuery();
			rs.next();
			String serviceName = rs.getString("service_name");
			int serviceId = rs.getInt("service_id");
			BigDecimal service_fee = rs.getBigDecimal("service_fee");
			String createdBy = rs.getString("created_by");
			String modifiedBy = rs.getString("modified_by");
			Timestamp createdAt = rs.getTimestamp("created_at");
			Timestamp modifiedAt = rs.getTimestamp("modified_at");
			service = new Service(serviceId, serviceName, service_fee, createdAt, modifiedAt, createdBy, modifiedBy);

			return service;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateService(Service service) {
		String query = "update service set service_fee=? where service_name=?";
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setBigDecimal(1, service.getServiceFee());
			ps.setString(2, service.getServiceName());

			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// TODO Auto-generated method stub
		return 0;
		
		
	}

	@Override
	public int deleteService(String service_name) {
		
		String query = "delete from service where service_name=?";
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, service_name);

			int count = ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
