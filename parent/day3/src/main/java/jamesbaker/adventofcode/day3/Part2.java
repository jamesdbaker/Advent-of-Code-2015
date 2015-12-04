package jamesbaker.adventofcode.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Part2 {

	public static void main(String[] args) throws IOException{
		Integer xSanta = 0;
		Integer ySanta = 0;
		Integer xRobo = 0;
		Integer yRobo = 0;
		
		Boolean santa = true;
		
		Set<String> houses = new HashSet<>();
		
		houses.add(xSanta + ":" + ySanta);
		houses.add(xRobo + ":" + yRobo);
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input.txt")))) {
            String content = buffer.lines().collect(Collectors.joining("\n"));
    		for(int i = 0; i < content.length(); i++){
    			char c = content.charAt(i);
    			
    			if(santa){
	    			if(c == '>'){
	    				xSanta++;
	    			}else if(c == '<'){
	    				xSanta--;
	    			}else if(c == '^'){
	    				ySanta++;
	    			}else if(c == 'v'){
	    				ySanta--;
	    			}
	    			houses.add(xSanta + ":" + ySanta);
    			}else{
    				if(c == '>'){
	    				xRobo++;
	    			}else if(c == '<'){
	    				xRobo--;
	    			}else if(c == '^'){
	    				yRobo++;
	    			}else if(c == 'v'){
	    				yRobo--;
	    			}
    				houses.add(xRobo + ":" + yRobo);
    			}
    			
    			santa = !santa;

    		}
        }
		
		System.out.println(houses.size());
	}

}
