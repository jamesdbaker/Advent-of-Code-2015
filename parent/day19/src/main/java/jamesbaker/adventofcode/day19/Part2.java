package jamesbaker.adventofcode.day19;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Part2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part2.class.getResource("replacements.txt")));
		String molecule = FileUtils.readFileToString(FileUtils.toFile(Part2.class.getResource("molecule.txt")));
		
		Multimap<String, String> replacements = ArrayListMultimap.create();
		
		for(String line : lines){
			String[] parts = line.split(" => ");
			replacements.put(parts[0], parts[1]);
		}
		
		Integer depth = 0;
		
		Set<String> currLevel = new HashSet<>();
		currLevel.add(molecule);
		
		Set<String> prevSeen = new HashSet<>();
		prevSeen.add(molecule);

		while(!currLevel.contains("e") && !currLevel.isEmpty()){
			depth++;
			System.out.println(depth + " (" + currLevel.size() + ")");
			Set<String> nextLevel = new HashSet<>();
			for(String c : currLevel){
				nextLevel.addAll(doReplacement(c, replacements));
			}
			
			nextLevel.removeAll(prevSeen);
			prevSeen.addAll(nextLevel);
			
			Set<String> sortedNextLevel = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String key1, String key2) {
					if(key1.length() >= key2.length()){
						return 1;
					}else{
						return -1;
					}
				}
			});
			sortedNextLevel.addAll(nextLevel);
			
			currLevel = new HashSet<>();
			Iterator<String> iter = sortedNextLevel.iterator();
			while(iter.hasNext() && currLevel.size() <= 10){
				currLevel.add(iter.next());
			}
		}
		
		System.out.println("Solution: "+depth);
	}
	
	private static Collection<String> doReplacement(String original, Multimap<String, String> replacements){		
		Set<String> replaced = new HashSet<>();
		for(String orig : replacements.keySet()){
			for(String repl : replacements.get(orig)){
				int index = 0;
				while((index = original.indexOf(repl, index)) != -1){
					replaced.add(original.substring(0, index) + orig + original.substring(index + repl.length()));
					index++;
				}
			}
		}
		
		return replaced;
	}

}
