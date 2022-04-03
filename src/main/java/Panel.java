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
    Timer tme =new Timer(100,this);
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
        Data.app.paintIcon(this,g,x[0],y[0]);
        for (int i = 1; i < length; i++) {
            Data.ibody.paintIcon(this,g,x[i],y[i]);
        }
        if (isStart == true) {
            g.drawString("开始游戏",200,200);

        }
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart == true) {

            for (int i = length-1; i >0 ; i--) {
                x[i]=x[i-1];
                y[i]=y[i-1];
            }
            x[0]=x[0]+30;
            y[0]=y[0];
            repaint();
        }
        tme.start();
    }
}
