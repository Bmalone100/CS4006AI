import javax.swing.JOptionPane;
import java.util.*;

ArrayList<String[][]>open   = new ArrayList<String[][]>();
ArrayList<String[][]>closed = new ArrayList<String[][]>();

public class ISProject
{
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
	public static void Validation()
	{

	}
	//Ronan
	public static void aStar()
	{
		String Source = "123450678";
		String end    = "123405678";
		String [][] SourceArray = gridInit(8, Source);
		String [][] EndArray    = gridInit(8, end);
		String S, E, C;
		for(int i = 0; i < 2; i++)
		{
			for(int j =0; j < 2; j++)
			if(SourceArray[i][j] == "0")
				S = SourceArray[i][j];
		}
		C = S;
		


















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
