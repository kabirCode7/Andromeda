package com.andromeda.casediary.service;

import java.util.List;

import com.andromeda.casediary.models.requestdto.CreateCaseRequestDTO;
import com.andromeda.casediary.models.responsedto.CreateCaseResponseDto;
import com.andromeda.casediary.models.responsedto.GetCaseDetailsResponseDto;

public interface CaseDetailsService {
    public CreateCaseResponseDto createCase(CreateCaseRequestDTO request);
    public GetCaseDetailsResponseDto getCaseDetailsById(Integer id);
    public List<GetCaseDetailsResponseDto> getAllCases();
}
