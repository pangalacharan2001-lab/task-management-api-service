package com.practice.task_management_api_service.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);

                Map<String, String> errorDetails = new HashMap<>();
                ObjectMapper objectMapper =new ObjectMapper();

                errorDetails.put("error", "Access Denied - Role Missing");

                response.getWriter().write(objectMapper.writeValueAsString(errorDetails));
            }
}
