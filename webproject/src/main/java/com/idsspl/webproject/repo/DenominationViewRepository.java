package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idsspl.webproject.entity.DenominationViewEntity;


@Repository
public interface DenominationViewRepository extends JpaRepository<DenominationViewEntity, Long> {
	
	@Query("SELECT a FROM DenominationViewEntity a WHERE a.agentName = :agentName ")
	public List<DenominationViewEntity> findInfoByAgentName(@Param("agentName") String agentName);
	
	
}