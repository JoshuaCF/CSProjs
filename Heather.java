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
		
		HashMap<String, Integer> letterValue = new HashMap<String, Integer>(); //Allows 'reading' of letter values

		letterValue.put("0", new Integer(0));
		letterValue.put("1", new Integer(1));
		letterValue.put("2", new Integer(2));
		letterValue.put("3", new Integer(3));
		letterValue.put("4", new Integer(4));
		letterValue.put("5", new Integer(5));
		letterValue.put("6", new Integer(6));
		letterValue.put("7", new Integer(7));
		letterValue.put("8", new Integer(8));
		letterValue.put("9", new Integer(9));
		letterValue.put("A", new Integer(10));
		letterValue.put("B", new Integer(11));
		letterValue.put("C", new Integer(12));
		letterValue.put("D", new Integer(13));
		letterValue.put("E", new Integer(14));
		letterValue.put("F", new Integer(15));
		//This is sloppy, but it works
		
		while(input.hasNext()) {
			value1 = input.next();
			base1 = input.next();
			value2 = input.next();
			base2 = input.next();
		}
		
		input.close();
	}
	
	static int toBaseTen(String value, int base, HashMap<String, Integer> map) {
		ArrayList<String> splitString = new ArrayList<String>();
		int base10 = 0;
		for(int length = value.length(); length > 0; length--) {
			splitString.add(value.substring(length - 1, length));
		}
		for(int iteration = 0; iteration < (splitString.size()); iteration++) {
			base10 += stringToIntMap(splitString.get(iteration), map) * (Math.pow(base, iteration));
		}
		
		return base10;
	}
	
	static int stringToIntMap(String string, HashMap<String, Integer> map) { //Returns a primitive 'int' from a numerical string after a lookup from a hashmap
		return map.get(string).intValue();
	}
	static int stringToInt(String string) { //Returns a primitive 'int' from a numerical string after a lookup from a hashmap
		return new Integer(string).intValue();
	}
	
	int findBase(int value, int goalValue) { //Finds an equivalent value and returns the base its in
		
		
		return 3; //Placeholder to stop eclipse from yelling the method returns nothing
	}
}