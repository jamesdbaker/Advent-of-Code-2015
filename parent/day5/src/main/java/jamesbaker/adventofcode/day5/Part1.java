package jamesbaker.adventofcode.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class Part1 {

	public static void main(String[] args) throws IOException {
		Integer niceCount = 0;
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
			String line;
			while((line = buffer.readLine()) != null){
				if(countVowels(line) >= 3 && containsDoubleLetter(line) && !containsNaughtyString(line)){
					niceCount++;
				}
			}
        }
		
		System.out.println(niceCount);
	}

	private static Integer countVowels(String s){
		Integer count = 0;
		
		count += StringUtils.countMatches(s, 'a');
		count += StringUtils.countMatches(s, 'e');
		count += StringUtils.countMatches(s, 'i');
		count += StringUtils.countMatches(s, 'o');
		count += StringUtils.countMatches(s, 'u');
		
		return count;
	}
	
	private static boolean containsDoubleLetter(String s){
		for(char alphabet = 'a'; alphabet <= 'z';alphabet++) {
		    StringBuilder doubleLetter = new StringBuilder();
		    doubleLetter.append(alphabet);
		    doubleLetter.append(alphabet);
		    
		    if(s.contains(doubleLetter)){
		    	return true;
		    }
		}
		
		return false;
	}
	
	private static boolean containsNaughtyString(String s){
		return s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy");
	}
}
