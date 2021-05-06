import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("This is Score4!");

		Player p1 = new Player("",' ');
		p1.ReadName("1st");
		
		Player p2 = new Player("",' ');
		p2.ReadName("2nd");


		p1.ReadChip1();
		p2.ReadChip2(p1.getChip());
		
		Board table = new Board();
		char[][] GB = new char[0][0];
		GB=table.ReadBoard();
	
		int first = Random();
		if (first == 1)
		    p1.Game(GB);
		else
			p2.Game(GB);
		
		
		int played = first;
		boolean win = false;
		while ( full(GB) == false && win == false )
		{
			if ( played % 2 == 1)
			{
				win = p2.Game(GB);
				played++;
			}
			else
			{
				win = p1.Game(GB);
				played++;
			}
			
		}
	 
	}
	
	
	public static int Random()
	{
	    Random dice = new Random();
	    int number;
	    
	    number = 1+dice.nextInt(2);
	    return number;
	}
	
	public static boolean full(char[][] array)
	{
		boolean f = false;
		int count1 = 0;
		
		for (int i=0; i< array.length; i++)
			for (int j=0; j<array[0].length; j++)
				if ( array[i][j] == '-' )
					count1++;
					
		if ( count1 == 0)
		{
			f = true;
			System.out.println("GAME OVER. WE HAVE A DRAW!");
		}
		
		return f;
	}
	

}
