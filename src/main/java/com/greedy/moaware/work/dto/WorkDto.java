package com.greedy.moaware.work.dto;

import java.util.Date;

import com.greedy.moaware.employee.dto.EmpDto;

import lombok.Data;

@Data
public class WorkDto {

	private Date workTime;

	private Date quitTimel;
	
	private String workStatus;
	
	private EmpDto employee;
	
	private Date workDate;
}
