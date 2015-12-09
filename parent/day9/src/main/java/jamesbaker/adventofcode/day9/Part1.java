package jamesbaker.adventofcode.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Collections2;

public class Part1 {
	private static final Pattern DISTANCES = Pattern.compile("([A-Za-z]+) to ([A-Za-z]+) = ([0-9]+)");
	
	public static void main(String[] args) throws IOException {
		Set<String> places = new HashSet<>();
		Map<String, Integer> distances = new HashMap<>();
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
			String line;
			while((line = buffer.readLine()) != null){
				Matcher m = DISTANCES.matcher(line);
				
				m.find();
				places.add(m.group(1));
				places.add(m.group(2));
								
				distances.put(m.group(1) + ":" + m.group(2), Integer.parseInt(m.group(3)));
				distances.put(m.group(2) + ":" + m.group(1), Integer.parseInt(m.group(3)));
			}
        }
		
		Integer minDist = Integer.MAX_VALUE;
		String minRoute = "";
		
		Collection<List<String>> permutations = Collections2.permutations(places);
		for(List<String> perm : permutations){
			if(perm.size() != places.size())
				continue;
			
			Integer dist = 0;
			StringJoiner sj = new StringJoiner(" -> ");
			for(int i = 0; i < perm.size() - 1; i++){
				dist += distances.get(perm.get(i) + ":" + perm.get(i + 1));
				sj.add(perm.get(i));
			}
			sj.add(perm.get(perm.size() - 1));

			if(dist < minDist){				
				minDist = dist;
				minRoute = sj.toString();
			}
		}
		
		System.out.println("Shortest Route: "+minRoute);
		System.out.println("Shortest Distance: "+minDist);
	}

}
