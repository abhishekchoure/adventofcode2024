import java.io.*;
import java.util.*;
import java.util.regex.*;


class Problem1{
	public static void main(String[] args) throws Exception{	
		File inputFile = new File("input.txt");
		Scanner sc = new Scanner(inputFile);
		String pattern = "mul\\((\\d+),(\\d+)\\)";
		int ans = 0;

		while(sc.hasNextLine()){
			String inputString = sc.nextLine();
			Pattern mulPattern = Pattern.compile(pattern);
			Matcher mulMatcher = mulPattern.matcher(inputString);
			int total = 0;

			while(mulMatcher.find()){
				total += Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2));
			}

			ans += total;
		}

		System.out.println("Answer: " + ans);
	}
}
