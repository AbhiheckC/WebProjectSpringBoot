package com.idsspl.webproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idsspl.webproject.entity.AgentCollectionEntity;

@Repository
public interface AgentCollectionRepo extends JpaRepository<AgentCollectionEntity, String>{

}
