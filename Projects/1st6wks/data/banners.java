import java.util.*;
import java.io.*;

public class banners {
	public static void main(String[] args) throws IOException {
		//Declare variables
		int lines;
		String next;
		int nextInt;
		Scanner input = new Scanner(new FileReader("banners.dat"));
		Scanner start = new Scanner(input.nextLine());
		ArrayList<ArrayList<Integer>> bannerWall = new ArrayList<ArrayList<Integer>>();
		
		
		//Start program
		while(start.hasNextInt()) {
			banners.startBanner(bannerWall, start.nextInt(), start.nextInt());
		}
		start.close();
		
		lines = input.nextInt();
		for(; lines > 0; lines--) {
			next = input.next();
			nextInt = input.nextInt();
			if(next.equals("REMOVE")) {
				banners.removeBanner(bannerWall, nextInt);
			} else {
				banners.addBanner(bannerWall, nextInt);
			}
		}
		//Cleanup
		bannerWall.clear();
		input.close();
	}
	
	static void startBanner(ArrayList<ArrayList<Integer>> list, int left, int size) {
		list.add(new ArrayList<Integer>());
		list.get(list.size() - 1).add(left);
		list.get(list.size() - 1).add(size);
	}
	static void removeBanner(ArrayList<ArrayList<Integer>> list, int banner) {
		System.out.println("REMOVE BANNER AT POSITION " + list.get(banner - 1).get(0));
		list.remove(banner - 1);
		list.trimToSize();
	}
	static void addBanner(ArrayList<ArrayList<Integer>> list, int size) {
		for(int i = -1; i <= list.size(); i++) {
			if(i == -1) {
				if(list.get(i + 1).get(0) > size) {
					list.add(0, new ArrayList<Integer>());
					list.get(0).add(1);
					list.get(0).add(size);
					System.out.println("ADD BANNER AT POSITION " + list.get(0).get(0));
					break;
				}
			} else if(i == list.size() - 1) {
				int curLeft = list.get(i).get(0);
				int curSize = list.get(i).get(1);
				if(100 - (curLeft - 1 + curSize) >= size) {
					list.add(i + 1, new ArrayList<Integer>());
					list.get(i + 1).add(curLeft + curSize);
					list.get(i + 1).add(size);
					System.out.println("ADD BANNER AT POSITION " + list.get(i +1).get(0));
					break;
				}
			} else {
				int curLeft = list.get(i).get(0);
				int curSize = list.get(i).get(1);
				if(list.get(i + 1).get(0) - (curLeft - 1 + curSize) >= size) {
					list.add(i + 1, new ArrayList<Integer>());
					list.get(i + 1).add(curLeft + curSize);
					list.get(i + 1).add(size);
					System.out.println("ADD BANNER AT POSITION " + list.get(i + 1).get(0));
					break;
				}
			}
		}
	}
}