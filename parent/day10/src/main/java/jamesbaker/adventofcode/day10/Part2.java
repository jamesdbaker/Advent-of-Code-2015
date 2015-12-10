package jamesbaker.adventofcode.day10;

public class Part2 {

	private static final String INPUT = "1321131112";
	
	public static void main(String[] args) {
		String s = INPUT;
		for(int i = 1; i <= 50; i++){
			s = Part1.lookAndSay(s);
			//System.out.println(i+": "+s);
		}
		System.out.println("Final length: "+s.length());
	}
}
