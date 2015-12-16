package jamesbaker.adventofcode.day16;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class Part1 {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> ticker = new HashMap<>();
		ticker.put("children", 3);
		ticker.put("cats", 7);
		ticker.put("samoyeds", 2);
		ticker.put("pomeranians", 3);
		ticker.put("akitas", 0);
		ticker.put("vizslas", 0);
		ticker.put("goldfish", 5);
		ticker.put("trees", 3);
		ticker.put("cars", 2);
		ticker.put("perfumes", 1);
		
		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part1.class.getResource("input.txt")));

		for(String line : lines){
			String[] parts = line.split(" ", 3);
			String sue = parts[1].substring(0, parts[1].length() - 1);
			
			String[] properties = parts[2].split(",");
			boolean contender = true;
			for(String prop : properties){
				String[] propParts = prop.split(": ");
				if(ticker.get(propParts[0].trim()) != Integer.parseInt(propParts[1].trim())){
					contender = false;
					break;
				}
			}
			
			if(contender){
				System.out.println("Sue " + sue);
			}
		}
	}

}
