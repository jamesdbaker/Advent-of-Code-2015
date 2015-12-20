package jamesbaker.adventofcode.day20;

public class Part2 {
	private static final int INPUT = 29000000;
	
	public static void main(String[] args) {
		int i = 665280;
		while(sumFactors(i) < INPUT/11){
			if(i % 10 == 0)
				System.out.println(i);
			
			i++;
		}
		
		System.out.println("Solution: "+i);
	}
	
	private static Integer sumFactors(Integer houseNumber){
		Integer total = 0;
		
		for(int elf = 1; elf <= houseNumber; elf++){
			if(houseNumber % elf == 0){
				if(50*elf < houseNumber)
					continue;
				
				total += elf;
				if(Math.pow(elf, 2) != houseNumber)
					total += houseNumber/elf;
			}
		}
				
		return total;
	}

}
