import javax.swing.JOptionPane;
import java.util.*;

public class ISProject
{
	public static void main(String [] args)
	{   
        String puzzleChoice="";
		String pattern = "0123456789";
        String StartState="";
        String EndState="";
		String[] options = {"8 Puzzle", "15 Puzzle"};
		ArrayList<String[][]> open=new ArrayList<String[][]>();
		ArrayList<String[][]> closed=new ArrayList<String[][]>();
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

	}
	//Ronan
	public static void aStar()
	{
		
	}
	//Brian
	public static void gridInit(int size, String inString)
	{
        String[][] puzzle = new String[Math.sqrt(size+1)][Math.sqrt(size+1)];
        String tempStr = "";
        for(int i = 0; i < size ; i++)
        {   
            tempStr = inString[i];
            for(int j = 0; j<Math.sqrt(size+1)-1 ; j++)
            {
                for(int k = 0; k < Math.sqrt(size+1)-1; k++)
                    puzzle[j][k]=tempStr;
            }
        }
	}
	//feel free to add methods

	//takes the current state as a parameter and checks if it is present in the list of closed states
	//returns TRUE if a duplicate IS FOUND
	public static boolean isDuplicate(int[][] currentState) {
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