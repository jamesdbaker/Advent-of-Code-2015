package jamesbaker.adventofcode.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Part1 {

	public static void main(String[] args) throws IOException{
		Integer x = 0;
		Integer y = 0;
		Set<String> houses = new HashSet<>();
		houses.add(x + ":" + y);
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
            String content = buffer.lines().collect(Collectors.joining("\n"));
    		for(int i = 0; i < content.length(); i++){
    			char c = content.charAt(i);
    			
    			if(c == '>'){
    				x++;
    			}else if(c == '<'){
    				x--;
    			}else if(c == '^'){
    				y++;
    			}else if(c == 'v'){
    				y--;
    			}
    			
    			houses.add(x + ":" + y);
    		}
        }
		
		System.out.println(houses.size());
	}

}
