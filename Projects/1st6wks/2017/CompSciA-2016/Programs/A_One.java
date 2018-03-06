import java.util.ArrayList;
public class A_One
{
	public static void main(String ars[])	
	{
		for(int a=1;a<=7;++a)
		{
			System.out.print(a);
		}
		System.out.println();
		int b=1;
		while(b<=7)
		{
			System.out.print(b);
			++b;
		}
		System.out.println();
		
		int c=1;
		do
		{
			System.out.print(c);
			++c;
		}
		while(c<=7);
		System.out.println();
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		for(int n:list)
			System.out.print(n);
	}
}