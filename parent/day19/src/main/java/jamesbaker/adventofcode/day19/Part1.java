package jamesbaker.adventofcode.day19;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Part1 {

	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part1.class.getResource("replacements.txt")));
		String molecule = FileUtils.readFileToString(FileUtils.toFile(Part1.class.getResource("molecule.txt")));
		
		Multimap<String, String> replacements = ArrayListMultimap.create();
		
		for(String line : lines){
			String[] parts = line.split(" => ");
			replacements.put(parts[0], parts[1]);
		}
		
		Set<String> newMolecules = new HashSet<>();
		for(String orig : replacements.keySet()){
			for(String repl : replacements.get(orig)){
				for(Integer i = 0; i <= molecule.length() - orig.length(); i++){
					String mol = molecule.substring(i, i + orig.length());
					if(mol.equals(orig)){
						newMolecules.add(molecule.substring(0, i) + repl + molecule.substring(i + orig.length()));
					}
				}
			}
		}
		
		System.out.println(newMolecules.size());
	}

}
