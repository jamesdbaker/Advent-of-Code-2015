package jamesbaker.adventofcode.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Part2 {

	private static final Pattern REPEATED_PAIR = Pattern.compile("([a-z]{2}).*\\1");
	private static final Pattern REPEATED_LETTER = Pattern.compile("([a-z])[a-z]\\1");
	
	public static void main(String[] args) throws IOException {
		Integer niceCount = 0;
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input.txt")))) {
			String line;
			while((line = buffer.readLine()) != null){
				if(containsRepeatedPair(line) && containsRepeatedLetter(line)){
					niceCount++;
				}
			}
        }
		
		System.out.println(niceCount);
	}
	
	private static boolean containsRepeatedPair(String s){
		return REPEATED_PAIR.matcher(s).find();
	}
	
	private static boolean containsRepeatedLetter(String s){
		return REPEATED_LETTER.matcher(s).find();
	}
}
