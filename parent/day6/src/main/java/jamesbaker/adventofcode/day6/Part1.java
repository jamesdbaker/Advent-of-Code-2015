package jamesbaker.adventofcode.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Part1 {

	public static void main(String[] args) throws IOException {
		boolean[][] grid = new boolean[1000][1000];
		
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(Part1.class.getResourceAsStream("input.txt")))) {
			String line;
			while((line = buffer.readLine()) != null){
				if(line.startsWith("turn on ")){
					int[] corners = parseRect(line.substring(8));
					trueGrid(grid, corners[0], corners[1], corners[2], corners[3]);
				}else if(line.startsWith("turn off ")){
					int[] corners = parseRect(line.substring(9));
					falseGrid(grid, corners[0], corners[1], corners[2], corners[3]);
				}else if(line.startsWith("toggle ")){
					int[] corners = parseRect(line.substring(7));
					toggleGrid(grid, corners[0], corners[1], corners[2], corners[3]);
				}else{
					System.err.println("Unexpected input: "+line);
				}
			}
        }
		
		System.out.println(countLights(grid));
	}
	
	private static int[] parseRect(String s){
		int[] ret = new int[4];	//x1, y1, x2, y2
		String[] corners = s.split(" through ");
		String[] one = corners[0].split(",");
		String[] two = corners[1].split(",");
		
		ret[0] = Integer.valueOf(one[0]);
		ret[1] = Integer.valueOf(one[1]);
		ret[2] = Integer.valueOf(two[0]);
		ret[3] = Integer.valueOf(two[1]);
		
		return ret;
	}

	private static int countLights(boolean[][] grid){
		int count = 0;
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid[x].length; y++){
				if(grid[x][y] == true)
					count++;
			}
		}
		
		return count;
	}
	
	private static void toggleGrid(boolean[][] grid, int x1, int y1, int x2, int y2){
		for (int x = x1; x <= x2; x++){
			for (int y = y1; y <= y2; y++){
				grid[x][y] = !grid[x][y];
			}
		}
	}
	
	private static void trueGrid(boolean[][] grid, int x1, int y1, int x2, int y2){
		for (int x = x1; x <= x2; x++){
			for (int y = y1; y <= y2; y++){
				grid[x][y] = true;
			}
		}
	}
	
	private static void falseGrid(boolean[][] grid, int x1, int y1, int x2, int y2){
		for (int x = x1; x <= x2; x++){
			for (int y = y1; y <= y2; y++){
				grid[x][y] = false;
			}
		}
	}
}
