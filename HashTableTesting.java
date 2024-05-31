/*
 * @author Sarthak Goyal
 * 
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTesting {

	@Test
	void put() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		assertEquals(a.size(), 6);
	}
	
	@Test
	void putMed() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		a.put("0", 6);
		a.put("1", 19);
		//a.put("0", 20);
		a.put("6", 66);
		a.put("put", 18);
		a.put("method", 31);
		assertEquals(a.size(), 11);
	}
	
	@Test
	void putOverlap() { //should be 2, printing size 8
		HashTable<Integer, Integer> a = new HashTable<>();
		a.put(1,1);
		a.put(0, 1);
		a.put(1, 0);
		a.put(0, 0);
		a.put(1, -1);
		a.put(0, -1);
		a.put(1, 0);
		a.put(1, 1); 		
		assertEquals(a.size(), 2);
	}	
	
	@Test
	void putReHash() { 
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("jazzman", 1);
		a.put("quizzes", 2);
		a.put("jumpoff", 1);
		a.put("cyclize", 2);
		a.put("kickoff", 1);
		a.put("lockjaw", 2);
		a.put("quacked", 1);
		a.put("squawks", 2);
		a.put("wheezed", 2);
		assertEquals(a.size(), 11);
	}
	
	@Test
	void clear() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		a.clear();
		assertEquals(a.size(), 0);
	}
	
	@Test
	void clearMed() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		a.put("0", 6);
		a.put("1", 19);
		//a.put("0", 20);
		a.put("6", 66);
		a.put("put", 18);
		a.put("method", 31);
		a.clear();
		assertEquals(a.size(), 0);
	}
	
	@Test
	void clearOverlap() {
		HashTable<Integer, Integer> a = new HashTable<>();
		a.put(1,1);
		a.put(0, 1);
		a.put(1, 0);
		a.put(0, 0);
		a.put(1, -1);
		a.put(0, -1);
		a.put(-1, 0);
		a.put(-1, -1); 
		a.clear();
		assertEquals(a.size(), 0);
	}
	
	
	@Test
	void isEmpty() {
		HashTable<String, Integer> a = new HashTable<>();
		assertTrue(a.isEmpty());		
	}
	
	@Test
	void isEmptyMed() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		a.put("0", 6);
		a.put("1", 19);
		a.put("6", 66);
		a.put("put", 18);
		a.put("method", 31);
		a.clear();
		assertTrue(a.isEmpty());		
	}
	
	@Test
	void isEmptyOverlap() {
		HashTable<Integer, Integer> a = new HashTable<>();
		a.put(1,1);
		a.put(0, 1);
		a.put(1, 0);
		a.put(0, 0);
		a.put(1, -1);
		a.put(0, -1);
		a.put(-1, 0);
		a.put(-1, -1); 
		a.clear();
		assertTrue(a.isEmpty());		
	}

	@Test
	void entries() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		System.out.println(a.entries());
	}
	
	@Test
	void containsKey() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		assertTrue(a.containsKey("iyer"));
	}
	
	@Test
	void containsKeyMed() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		a.put("0", 6);
		a.put("1", 19);
		a.put("6", 66);
		a.put("put", 18);
		a.put("method", 31);
		assertTrue(a.containsKey("Sarthak"));
	}
	
	@Test
	void getValueInts() {
		HashTable<String, Integer> a = new HashTable<>();
		a.put("sarthak", 1);
		a.put("vignesh", 2);
		a.put("sam", 1);
		a.put("Sarthak", 4);
		a.put("goyal", 2);
		a.put("iyer", 1);
		a.put("0", 6);
		a.put("1", 19);
		a.put("6", 66);
		a.put("put", 18);
		a.put("method", 31);
		int b = a.get("iyer");
		assertEquals(b, 1);
	}
	
	@Test
	void getValueOverlap() { //should return -1
		HashTable<Integer, Integer> a = new HashTable<>();
		a.put(1,1);
		a.put(0, 1);
		a.put(1, 0);
		a.put(0, 0);
		a.put(1, -1);
		a.put(0, -1);
		a.put(-1, 0);
		a.put(-1, -1); 
		int b = a.get(1);
		assertEquals(b, -1);
	}
	
	@Test
	void getValueStrings() { //should return 0
		HashTable<String, String> a = new HashTable<>();
		a.put("sarthak","0" );
		a.put("vignesh", "-1");
		a.put("vignesh", "0");
		a.put("sam", "1");
		a.put("Sarthak","-2" );
		a.put("goyal","2" );
		a.put("iyer", "3");
		a.put("0", "-3");
		a.put("1","4" );
		a.put("6", "-4");
		a.put("put","5" );
		a.put("method","-5" );
		String b = a.get("vignesh");
		assertEquals(b, "0");
	}
	
	@Test
	void containsValue() {
		HashTable<String, String> a = new HashTable<>();
		a.put("sarthak","0" );
		a.put("vignesh", "-1");
		a.put("sam", "1");
		a.put("Sarthak","-2" );
		a.put("goyal","2" );
		a.put("iyer", "3");
		a.put("0", "-3");
		a.put("1","4" );
		a.put("6", "-4");
		a.put("put","5" );
		a.put("method","-5" );
		assertTrue(a.containsValue("-2"));
	}
	
	@Test
	void containsValueOverlap() {
		HashTable<Integer, Integer> a = new HashTable<>();
		a.put(1,1);
		a.put(0, 1);
		a.put(1, 0);
		a.put(0, 0);
		a.put(1, -1);
		a.put(0, -1);
		a.put(-1, 0);
		a.put(-1, -1);
		assertTrue(a.containsValue(-1));
	}
	
	@Test
	void removeValue() {
		HashTable<String, String> a = new HashTable<>();
		a.put("sarthak","0" );
		a.put("vignesh", "-1");
		a.put("sam", "1");
		a.put("Sarthak","-2" );
		a.put("goyal","2" );
		a.put("iyer", "3");
		a.put("0", "-3");
		a.put("1","4" );
		a.put("6", "-4");
		a.put("put","5" );
		a.put("method","-5" );
		String b = a.remove("6");
		assertEquals(b, "-4");
	}
	
	
//***********************************************************************************************************
//										TESTS FOR STUDENT HASH METHODS
//***********************************************************************************************************	
	@Test
	void studentBadHash() {
		StudentBadHash student = new StudentBadHash(706, "Sarthak", "Goyal");
		assertEquals(student.hashCode(), 706);	
	}
	
	@Test
	void studentBadHash01() {
		StudentBadHash student = new StudentBadHash(161, "Jane", "Doe");
		assertEquals(student.hashCode(), 161);	
	}
	
	@Test
	void studentMediumHash() {
		StudentMediumHash student = new StudentMediumHash(162, "Sarthak", "Goyal");
		assertEquals(student.hashCode(), 1944);
	}
	
	@Test
	void studentMediumHash01() {
		StudentMediumHash student = new StudentMediumHash(5017, "Jane", "Doe");
		assertEquals(student.hashCode(), 35119);
	}
	
	@Test
	void studentGoodHash() {
		StudentGoodHash student = new StudentGoodHash(123, "John", "Doe");
		assertEquals(student.hashCode(), 3813);
	}
	
	@Test
	void studentGoodHash01() {
		StudentGoodHash student = new StudentGoodHash(37035, "Jane", "Doe");
		assertEquals(student.hashCode(), 1148085);		
	}
}
