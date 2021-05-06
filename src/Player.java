import java.util.Scanner;
import java.util.Random;

public class Player {
	
	private String name;
	private char chip;
	
	
	public Player(String name, char chip)
	{
		this.name = name;
		this.chip = chip;
		
	}
	
	public void ReadName(String n)
	{
		Scanner keyboard = new Scanner(System.in);
		
	    System.out.print("Please enter the name of the "+ n+ " player: ");
		name = keyboard.nextLine();
		
	}
	
	public void ReadChip1()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print(name +", please select your chip: ");
		chip = keyboard.next().charAt(0);
		while( chip != 'x' && chip != 'o' )
		{
			System.out.println("Please select x or o.");
			chip = keyboard.next().charAt(0);
		}
		
	}
	
	public void ReadChip2(char c)
	{
		
		if ( c == 'x')
		{
			System.out.print( name +", your chip is: o");
			chip = 'o';
		}
		else
		{
			System.out.print( name +", your chip is: x");
			chip = 'x';
		}
		System.out.println();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getChip() {
		return chip;
	}

	public void setChip(char chip) {
		this.chip = chip;
	}
	
	
	public boolean Game(char[][] array)
	{
		Scanner keyboard = new Scanner(System.in);
	
		System.out.print(this.getName()+", your turn. Select column: ");
		int empty = -1;
		int col = keyboard.nextInt()-1;
	    for (int i=0; i<array.length; i++)
		{
			if ( array[i][col] == '-' )
			{
				empty = i;
			}
		}
		
	    while (empty == -1)
	    {
	    	System.out.println("This column is full. Please select an other column: ");
	    	col = keyboard.nextInt()-1;
	    	  for (int i=0; i<array.length; i++)
	   			if ( array[i][col] == '-' )
	   				empty = i;
	    }
	    
	    array[empty][col] = this.chip;
	    
        //print ton pinaka
		for(int i = 0; i<=array.length; i++)
		{
			if (i != array.length)		  
				System.out.print("|");
			for(int j = 0; j<array[0].length; j++)
			{
				if ( i != array.length )
					System.out.print(" "+array[i][j]+" "); 
			}
			if (i != array.length)		  
				System.out.println("| ");
		     
		}
		for (int i=0; i<(array[0].length*3+2); i++)
		{
			System.out.print("-");
		}
		System.out.println();
		for (int i=1; i<array[0].length+1; i++)
		{
			System.out.print("  "+ i);
		}
		System.out.println();
		  
		boolean c = check(array, col);
		if ( c == true )
		{ 
			System.out.println("GAME OVER. THE WINNER IS: "+this.name);
		}
		return c;
		
	}			
	
	
	public boolean check(char[][] array, int col)
	{
		int rows = array.length;
		int columns = array[0].length;
		
		//nikhse ka8eta
		int count1 = 1;
	
		for (int i=0; i<rows-3; i++)
		{
			
			if (array[i][col] == this.chip && array[i+1][col] == this.chip && array[i+2][col] == this.chip && array[i+3][col] == this.chip )
			{
				return true;
			}
		}
		
	
		//nikhse orizontia
		int r = 0;
		for (int i=0; i<rows; i++)
		{
			if (array[i][col] == this.chip)
				r = i;	
		}
		for (int j=0; j<columns-3; j++)
		{
			if (array[r][j] == this.chip && array[r][j+1] == this.chip && array[r][j+2] == this.chip && array[r][j+3] == this.chip )
				return true;
		}
		

		//nikhse plagia deksia
		for (int i=3; i<rows; i++)
		{
			for (int j=0; j<columns-3 ; j++)
			{
				if (array[i][j] == this.chip   && 
					array[i-1][j+1] == this.chip &&
					array[i-2][j+2] == this.chip &&
					array[i-3][j+3] == this.chip)
				{
					return true;
				}
				
			}
		}
		
		//nikhse plagia aristera
		for(int i = 0; i < rows - 3; i++){
			for(int j = 0; j < columns - 3; j++){
				if (array[i][j] == this.chip   && array[i+1][j+1] == this.chip && array[i+2][j+2] == this.chip && array[i+3][j+3] == this.chip)
				{
					return true;
				}
			}
		}
	
	
		return false;
	
	}
	

	
}
	
	


