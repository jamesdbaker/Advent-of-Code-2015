package jamesbaker.adventofcode.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {

	public static void main(String[] args) throws IOException{
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input.txt")))) {
			String line;
			Integer totalLength = 0;
			while((line = buffer.readLine()) != null){
				String[] parts = line.split("x");
				if(parts.length != 3){
					System.err.println("Couldn't parse line: "+line);
					continue;
				}
				
				List<Integer> dimensions = new ArrayList<>();
				dimensions.add(Integer.valueOf(parts[0]));
				dimensions.add(Integer.valueOf(parts[1]));
				dimensions.add(Integer.valueOf(parts[2]));
				
				Collections.sort(dimensions);
				
				Integer smallestPerimeter = 2*(dimensions.get(0) + dimensions.get(1));
				Integer volume = dimensions.get(0)*dimensions.get(1)*dimensions.get(2);
				
				totalLength += smallestPerimeter + volume;
			}
			
			System.out.println(totalLength);
        }
	}
}
