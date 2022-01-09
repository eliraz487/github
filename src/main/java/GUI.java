
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import javax.accessibility.AccessibleContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author YAIR.D
 */
public class GUI extends JFrame {

    static String time2 = "";
    private int length;
    private int width;
    private Board b1;
    private int num_mines;
    int indexi = 0;
    int indexj = 0;

    public void GUI(int length, int width, int num_mines) {
        this.length = length;
        this.width = width;
        this.num_mines = num_mines;
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    void print(JPanel panel, JFrame frame, Board b1) {
        Scanner str = new Scanner(System.in);
        ImageIcon icon = new ImageIcon();

        if (b1.countmines == -1 || b1.prees_on_mine) { //if preesing on mine, print and finish
            if (b1.isShowall()) {
                for (int i = 0; i < b1.getLength(); i++) {
                    for (int j = 0; j < b1.getWidth(); j++) {
                        if (b1.getboard()[i][j].isMine()) {
                            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\new boom.png");
                            // b1.getboard()[i][j].setSelect(true);
                            b1.getboard()[i][j].setIcon(resizeIcon(icon, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));

                        }
                    }
                }
                return;
            }
        } else {
            for (int i = 0; i < b1.getLength(); i++) {
                for (int j = 0; j < b1.getWidth(); j++) {
                    if (b1.getboard()[i][j].isFlag()) {   //if this button have flag,print

                        icon = new ImageIcon("C:\\\\Users\\\\USER001\\\\Documents\\\\NetBeansProjects\\\\MineSweeper\\\\src\\\\main\\\\java\\\\Minesweeper_flag.svg.png");
                        b1.getboard()[i][j].setIcon(resizeIcon(icon, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                        b1.getboard()[i][j].setBackground(new Color(204, 255, 153));
                        //  b1.getboard()[i][j].setSelect(true);

                        panel.add(b1.getboard()[i][j]);
                    } else {
                        if (b1.getboard()[i][j].isSelect()) {  //if this button 'click' so show like click,change color
                            b1.getboard()[i][j].setIcon(resizeIcon(b1.getboard()[i][j].icon_button(), (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                            b1.getboard()[i][j].setBackground(Color.DARK_GRAY);
                        } else {  // print this button clear
                            b1.getboard()[i][j].setIcon(resizeIcon(b1.getboard()[i][j].icon_button(), (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                            b1.getboard()[i][j].setBackground(new Color(204, 255, 153));
                            //   b1.getboard()[i][j].setSelect(true);

                        }
                    }
                    panel.add(b1.getboard()[i][j]);   //add this button to panel
                }
            }
        }

        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle(" M.S  Flage:" + b1.countflages + "   TIMER:" + time2);
        b1.Press(str.nextInt(), str.nextInt(), str.nextInt(), str.nextInt());
        frame.setTitle(" M.S  Flage:" + b1.countflages + "   TIMER:" + time2);
        print(panel, frame, b1);//recursi
    }

    public void New_Game() {

        b1 = new Board();
        b1.Board(this.length, this.width);

        //creat BOARD
        JFrame frame = new JFrame();
        frame.setTitle(" MineSweeper YAIR.D");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\minelogo.jpg");
        frame.setIconImage(icon);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(b1.getLength(), b1.getWidth()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, b1.getLength() * 35, b1.getWidth() * 35);
        frame.add(panel);
        for (int i = 0; i < b1.getBoard().length; i++) {
            for (int j = 0; j < b1.getBoard()[1].length; j++) {
                b1.getBoard()[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jButtonsMouseClicked(evt);
                    }
                });
            }
        }
        b1.Put_Mines(this.num_mines);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + b1.All_Mines());

        print(panel, frame, b1);
        System.out.println("game over!");

    }

    private void jButtonsMouseClicked(java.awt.event.MouseEvent evt) {
        for (int i = 0; i < b1.getBoard().length; i++) {
            for (int j = 0; j < b1.getBoard()[1].length; j++) {
                if (b1.getBoard()[i][j] == evt.getSource()) {
                    b1.getBoard()[i][j].setBackground(Color.red);
                    return;
                }
            }
        }
    }

}
