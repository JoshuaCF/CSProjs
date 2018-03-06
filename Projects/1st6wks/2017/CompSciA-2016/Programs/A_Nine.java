import java.io.*;
import java.util.Scanner;
public class A_Nine
{
	
	public static void main(String ars[]) throws IOException
	{
		Scanner in= new Scanner(new FileReader("a_nine.dat"));
		int n=in.nextInt();
		for(int j=0;j<4;j++)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			double c=a;
			double d=b;
			int sum= a+b;
			int diff;
			if(a>b)
			diff=a-b;
			else
			diff=b-a;
			int pro=a*b;
			double quo;
			if(c>d)
			quo=c/d;
			else
			quo=d/c;
			System.out.print(sum+" "+diff+" "+pro);
			System.out.printf("%5.2f",quo);
			System.out.println("");
		}
	}
}