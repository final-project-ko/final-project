package com.ohgiraffers.finalproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FinalProjectApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		// 애플리케이션 컨텍스트가 올바르게 로드되었는지 확인
		assertThat(context).isNotNull();

		// 예를 들어, 특정 빈이 존재하는지 확인
		// assertThat(context.getBean(ExampleBean.class)).isNotNull();
		// 이거 추가되는지 확인하기
	}

}