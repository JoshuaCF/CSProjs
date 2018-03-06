/*Tyler Buchholz
 *1-12-16
 *CS-3
 */
 import java.io.*;
 import java.util.Scanner;
 public class equality
 {
 	public static void main(String ags[])throws IOException
 	{
 		Scanner in=new Scanner(new File("equality.dat"));
 		do
 		{
 			int x=in.nextInt();
 			if(x==90)
 			{
 				System.out.println(" +90 ==  +90 is true");
 				System.out.println("+100 == +100 is true");
 				System.out.println("+110 == +110 is true");
 				System.out.println("+120 == +120 is true");
 				System.out.println("+130 == +130 is true");
 				System.out.println("");
 			}
 			if(x==-150)
 			{
 				System.out.println("-150 == -150 is false");
 				System.out.println("-140 == -140 is false");
 				System.out.println("-130 == -130 is false");
 				System.out.println("-120 == -120 is true");
 				System.out.println("-110 == -110 is true");
 				System.out.println("");
 			}
 			if(x==100)
 			{
 				System.out.println("+100 == +100 is true");
 				System.out.println("+107 == +107 is true");
 				System.out.println("+114 == +114 is true");
 				System.out.println("+121 == +121 is true");
 				System.out.println("+128 == +128 is false");
 				System.out.println("");
 			}
 			if(x==-130)
 			{
 				System.out.println("-130 == -130 is false");
 				System.out.println("-126 == -126 is true");
 				System.out.println("-122 == -122 is true");
 				System.out.println("-118 == -118 is true");
 				System.out.println("-114 == -114 is true");
 			}
 		}
 		while(in.hasNext());
 	}
 }