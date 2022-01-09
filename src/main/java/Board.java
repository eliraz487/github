
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;

public class Board {

    Scanner s = new Scanner(System.in);
    private int Length;
    private int Width;
    private boolean showall = false;
    private Cell[][] board;
    private int arr_index[][] = new int[2][500]; // Any parameters...

    
    public void Board(int Length, int Width) {
        this.Length = Length;
        this.Width = Width;
        this.board = new Cell[Length][Width];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = new Cell(new JButton());
            }
        }
        Start_arr_index();

    }  //Creat the board game int length X int length.

    public Cell[][] getBoard() {
        return board;
    }

   

    int z = 0;
    int count = 0;
    int m = 0;
    int temp_index = 0;
    int tempI = 0;
    int tempcount = 0;
    int tempJ = 0;
    int countmines = 0;
    ; boolean prees_on_mine = false;
    int countflages = 0;

    //GETTER AND SETTER
    public Cell[][] getboard() {
        return board;
    }

    public boolean isShowall() {
        return showall;
    }

    public void setShowall(boolean showall) {
        this.showall = showall;
    }

    public int getLength() {
        return Length;
    }

    public void setLength(int Length) {
        this.Length = Length;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }

    public int All_Mines() {
        for (int i = 0; i < this.Length; i++) {
            for (int j = 0; j < this.Width; j++) {
                if (this.board[i][j].isMine()) {
                    countmines++;
                    countflages++;
                }
            }
        }
        return countmines;
    }

    void Start_arr_index() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 500; j++) {
                arr_index[i][j] = 999;
            }
        }
    }  // This restart the array in value 999, this is stop the recursy in the next function.

    boolean have_boom() {
        for (int i = 0; i < this.Length; i++) {
            for (int j = 0; j < this.Width; j++) {
                if (this.board[i][j].isBoom()) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean if_in_arr(int i, int j) {
        if (i >= 0 && i < this.board.length && j >= 0 && j < this.board[1].length) {
            return true;
        }
        return false;
    } //Checking if the local in arr.

    void Put_Mines(int num_of_mines) {
        Random rnd = new Random();
        for (int k = 0; k < num_of_mines; k++) {
            this.board[rnd.nextInt(this.Length)][rnd.nextInt(this.Width)].setMine(true);
        }
    }   //  $$ two function just for Cheking

    boolean if_not_in_arr_index(int i, int j, int[][] arr) {
        if (if_in_arr(i, j)) {
            for (int l = 0; l < count; l++) {
                if (arr[0][l] == i && arr[1][l] == j) {
                    return false;
                }
            }
            arr[0][count] = i;
            arr[1][count] = j;
            count++;
            return true;
        }
        return false;
    } // Enter to the arr of index just if not found here.

    void NumMines(int i, int j) {
        int count_mines = 0;

        if (if_in_arr(i, j + 1)) {
            if (board[i][j + 1].isMine()) //right) 
            {
                count_mines++;
            }
        }

        if (if_in_arr(i, j - 1)) {
            if (board[i][j - 1].isMine()) //left) {
            {
                count_mines++;
            }
        }

        if (if_in_arr(i + 1, j)) {
            if (board[i + 1][j].isMine()) //up)
            {
                count_mines++;
            }
        }

        if (if_in_arr(i - 1, j)) {
            if (board[i - 1][j].isMine()) //down)
            {
                count_mines++;
            }
        }

        if (if_in_arr(i - 1, j - 1)) {
            if (board[i - 1][j - 1].isMine()) //down and left)
            {
                count_mines++;
            }
        }

        if (if_in_arr(i - 1, j + 1)) {
            if (board[i - 1][j + 1].isMine()) //down and right)
            {
                count_mines++;
            }
        }

        if (if_in_arr(i + 1, j + 1)) {
            if (board[i + 1][j + 1].isMine()) //up and righr)
            {
                count_mines++;
            }
        }

        if (if_in_arr(i + 1, j - 1)) {
            if (board[i + 1][j - 1].isMine()) //up and left)
            {
                count_mines++;
            }
        }
        this.board[i][j].setShow(count_mines);
    }  //Number MINES aroun local.

    void Move(int i, int j, int[][] arr) {
        boolean ok = true;

        if (i == 999) {
            return;
        }
        if (if_in_arr(i, j + 1)) {
            if (board[i][j + 1].isMine()) //right
            {
                ok = false;
            }
        }
        if (if_in_arr(i, j - 1)) {
            if (board[i][j - 1].isMine()) //left
            {
                ok = false;
            }
        }

        if (if_in_arr(i + 1, j)) {
            if (board[i + 1][j].isMine())//down 
            {
                ok = false;
            }
        }

        if (if_in_arr(i - 1, j)) {
            if (board[i - 1][j].isMine()) //up
            {
                ok = false;
            }
        }

        if (if_in_arr(i - 1, j - 1)) {
            if (board[i - 1][j - 1].isMine())//up and left) {
            {
                ok = false;
            }
        }

        if (if_in_arr(i - 1, j + 1)) {
            if (board[i - 1][j + 1].isMine())//up and right) {
            {
                ok = false;
            }
        }

        if (if_in_arr(i + 1, j + 1)) {
            if (board[i + 1][j + 1].isMine()) //down and righr) {
            {
                ok = false;
            }
        }

        if (if_in_arr(i + 1, j - 1)) {
            if (board[i + 1][j - 1].isMine())//down and left) {
            {
                ok = false;
            }
        }

        if (ok) {
            if_not_in_arr_index(i, j, arr_index);//local
            if_not_in_arr_index(i, j + 1, arr_index);//right
            if_not_in_arr_index(i, j - 1, arr_index);//left
            if_not_in_arr_index(i + 1, j, arr_index);//down
            if_not_in_arr_index(i - 1, j, arr_index);//up
            if_not_in_arr_index(i - 1, j - 1, arr_index);//up and left
            if_not_in_arr_index(i - 1, j + 1, arr_index);//up and right
            if_not_in_arr_index(i + 1, j + 1, arr_index);//down and right
            if_not_in_arr_index(i + 1, j - 1, arr_index);//down and left
        } else {
            NumMines(i, j);
        }

        m++;
        Move(arr_index[0][m], arr_index[1][m], arr_index);
    } //Recursy function make move- the basic of game is here.

    void Press(int i, int j, int right_clik, int left_clik) {
        if (right_clik == 1) {// אם נלחץ מקש ימני  שים דגל
            if (this.board[i][j].getCountflags() == 0) {
                this.board[i][j].setFlag(true);
                if (this.board[i][j].isMine()) {
                    countmines--;
                }
                this.board[i][j].setCountflags(1);
                countflages--;
            } else {
                this.board[i][j].setFlag(false);
                if (this.board[i][j].isMine()) {
                    countmines++;
                }
                this.board[i][j].setCountflags(0);
                countflages++;
            }

        } else {
            if (this.board[i][j].isMine() && left_clik == 1) {// אם נלחץ באחד המקשים ויש מוקש אז נגמר המשחקק
                this.board[i][j].setShow(888); //אם עלה על מוקש
                this.showall = true;
                countmines = -1;//אם לחץ על מוקש ללא דגל אז שים מינוס  אחד אוטומטית נגמר המשחק אין צורך להגיע לאפס
            } else {
                if (left_clik == 1 && this.board[i][j].isMine() == false) {//אחרת אם אין מוקש ומקש ימני או שמאלי נלחצו תראה כמה מוקשים יש סביב הכפתור שנלחץ
                    Move(i, j, arr_index);
                    for (int k = 0; k < count; k++) {
                        NumMines(arr_index[0][k], arr_index[1][k]);
                        if (this.board[arr_index[0][k]][arr_index[1][k]].getShow() == 0) {
                            this.board[arr_index[0][k]][arr_index[1][k]].setSelect(true);//אם נלחץ

                        }
                    }

                }
            }
        }

    }  // Press on button...

    void open(int indexi, int indexj) {
        this.board[indexi][indexj].setBackground(Color.red);
    }

}
