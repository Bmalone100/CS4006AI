import javax.swing.JOptionPane;
import java.util.*;
public class Puzzle {
    Matrix startState= new node[9];
    Matrix endState= new node[9];
    ArrayList<Matrix> closed=new ArrayList<Matrix>();
    ArrayList<Matrix> open=new ArrayList<Matrix>();

    public static void main(String [] args)
    {
        menu();
    }

    void menu()
    {

        String puzzleChoice="";
        String pattern = "0123456789";
        String startStateIn="";
        String endStateIn="";
        String[] options = {"8 Puzzle", "15 Puzzle"};

        puzzleChoice = JOptionPane.showInputDialog(null, "Choose a puzzle", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]).toString();

            if(puzzleChoice==options[0])
            {
                //eightPuzzle();
            }
            else
            {
                //fifteenPuzzle();
            }
    }

    void eightPuzzle()
    {
        String startStateIn = "";
        String endStateIn = "";

        int row = 0;
        int coloumn = 0;
        node temp = new node();

        String aChar = "";
        String value [] = startStateIn.split(" ");
        String endValue [] = endStateIn.split(" ");

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input a starting puzzle state");
        startStateIn = keyboard.nextLine();                       //change to JOption
        System.out.println("Input the puzzle end state");       //Change to JOption
        endStateIn = keyboard.nextLine();
        for (int i=0;i<9;i++) {
            for (int j=0; j<3; j++) {
                for (int k=0;k<3;k++) {
                    startState[i]=new node(Integer.parseInt(value[i]),j,k);
                    endState[i]=new node(Integer.parseInt(endValue[i]),j,k);
                }
            }
        }
    }

    int calculateHeuristicValue(Matrix currentState)
    {
        int totalHeuristic=0;
        //Assign Nodes values
        //Compare Start State vs End State 
        //Calculate h value for each node and assign to node
        for (int i=0;i<8;i++) {
            totalHeuristic+=Math.abs(currentState[i].getHeursitic-endState[i].getHeursitic);
        }
        return totalHeuristic+Matrix.g;
    }
}
// ****************************************
//              Private classes
//****************************************

class node{
    private:
    int val; //numeric value
    int posx; //Is it in the specified row position
    int posy; //Is it in the specified coloumn position

    public node(int value, int positionX, positionY)
    {
        val = value;
        posx = positionX;
        posy = positionY;
    }

    public int getValue()
    {
        return val;
    }

    public int setValue(int value)
    {
        val = value;
    }

    public int getPositionX()
    {
        return posx;
    }

    public int setPositionX(int position)
    {
        posx = position;
    }

    public int getPositionY()
    {
        return posy;
    }

    public int setPositionY(int position)
    {
        posy = position;
    }

    public boolean isOpen()
    {
        return open;
    }

    public boolean setOpen(boolean isOpen)
    {
        open = isOpen;
    }  

    public int getHeursitic()
    {
        return posx+posy;
    }
}

class Matrix {
    public int g=0;
    public nodes[]=new node[9];
    public Matrix(node[] in) {
        for(int i=0;i<in.length;i++){
            nodes[i]=new node(in[i].getValue, in[i].getPositionX, in[i].getPositionY);
        }
    }
}