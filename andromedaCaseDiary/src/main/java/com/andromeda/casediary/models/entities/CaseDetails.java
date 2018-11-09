package com.andromeda.casediary.models.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "CASE_DETAILS")
@Getter
@Setter
public class CaseDetails {
	@Id
	@GeneratedValue
	private Integer caseId;
	private String  caseType;
	private String caseStatus;
	private String chargesPressed;
	private String plaintiffName;
	private String defendantName;
	private String firNumber;
	private String casePoliceStation;
	private String witness;
	private Date incedentDate;
	private Date firTakenDate;
	private Date nextHearingDate;
	private String courtName;
	private String presentJudgeName;
	private String plaintiffLawyerName;
	private String defendantLawyerName;
	private Date createdDate;
	private String updatedDate;
	
	
	
	
	
}
