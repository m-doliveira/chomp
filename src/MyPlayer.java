import java.awt.*;
import java.util.ArrayList;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    ArrayList<int[]> boards = new ArrayList<int[]>();
    ArrayList<Board> loseBoards = new ArrayList<Board>();
    ArrayList<Board> allBoards = new ArrayList<Board>();

    public MyPlayer() {
        columns = new int[10];
threelist();
        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public void threelist(){
        System.out.println("3x3 boards:");
        for (int i = 1; i<4; i = i+1) {
            for (int m = 0;m<=i; m = m+1) {
                for (int o = 0; o<=m; o = o+1) {
                    System.out.println("");
                    System.out.println("board:"+i+""+m+""+o); //add +return result
                    int[] b3y3 = {i,m,o};
                    boards.add(b3y3);
                    possibleboards(i,m,o);
                    //correspondingBoards.add(new Board(i,m,o));
                }
            }
        }
        System.out.println("loseboards:");
        for(int k=0; k<loseBoards.size();k=k+1){
            System.out.println(loseBoards.get(k).A+""+loseBoards.get(k).B+""+loseBoards.get(k).C);
        }
    }
    public void possibleboards(int A, int B, int C) {
        Board current = new Board(A,B,C,3,3);
        // lose boards 3x3: 100,210,220,211,311
        boolean wboard=false;
        System.out.println("within board");
        for (int c = C-1; c > -1; c = c - 1) {
            int a = A;
            int b = B;
            System.out.println(a + "" + b + "" + c);
            for(int l=0; l<loseBoards.size();l=l+1){
                if ( loseBoards.get(l).A==a && loseBoards.get(l).B==b&&loseBoards.get(l).C==c) {
                    System.out.println("(win)");
                    wboard=true;
                    current.lba=a;
                    current.lbb=b;
                    current.lbc=c;
                }}
        }
        for (int b = B-1;b>-1; b = b - 1) {
            int a = A;
            int c = C;
            if (c > b) {
                c = b;
            }
            System.out.println(a + "" + b + "" + c);
            for(int l=0; l<loseBoards.size();l=l+1){
                if ( loseBoards.get(l).A==a && loseBoards.get(l).B==b&&loseBoards.get(l).C==c) {
                    System.out.println("(win)");
                    wboard=true;
                    current.lba=a;
                    current.lbb=b;
                    current.lbc=c;
                }
            }
        }
        for (int a = A-1; a > 0; a = a - 1) {
            int b = B;
            if ( b> a) {
                b = a;}
            int c = C;
            if ( c> b) {
                c = b;}
            System.out.println(a + "" + b + "" + c);
            for(int l=0; l<loseBoards.size();l=l+1) {
                if (loseBoards.get(l).A == a && loseBoards.get(l).B == b && loseBoards.get(l).C == c) {
                    System.out.println("(win)");
                    wboard=true;
                    current.lba=a;
                    current.lbb=b;
                    current.lbc=c;
                }

            }
        }

        if (wboard==false) {
            loseBoards.add(new Board(A,B,C,3,3));

            //add lose board to all boards
        }

        if (wboard==true) {
            System.out.println("pkejobvaeo");
            calc(current);
           allBoards.add(current);
        }

    }

public void calc(Board now){
        if (now.A-now.lba>0) {
            now.row=now.lba;
            now.col=0;
            System.out.println("c:0" + "r:" + now.lba);
        }
        else{
            if(now.B-now.lbb>0){
                now.row=now.lbb;
                now.col=1;
                System.out.println("c:1"+"r:"+ now.lbb);
            }
            else{
                if (now.B-now.lbb>0){
                    now.row=now.lbc;
                    now.col=2;
                    System.out.println("c:2"+"r:"+ now.lbc);
                }
            }
        }

}
    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 1;
        int row = 1 ;
        int Ca=0;
        int Cb=0;
        int Cc=0;
        for (int r=0; r< gameBoard.length; r++){
            if (gameBoard[r][0].isAlive==true ){
                Ca++;
            }
            if (gameBoard[r][1].isAlive==true){
                Cb++;
            }
            if (gameBoard[r][2].isAlive==true){
                Cc++;
            }
        }
        System.out.println("curr"+Ca+""+Cb+""+Cc);
        System.out.println(allBoards.size());
        for(int y=0; y< allBoards.size(); y++){
            System.out.println(allBoards.get(y).A +""+ allBoards.get(y).B+""+ allBoards.get(y).C);
            if (Ca== allBoards.get(y).A && Cb== allBoards.get(y).B && Cc== allBoards.get(y).C){

                System.out.println("found");
                System.out.println("r: " + allBoards.get(y).row+"c: "+allBoards.get(y).col);

                column= allBoards.get(y).col;
                row=allBoards.get(y).row;
                System.out.println("row: " + row+"col: "+column);
            }
        }
        //using the coordinates form calc
       // for (int x=u; x<allBoards.size(); x=x+1){}



        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);

        return myMove;
    }

}
