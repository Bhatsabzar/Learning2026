package com.Learning2026;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class Learning2026ApplicationTests {

	@Test
	void simpleTest() {
		int a = 10;
		int b = 20;

		int result = a + b;

		assertEquals(30, result);
	}

}
