package jamesbaker.adventofcode.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringEscapeUtils;

public class Part2 {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sbOrig = new StringBuilder();
		StringBuilder sbEscaped = new StringBuilder();
	
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
			String line;
			while((line = buffer.readLine()) != null){
				sbOrig.append(line);
				sbEscaped.append("\"" + StringEscapeUtils.escapeJava(line) + "\"");
			}
        }
		
		System.out.println(sbEscaped.length() - sbOrig.length());
	}

}
