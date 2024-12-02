import java.util.*;
import java.io.*;

class Problem1{

	public static ArrayList<Integer> parseLine(String line) throws Exception{
		ArrayList<Integer> parsedInputLine = new ArrayList<Integer>();
		String[] numbers = line.split(" ");
		for(int i=0; i < numbers.length; i++){
			parsedInputLine.add(Integer.parseInt(numbers[i]));
		}
		return parsedInputLine;
	}

	public static Boolean isArrayIncreasing(ArrayList<Integer> numbers){
		for(int i=1 ; i < numbers.size(); i++){
			if(numbers.get(i - 1) <= numbers.get(i)){
				return false;
			}
		}
		return true;
	}

	public static Boolean isArrayDecreasing(ArrayList<Integer> numbers){
		for(int i=1 ; i < numbers.size(); i++){
			if(numbers.get(i - 1) >= numbers.get(i)){
				return false;
			}
		}
		return true;
	}

	public static Boolean areDifferingLevelsCorrect(ArrayList<Integer> numbers){
		for(int i=1; i < numbers.size(); i++){
			if(Math.abs(numbers.get(i-1) - numbers.get(i)) > 3){
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception{
		List<ArrayList<Integer>> inputs = new ArrayList<ArrayList<Integer>>();
		int safeReportsCounter = 0;

		File inputFile = new File("input.txt");
		Scanner sc = new Scanner(inputFile);
		while(sc.hasNextLine()){
			ArrayList<Integer> parsedNumberArray = parseLine(sc.nextLine());
			inputs.add(parsedNumberArray);
		}
	
		for(int i=0; i< inputs.size(); i++){
			ArrayList<Integer> numbers = inputs.get(i);
			Boolean checks = isArrayIncreasing(numbers) || isArrayDecreasing(numbers);
			if(checks){
				Boolean levelsCheck = areDifferingLevelsCorrect(numbers);
				if(levelsCheck){
					safeReportsCounter++;
				}
			}
		}	
		System.out.println("Safe Reports : " + safeReportsCounter);
	}
}
