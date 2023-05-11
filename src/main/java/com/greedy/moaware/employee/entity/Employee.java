package com.greedy.moaware.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Employee")
@SequenceGenerator(name="EMP_SEQ_GENERATOR", sequenceName="SEQ_EMP_CODE", initialValue=1, allocationSize=1)
public class Employee {
	
	@Id
	@Column(name="EMP_CODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ_GENERATOR")
	private Integer empCode;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMP_ID")
	private String empID;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="RETIRE_YN")
	private String retireYn;
	
	@Column(name="HIRE_DATE")
	private Date hireDate;
	
	@Column(name="EXTENSION_NUM")
	private String extensionNum;
	
	@Column(name="EMP_SSI")
	private String empSsi;
	
	@ManyToOne
	@JoinColumn(name="JOB_CODE")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name="DEPT_CODE")
	private Department dept;
	
	

}
