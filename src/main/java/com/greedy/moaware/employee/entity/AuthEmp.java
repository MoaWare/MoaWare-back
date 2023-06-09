package com.greedy.moaware.employee.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="EMPLOYEE")
@DynamicInsert
public class AuthEmp {
	
	@Id
	@Column(name="EMP_CODE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empCode;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_ID")
	private String empId;
	
	@Column(name="EMP_PWD")
	private String empPwd;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="RETIRE_YN") 
	private String retireYn;

	@Column(name="PHONE") 
	private String phone;
	
	@Column(name="EXTENSION_NUM") 
	private String extensionNum;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="EMP_CODE")
	private List<Role> roleList;
	
	@Column(name="HIRE_DATE") 
	private Date hireDate;
	  
	
	
	

}