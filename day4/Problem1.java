import java.io.*;
import java.util.*;

class Problem1{
		
	public static void readMatrix(ArrayList<ArrayList<String>> matrix, String line){
		ArrayList<String> row  = new ArrayList<String>();
		String[] tokens = line.split("");
		for(int i=0; i < tokens.length ; i++){
			row.add(tokens[i]);
		}
		matrix.add(row);
	}

	public static void main(String[] args) throws Exception{
		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
		File inputFile = new File("input.txt");
		Scanner sc = new Scanner(inputFile);
		while(sc.hasNextLine()){
			readMatrix(matrix, sc.nextLine());
		}

		int xmasCount = 0;

		for(int row=0; row < matrix.size(); row++){
			ArrayList<String> currRow = matrix.get(row);
			for(int col=0; col < currRow.size(); col++){
				if(currRow.get(col).equals("X")){
					// Horizontal
					if(col + 3 <= currRow.size() - 1){
						if(currRow.get(col + 1).equals("M") && currRow.get(col + 2).equals("A") && currRow.get(col + 3).equals("S")){
							xmasCount++;
						}
					}

					// Horizontal reverse
					if(col - 3 >= 0){	
						if(currRow.get(col - 1).equals("M") && currRow.get(col - 2).equals("A") && currRow.get(col - 3).equals("S")){
							xmasCount++;
						}
					}

					// Vertical
					if(row + 3 <= matrix.size() - 1){
						if(matrix.get(row + 1).get(col).equals("M") && matrix.get(row + 2).get(col).equals("A") && matrix.get(row + 3).get(col).equals("S")){
							xmasCount++;
						}
					}

					// Vertical reverse
					if(row - 3 >= 0){
						if(matrix.get(row - 1).get(col).equals("M") && matrix.get(row - 2).get(col).equals("A") && matrix.get(row - 3).get(col).equals("S")){
							xmasCount++;
						}
					}

					// Top-Down Diagonally forward
					if(row + 3 <= matrix.size() - 1 && col + 3 <= currRow.size() - 1){
						if(matrix.get(row + 1).get(col + 1).equals("M") && matrix.get(row + 2).get(col + 2).equals("A") && matrix.get(row + 3).get(col + 3).equals("S")){
							xmasCount++;
						}
					}

					// Top-Down Diagonally backward
					if(row + 3 <= matrix.size() - 1 && col - 3 >= 0){
						if(matrix.get(row + 1).get(col - 1).equals("M") && matrix.get(row + 2).get(col - 2).equals("A") && matrix.get(row + 3).get(col - 3).equals("S")){
							xmasCount++;
						}
					}

					// Bottom-Up Diagonally forward
					if(row - 3 >= 0 && col + 3 <= currRow.size() - 1){
						if(matrix.get(row - 1).get(col + 1).equals("M") && matrix.get(row - 2).get(col + 2).equals("A") && matrix.get(row - 3).get(col + 3).equals("S")){
							xmasCount++;
						}
					}

					// Botom-Up Diagonally backward
					if(row - 3 >= 0 && col - 3 >= 0){
						if(matrix.get(row - 1).get(col - 1).equals("M") && matrix.get(row - 2).get(col - 2).equals("A") && matrix.get(row - 3).get(col - 3).equals("S")){
							xmasCount++;
						}
					}
				}
			}
		}

		System.out.println(xmasCount);
	}
}

