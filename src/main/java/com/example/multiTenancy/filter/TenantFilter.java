package com.example.multiTenancy.filter;

import com.example.multiTenancy.tenants.TenantContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TenantFilter extends OncePerRequestFilter {

    @Autowired
    TenantContext tenantContext;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {


        String tenantId=request.getHeader("X-Tenant-Id");

        tenantContext.setCurrentThread(tenantId);

        try {
            filterChain.doFilter(request,response);
        }
        finally {
             tenantContext.setCurrentThread("");
        }

        }
}
