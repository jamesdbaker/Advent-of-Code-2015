package jamesbaker.adventofcode.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Part1 {
	private static final Pattern X = Pattern.compile("\\\\x[0-9a-f]{2}");
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		Integer quotes = 0;
		Integer escapedBackslashes = 0;
		Integer escapedQuotes = 0;
		Integer hexCodes = 0;
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
			String line;
			while((line = buffer.readLine()) != null){
				if(line.startsWith("\"")){
					quotes++;
				}
				if(line.endsWith("\"") && ! line.endsWith("\\\"")){
					quotes++;
				}
				escapedBackslashes += StringUtils.countMatches(line, "\\\\");
				escapedQuotes += StringUtils.countMatches(line, "\\\"");
				
				Matcher mX = X.matcher(line);
				while(mX.find())
					hexCodes++;
				
				sb.append(line);
			}
        }
		String data = sb.toString();
		
		Integer originalLength = data.length();
		Integer memoryLength = originalLength - quotes - escapedBackslashes - escapedQuotes - 3*hexCodes;
		
		System.out.println("Literal Length: " + originalLength);
		System.out.println("Memory Length: "+ memoryLength);
		System.out.println("Difference: " + (originalLength - memoryLength));
	}

}
