package com.greedy.moaware.payment.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@Table(name="PAYMENT")
public class Payment {
	
	@Id
	@Column(name="PAY_CODE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer payCode;
	
	@Column(name="DRAFT_DATE")
	private Date draftDate;
	
	@ManyToOne
	@JoinColumn(name="EMP_CODE")
	private PayEmp emp;
	
	@Column(name="DRAFT_TITLE")
	private String draftTitle;
	
	@Column(name="DRAFT_CONTENT")
	private String draftContent;
	
	@Column(name="PAY_STATUS")
	private String payStatus;
	
	@ManyToOne
	@JoinColumn(name="FORM_CODE")
	private Form form;
	
	@OneToOne(mappedBy = "pay") 
	private PayFileCategory payFileCategory;
	
	@OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="PAY_CODE", referencedColumnName="PAY_CODE")  
	private List<PaymentMember> paymentMember;
	
	@OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="PAY_CODE", referencedColumnName="PAY_CODE")  
	private List<RefenceMember> refenceMember;

	@Override
	public String toString() {
		return "Payment [payCode=" + payCode + ", draftDate=" + draftDate + ", emp=" + emp + ", draftTitle="
				+ draftTitle  + ", payStatus=" + payStatus + ", payFileCategory="
				+ payFileCategory + ", paymentMember=" + paymentMember + ", refenceMember=" + refenceMember + "]";
	}

	
	/*임시 저장문서 업데이트 (첨부파일 변경시) */
	public void updatePayment(Integer payCode, Date draftDate, String draftTitle, String draftContent,
			String payStatus, Form form, PayFileCategory payFileCategory, List<PaymentMember> paymentMember,
			List<RefenceMember> refenceMember) {
		this.payCode = payCode;
		this.draftDate = draftDate;
		this.draftTitle = draftTitle;
		this.draftContent = draftContent;
		this.payStatus = payStatus;
		this.form = form;
		this.payFileCategory = payFileCategory;
		this.paymentMember = paymentMember;
		this.refenceMember = refenceMember;
	}
	
	
	/*임시 저장문서 업데이트 (첨부파일 새로등록) */
	public void updatePayment(Integer payCode, Date draftDate, String draftTitle, String draftContent,
			String payStatus, Form form, List<PaymentMember> paymentMember,
			List<RefenceMember> refenceMember) {
		this.payCode = payCode;
		this.draftDate = draftDate;
		this.draftTitle = draftTitle;
		this.draftContent = draftContent;
		this.payStatus = payStatus;
		this.form = form;
		this.paymentMember = paymentMember;
		this.refenceMember = refenceMember;
	}
	
	
	
	
}
