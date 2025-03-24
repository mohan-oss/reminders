package com.reminder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ExpensetrackerApplicationTests {
	@Mock
	Map<String,Integer> map;

	@BeforeEach
	public void hello(){
		//MockitoAnnotations.initMocks(this);
		List l = mock(List.class);
	}

	@Test
	@EnabledOnOs(value = {OS.WINDOWS})
	void contextLoads() {
		Mockito.when(map.size()).thenReturn(10).thenReturn(23);


		System.out.println(map.size());
		System.out.println(map.size());
	}

}
