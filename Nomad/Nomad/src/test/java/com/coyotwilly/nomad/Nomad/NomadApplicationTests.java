package com.coyotwilly.nomad.Nomad;

import com.coyotwilly.nomad.Nomad.model.User;
import com.coyotwilly.nomad.Nomad.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NomadApplicationTests {
	@Autowired
	UserService userService;
	@Test
	void contextLoads() {
		User user = User.builder()
				.firstName("Abdul")
				.lastName("el Sharamn")
				.emailAddress("aaa@bb.com")
				.pin(1234)
				.passportNo("A9632B")
				.documentNo("A9632B")
				.build();
		userService.saveUser(user);
		userService.getAllUsers().forEach(System.out::println);
	}

}
