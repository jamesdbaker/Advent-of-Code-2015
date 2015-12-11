package jamesbaker.adventofcode.day11;

public class Solution {
	private static final String INPUT = "vzbxkghb";
	
	public static void main(String[] args) {
		//Part 1
		String s = incrementString(INPUT);
		while(!isValid(s)){
			s = incrementString(s);
		}
		
		System.out.println("First password: "+s);
		
		//Part 2
		s = incrementString(s);
		while(!isValid(s)){
			s = incrementString(s);
		}
		
		System.out.println("Second password: "+s);
	}

	private static String incrementString(String s){
		char c = s.charAt(s.length() - 1);
		if(c == 'z'){
			return incrementString(s.substring(0, s.length() - 1)) + 'a';
		}else{
			c++;
			return s.substring(0, s.length() - 1) + c;
		}
	}
	
	private static Boolean isValid(String s){
		if(!s.matches("[a-z]{8}")){
			return false;
		}
		
		if(s.contains("i") || s.contains("o") || s.contains("l")){
			return false;
		}
		
		boolean found = false;
		for(int i = 0; i < s.length() - 2; i++){
			char c1 = s.charAt(i);
			char c2 = s.charAt(i+1);
			char c3 = s.charAt(i+2);
			
			if(c1 + 1 == c2 && c1 + 2 == c3){
				found = true;
				break;
			}
		}
		if(!found){
			return false;
		}
		
		if(!s.matches(".*([a-z])\\1.*([a-z])\\2")){
			return false;
		}
		
		return true;
	}
}
