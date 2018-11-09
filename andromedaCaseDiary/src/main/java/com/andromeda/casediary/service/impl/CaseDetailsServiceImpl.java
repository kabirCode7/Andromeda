package com.andromeda.casediary.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.andromeda.casediary.models.entities.CaseDetails;
import com.andromeda.casediary.models.requestdto.CreateCaseRequestDTO;
import com.andromeda.casediary.models.responsedto.CreateCaseResponseDto;
import com.andromeda.casediary.models.responsedto.GenericResponseMetaData;
import com.andromeda.casediary.models.responsedto.GetCaseDetailsResponseDto;
import com.andromeda.casediary.repository.CaseDetailsJpaDao;
import com.andromeda.casediary.service.CaseDetailsService;

@Service
public class CaseDetailsServiceImpl implements CaseDetailsService {
	@Autowired
	private CaseDetailsJpaDao caseDetailsJpaDao;

	@Override
	public CreateCaseResponseDto createCase(CreateCaseRequestDTO request) {
		CreateCaseResponseDto response = new CreateCaseResponseDto();
		GenericResponseMetaData metadata = new GenericResponseMetaData();
		try {
			System.out.println("inside service ");
			CaseDetails caseDetails = createJpaFromRequestObject(request);
			caseDetailsJpaDao.save(caseDetails);
			metadata.setHttpstatus(HttpStatus.ACCEPTED);
			response.setCaseId(caseDetails.getCaseId());
			response.setMetaData(metadata);

		} catch (Exception e) {
			e.printStackTrace();
			metadata.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			metadata.setMessage("OOPS, something went wrong !! Shame on us");
			metadata.setErrorStackTrace(e.getMessage() + " " + e.getCause());
			response.setMetaData(metadata);
		}
		return response;
	}

	@Override
	public GetCaseDetailsResponseDto getCaseDetailsById(Integer id) {
		GetCaseDetailsResponseDto response = null;
		GenericResponseMetaData metaData= new GenericResponseMetaData();
		try {
			Optional<CaseDetails> caseDetails = caseDetailsJpaDao.findById(id);
			if (caseDetails.isPresent()) {
				response=createObjectFromJpa(caseDetails.get());
				metaData.setHttpstatus(HttpStatus.ACCEPTED);
				
			}else {
				metaData.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
				metaData.setMessage("Invalid Case Id");
				response.setMetadata(metaData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			metaData.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			metaData.setMessage("OOPS, something went wrong !! Shame on us");
			metaData.setErrorStackTrace(e.getMessage() + " " + e.getCause());
			response.setMetadata(metaData);
		}

		return response;
	}
	
	@Override
	public List<GetCaseDetailsResponseDto> getAllCases(){
		
		List<GetCaseDetailsResponseDto> caseList = null;
		GenericResponseMetaData metaData= new GenericResponseMetaData();
		
		try {
			List<CaseDetails> caseDetailsAll = (List<CaseDetails>) caseDetailsJpaDao.findAll();
			if (caseDetailsAll==null && !caseDetailsAll.isEmpty()) {
				for(CaseDetails caseDetails: caseDetailsAll) {
					GetCaseDetailsResponseDto responseObject=createObjectFromJpa(caseDetails);
				}
				metaData.setHttpstatus(HttpStatus.ACCEPTED);
				
			}else {
				metaData.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
				metaData.setMessage("Invalid Case Id");
				response.setMetadata(metaData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			metaData.setHttpstatus(HttpStatus.INTERNAL_SERVER_ERROR);
			metaData.setMessage("OOPS, something went wrong !! Shame on us");
			metaData.setErrorStackTrace(e.getMessage() + " " + e.getCause());
			response.setMetadata(metaData);
		}

		return response;
		return null;
		
	}

	public CaseDetails createJpaFromRequestObject(CreateCaseRequestDTO request) {
		CaseDetails caseDetails = new CaseDetails();
		caseDetails.setCasePoliceStation(request.getCasePoliceStation());
		caseDetails.setCaseStatus(request.getCaseStatus());
		caseDetails.setCaseType(request.getCaseType());
		caseDetails.setChargesPressed(request.getChargesPressed());
		caseDetails.setCourtName(request.getCourtName());
		caseDetails.setCreatedDate(new Date());
		caseDetails.setDefendantLawyerName(request.getDefendantLawyerName());
		caseDetails.setDefendantName(request.getDefendantName());
		caseDetails.setFirNumber(request.getFirNumber());
		if (request.getFirTakenDate() != null)
			caseDetails.setFirTakenDate(new Date(request.getFirTakenDate()));
		if (request.getIncedentDate() != null)
			caseDetails.setIncedentDate(new Date(request.getIncedentDate()));
		if (request.getNextHearingDate() != null)
			caseDetails.setNextHearingDate(new Date(request.getNextHearingDate()));
		caseDetails.setPlaintiffLawyerName(request.getPlaintiffLawyerName());
		caseDetails.setPlaintiffName(request.getPlaintiffName());
		caseDetails.setPresentJudgeName(request.getPresentJudgeName());
		caseDetails.setWitness(request.getWitness());
		return caseDetails;

	}

	public GetCaseDetailsResponseDto createObjectFromJpa(CaseDetails caseDetails) {
		GetCaseDetailsResponseDto response = new GetCaseDetailsResponseDto();
		response.setCasePoliceStation(caseDetails.getCasePoliceStation());
		response.setCaseStatus(caseDetails.getCaseStatus());
		response.setCaseType(caseDetails.getCaseType());
		response.setChargesPressed(caseDetails.getChargesPressed());
		response.setCourtName(caseDetails.getCourtName());
		response.setCreatedDate(new Date());
		response.setDefendantLawyerName(caseDetails.getDefendantLawyerName());
		response.setDefendantName(caseDetails.getDefendantName());
		response.setFirNumber(caseDetails.getFirNumber());
		if (caseDetails.getFirTakenDate() != null)
			response.setFirTakenDate(caseDetails.getFirTakenDate().getTime());
		if (caseDetails.getIncedentDate() != null)
			response.setIncedentDate(caseDetails.getIncedentDate().getTime());
		if (caseDetails.getNextHearingDate() != null)
			response.setNextHearingDate(caseDetails.getNextHearingDate().getTime());
		response.setPlaintiffLawyerName(caseDetails.getPlaintiffLawyerName());
		response.setPlaintiffName(caseDetails.getPlaintiffName());
		response.setPresentJudgeName(caseDetails.getPresentJudgeName());
		response.setWitness(caseDetails.getWitness());
		return response;

	}

}
