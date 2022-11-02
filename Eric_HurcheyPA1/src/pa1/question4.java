package pa1;
import java.util.Scanner;
public class question4{
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Your message? ");
		String message = console.nextLine();
		System.out.print("Encoding key? ");
		int rotation = console.nextInt();
		String encoded_m = "";
		char letter; 
		for (int x = 0; x < message.length(); x++) {
			letter = message.charAt(x);
			if (letter >= 'a' && letter <= 'z') {
				letter = (char)(letter + rotation);
				if (letter > 'z') {
					letter = (char)(letter + 'a' - 'z' -1);
				encoded_m = encoded_m + letter;
				}
			}
			else if(letter >= 'A' && letter <= 'Z') {
				letter = (char)(letter + rotation);
				if (letter > 'Z') {
					letter = (char) (letter + 'A' - 'Z' - 1); 
				}
				encoded_m = encoded_m + letter;
			}
			else {
				encoded_m = encoded_m + letter;
			}
		}
	System.out.println("Your Message: " + encoded_m.toUpperCase());
	console.close();
	}
}
