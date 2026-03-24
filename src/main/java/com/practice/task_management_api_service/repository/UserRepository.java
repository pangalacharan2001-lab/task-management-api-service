package com.practice.task_management_api_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.task_management_api_service.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByUserName(String userName);

}
