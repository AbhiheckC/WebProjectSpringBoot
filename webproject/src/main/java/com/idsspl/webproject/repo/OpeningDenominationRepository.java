package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idsspl.webproject.entity.OpeningDenominationEntity;
import com.idsspl.webproject.entity.OpeningDenominationId;

public interface OpeningDenominationRepository extends JpaRepository<OpeningDenominationEntity, OpeningDenominationId> {
	
	
//	@Query("SELECT a FROM OpeningDenominationEntity a WHERE a.agentName = :agentName and  a.denominationDate = :denominationdate")
//	public List<OpeningDenominationEntity> finddenoInfoByAgentName(@Param("agentName") String agentName, @Param("denominationdate") String denominationdate);

//	public List<OpeningDenominationEntity> finddenoInfoByAgentName(OpeningDenominationId openingDenominationId);to_char(a.txndate,'YYYY-MM-DD')
	 @Query("SELECT o FROM OpeningDenominationEntity o WHERE o.id.agentId = :agentId AND o.id.denominationDate = :denominationDate")
	    List<OpeningDenominationEntity> findByAgentIdAndDenominationDate(@Param("agentId") String agentId,
	                                                                      @Param("denominationDate") String denominationDate);
}