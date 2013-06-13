package com.qsoft.longdt;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void shouldReturnZeroOnEmptyString(){
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void shouldReturnNumberOnNumberInput()
	{
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void shouldReturnWithCommaDelim(){
		assertEquals(3, StringCalculator.add("1,2"));
	}
	
	@Test
	public void shouldReturnWithBreakLineDelim(){
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}	

	@Test
	public void shouldReturnExceptionWithNegativeNumber(){
		try {
			StringCalculator.add("-1,2,3");
		} catch (NumberFormatException e) {
			assertEquals(e.getMessage(), StringCalculator.add("negatives not allowed 1"));
		}
	}
	
	@Test
	public void shouldReturnWithDelimDefine(){
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	
	
	@Test
	public void shouldReturnWithoutNumberGreaterThanOneThoudsandOne(){
		assertEquals(3, StringCalculator.add("//;\n1;2,1001"));
	}
	
	@Test
	public void shouldReturnWithLongDelim(){
		assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void shouldReturnWithManyTypeDelim(){
		assertEquals(6, StringCalculator.add("//[ab][**]\n1ab2**3"));
	}
}
