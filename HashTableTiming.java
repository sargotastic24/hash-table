import java.util.HashMap;

/*
 * @author Sarthak Goyal
 */
public class HashTableTiming { 
	
		public static void main(String[] args) { 
			 //StudentBadHash s1 = new StudentBadHash(1, "sarthak", "goyal");
			 //StudentMediumHash s1 = new StudentMediumHash(1, "sarthak", "goyal");
			 //StudentGoodHash s1 = new StudentGoodHash(1, "sarthak", "goyal"); 
		     //HashTable<StudentGoodHash, Integer> h = new HashTable<>();
			 //HashTable<Integer, Integer> h = new HashTable<>();
			HashMap<Integer, Integer> map = new HashMap<>();
			 
			for(int i = 0; i <= 1000; i++) {
				//int a = getRandomIntBetweenRange(1111111, 9999999);
				//s1 = new StudentBadHash(a, "A", "B");
				//s1 = new StudentMediumHash(a, "A", "B");
				//s1 = new StudentGoodHash(a, "A", "B");
				//h.put(s1, 1);
			}
			
			  // Do 10000 lookups and use the average running time.
		 int timesToLoop = 1000;
		    
		    // For each problem size n . . .
		    for (int n = 1000; n <= 10000; n += 1000) {
		      long startTime, midpointTime, stopTime;
		      
		      startTime = System.nanoTime();
		      while (System.nanoTime() - startTime < 1000000000) { // empty block 
		      }
		      
		      // Now, run the test.  
		      startTime = System.nanoTime();
		      for(int i = 0; i < n; i++) {               //StudentBadHash
			    	//h.get(a);
		    	  int a = getRandomIntBetweenRange(1, 100);
					//h.put(a, 1);
		    	  map.put(a, 1);
			   }
		      
		      for (int i = 0; i < timesToLoop; i++) {               //StudentMediumHash
		    	
		      }

		      midpointTime = System.nanoTime();

/*		      for(int i = 0; i < timesToLoop; i++) { 	             //StudentGoodHash
		    	  //lls.pop(); 
		    	  //arr.pop();
		      }*/

		      for(int i = 0; i < n; i++) {				//empty loop to account for the "for loop" runtime.
		      }
		      stopTime = System.nanoTime();

		      // Compute the time, subtract the cost of running the loop
		      // from the cost of running the loop and doing the lookups.
		      // Average it over the number of runs.
		      double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
		          / timesToLoop;

		      System.out.println(n + "\t" + averageTime);
		  }

		}
		
		public static int getRandomIntBetweenRange(int min, int max){
		    int x = (int) ((Math.random()*((max-min)+1))+min);
		    return x;
		}
}

