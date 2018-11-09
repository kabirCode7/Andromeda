package com.andromeda.casediary.repository;

import org.springframework.data.repository.CrudRepository;

import com.andromeda.casediary.models.entities.CaseDetails;



public interface CaseDetailsJpaDao extends CrudRepository<CaseDetails, Integer> {
	
}
