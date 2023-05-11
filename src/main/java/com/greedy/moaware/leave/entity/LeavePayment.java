package com.greedy.moaware.leave.entity;

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

import com.greedy.moaware.employee.entity.Emp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="LEAVE_PAYMENT")
@SequenceGenerator(name="LEAVE_SEQ_GENERATOR", sequenceName="SEQ_LEAVE_CODE", initialValue=1, allocationSize=1)
public class LeavePayment {
	
	@Id
	@Column(name="LEAVE_CODE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LEAVE_SEQ_GENERATOR")
	private Integer leaveCode;
	
	@Column(name="LEAVE_START_DAY")
	private Date leaveStartDay;
	
	@Column(name="LEAVE_TYPE")
	private String leaveType;
	
	@Column(name="LEAVE_REQ_DATE")
	private Date leaveReqDate;
	
	@ManyToOne
	@JoinColumn(name="EMP_CODE")
	private Emp emplyoee;
	
	@Column(name="L_PAY_STATUS")
	private String lPayStatus;
	
	@ManyToOne
	@JoinColumn(name="EMP_CODE")
	private Emp payEmp;
	
	@Column(name="L_PAY_DATE")
	private Date lPayDate;
	
	@Column(name="L_FINAL_PAY_DATE")
	private Date lFinalPayDate;
	
	@ManyToOne
	@JoinColumn(name="EMP_CODE")
	private Emp payFinalEmp;
	
	@Column(name="LEAVE_END_DATE")
	private Date leaveEndDate;
	
	
	
	
	
}