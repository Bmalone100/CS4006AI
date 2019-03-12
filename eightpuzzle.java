import javax.swing.JOptionPane;
public class ISProject
{
	public static void main(String [] args)
	{   
        String puzzleChoice="";
		striing patrern = "0123456789";
        String StartState="";
        String EndState="";
		String[] options = {"8 Puzzel", "15 Puzzel"};
        puzzleChoice = JOptionPane.showInputDialog(null, "Choose a puzell", "Menu", 
		JOptionPane.PLAIN_MESSAGE, null, options, options[0]).toString();
		if(puzzleChoice==options[0])
		{
			JOptionPane.showMessageDialog(null,"eight puzzel?,ok");
			//eightPuzzle();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"fifteen puzzel?,ok");
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
		
	}
	//feel free to add methods
}
