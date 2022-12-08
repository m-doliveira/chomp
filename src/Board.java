import java.util.ArrayList;

public class Board {
    public int A;
    public int B;
    public int C;
    public boolean result =false;
    ArrayList<int[]> correspondingBoards = new ArrayList<int[]>();

    public Board(int pa, int pb, int pc){
        A=pa;
        B=pb;
        C=pc;
    }

}
