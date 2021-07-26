package com.cognizant.pms.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.pms.auth.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, String>{

}
