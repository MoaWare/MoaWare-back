package com.greedy.moaware.admin.emp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import com.greedy.moaware.employee.entity.Dept;
import com.greedy.moaware.employee.entity.FileCategory;
import com.greedy.moaware.employee.entity.Job;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DynamicInsert
@Table(name="EMPLOYEE")
public class AdminEmp {
	
	@Id
	@Column(name="EMP_CODE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empCode;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMP_ID")
	private String empID;
	
	@Column(name="EMP_PWD")
	private String empPwd;
	 
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="RETIRE_YN")
	private String retireYn;
	
	
	@Column(name="HIRE_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
	private Dept dept;

	
	public void update(String retireYn) {
		this.retireYn = retireYn;
		
	}


	public void update
	(Integer empCode, String empName, String phone,
			String empID, Job job, Dept dept) {
	
		this.empCode = empCode;
		this.empName = empName;
		this.phone = phone;
		this.empID = empID;
		this.job = job;
		this.dept = dept;

	}
	

	
	

}