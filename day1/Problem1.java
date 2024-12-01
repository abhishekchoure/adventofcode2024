import java.io.*;
import java.util.*;

class Problem1{
	public static void main(String[] args) throws Exception{
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		File inputFile = new File("input.txt");
		Scanner sc = new Scanner(inputFile);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] inputs = line.split("   ");
			arr1.add(Integer.parseInt(inputs[0]));
			arr2.add(Integer.parseInt(inputs[1]));
		}

		Collections.sort(arr1);
		Collections.sort(arr2);

		int ans = 0;
		for(int i=0; i<arr1.size(); i++){
			ans += Math.abs(arr1.get(i) - arr2.get(i));
		}
		System.out.println("Total Distance : " + ans);
	}
}
