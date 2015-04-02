package com.cts.sla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sla.model.CaseDetail;

public interface SLACaseRepository extends JpaRepository<CaseDetail, String> {
	public List<CaseDetail> findAllByQueue(String queue);
	public List<CaseDetail> findAllByOwner(String queue);
	public List<CaseDetail> findAllByCaseStatus(String caseStatus);
}
