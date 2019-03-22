import javax.swing.JOptionPane;
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
			eightPuzzle(pattern,startState,endState);
		}
		else
		{
			
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
	public static void Validation()
	{
		
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
}
