package com.greedy.moaware.leave.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.greedy.moaware.employee.entity.Emp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="LEAVE")
public class Leave {

	@Id
	@ManyToOne
	@JoinColumn(name="EMP_CODE")
	private Emp employee;
	
	@Column(name="LEAVE_TOTAL_DAY")
	private String leaveTotalDay;
	
	@Column(name="LEAVE_YEAR")
	private int leaveYear;
	
	@Column(name="LEAVE_USE_DAY")
	private String leaveUseDay;
	
}
