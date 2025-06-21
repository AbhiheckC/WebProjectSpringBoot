package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idsspl.webproject.entity.Denomination;
@Repository
public interface DenominationRepository extends JpaRepository<Denomination, Long> {
	
	@Query("SELECT a FROM Denomination a WHERE a.agentName = :agentName and   a.denominationdate = :asondate ORDER BY a.receiptNo asc")
	public List<Denomination> findInfoByAgentName(@Param("agentName") String agentName, @Param("asondate") String asondate);
	
	@Query("SELECT a FROM Denomination a WHERE a.agentName = :agentName and   a.denominationdate = :asondate and a.changeReturn >0 ORDER BY a.receiptNo asc")
	public List<Denomination> findInfoByAgentNameReturn(@Param("agentName") String agentName, @Param("asondate") String asondate);
	
	
}

