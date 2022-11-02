package pa1;
import java.util.Scanner;
public class question5{
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Your first name? ");
//		Calling a string fn to get the string of the first name
		String fn = console.nextLine();
		System.out.print("Your last name? ");
//		Calling a string ln to get the string of the last name
		String ln = console.nextLine();
//		Making the first name all lower case
		String fnlower = fn.toLowerCase();
//		A program to get a hold of the firstname's first letter
		char fnletter = fnlower.charAt(0);
		String newfn2 = fnlower.substring(1) + fnletter + "ay";
//		Taking to account any random spaces and removing the spaces
		String newfirstname = newfn2.replaceAll("\\s", "");
//		Having a string to hold the first pig latin name
		String newfirstname2 = newfirstname.substring(0,1).toUpperCase() + newfirstname.substring(1);
//		Making the last name all lower case
		String lastname1 = ln.toLowerCase();
		char lastletter = lastname1.charAt(0);
		String lastname2 = lastname1.substring(1) + lastletter + "ay";
//		Taking to account any random spaces and removing the spaces
		String newlastname = lastname2.replaceAll("\\s", "");
//		Having a string to hold the last pig latin name
		String newlastname2 = newlastname.substring(0,1).toUpperCase() + newlastname.substring(1);
//		A program to print out the first and last pig latin names
		System.out.print(newfirstname2 + " " + newlastname2);
		console.close();
	}
}