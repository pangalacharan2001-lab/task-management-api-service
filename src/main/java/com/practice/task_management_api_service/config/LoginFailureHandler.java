package com.practice.task_management_api_service.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

public class LoginFailureHandler implements AuthenticationFailureHandler
{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException 
            {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> errorDetails = new HashMap<>();
                
                if(exception instanceof UsernameNotFoundException)
                {
                    errorDetails.put("error", "UserName Not Found");
                }
                else if(exception instanceof BadCredentialsException)
                {
                    errorDetails.put("error", "Password Mismatch");
                }
                else{
                    errorDetails.put("error", "Invalid Credentials");
                }
                response.getWriter().write(objectMapper.writeValueAsString(errorDetails));
            }   

}
