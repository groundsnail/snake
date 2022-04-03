import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener, ActionListener {
    int length;
    int[] x =new int[100];
    int[] y =new int[100];
    boolean isStart = false;
    String direction = "R";
    Timer tme =new Timer(100,this);
    int foodX=(int)(Math.random()*1000);
    int foodY=(int)(Math.random()*1000);
    public Panel() {
        init();
        this.setFocusable(true); //获取焦点事件
        this.addKeyListener(this); //键盘监听事件
        tme.start();
    }

    public void init(){
        length = 3;
        x[0]=80;
        y[0]=20;
        x[1]=50;
        y[1]=20;
        x[2]=20;
        y[2]=20;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        if (direction.equals("R")) {
            Data.app.paintIcon(this,g,x[0],y[0]);
        }
        if (direction.equals("L")) {
            Data.appL.paintIcon(this,g,x[0],y[0]);
        }
        if (direction.equals("D")) {
            Data.appD.paintIcon(this,g,x[0],y[0]);
        }
        if (direction.equals("U")) {
            Data.appU.paintIcon(this,g,x[0],y[0]);
        }

        for (int i = 1; i < length; i++) {
            Data.ibody.paintIcon(this,g,x[i],y[i]);
        }
        if (isStart == false) {
            g.drawString("开始游戏",200,200);

        }
        else {Data.food.paintIcon(this,g,foodX,foodY);}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        if (keyCode == KeyEvent.VK_S) {
            isStart=!isStart;

            repaint();
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            direction= "R";
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            direction= "L";
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            direction= "D";
        }
        if (keyCode == KeyEvent.VK_UP) {
            direction= "U";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart == true) {
            if (direction.equals("R")) {
                for (int i = length-1; i >0 ; i--) {
                    x[i]=x[i-1];
                    y[i]=y[i-1];
                }
                x[0]=x[0]+30;
                y[0]=y[0];
                repaint();
            }
            if (direction.equals("L")) {
                for (int i = length-1; i >0 ; i--) {
                    x[i]=x[i-1];
                    y[i]=y[i-1];
                }
                x[0]=x[0]-30;
                y[0]=y[0];
                repaint();
            }
            if (direction.equals("U")) {
                for (int i = length-1; i >0 ; i--) {
                    x[i]=x[i-1];
                    y[i]=y[i-1];
                }
                x[0]=x[0];
                y[0]=y[0]-30;
                repaint();
            }
            if (direction.equals("D")) {
                for (int i = length-1; i >0 ; i--) {
                    x[i]=x[i-1];
                    y[i]=y[i-1];
                }
                x[0]=x[0];
                y[0]=y[0]+30;
                repaint();
            }

        }
        tme.start();
    }
}
