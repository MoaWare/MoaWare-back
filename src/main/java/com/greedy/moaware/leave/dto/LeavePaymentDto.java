package com.greedy.moaware.leave.dto;

import java.util.Date;

import com.greedy.moaware.employee.dto.EmpDto;
import com.greedy.moaware.employee.entity.Emp;

import lombok.Data;

@Data
public class LeavePaymentDto {

	private Integer leaveCode;
	
	private Date leaveStartDay;
	
	private String leaveType;
	
	private Date leaveReqDate;
	
	private Emp emplyoee;
	
	private String lPayStatus;
	
	private EmpDto payEmp;
	
	private Date lPayDate;
	
	private Date lFinalPayDate;
	
	private EmpDto payFinalEmp;
	
	private Date leaveEndDate;
}
