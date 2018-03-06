import java.io.*;
import java.util.Scanner;
public class DryRun
{
	public static void main(String ars[]) throws IOException
	{
		Scanner in= new Scanner(new FileReader("dryrun.dat"));
		int n= in.nextInt();
		for(int i=0;i<4;++i)
		{
			String w=in.next();
			System.out.println("I like "+w+".");
		}
	}
}