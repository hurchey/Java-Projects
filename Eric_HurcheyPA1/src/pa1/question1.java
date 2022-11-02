package pa1;
import java.util.Scanner;
public class question1 {

	public static void main (String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Initial Value is: ");

		int value = console.nextInt();
//		Creating an operations variable to read how many operations is being done
		int operations = 0;
		while (value > 1) {
			if (value % 2 == 0) {
				value = value / 2;
				System.out.println("Next value is: " + value);
				operations += 1;
			}
			else {
				value = ((3 * value) + 1);
				System.out.println("Next value is: " + value);
				operations += 1;
			}
		}
//		Creating a program where that prints Error if the input value is less than 1
		if (operations < 1 && value < 1) {
			System.out.print("Error");
//			console.close();
		}
		else{
			System.out.print("Final value " + value + ", number of operations performed " + operations);
//			console.close();
		}
		console.close();
	}

}
		