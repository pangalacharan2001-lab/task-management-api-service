package com.practice.task_management_api_service.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.task_management_api_service.entity.UserInfo;
import com.practice.task_management_api_service.exception.UserNameNotFoundException;
import com.practice.task_management_api_service.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;

    
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUserName(username).orElseThrow(() -> new UserNameNotFoundException(username));
		return User.withUsername(userInfo.getUserName()).password(userInfo.getPassword()).roles(userInfo.getRoles().toUpperCase()).build();    
    }

}
