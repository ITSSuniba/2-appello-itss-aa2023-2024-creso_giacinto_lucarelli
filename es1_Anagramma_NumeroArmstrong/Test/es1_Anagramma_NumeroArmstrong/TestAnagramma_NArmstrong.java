package es1_Anagramma_NumeroArmstrong;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class TestAnagramma_NArmstrong {
	Anagramma_NArmstrong anagrammaNumeroArmstrong = new Anagramma_NArmstrong();
	
   @Order(1)
   @ParameterizedTest
   @DisplayName("Explore what the function does with casual input for string to Anagrammi")
   @MethodSource("exploreStrings")
   void shouldReturnCorrectResultExploreStrings(String str1, String str2, boolean expected) {
	   assertThat(anagrammaNumeroArmstrong.sonoAnagrammi(str2, str2), is(equalTo(expected)));
   }

   static Stream<Arguments> exploreStrings(){
	   return Stream.of(
			   Arguments.of("listen", "silent", true),
			   Arguments.of("LiSten", "sIlEnT", true), //possono avere caratteri maiuscoli
			   Arguments.of(null, null, false) //eccezione, le stringhe non possono essere nulle
			   );
   }
   
   @Order(2)
   @ParameterizedTest
   @DisplayName("Explore what the function does with casual input of number for Armstrong")
   @MethodSource("exploreNumbers")
   void shouldReturnCorrectResultExploreNumbers(Integer numero, boolean expected) {
	   assertThat(anagrammaNumeroArmstrong.isNumeroArmstrong(numero), is(equalTo(expected)));
   }

   static Stream<Arguments> exploreNumbers(){
	   return Stream.of(
			   Arguments.of(153, true),
			   Arguments.of(null, false) //eccezione, il numero non può essere null
			   );
   }
   
   @Order(3)
   @ParameterizedTest
   @DisplayName("Sad Path Test Strings")
   @MethodSource("sadPathTestCasesStrings")
   void shouldReturnCorrectResultSadPathStrings(String str1, String str2) {
	   if(str1 == null && str2 == null) {
		   assertFalse(new Anagramma_NArmstrong().sonoAnagrammi(str1, str2));
	   }
   }
   
   static Stream<Arguments> sadPathTestCasesStrings(){
	return Stream.of(
			Arguments.of(null, null),//T8
			Arguments.of("hello", null), //T9
			Arguments.of(null, "hello") //T10
			); 
   }
   
   @Order(4)
   @ParameterizedTest
   @DisplayName("Sad Path Test Numbers")
   @MethodSource("sadPathTestCasesNumbers")
   void shouldReturnCorrectResultSadPathNumbers(Integer numero) {
	   if(numero<0 && numero == Integer.MIN_VALUE) {
		   assertFalse(new Anagramma_NArmstrong().isNumeroArmstrong(numero));
	   }
   }
   
   static Stream<Arguments> sadPathTestCasesNumbers(){
	return Stream.of(
			Arguments.of(-1),//T20
			Arguments.of(Integer.MIN_VALUE) //T22
			);
   }
   
   @Order(5)
   @ParameterizedTest
   @DisplayName("Happy Path Test Strings")
   @MethodSource("happyPathTestCasesStrings")
   void shouldReturnCorrectResultHappyPathStrings(String str1, String str2, boolean expected) {
	   assertThat(new Anagramma_NArmstrong().sonoAnagrammi(str1, str2), is(equalTo(expected)));
   }
   
   static Stream<Arguments> happyPathTestCasesStrings(){
	   return Stream.of(
			   Arguments.of("listen", "silent", true), //T1
			   Arguments.of("eleven plus two", "twelve plus one", true), //T2
			   Arguments.of("Race", "care", true), //T3
			   Arguments.of("debit card", "bad credit", true), //T4
			   Arguments.of("astronomer", "moon starer", true), //T6
			   Arguments.of(" ", " ", true), //T9 boundary case
			   Arguments.of("a", "a", true), //T10 boundary case
			   Arguments.of("hello", "hello", true), //T11 boundary case
			   Arguments.of("hello", "aworld", false) //T11 boundary case
			   );
   }
   
   @Order(6)
   @ParameterizedTest
   @DisplayName("Happy Path Test Numbers")
   @MethodSource("happyPathTestCasesNumbers")
   void shouldReturnCorrectResultHappyPathNumbers(Integer numero, boolean expected) {
	   assertThat(new Anagramma_NArmstrong().isNumeroArmstrong(numero), is(equalTo(expected)));
   }
   
   static Stream<Arguments> happyPathTestCasesNumbers(){
	   return Stream.of(
			   Arguments.of(153, true), //T12
			   Arguments.of(370, true), //T13
			   Arguments.of(5, true), //T16 boundary case
			   Arguments.of(0, true) //T17 boundary case
			   );
   }
   
   @Order(7)
   @ParameterizedTest
   @DisplayName("Special Characters in Strings Test")
   @MethodSource("specialCharactersInStringsTestCases")
   void shouldReturnCorrectResultSpecialCharactersInStrings(String str1, String str2, boolean expected) {
	   assertThat(new Anagramma_NArmstrong().sonoAnagrammi(str1, str2), is(equalTo(expected)));
   }
   
   static Stream<Arguments> specialCharactersInStringsTestCases(){
	   return Stream.of(
			   Arguments.of("hello!@#", "!@#olleh", true), //T24
			   Arguments.of("a&b c", "bca& ", true), //T25
			   Arguments.of("&%$£ ?/", "?% &£$/", true) //T26
			   );
   }
   
   @Order(8)
   @ParameterizedTest
   @DisplayName("Special Numbers of Armstrong Test")
   @MethodSource("specialNumbersOfArmstrongTestCases")
   void shouldReturnCorrectResultSpecialNumbersOfArmstrong(Integer numero, boolean expected) {
	   assertThat(new Anagramma_NArmstrong().isNumeroArmstrong(numero), is(equalTo(expected)));
   }
   
   static Stream<Arguments> specialNumbersOfArmstrongTestCases(){
	   return Stream.of(
			   Arguments.of(548834, true) //T27 numero int di Armstrong più grande calcolabile  
			   );
   }
   
}