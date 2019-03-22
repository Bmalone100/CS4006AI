import javax.swing.JOptionPane;
import java.util.*;
public class ISProject
{
	public static void main(String [] args)
	{   
        String puzzleChoice="";
		String pattern = "[0-8]{0,9}";
		String pattern2 = "[0-8]{0,15}";
        String startState="";
        String endState="";
		String[] options = {"8 Puzzel", "15 Puzzel"};
        puzzleChoice = JOptionPane.showInputDialog(null, "Choose a puzell", "Menu", 
		JOptionPane.PLAIN_MESSAGE, null, options, options[0]).toString();
		if(puzzleChoice==options[0])
		{
			JOptionPane.showMessageDialog(null,"eight puzzel?,ok");
			eightPuzzle(pattern,startState,endState);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"fifteen puzzel?,ok");
			
			fifteenPuzzle(pattern2,startState,endState);
		}
	}
	//Ibrahim
	public static void eightPuzzle(String pattern, String startState, String endState)
	{
		int tries = 0;
		while(tries<3){
				startState = JOptionPane.showInputDialog(null,"please enter all numbers from 0-9 as a start state");
				endState = JOptionPane.showInputDialog(null,"please enter all numbers from 0-9 as an end state");
		
				if(startState.matches(pattern) && endState.matches(pattern))
				{
					String []startArray=startState.split("");
					String [] endArray =endState.split("");
					Validation(startArray,endArray);
				}
				else
				{
				JOptionPane.showMessageDialog(null,"we want a digit please from 0-9");
				tries++;
				}
			 }
			 JOptionPane.showMessageDialog(null,"you are clearly messing around i don't have time for dis");
	
	}
	//Ibrahim
	public static void fifteenPuzzle(String pattern2, String startState, String endState)
	{	
		int tries = 0;
		while(tries<3){
				startState = JOptionPane.showInputDialog(null,"please enter all numbers from 0-9 as a start state");
				endState = JOptionPane.showInputDialog(null,"please enter all numbers from 0-9 as an end state");
		
				if(startState.matches(pattern2) && endState.matches(pattern2))
				{
					String []startArray=startState.split("");
					String [] endArray =endState.split("");
					Validation(startArray,endArray);
					tries =3;
				}
				else
				{
				JOptionPane.showMessageDialog(null,"we want a digit please from 0-9");
				tries++;
				}
			 }
			 JOptionPane.showMessageDialog(null,"you are clearly messing around i don't have time for dis");
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
