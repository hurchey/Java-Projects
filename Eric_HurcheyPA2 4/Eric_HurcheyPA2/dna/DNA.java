package dna;
import java.io.*;	 // for File, PrintStream
import java.util.*;   // for Scanner, Arrays
public class DNA {
	/**
	 * Constants
	 */
	public static final int UNIQUE_NUC = 4; 
	public static final int MIN_CODON = 5;
	public static final int PERCENTAGE = 30;
	public static final int NUC_PER_CODON = 3;

	public static void main(String[] arg) throws FileNotFoundException {
		System.out.println("This program reports information about DNA");
		System.out.println("nucleotide sequences that may encode proteins.");
		Scanner console = new Scanner(System.in);
		System.out.print("Input file name? ");
		String inputFile = console.nextLine();
		System.out.print("Output file name? ");
		String outputFile = console.nextLine();
		Scanner input = new Scanner(new File(inputFile));
 		PrintStream output = new PrintStream(new File(outputFile));
 		while (input.hasNextLine()){
			String regionName = input.nextLine();
			String nucleotides = input.nextLine().toUpperCase();
			int[] countList = nucCount(nucleotides);
			double toMa = totalMass(countList, nucleotides); 				//assigns the computed values to a new variable,									
			double[] percentage = mass(countList, toMa); 					//for passing it to the printOutput function
			toMa = Math.round(toMa * 10.0) / 10.0;							//rounds the total mass to one digit past the decimal 
			String[] codonList = codon(nucleotides);
			String check = checkProtein(codonList, percentage);
			printOutput(nucleotides, regionName, countList, percentage, toMa, codonList, check, output);
		console.close();
		}
	}
	/**
	 * 
	 * @param nucleo
	 * @param UNIQUE_NUC
	 * @return count
	 * This counts the number of each unique nucleotides and creates an array of the counts
	 * 
	 */
	public static int[] nucCount(String nucleo) {
		int[] count = new int[UNIQUE_NUC];
		for (int i = 0; i < nucleo.length(); i++) {
			if(nucleo.charAt(i) == 'A') {
				count[0] += 1;
			} else if(nucleo.charAt(i) == 'C') {
				count[1] += 1;
			}else if(nucleo.charAt(i) == 'G') {
				count[2] += 1;
			}else if(nucleo.charAt(i) == 'T') {
				count[3] += 1;
			}
		}
		return count;
 	}
 	/**
 	 * 
 	 * @param countList
 	 * @param nucleo
 	 * @return totalMass
 	 * This calculates the total mass of the nucleotides
 	 * 
 	 */
 	public static double totalMass(int[] countList, String nucleo) {
 		double totalMass = 0.0;
 		double junkMass = 0.0;
 		double[] masses = {135.128, 111.103, 151.128, 125.107};
 		for (int i = 0; i < UNIQUE_NUC; i++) { 		/*Calculates the total mass*/
 			totalMass += countList[i]*masses[i];
 		}
 		for (int i = 0; i < nucleo.length(); i++) { /*Calculates the mass of the junks*/
 			if (nucleo.charAt(i) == '-') {
 				junkMass += 100;
 			}
 		}
 		totalMass += junkMass;
 		return totalMass;
 	}
 	/**
 	 * 
 	 * @param countList
 	 * @param UNIQUE_NUC
 	 * @return percentage array
 	 * This calculates the percentage of the mass of each nucleotides
 	 * 
 	 */
 	public static double[] mass(int[] countList, double totalMass) {
 		double[] masses = {135.128, 111.103, 151.128, 125.107};
 		double[] percentage = new double[UNIQUE_NUC];
 		for (int i = 0; i < UNIQUE_NUC; i++) {
 			double notRounded = 0.0;
 			notRounded = ((masses[i]*countList[i]) / totalMass) * 100; //calculates the percentage of the mass of each nucleotide in the chain
 			percentage[i] = Math.round(notRounded*10.0) / 10.0;
 		}
 		return percentage;
 	}
 	/**
 	 * 
 	 * @param nucleo
 	 * @return trioList the list of codons
 	 * This creates a list of codons from the nucleotides
 	 * 
 	 */
 	public static String[] codon(String nucleo) {
 		nucleo = nucleo.replace("-", "");
 		int nucleoLength = nucleo.length();
 		int numOfCodons = nucleoLength/3;
 		String[] trioList = new String[numOfCodons];
 		int j = 0; 										/*Instantiating a new variable for incrementing through the Nucleotides*/
 		for (int i = 0; i < numOfCodons - 1 ; i ++) {	
 			trioList[i] = nucleo.substring(j, j + NUC_PER_CODON); 
 			j += NUC_PER_CODON; 						/*increments by 3*/
 		}
 		trioList[numOfCodons - 1] = nucleo.substring(j);/*Assign the last group of codon to the array*/
 		return trioList;
 	}
 	/**
 	 * 
 	 * @param codonList
 	 * @param nucleo
 	 * @param percentage
 	 * @return boolean value to represent whether if it is a protein-coding gene
 	 * This takes in the codon list and determine whether the nucleotides is a protein-coding gene
 	 * 
 	 */
 	public static String checkProtein(String[] codonList, double[] percentage) {
 		String flag = "NO";
 		int numOfCodons = codonList.length;
 		String lastCodon = codonList[numOfCodons - 1];
 		double percentageOfCG = percentage[1] + percentage[2];  //calculates the percentage combination of 'C' and 'G' nucleotides
 		if (codonList[0].equals("ATG")){
 			flag = "YES"; 
 		} else {
 			return "NO";
 		}
 		if (lastCodon.equals("TAA") || lastCodon.equals("TAG") || lastCodon.equals("TGA")) {
 			flag = "YES";
 		} else {
 			return "NO";
 		}
 		if (numOfCodons < MIN_CODON) {
 			return "NO";
 		}
 		if (percentageOfCG < PERCENTAGE) {
 			return "NO";
 		}
 		return flag;
 	}
 	/**
 	 * 
 	 * @param nucleotides
 	 * @param regionName
 	 * @param countList
 	 * @param percentage
 	 * @param toMa
 	 * @param codonList
 	 * @param check
 	 * @param output
 	 * This prints all the computed value
 	 * 
 	 */
 	public static void printOutput(String nucleotides, String regionName, 
 									int[] countList, 
 									double[] percentage, 
 									double toMa, 
 									String[] codonList,
 									String check,
 									PrintStream output)  {
 		output.println("Region Name: " + regionName);
 		output.println("Nucleotides: " + nucleotides.replace("-", ""));
 		output.println("Nuc. Counts: " + Arrays.toString(countList));
 		output.println("Total Mass%: " + Arrays.toString(percentage) + " of " + toMa);
 		output.println("Codons List: " + Arrays.toString(codonList));
 		output.println("Is Protein? " + check);
 		output.println();
 		
 	}
}