package jamesbaker.adventofcode.day17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;


public class Part2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part2.class.getResource("input.txt")));
		List<Integer> containers = new ArrayList<>();

		lines.forEach(s -> containers.add(Integer.parseInt(s)));

		Integer count = 0;
		
		ICombinatoricsVector<Integer> initialVector = Factory.createVector(containers);
		for(int i = 1; i <= containers.size(); i++){
			Generator<Integer> gen = Factory.createSimpleCombinationGenerator(initialVector, i);
			for (ICombinatoricsVector<Integer> combination : gen) {
				Integer total = 0;
				for(Integer container : combination){
					total += container;
				}
				
				if(total == 150){
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
