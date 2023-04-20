package com.idsspl.webproject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.idsspl.webproject.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{

//	public Optional<UserEntity> findById(Long userId);
	
	public UserEntity findByUserName(String userName);
	
}
