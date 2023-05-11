package com.greedy.moaware.leave.dto;

import com.greedy.moaware.employee.dto.EmpDto;

import lombok.Data;

@Data
public class LeaveDto {

	private EmpDto employee;
	
	private String leaveTotalDay;
	
	private int leaveYear;
	
	private String leaveUseDay;
	
}
