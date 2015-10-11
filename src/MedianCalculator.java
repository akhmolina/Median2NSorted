import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedianCalculator {

	public static void main(String[] args) {
		String[] firstNarray, secondNarray;
		int N =0;
		
		Scanner in = new Scanner(System.in);		
		do
		{
			System.out.println("Введите первый отсортированный по возрастанию массив N натуральных чисел, разделенных любым символом (одной строкой):");
	        String firstN = in.nextLine();
	        System.out.println("Введите второй отсортированный по возрастанию массив N натуральных чисел, разделенных любым символом (одной строкой):");
	        String secondN = in.nextLine();
	        
	        //deleting non-digits at the start and the end
	        Pattern p = Pattern.compile("^\\D*((\\d+\\D+)*\\d+)\\D*$");  
	        Matcher firstm = p.matcher(firstN);
	        Matcher secondm = p.matcher(secondN);
	        
	        if (firstm.matches()){firstN = firstm.group(1);}
	        if (secondm.matches()){secondN = secondm.group(1);}

			firstNarray = firstN.split("\\D+");
			secondNarray = secondN.split("\\D+");
			N = firstNarray.length;
			if (N != secondNarray.length)
			{System.out.println("Введенные массивы имеют не одинаковый размер. Веедите массивы заново.");}
		}while (firstNarray.length != secondNarray.length);	
		in.close();
		
		long[] numbers = new long[2*N];
		
		long  first = Long.parseLong(firstNarray[0]);
		long  second = Long.parseLong(secondNarray[0]);		 
		int i = 0, j = 0, k = 0;
		while (j<N && k<N)
		{
			 long savedfirst = first;
			 if(first <= second)
			 {
				 numbers[i] = first; j++; i++;
				 if (j<N){first = Long.parseLong(firstNarray[j]);}
			 }
			 if(second <= savedfirst)
			 {
				 numbers[i] = second; k++; i++;
				 if (k<N) {second = Long.parseLong(secondNarray[k]);}
			 }
		}
		while (i<2*N)
		{
			if (j<N){numbers[i]= Long.parseLong(firstNarray[j]); j++;}
			else if(k<N) {numbers[i] = Long.parseLong(secondNarray[k]); k++;}
			i++;
		}
		
		double median = ((double)numbers[N-1] + (double)numbers[N])/2;
		System.out.println("Медиана равна = " + median);
		
	}

}
