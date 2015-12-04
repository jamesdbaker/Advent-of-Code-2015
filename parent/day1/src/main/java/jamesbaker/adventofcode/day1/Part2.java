package jamesbaker.adventofcode.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Part2 {

	public static void main(String[] args) throws IOException{
		String content = "";
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part2.class.getResourceAsStream("input.txt")))) {
            content = buffer.lines().collect(Collectors.joining("\n"));
        }
		
		int floor = 0;
		for(int i = 0; i < content.length(); i++){
			if(content.charAt(i) == '('){
				floor++;
			}else if(content.charAt(i) == ')'){
				floor--;
			}
			
			if(floor == -1){
				System.out.println(i + 1);
				break;
			}
		}
	}

}
