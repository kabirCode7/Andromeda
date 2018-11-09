package com.andromeda.casediary.models.responsedto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetCaseDetailsResponseDto {
	private GenericResponseMetaData metadata;
	private Integer caseId;
	private String  caseType;
	private String caseStatus;
	private String chargesPressed;
	private String plaintiffName;
	private String defendantName;
	private String firNumber;
	private String casePoliceStation;
	private String witness;
	private Long incedentDate;
	private Long firTakenDate;
	private Long nextHearingDate;
	private String courtName;
	private String presentJudgeName;
	private String plaintiffLawyerName;
	private String defendantLawyerName;
	private Date createdDate;
	private Date updatedDate;
}
