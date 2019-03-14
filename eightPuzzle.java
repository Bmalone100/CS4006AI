import javax.swing.JOptionPane;
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
		
	}
	//Brian
	public static void puzzleOutput()
	{
        int[][] puzzle = new int[3][3];
        int [] prepuzzle = new int [9];
        String tempStr = "";
        int tempInt = 0;
        int arrayLength = prepuzzle.length;
        int[] tempArray = new [3];
        for(int i = 0; i < 9 ; i++)
        {   
            tempStr = StartState.split(" ");
            tempInt = Integer.parseInt(tempStr); 
                prepuzzle[i] = tempInt;
        }
            for(int i = 0; i<3 i++)
            {
              puzzle[0][i] = prepuzzle[arrayLength/3];
              puzzle[1][i] = prepuzzle[arrayLength/3];
              puzzle[2][i] = prepuzzle[arrayLength/3];
            }
           
		int S, E, C;

        C = S;

        String open [] = new String [9];
        String closed [] = new String [9];

        closed[0] = C;
 
	}

    public void mem(int n)
    {
        
    }
	//feel free to add methods
}