package jamesbaker.adventofcode.day13;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Collections2;

public class Part2 {
	private static final Pattern HAPPINESS = Pattern.compile("([A-Za-z]+) would (gain|lose) (\\d+) happiness units by sitting next to ([A-Za-z]+)");
	
	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part2.class.getResource("input.txt")));
		Map<String, Integer> happinessGain = new HashMap<>();
		Set<String> names = new HashSet<>();
		
		for(String line : lines){
			Matcher m = HAPPINESS.matcher(line);
			if(m.find()){
				happinessGain.put(m.group(1) + ":" + m.group(4), m.group(2).equals("gain") ? Integer.parseInt(m.group(3)) : -Integer.parseInt(m.group(3)));
				names.add(m.group(1));
			}else{
				System.err.println("Couldn't parse line: "+line);
			}
		}
		
		for(String name : names){
			happinessGain.put(name + ":Me", 0);
			happinessGain.put("Me:" + name, 0);
		}
		names.add("Me");
		
		Integer maxHappiness = Integer.MIN_VALUE;
		
		Collection<List<String>> permutations = Collections2.permutations(names);
		for(List<String> perm : permutations){
			if(perm.size() != names.size())
				continue;
			
			Integer happiness = 0;
			for(int i = 0; i < perm.size() - 1; i++){
				happiness += happinessGain.get(perm.get(i) + ":" + perm.get(i + 1));
				happiness += happinessGain.get(perm.get(i + 1) + ":" + perm.get(i));
			}
			happiness += happinessGain.get(perm.get(0) + ":" + perm.get(perm.size() - 1));
			happiness += happinessGain.get(perm.get(perm.size() - 1) + ":" + perm.get(0));

			if(happiness > maxHappiness){				
				maxHappiness = happiness;
			}
		}
		
		System.out.println(maxHappiness);
	}

}
