package jamesbaker.adventofcode.day14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Part1 {
	private static final Pattern REINDEER = Pattern.compile("([A-Za-z]+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");
	private static final Integer TIME = 2503;
	
	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part1.class.getResource("input.txt")));
		List<Reindeer> reindeers = new ArrayList<>();
		
		for(String line : lines){
			Matcher m = REINDEER.matcher(line);
			if(m.find()){
				Reindeer r = new Reindeer(Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)));
				reindeers.add(r);
			}else{
				System.err.println("Couldn't parse line: "+line);
			}
		}
		
		for(Integer t = 0; t < TIME; t++){
			for(Reindeer r : reindeers){
				r.nextSecond();
			}
		}
		
		Integer maxDistance = 0;
		for(Reindeer r : reindeers){
			if(r.getDistance() > maxDistance){
				maxDistance = r.getDistance();
			}
		}
		
		System.out.println(maxDistance);
	}

}
