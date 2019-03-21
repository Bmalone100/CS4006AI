import javax.swing.JOptionPane;
import java.util.*;

public class eightPuzzle
{
	static ArrayList<String[][]> open=new ArrayList<String[][]>();
	static ArrayList<String[][]> closed=new ArrayList<String[][]>();
	public static void main(String [] args)
	{   
        String puzzleChoice="";
		String pattern = "0123456789";
        String StartState="";
        String EndState="";
		String[] options = {"8 Puzzle", "15 Puzzle"};
        puzzleChoice = JOptionPane.showInputDialog(null, "Choose a puzzle", "Menu", 
		JOptionPane.PLAIN_MESSAGE, null, options, options[0]).toString();
		if(puzzleChoice==options[0])
		{
			JOptionPane.showMessageDialog(null,"eight puzzle?,ok");
			//eightPuzzle();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"fifteen puzzle?,ok");
			//fifteenPuzzle();
		}
	}
	//Ibrahim
	public static void eightPuzzle()
	{
		
	}
	//Ibrahim
	public static void fifteenPuzzle()
	{
		
	}
	//daire
	//returns int based on which strings are valid.
	//all valid: return 0, startState invalid: return 1, endState invalid: return 2, both invalid: return 3
	public static int Validation(String startState, String endState) {	
		int result=0;
		return result;
	}
	//Ronan
	public static void aStar()
	{
		
	}
	//Brian
	public static void gridInit(int size, String inString)
	{
		int sizeSqrt=(int)Math.sqrt(size+1); 
        String[][] puzzle = new String[sizeSqrt][sizeSqrt];
        char tempStr;
        for(int i = 0; i < size ; i++)
        {   
            tempStr = inString.charAt(i);
            for(int j = 0; j<sizeSqrt-1 ; j++)
            {
                for(int k = 0; k < sizeSqrt-1; k++)
                    puzzle[j][k]=""+tempStr;
            }
        }
	}
	//feel free to add methods

	//takes the current state as a parameter and checks if it is present in the list of closed states
	//returns TRUE if a duplicate IS FOUND
	public static boolean isDuplicate(String[][] currentState) {
		int dupeCount=0;
		boolean dupe=false;
		for(int i=0; i<closed.size() && dupeCount<8; i++) {
			dupeCount=0;
			for (int j=0; j<closed.get(i).length; j++) {
				for (int k=0; k<closed.get(i).length; k++) {
					if (closed.get(i)[j][k]==currentState[j][k])
						dupeCount++;
				}
			}
			if (dupeCount>7) dupe= true;
		}
		return dupe;
	}
}