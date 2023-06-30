package com.vs.authserverboot3.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        var date = LocalDateTime.now();
        log.info("LogFilter Authorization-Server {} : HttpRequest {}:{}" , date ,httpRequest.getLocalAddr(),  httpRequest.getLocalPort() + httpRequest.getServletPath());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
