import java.util.Scanner;

public class Board {
	private int rows;
	private int columns;
	
	
	public char[][] ReadBoard()
	{
		char[][] Table = new char[0][0];
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter the number of rows: ");
		rows = keyboard.nextInt();
		
		while ( rows < 4 || rows > 15 )
		{
			System.out.print("Incorrect input. Please enter the number of rows: "); 
			rows = keyboard.nextInt();
		}
		System.out.print("Please enter the number of columns: ");
		columns = keyboard.nextInt();
		System.out.println();
		while ( columns < 4 || columns > 15 )
		{
			System.out.print("Incorrect input. Please enter the number of columns: ");
			columns = keyboard.nextInt();
		}
		
		
		Table = new char[rows][columns];
		for(int i = 0; i<rows; i++)
		    for(int j = 0; j<columns; j++)
		    {
		        Table[i][j] = '-';
		    }
        
		  for(int i = 0; i<rows; i++)
		  {
			  System.out.print("|");
		      for(int j = 0; j<columns; j++)
		      {
		    	  if ( i != rows )
		    	      System.out.print(" "+Table[i][j]+" "); 
		      }  
	           System.out.println("| ");
		     
		  }
		  for (int i=0; i<columns*3+2; i++)
		  {
			  System.out.print("-");
		  }
	
		  System.out.println();
		  for (int i=1; i<columns+1; i++)
		  {
			  if ( i < 10)
				  System.out.print("  "+ i);
			  else
			  {
				  System.out.print(" "+ i);
			  }
			  
		  }
		  System.out.println();
		  
		  return Table;
		 
	}
	
	

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	 
}
