package pa1;
import java.util.Scanner;
public class question2 {
	
	public static void main (String[] args) {
		Scanner console = new Scanner(System.in);
	    System.out.print("Pick any number: ");
	    int num = console.nextInt();
	    int digits = 0;
	    for (int i = num; i > 0; i = i / 10) {
	    	digits++;
	    }
	    while (num >= 0 && digits > 0) {
	    	System.out.println(num / (int) Math.pow(10,digits-1));
	        num = num % (int) (Math.pow(10,digits-1));
	        digits = digits - 1;
	    }
	    console.close();
	}		
}
