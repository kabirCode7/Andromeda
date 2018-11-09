package com.andromeda.casediary.models.responsedto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCaseResponseDto {
	private GenericResponseMetaData metaData;
	private Integer caseId;
}
