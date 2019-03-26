import javax.swing.JOptionPane;
import java.util.*;
public class Puzzle {
    static Matrix startState= new Matrix();
    static Matrix endState= new Matrix();
    ArrayList<Matrix> closed=new ArrayList<Matrix>();
    ArrayList<Matrix> open=new ArrayList<Matrix>();

    public static void main(String [] args)
    {
        menu();
    }

    static void menu()
    {
        String puzzleChoice="";
        String pattern = "0123456789";
        String startStateIn="";
        String endStateIn="";
        String[] options = {"8 Puzzle", "15 Puzzle"};

        puzzleChoice = JOptionPane.showInputDialog(null, "Choose a puzzle", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]).toString();

            if(puzzleChoice.equals(options[0]))
            {
                eightPuzzle();
            }
            else
            {
                //fifteenPuzzle();
            }
    }

    static void eightPuzzle()
    {
    	startState=new Matrix(8);
    	endState=new Matrix(8);
        String startStateIn = "";
        String endStateIn = "";

        Scanner keyboard = new Scanner(System.in);

        startStateIn = JOptionPane.showInputDialog(null, "Input a starting puzzle state");
        endStateIn = JOptionPane.showInputDialog(null, "Input an ending puzzle state");

        String value [] = startStateIn.split(" ");
        String endValue [] = endStateIn.split(" ");
        for (int i=0;i<8;i++) {
            for (int j=0; j<3; j++) {
                for (int k=0;k<3;k++) {
                    startState.nodes[i]=new Node(Integer.parseInt(value[i]),j,k);
                    endState.nodes[i]=new Node(Integer.parseInt(endValue[i]),j,k);
                }
            }
        }
    }

    public int calculateHeuristicValue(Matrix currentState)
    {
        int totalHeuristic=0;
        //Assign Nodes values
        //Compare Start State vs End State 
        //Calculate h value for each node and assign to node
        for (int i=0;i<currentState.size;i++) {
            totalHeuristic+=Math.abs(currentState.nodes[i].getHeursitic()-endState.nodes[i].getHeursitic());
        }
        return totalHeuristic+currentState.getG();
    }

    //takes the current state as a parameter and checks if it is present in the list of closed states
	//returns TRUE if a duplicate IS FOUND
 //    public static boolean isDuplicate(Matrix currentState) {
	// 	int dupeCount=0;
	// 	boolean dupe=false;
	// 	for(int i=0; i<closed.get(i).nodes.length; i++) {
	// 		for (int j=0; j<closed.get(i).nodes.length; j++) {
	// 			for (int k=0; k<closed.get(i)nodes.length; k++) {
	// 				if (closed.get(i)[j][k]==currentState[j][k])
	// 					dupeCount++;
	// 			}
	// 		}
	// 		if (dupeCount>7) dupe= true;
	// 	}
	// 	return dupe;
	// }
}
// ****************************************
//              Private classes
//****************************************

class Node{
    int val; //numeric value
    int posx; //Is it in the specified row position
    int posy; //Is it in the specified coloumn position

    public Node(int value, int positionX, int positionY)
    {
        val = value;
        posx = positionX;
        posy = positionY;
    }

    public int getValue() 	  {return val;}
    public int getPositionX() {return posx;}
    public int getPositionY() {return posy;}
    public int getHeursitic() {return posx+posy;}

    public void setValue(int value) 	   {val = value;}
    public void setPositionX(int position) {posx = position;}
    public void setPositionY(int position) {posy = position;}
}

class Matrix {
    private int g=0;
    public 	int size=0;
    public 	Node nodes[]=new Node[9];

    //constructors
    public Matrix(){}
    public Matrix(int squares) {
    	nodes=new Node[squares+1];
    	size=squares;
    	//int width=Math.sqrt(squares+1)-1;
        // for(int i=0;i<width;i++){
        //     nodes[i]=new Node(in[i].getValue(), in[i].getPositionX(), in[i].getPositionY());
        // }
    }

    //getters and setters
    public int getG() {return g;}
    public void setG(int in) {g=in;}

    //methods
    boolean isEqual(Matrix in) {
    	boolean out=true;
    	for (int j=0; j<nodes.length && out; j++) {
			if (this.nodes[j].getValue()!=in.nodes[j].getValue())
				out=false;
		}
		return out;
    }
}