package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bin.Employee;
import com.util.EmployeeUtil;


public class EmployeeDao {
	public static void insertEmployee(Employee s) {
		try {
			Connection conn = EmployeeUtil.creatConnection();
			String sql="insert into employee(fname,lname,email,mobile,address,gender) value(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getMobile());
			pst.setString(5, s.getAddress());
			pst.setString(6, s.getGender());
			pst.executeUpdate();
		} catch (Exception e) {
            e.printStackTrace();
		}
	}

	public static List<Employee> getAllEmployees(){
		List<Employee>  List=new ArrayList<Employee>();
		try {
			Connection conn=EmployeeUtil.creatConnection();
			String sql="Select * from employee";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Employee s=new Employee();
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setEmail(rs.getString("email"));					
			    s.setMobile(rs.getString("mobile"));
			    s.setAddress(rs.getString("Address"));
			    s.setGender(rs.getString("Gender"));
			    List.add(s);
			}
		} catch (Exception e) {
            e.printStackTrace();
		}
		return List;
	}
	public static Employee getEmployees(int id){
		Employee s=null;
		try {
			Connection conn=EmployeeUtil.creatConnection();
			String sql="Select * from employee where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				s=new Employee();
				s.setId(rs.getInt("id"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setEmail(rs.getString("email"));				
			    s.setMobile(rs.getString("mobile"));
			    s.setAddress(rs.getString("Address"));
			    s.setGender(rs.getString("Gender"));
			   
			}
		} catch (Exception e) {
            e.printStackTrace();
		}
		return s;
	}
	public static void updateEmployee(Employee s) {
		try {
			Connection conn =EmployeeUtil.creatConnection();
			String sql="update employee set fname=?, lname=?,email=?,mobile=?, address=?,gender=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, s.getFname());
			pst.setString(2, s.getLname());
			pst.setString(3, s.getEmail());
			pst.setString(4, s.getMobile());
			pst.setString(5, s.getAddress());
			pst.setString(6, s.getGender());
			pst.setInt(7, s.getId());
			pst.executeUpdate();
		} catch (Exception e) {
            e.printStackTrace();
		}
	}
	
	public static void deleteEmployee(int id) {
		try {
			Connection conn=EmployeeUtil.creatConnection();
			String sql="delete from employee where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			
			
					
			
		} catch (Exception e) {
            e.printStackTrace();
		}
	}


}

