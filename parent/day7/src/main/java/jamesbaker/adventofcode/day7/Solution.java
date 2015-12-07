package jamesbaker.adventofcode.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class Solution {
	private static final Pattern SET = Pattern.compile("([a-z0-9]+) -> ([a-z]+)");
	private static final Pattern NOT = Pattern.compile("NOT ([a-z0-9]+) -> ([a-z]+)");
	private static final Pattern OR = Pattern.compile("([a-z0-9]+) OR ([a-z0-9]+) -> ([a-z]+)");
	private static final Pattern AND = Pattern.compile("([a-z0-9]+) AND ([a-z0-9]+) -> ([a-z]+)");
	private static final Pattern RSHIFT = Pattern.compile("([a-z0-9]+) RSHIFT ([0-9]+) -> ([a-z]+)");
	private static final Pattern LSHIFT = Pattern.compile("([a-z0-9]+) LSHIFT ([0-9]+) -> ([a-z]+)");
	
	public static void main(String[] args) throws IOException {
		Map<String, Integer> valueRegister = new HashMap<>();
		
		List<String> instructions = new ArrayList<>();
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("input.txt")))) {
			String line;
			while((line = buffer.readLine()) != null){
				instructions.add(line);
			}
        }
		
		List<String> instructionsPart1 = new ArrayList<>(instructions);
		while(!instructionsPart1.isEmpty()){
			Iterator<String> iter = instructionsPart1.iterator();
			while(iter.hasNext()){
				if(parseInstruction(iter.next(), valueRegister)){
					iter.remove();
				}
			}
		}
		
		System.out.println("Part 1, value of a: " + valueRegister.get("a"));
		
		Integer a = valueRegister.get("a");
		valueRegister = new HashMap<>();
		
		List<String> instructionsPart2 = new ArrayList<>(instructions);
		while(!instructionsPart2.isEmpty()){
			Iterator<String> iter = instructionsPart2.iterator();
			while(iter.hasNext()){
				String inst = iter.next();
				if(inst.endsWith(" -> b")){
					inst = a + " -> b";
				}
				
				if(parseInstruction(inst, valueRegister)){
					iter.remove();
				}
			}
		}
		
		System.out.println("Part 2, value of a: " + valueRegister.get("a"));
	}
	
	private static boolean parseInstruction(String s, Map<String, Integer> values){
		//Is the instruction SET?
		Matcher mSet = SET.matcher(s);
		if(mSet.matches()){
			Integer val = null;
			if(StringUtils.isNumeric(mSet.group(1))){
				val = Integer.parseInt(mSet.group(1));
			}else{
				val = values.getOrDefault(mSet.group(1), null);
			}
			
			if(val == null){
				return false;
			}
			
			values.put(mSet.group(2), val);
			return true;
		}
		
		//Is the instruction NOT?
		Matcher mNot = NOT.matcher(s);
		if(mNot.matches()){
			Integer val = null;
			if(StringUtils.isNumeric(mNot.group(1))){
				val = Integer.parseInt(mNot.group(1));
			}else{
				val = values.getOrDefault(mNot.group(1), null);
			}
			
			if(val == null){
				return false;
			}
			
			values.put(mNot.group(2), ~val);
			return true;
		}
		
		//Is the instruction OR?
		Matcher mOr = OR.matcher(s);
		if(mOr.matches()){
			Integer val1 = null;
			if(StringUtils.isNumeric(mOr.group(1))){
				val1 = Integer.parseInt(mOr.group(1));
			}else{
				val1 = values.getOrDefault(mOr.group(1), null);
			}
			
			if(val1 == null){
				return false;
			}
			
			Integer val2 = null;
			if(StringUtils.isNumeric(mOr.group(2))){
				val2 = Integer.parseInt(mOr.group(2));
			}else{
				val2 = values.getOrDefault(mOr.group(2), null);
			}
			
			if(val2 == null){
				return false;
			}
			
			values.put(mOr.group(3), val1 | val2);
			return true;
		}
		
		//Is the instruction AND?
		Matcher mAnd = AND.matcher(s);
		if(mAnd.matches()){
			Integer val1 = null;
			if(StringUtils.isNumeric(mAnd.group(1))){
				val1 = Integer.parseInt(mAnd.group(1));
			}else{
				val1 = values.getOrDefault(mAnd.group(1), null);
			}
			
			if(val1 == null){
				return false;
			}
			
			Integer val2 = null;
			if(StringUtils.isNumeric(mAnd.group(2))){
				val2 = Integer.parseInt(mAnd.group(2));
			}else{
				val2 = values.getOrDefault(mAnd.group(2), null);
			}
			
			if(val2 == null){
				return false;
			}
			
			values.put(mAnd.group(3), val1 & val2);
			return true;
		}
		
		//Is the instruction RSHIFT?
		Matcher mRShift = RSHIFT.matcher(s);
		if(mRShift.matches()){
			Integer val1 = null;
			if(StringUtils.isNumeric(mRShift.group(1))){
				val1 = Integer.parseInt(mRShift.group(1));
			}else{
				val1 = values.getOrDefault(mRShift.group(1), null);
			}
			
			if(val1 == null){
				return false;
			}
			
			Integer shift = Integer.parseInt(mRShift.group(2));
			
			values.put(mRShift.group(3), val1 >> shift);
			return true;
		}
		
		//Is the instruction LSHIFT?
		Matcher mLShift = LSHIFT.matcher(s);
		if(mLShift.matches()){
			Integer val1 = null;
			if(StringUtils.isNumeric(mLShift.group(1))){
				val1 = Integer.parseInt(mLShift.group(1));
			}else{
				val1 = values.getOrDefault(mLShift.group(1), null);
			}
			
			if(val1 == null){
				return false;
			}
			
			Integer shift = Integer.parseInt(mLShift.group(2));
			
			values.put(mLShift.group(3), val1 << shift);
			return true;
		}
		
		System.err.println("Didn't understand instruction: "+s);
		return true;
	}

}
