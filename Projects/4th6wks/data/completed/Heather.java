import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Heather {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("heather.dat"));
		String value1; //First value
		String base1; //Base of first value
		String value2; //Second value
		String base2; //Base of second value
		
		while(input.hasNext()) {
			value1 = input.next();
			base1 = input.next();
			value2 = input.next();
			base2 = input.next();
			
			if(value1.equals("X")) {
				System.out.println(findValue(value2, base2, base1));
			} else if(value2.equals("X")) {
				System.out.println(findValue(value1, base1, base2));
			} else if(base1.equals("X")) {
				System.out.println(findBase(value2, base2, value1));
			} else {
				System.out.println(findBase(value1, base1, value2));
			}
		}
		
		input.close();
	}
	
	//The biggest methods, they do the work and call other methods
	private static String findValue(String value, String baseValue, String baseTarget) {
		int base10Value = toBaseTen(value, stringToInt(baseValue)); //Converts the input value to base 10
		int targetBase = stringToInt(baseTarget); //Converts baseTarget to an int
		return baseConverter(base10Value, targetBase);
	}
	private static int findBase(String value, String base, String goalValue) { //Finds an equivalent value and returns the base its in
		int base10Value = toBaseTen(value, stringToInt(base));
		for(int iteration = 2; iteration <= 36; iteration++) {
			if(baseConverter(base10Value, iteration).equals(goalValue)) {
				return iteration;
			}
		}
		return 0;
	}
	
	//Type converting methods
	private static int stringToIntMap(String string) { //Returns a primitive 'int' from a numerical string after a lookup from a hashmap, used for values
		HashMap<String, Integer> map = constructSIMap();
		return map.get(string).intValue();
	}
	private static int stringToInt(String string) { //Returns a primitive 'int' from a numerical string, used for bases
		return new Integer(string).intValue();
	}
	
	//Miscellaneous
	private static int toBaseTen(String value, int base) { //Converts a value in a base to base 10 value
		ArrayList<String> splitString = new ArrayList<String>(); //Will split string into digits in the array, least value to greatest
		
		int base10 = 0; //Will store final return value
		
		for(int length = value.length(); length > 0; length--) { //Cycles through string backwards and puts it in the array
			splitString.add(value.substring(length - 1, length));
		}
		
		for(int iteration = 0; iteration < (splitString.size()); iteration++) { //Goes through array and converts to int, then multplies by base^iteration, creating a base 10 value
			base10 += stringToIntMap(splitString.get(iteration)) * (Math.pow(base, iteration));
		}
		
		return base10; //Return final value
	}
	
	private static String baseConverter(int value, int base) {
		int iterationPow = 0;
		int iterationMul = 0;
		ArrayList<String> integerString = constructISArray();
		for(;Math.pow(base, iterationPow) <= value; iterationPow++) {}
		iterationPow--;
		for(;(Math.pow(base, iterationPow) * iterationMul) <= value; iterationMul++) {}
		iterationMul--;
		if((value - (Math.pow(base, iterationPow) * iterationMul)) == 0) {
			return integerString.get(iterationMul);
		} else {
			return integerString.get(iterationMul) + baseConverter((int)(value - (Math.pow(base, iterationPow) * iterationMul)), base);
		}
	}
	
	//Construction methods, provides maps and arrays for methods instead of adding this junk in them or req'ing an input of it
	private static HashMap<String, Integer> constructSIMap() { //Allows creation of the hashmap within methods that need it instead of requiring it as an arg
		HashMap<String, Integer> letterValue = new HashMap<String, Integer>(); //Allows 'reading' of letter values
		
		letterValue.put("0", 0);
		letterValue.put("1", 1);
		letterValue.put("2", 2);
		letterValue.put("3", 3);
		letterValue.put("4", 4);
		letterValue.put("5", 5);
		letterValue.put("6", 6);
		letterValue.put("7", 7);
		letterValue.put("8", 8);
		letterValue.put("9", 9);
		letterValue.put("A", 10);
		letterValue.put("B", 11);
		letterValue.put("C", 12);
		letterValue.put("D", 13);
		letterValue.put("E", 14);
		letterValue.put("F", 15);
		letterValue.put("G", 16);
		letterValue.put("H", 17);
		letterValue.put("I", 18);
		letterValue.put("J", 19);
		letterValue.put("K", 20);
		letterValue.put("L", 21);
		letterValue.put("M", 22);
		letterValue.put("N", 23);
		letterValue.put("O", 24);
		letterValue.put("P", 25);
		letterValue.put("Q", 26);
		letterValue.put("R", 27);
		letterValue.put("S", 28);
		letterValue.put("T", 29);
		letterValue.put("U", 30);
		letterValue.put("V", 31);
		letterValue.put("W", 32);
		letterValue.put("X", 33);
		letterValue.put("Y", 34);
		letterValue.put("Z", 35);
		
		return letterValue;
	}
	
	private static ArrayList<String> constructISArray() { //Will allow me to convert base 10 values into single digits by 'stringArray[base10value]'
		ArrayList<String> stringArray = new ArrayList<String>();
		
		stringArray.add("0");
		stringArray.add("1");
		stringArray.add("2");
		stringArray.add("3");
		stringArray.add("4");
		stringArray.add("5");
		stringArray.add("6");
		stringArray.add("7");
		stringArray.add("8");
		stringArray.add("9");
		stringArray.add("A");
		stringArray.add("B");
		stringArray.add("C");
		stringArray.add("D");
		stringArray.add("E");
		stringArray.add("F");
		stringArray.add("G");
		stringArray.add("H");
		stringArray.add("I");
		stringArray.add("J");
		stringArray.add("K");
		stringArray.add("L");
		stringArray.add("M");
		stringArray.add("N");
		stringArray.add("O");
		stringArray.add("P");
		stringArray.add("Q");
		stringArray.add("R");
		stringArray.add("S");
		stringArray.add("T");
		stringArray.add("U");
		stringArray.add("V");
		stringArray.add("W");
		stringArray.add("X");
		stringArray.add("Y");
		stringArray.add("Z");
		
		return stringArray;
	}
}