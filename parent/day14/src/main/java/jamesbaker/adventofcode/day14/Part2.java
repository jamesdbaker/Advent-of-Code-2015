package jamesbaker.adventofcode.day14;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Part2 {
	private static final Pattern REINDEER = Pattern.compile("([A-Za-z]+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");
	private static final Integer TIME = 2503;
	
	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part2.class.getResource("input.txt")));
		Map<String, Reindeer> reindeers = new HashMap<>();
		Map<String, Integer> scoreTable = new HashMap<>();
		
		for(String line : lines){
			Matcher m = REINDEER.matcher(line);
			if(m.find()){
				Reindeer r = new Reindeer(Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)));
				reindeers.put(m.group(1), r);
				scoreTable.put(m.group(1), 0);
			}else{
				System.err.println("Couldn't parse line: "+line);
			}
		}
		
		for(Integer t = 1; t <= TIME; t++){
			reindeers.values().forEach(r -> r.nextSecond());
			
			Integer maxDistance = reindeers.values().stream().max(new Comparator<Reindeer>() {
				@Override
				public int compare(Reindeer r1, Reindeer r2) {
					return r1.getDistance().compareTo(r2.getDistance());
				}
			}).get().getDistance();
			
			for(Entry<String, Reindeer> e : reindeers.entrySet()){
				if(e.getValue().getDistance() == maxDistance){
					scoreTable.put(e.getKey(), scoreTable.get(e.getKey()) + 1);
				}
			}
		}
		
		Integer maxScore = 0;
		for(Entry<String, Integer> score : scoreTable.entrySet()){
			System.out.println(score.getKey() + ": " + score.getValue());
			if(score.getValue() > maxScore){
				maxScore = score.getValue();
			}
		}
		
		System.out.println();
		System.out.println("Maximum Score: "+maxScore);
	}

}
