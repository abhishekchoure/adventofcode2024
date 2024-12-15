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

		int masCount = 0;

		for(int row=0; row < matrix.size(); row++){
			ArrayList<String> currRow = matrix.get(row);
			for(int col=0; col < currRow.size(); col++){
				if(currRow.get(col).equals("A")){
					if(row + 1 < matrix.get(row).size() && row - 1 >= 0 && col + 1 < currRow.size() && col - 1 >= 0){
						if(matrix.get(row + 1).get(col - 1).equals("M") && matrix.get(row + 1).get(col + 1).equals("S") && matrix.get(row - 1).get(col - 1).equals("M") && matrix.get(row - 1).get(col + 1).equals("S")){
							masCount++;
						}
						if(matrix.get(row + 1).get(col - 1).equals("M") && matrix.get(row + 1).get(col + 1).equals("M") && matrix.get(row - 1).get(col - 1).equals("S") && matrix.get(row - 1).get(col + 1).equals("S")){
							masCount++;
						}
						if(matrix.get(row + 1).get(col - 1).equals("S") && matrix.get(row + 1).get(col + 1).equals("S") && matrix.get(row - 1).get(col - 1).equals("M") && matrix.get(row - 1).get(col + 1).equals("M")){
							masCount++;
						}
						if(matrix.get(row + 1).get(col - 1).equals("S") && matrix.get(row + 1).get(col + 1).equals("M") && matrix.get(row - 1).get(col - 1).equals("S") && matrix.get(row - 1).get(col + 1).equals("M")){
							masCount++;
						}		
					}
				}
			}
		}

		System.out.println(masCount);
	}
}

