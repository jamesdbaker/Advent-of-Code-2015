package jamesbaker.adventofcode.day20;

public class Part1 {
	private static final int INPUT = 29000000;
	
	public static void main(String[] args) {
		int i = 1;
		while(sumFactors(i) < INPUT/10){
			if(i % 10 == 0)
				System.out.println(i);
			
			i++;
		}
		
		System.out.println("Solution: "+i);
	}
	
	private static Integer sumFactors(Integer i){
		Integer total = 0;
		
		for(int x = 1; x <= Math.sqrt(i); x++){
			if(i % x == 0){
				total += x;
				if(Math.pow(x, 2) != i)
					total += i/x;
			}
		}
				
		return total;
	}

}
