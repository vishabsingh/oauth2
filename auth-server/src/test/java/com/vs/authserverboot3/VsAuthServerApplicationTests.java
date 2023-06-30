package com.vs.authserverboot3;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class VsAuthServerApplicationTests {

	@BeforeAll
	static void init() {
		var context = SecurityContextHolder.createEmptyContext();
		var testingAuthenticationToken = new TestingAuthenticationToken("SINGH", "test123", "WRITE");
		context.setAuthentication(testingAuthenticationToken);
		SecurityContextHolder.setContext(context);
	}

	@Test
	void contextLoads() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		log.info("authentication = {} " , authentication);
		assertThat(authentication.getPrincipal())
				.isNotNull()
				.isEqualTo("SINGH");
		assertThat(authentication.getCredentials()).isEqualTo("test123");
	}

}
