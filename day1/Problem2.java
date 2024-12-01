import java.io.*;
import java.util.*;

class Problem2{
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

		int ans = 0;
		for(int i=0; i < arr1.size() ; i++){
			int key = arr1.get(i);
			int times = 0;
		
			for(int j=0; j< arr2.size(); j++){
				if(key == arr2.get(j)){
					times++;	
				}
			}

			ans = ans + key * times;
		}	

		System.out.println("Similarity Score : " + ans);
	}
}


