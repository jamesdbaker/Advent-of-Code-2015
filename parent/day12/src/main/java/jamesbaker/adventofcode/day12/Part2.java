package jamesbaker.adventofcode.day12;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Part2 {

	public static void main(String[] args) throws IOException {
		String input = FileUtils.readFileToString(FileUtils.toFile(Part1.class.getResource("input.txt")));
		JSONArray rootArray = new JSONArray(input);
		
		System.out.println(process(rootArray));
	}
	
	private static Integer process(Object o){
		Integer total = 0;
		if(o instanceof JSONArray){
			JSONArray a = (JSONArray) o;
			for(Object obj : a){
				total += process(obj);
			}
		}else if(o instanceof JSONObject){
			JSONObject a = (JSONObject) o;

			if(allowObject(a)){
				Iterator<?> keys = a.keys();
				
				while( keys.hasNext() ) {
				    String key = (String)keys.next();
				    total += process(a.get(key));
				}
			}
		}else if(o instanceof Integer){
			total += (Integer) o;
		}
		
		return total;
	}
	
	private static boolean allowObject(JSONObject obj){
		Iterator<?> keys = obj.keys();

		while( keys.hasNext() ) {
		    Object o = obj.get((String)keys.next());
		    if(o instanceof String){
		    	String s = (String) o;
		    	if(s.equalsIgnoreCase("red")){
		    		return false;
		    	}
		    }
		}
		
		return true;
	}
}
