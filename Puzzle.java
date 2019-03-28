import javax.swing.JOptionPane;
import java.util.*;
public class Puzzle {
    static Matrix startState= new Matrix();
    static Matrix endState= new Matrix();
    static Matrix currentState=new Matrix();
    static ArrayList<Matrix> closed=new ArrayList<Matrix>();
    static ArrayList<Matrix> open=new ArrayList<Matrix>();
    static int puzzleSize=0;

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
            	puzzleSize=8;
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
    	currentState=new Matrix(8);
        String startStateIn = "";
        String endStateIn = "";

        startStateIn = JOptionPane.showInputDialog(null, "Input a starting puzzle state");
        startStateIn+=" ";
        //call validation here
        endStateIn = JOptionPane.showInputDialog(null, "Input an ending puzzle state");
        endStateIn+=" ";
        //call validation here

        String value [] = startStateIn.split(" ");
        String endValue [] = endStateIn.split(" ");
        int i=0;
        for (int j=0; j<3; j++) {
            for (int k=0;k<3;k++) {
                startState.nodes[i]=new Node(Integer.parseInt(value[i]),j,k);
                currentState.nodes[i]=new Node(Integer.parseInt(value[i]),j,k);
                endState.nodes[i]=new Node(Integer.parseInt(endValue[i]),j,k);
                i++;
            }
        }
        //this will loop
        System.out.println(currentState);
        int[] currentMoves=currentState.findZero(puzzleSize);
        for (int j=0; j<currentMoves.length; j++) {
        	if (currentMoves[j]!=0) {
        		open.add(Matrix.newMovedMatrix(currentState, currentMoves[j]));
        	}
        }
        for (int j=0; j<open.size(); j++) {
        	System.out.println(open.get(j));
        	System.out.println(calculateHeuristicValue(open.get(j)));
        }

    }

    public static int calculateHeuristicValue(Matrix in)
    {
        int totalHeuristic=0;
        //Assign Nodes values
        //Compare Start State vs End State 
        //Calculate h value for each node and assign to node
        for (int i=0;i<in.getSize();i++) {
        	System.out.println(String.format("%d %d %d %d %d %d",
        		in.getNode(i).getValue(),
        		in.getNode(i).getPositionX(),
        		in.getNode(i).getPositionY(),
        		endState.getNode(i).getValue(),
        		endState.getNode(i).getPositionX(),
        		endState.getNode(i).getPositionY()));
            totalHeuristic+=Math.abs((in.getNode(i).getPositionX()-endState.getNode(i).getPositionX())+(in.getNode(i).getPositionX()-endState.getNode(i).getPositionY()));
            System.out.println(String.format("Heuristic for %d is %d",i,Math.abs((in.getNode(i).getPositionX()-endState.getNode(i).getPositionX())+(in.getNode(i).getPositionX()-endState.getNode(i).getPositionY()))));
        }
        return totalHeuristic+in.getG();
    }

    void calculateMovements (Matrix currentState) {

    }
}
// ****************************************
//              Private classes
//*****************************************

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

    public void setValue(int value) 	   {val = value;}
    public void setPositionX(int position) {posx = position;}
    public void setPositionY(int position) {posy = position;}

    //Checks if the zero node can move or if it is against a side
    //reuturns false for moves that can't be made
    //the array is in {left, up, right, down}
    public boolean[] findMoves(int puzzleSize) {
    	int width=(int)Math.sqrt(puzzleSize+1)-1;
    	boolean[] out={true, true, true, true};
    	if (posy<1)
    		out[0]=false;
    	if (posx<1)
    		out[1]=false;
    	if (posy>width-1)
    		out[2]=false;
    	if (posx>width-1)
    		out[3]=false;
    	return out;
    }
}

class Matrix {
    private int g=0; //gn from the brief
    private int size=0;
    private int width=0;
    public 	Node nodes[]=new Node[9];
    //constructors
    public Matrix(){}
    public Matrix(int squares) { //creates the matrix for an 8 or 15 puzzle
    	nodes=new Node[squares+1];
    	size=squares+1;
    	width=(int)Math.sqrt(squares+1);
    }

    //getters and setters
    //No getter or setter for nodes
    //just use Mastrix.nodes[], for example startState.nodes[1]
    public int 	getSize() {return size;}
    public int 	getG() {return g;}
    public Node getNode(int in) {
    	boolean found=false;
    	for(int i=0; i<size && !found; i++) {
    		if (nodes[i].getValue()==in) {
    			return nodes[i];
    		}
    	}
    	return nodes[0];
    }
    public int findNode(int in) {
    	boolean found=false;
    	for(int i=0; i<nodes.length; i++) {
    		if (in==nodes[i].getValue())
    			return i;
    	}
    	return 0;
    }

    public void setG(int in) {g=in;}
    public void plusG() {g++;}

    //methods
    boolean isEqual(Matrix in) {
    	boolean out=true;
    	for (int j=0; j<nodes.length && out; j++) {
			if (this.nodes[j].getValue()!=in.nodes[j].getValue())
				out=false;
		}
		return out;
    }
    @Override
    public String toString() {
    	String out="";
    	int index=0;
    	for(int i=0; i<width;i++) {
    		for (int j=0;j<width;j++) {
    			out+=nodes[index].getValue()+" ";
    			index++;
    		}
    		out+="\n";
    	}
    	return out;
    }
    public int[] findZero(int puzzleSize) {
    	boolean found=false;
    	int[] out=new int[4];
    	for(int i=0; i<size && !found; i++) {
    		if (nodes[i].getValue()==0) {
    			found=true;
    			boolean[] moves=nodes[i].findMoves(puzzleSize);
				if (moves[0]==true) {
					System.out.println(nodes[i-1].getValue()+" to the east\n");
					out[0]=nodes[i-1].getValue();
				}
				if (moves[1]==true) {
					System.out.println(nodes[i-width].getValue()+" to the south\n");
					out[1]=nodes[i-width].getValue();
				}

				if (moves[2]==true) {
					System.out.println(nodes[i+1].getValue()+" to the west\n");
					out[2]=nodes[i+1].getValue();
				}
				if (moves[3]==true) {
					System.out.println(nodes[i+width].getValue()+" to the north\n");
					out[3]=nodes[i+width].getValue();
				}
    		}
    	}
    	return out;
    }
    public static Matrix newMovedMatrix(Matrix old, int in) {
    	int zeroLocation=old.findNode(0);
    	int inLocation=old.findNode(in);
    	Node tempZero=new Node(0,old.getNode(0).getPositionX(),old.getNode(0).getPositionY());
    	Node tempIn=new Node(in,old.getNode(in).getPositionX(),old.getNode(in).getPositionY());
    	Matrix out=new Matrix(8); //HARDCODED
    	for (int i=0; i<9; i++) {
    		if (i!=zeroLocation && i!=inLocation)
    			out.nodes[i]=new Node(old.nodes[i].getValue(), old.nodes[i].getPositionX(), old.nodes[i].getPositionY());
    		else if (i==zeroLocation)
    			out.nodes[i]=tempIn;
    		else
    			out.nodes[i]=tempZero;
    	}
    	return out;
    }
}