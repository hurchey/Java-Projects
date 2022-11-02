package pa1;
import java.util.Scanner;
public class question3 {
	
	public static void main (String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Pick any number from 1 to 4999: ");
		int num = console.nextInt();
		String roman = "";
		if (num < 1 || num >= 5000) {
			System.out.print("Error");
		}
		else {
			while (num >= 1000) {
				roman += "M";
				num -=1000;
			}
			while (num >= 900) {
				roman += "CM";
				num -= 900;
			}
			while (num >= 500) {
				roman += "D";
				num -= 500;
			}
			while (num >= 400){
				roman += "CD";
				num -= 400;
			}
			while (num >= 100) {
				roman += "C";
				num -= 100;
			}
			while (num >= 90) {
				roman += "XC";
				num -= 90;
			}
			while (num >= 50) {
				roman += "L";
				num -= 50;
				}
			while (num >= 40) {
				roman += "XL";
				num -= 40;
			}
			while (num >= 10) {
				roman += "X";
				num -= 10;
			}
			while (num >= 9) {
				roman += "IX";
				num -= 9;
			}
			while (num >= 5) {
				roman += "V";
				num -= 5;
			}
			while (num >= 4) {
				roman += "IV";
				num -= 4;
			}
			while (num >= 1) {
				roman += "I";
				num -= 1;
			}
			System.out.print(roman);
			console.close();
		}
		System.out.print(roman);
		console.close();

	}
}
