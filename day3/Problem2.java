import java.io.*;
import java.util.*;
import java.util.regex.*;


class Problem2{
	public static String filterDisabledMuls(String inputString){
		StringBuilder tempBuilder = new StringBuilder(inputString);
		if(tempBuilder.indexOf("don't()") == -1) return tempBuilder.toString();

		while(tempBuilder.indexOf("don't()") != -1){
			int startTrimIndex = tempBuilder.indexOf("don't()");
			int endTrimIndex = tempBuilder.indexOf("do()", startTrimIndex + 6);
			if(endTrimIndex == -1){
				tempBuilder.delete(startTrimIndex, tempBuilder.length());
			}else {
				tempBuilder.delete(startTrimIndex, endTrimIndex + 3 + 1);
			}
		}
		return tempBuilder.toString();
	}

	public static void main(String[] args) throws Exception{
		File inputFile = new File("input.txt");
		Scanner sc = new Scanner(inputFile);
		String pattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
		int ans = 0;

		while(sc.hasNextLine()){
			String inputString = sc.nextLine();
			String enabledMulString = filterDisabledMuls(inputString);
			Pattern mulPattern = Pattern.compile(pattern);
			Matcher mulMatcher = mulPattern.matcher(enabledMulString);
			int total = 0;

			while(mulMatcher.find()){
				total += Integer.parseInt(mulMatcher.group(1)) * Integer.parseInt(mulMatcher.group(2));
			}

			ans += total;
		}

		System.out.println("Answer: " + ans);
	}
}
