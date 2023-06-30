package com.vs.resourceserverboot3.filter;

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
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.Stream;

@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        var date = LocalDateTime.now();
        log.info("LogFilter Resource-Server {} : HttpRequest {}:{}" , date ,httpRequest.getLocalAddr(),  httpRequest.getLocalPort() + httpRequest.getServletPath());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
