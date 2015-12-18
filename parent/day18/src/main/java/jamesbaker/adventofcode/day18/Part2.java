package jamesbaker.adventofcode.day18;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Part2 {

	public static void main(String[] args) throws IOException {
		boolean[][] grid = new boolean[100][100];

		List<String> lines = FileUtils.readLines(FileUtils.toFile(Part2.class.getResource("input.txt")));
		for(int y = 0; y < lines.size(); y++){
			String line = lines.get(y);
			for(int x = 0; x < line.length(); x++){
				if(line.charAt(x) == '#'){
					grid[x][y] = true;
				}
			}
		}
		
		grid[0][0] = true;
		grid[99][0] = true;
		grid[99][99] = true;
		grid[0][99] = true;
		
		for(int f = 0; f < 100; f++){
			grid = animate(grid);
		}
		
		System.out.println(countLights(grid));
	}
	
	private static boolean[][] animate(boolean[][] grid){
		boolean[][] newGrid = new boolean[100][100];
		
		for(int x = 0; x< 100; x++){
			for(int y = 0; y < 100; y++){
				
				if(x == 0 && y == 0 || x == 0 && y == 99 || x == 99 && y == 0 || x == 99 && y == 99){
					newGrid[x][y] = true;
					continue;
				}
				
				int neighbours = countNeighbours(grid, x, y);

				if(grid[x][y]){
					if(neighbours == 2 || neighbours == 3){
						newGrid[x][y] = true;
					}else{
						newGrid[x][y] = false;
					}
				}else{
					if(neighbours == 3){
						newGrid[x][y] = true;
					}else{
						newGrid[x][y] = false;
					}
				}
			}
		}
		
		return newGrid;
	}
	
	private static int countNeighbours(boolean[][] grid, int x, int y){
		int count = 0;
		
		try{
			count += grid[x-1][y-1] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		try{
			count += grid[x][y-1] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		try{
			count += grid[x+1][y-1] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		
		try{
			count += grid[x-1][y] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		try{
			count += grid[x+1][y] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		
		try{
			count += grid[x-1][y+1] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		try{
			count += grid[x][y+1] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		try{
			count += grid[x+1][y+1] ? 1 : 0;
		}catch(ArrayIndexOutOfBoundsException e){
			//Ignore
		}
		
		return count;
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
}
