package com.andromeda.casediary.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.casediary.models.entities.CaseDetails;
import com.andromeda.casediary.models.requestdto.CreateCaseRequestDTO;
import com.andromeda.casediary.models.responsedto.CreateCaseResponseDto;
import com.andromeda.casediary.models.responsedto.GenericResponseMetaData;
import com.andromeda.casediary.service.CaseDetailsService;
import com.andromeda.casediary.utility.CommonUtilities;

@RestController
public class CaseDetailsRestController {

	@Autowired
	private CaseDetailsService caseDetailsService;

	@RequestMapping(value="/cases",method=RequestMethod.POST)
	public String storeCaseDetails(@RequestBody CreateCaseRequestDTO createCaseRequestDTO) {
		//CreateCaseRequestDTO createCaseRequestDTO = null;
		CreateCaseResponseDto response = null;
		GenericResponseMetaData metadata = new GenericResponseMetaData();
		String responseString = null;

		try {
			System.out.println("here");
			System.out.println("request json :"+createCaseRequestDTO.toString());
			System.out.println(createCaseRequestDTO.toString());
			response = caseDetailsService.createCase(createCaseRequestDTO);
			

		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			metadata.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			metadata.setMessage("OOPS, something went wrong !! Shame on us");
			metadata.setErrorStackTrace(e.getMessage()+" "+e.getCause());
			response.setMetaData(metadata);
			
		}
		responseString = CommonUtilities.ObjectToJsonString(response);
		System.out.println(responseString);
		return responseString;

	}

}
