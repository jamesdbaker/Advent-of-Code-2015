package jamesbaker.adventofcode.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part1 {

	public static void main(String[] args) throws IOException{
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
			String line;
			Integer totalArea = 0;
			while((line = buffer.readLine()) != null){
				String[] parts = line.split("x");
				if(parts.length != 3){
					System.err.println("Couldn't parse line: "+line);
					continue;
				}
				
				Integer l = Integer.valueOf(parts[0]);
				Integer w = Integer.valueOf(parts[1]);
				Integer h = Integer.valueOf(parts[2]);
				
				Integer side1 = l*w;
				Integer side2 = l*h;
				Integer side3 = w*h;
				
				Integer sideMin = Math.min(Math.min(side1, side2), side3);
				
				totalArea += 2*(side1+side2+side3) + sideMin;
			}
			
			System.out.println(totalArea);
        }
	}
}
