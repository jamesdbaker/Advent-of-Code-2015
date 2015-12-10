package jamesbaker.adventofcode.day10;

public class Part1 {

	private static final String INPUT = "1321131112";
	
	public static void main(String[] args) {
		String s = INPUT;
		for(int i = 1; i <= 40; i++){
			s = lookAndSay(s);
			//System.out.println(i+": "+s);
		}
		System.out.println("Final length: "+s.length());
	}

	public static String lookAndSay(String s){
		StringBuilder ret = new StringBuilder();
		
		char prevChar = ' ';
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			char currChar = s.charAt(i);
			if(currChar != prevChar && count > 0){
				ret.append(count);
				ret.append(prevChar);
				count = 0;
			}
			count++;
			prevChar = currChar;
		}
		ret.append(count);
		ret.append(prevChar);
		
		return ret.toString();
	}
}
