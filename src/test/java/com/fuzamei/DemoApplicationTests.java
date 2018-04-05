package com.fuzamei;

import com.fuzamei.controller.TestAction;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private TestAction testAction;

	private MockMvc mvc;

	@Test
	public void contextLoads() {
		String hello = testAction.hello();
		System.out.println(hello);
	}
	@Test
	public void contextTest() {
		String hello = testAction.test();
		System.out.println(hello);
	}

	@Test
	public void contextRandom() {
		String hello = testAction.random();
		System.out.println(hello);
	}

	public void hello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("hello world2")));
	}

}
