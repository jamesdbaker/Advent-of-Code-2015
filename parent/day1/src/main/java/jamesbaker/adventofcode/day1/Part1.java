package jamesbaker.adventofcode.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Part1 {

	public static void main(String[] args) throws IOException{
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
            String content = buffer.lines().collect(Collectors.joining("\n"));
    		System.out.println(StringUtils.countMatches(content, '(') - StringUtils.countMatches(content, ')'));
        }
	}
}
