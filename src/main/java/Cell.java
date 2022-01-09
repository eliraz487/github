
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cell extends JButton /*implements MouseListener */ {

    private JButton button;
    private boolean Mine = false;
    private boolean flag = false;
    private int show;
    private boolean select = false;
    private boolean  boom = false;
    private int countflags;
    private int i;
    private int j;
    boolean click = false;

    public Cell(JButton other) {
        this.button=other;
    }

    public Cell(String text) {
        super(text);
    }

    
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getCountflags() {
        return countflags;
    }

    public void setCountflags(int countflags) {
        this.countflags = countflags;
    }

    public boolean isBoom() {
        return boom;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isMine() {
        return Mine;
    }

    public void setMine(boolean Mine) {
        this.Mine = Mine;
    }

    public ImageIcon Show_all_mines(boolean ok) {
        ImageIcon icon = new ImageIcon("");

        if (ok) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\bomb.png");
        }
        return icon;
    }

    public ImageIcon icon_button() {
        ImageIcon icon = new ImageIcon("");
        if (this.show == 888) {
            this.boom = true;
        }
        if (this.show == 777) {
            this.select = true;
        }
        if (this.show == 1) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_1.svg.png");
        }
        if (this.show == 2) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_2.svg.png");
        }
        if (this.show == 3) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_3.svg.png");
        }
        if (this.show == 4) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_4.svg.png");
        }
        if (this.show == 5) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_5.svg.png");
        }
        if (this.show == 6) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_6.svg.png");
        }
        if (this.show == 7) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_7.svg.png");
        }
        if (this.show == 8) {
            icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\Minesweeper_8.svg.png");
        }
        return icon;
    }

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
