package managerequest;

import java.util.Scanner;

public class Feedback {

	public Feedback() 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Rate the driver on a scale of 1 to 5, 1 being bad and 5 being excellent");
		int rating=scanner.nextInt();
		InsertFeedback insert=new InsertFeedback(rating);
		
	}
}
