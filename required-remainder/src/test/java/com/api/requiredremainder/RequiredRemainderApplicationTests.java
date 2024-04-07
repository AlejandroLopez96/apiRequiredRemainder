package com.api.requiredremainder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.requiredremainder.service.RequiredRemainderService;

@SpringBootTest
class RequiredRemainderApplicationTests {

	@Autowired
	private RequiredRemainderService requiredRemainderService;

	@Test
	void whenExampleOne_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 7;
		Integer y = 5;
		Integer n = 12345;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(12339, result);
		
	}

	@Test
	void whenExampleTwo_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 5;
		Integer y = 0;
		Integer n = 4;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(0, result);
		
	}

	@Test
	void whenExampleThree_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 10;
		Integer y = 5;
		Integer n = 15;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(15, result);
		
	}

	@Test
	void whenExampleFour_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 17;
		Integer y = 8;
		Integer n = 54321;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(54306, result);
		
	}

	@Test
	void whenExampleFive_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 499999993;
		Integer y = 9;
		Integer n = 1000000000;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(999999995, result);
		
	}

	@Test
	void whenExampleSix_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 10;
		Integer y = 5;
		Integer n = 187;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(185, result);
		
	}

	@Test
	void whenExampleSeven_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 2;
		Integer y = 0;
		Integer n = 999999999;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(999999998, result);
		
	}

	// There are some examples out of specified tests cases
	@Test
	void whenExampleEight_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 178;
		Integer y = 13;
		Integer n = 9222;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(9091, result);
		
	}

	@Test
	void whenExampleNine_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 2222;
		Integer y = 56;
		Integer n = 88899;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(86714, result);
		
	}

	@Test
	void whenExampleTen_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 857;
		Integer y = 23;
		Integer n = 7784;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(7736, result);
	}

	@Test
	void whenExampleEleven_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 536888;
		Integer y = 2;
		Integer n = 9999;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(2, result);
	}	

	@Test
	void whenExampleTwelve_thenReturnResult() throws Exception {
		Integer result;

		// given
		Integer x = 29;
		Integer y = 65;
		Integer n = 543;

		// when
		result = this.requiredRemainderService.calculate(x, y, n);

		// then
		assertEquals(529, result);
		
	}

	@Test
	void whenXAndYHasValueAndNHasNotValue_thenReturnNull() {
		Integer result = null;

		// given
		Integer x = 178;
		Integer y = 13;
		Integer n = null;

		// when
		try {
			result = this.requiredRemainderService.calculate(x, y, n);
		} catch (Exception e) {
			// then
			assertEquals(null, result);
		}
	}

	@Test
	void whenXAndNHasValueAndYHasNotValue_thenReturnNull() {
		Integer result = null;

		// given
		Integer x = 178;
		Integer y = null;
		Integer n = 13;

		// when
		try {
			result = this.requiredRemainderService.calculate(x, y, n);
		} catch (Exception e) {
			// then
			assertEquals(null, result);
		}
	}

	@Test
	void whenYAndNHasValueAndXHasNotValue_thenReturnNull() {
		Integer result = null;

		// given
		Integer x = null;
		Integer y = 13;
		Integer n = 9222;

		// when
		try {
			result = this.requiredRemainderService.calculate(x, y, n);
		} catch (Exception e) {
			// then
			assertEquals(null, result);
		}
	}

}
