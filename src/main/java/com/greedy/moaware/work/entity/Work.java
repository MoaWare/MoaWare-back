package com.greedy.moaware.work.entity;

import java.util.Date;

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
@Table(name="WORK")
public class Work {
	
	@Column(name="WORK_TIME")
	private Date workTime;
	
	@Column(name="QUIT_TIME")
	private Date quitTimel;
	
	@Column(name="WORK_STATUS")
	private String workStatus;
	
	@Id
	@ManyToOne
	@JoinColumn(name="EMP_CODE")
	private Emp employee;
	
	@Id
	@Column(name="WORK_DATE")
	private Date workDate;
	
	
}
