import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Random;

public class Panel extends JPanel implements KeyListener, ActionListener {
    int length;
    int[] x =new int[100];
    int[] y =new int[100];
    boolean isStart = false;
    String direction = "R";
    String d0="R";
    Timer tme =new Timer(150,this);
    int foodX;
    int foodY;
    long score;
    int highest;
    Random random=new Random();

      public Panel() throws Exception {

        this.setFocusable(true); //获取焦点事件
        this.addKeyListener(this); //键盘监听事件
        tme.start();
        init();

      }

    public void init(){
        length = 3;
        x[0]=80;
        y[0]=20;
        x[1]=50;
        y[1]=20;
        x[2]=20;
        y[2]=20;
        foodX=80+30;
        foodY=20+60;
        isStart = false;
        score =0;

        try {
            JdbcTemplate jjj = C3p0t.jjj();
            String ssql="select * from highest where sid = ?";
            Map<String, Object> stringObjectMap = jjj.queryForMap(ssql, 1);
            highest = (int)stringObjectMap.get("score");
            System.out.println(highest);
        } catch (Exception e) {
            e.printStackTrace();
        }


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
            g.setFont(new Font("微软雅黑",Font.BOLD,60));
            g.drawString("s键 开始游戏",200,200);

        }
        Data.food.paintIcon(this,g,foodX,foodY);
        g.setFont(new Font("微软雅黑",Font.BOLD,40));
        g.drawString("积分"+score,1000,50);
        Data.food.paintIcon(this,g,foodX,foodY);
        g.setFont(new Font("微软雅黑",Font.BOLD,40));
        g.drawString("记录"+highest,1200,50);
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
        if (keyCode == KeyEvent.VK_RIGHT&&!direction.equals("L")) {
            direction= "R";
        }
        if (keyCode == KeyEvent.VK_LEFT&&!direction.equals("R")) {
            direction= "L";
        }
        if (keyCode == KeyEvent.VK_DOWN&&!direction.equals("U")) {
            direction= "D";
        }
        if (keyCode == KeyEvent.VK_UP&&!direction.equals("D")){
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
            if(x[0]==foodX&&y[0]==foodY) {
                length++;
                score=score+10;
                foodX=80+30*random.nextInt(40);
                foodY=20+30*random.nextInt(30);
                x[length-1]=x[length-2];
                y[length-1]=y[length-2];
            }
            for (int i = 1; i < length; i++) {
                if (x[i] == x[0]&&y[i]==y[0]) {

                    try {
                        JdbcTemplate doa = C3p0t.jjj();
                        String sql="update highest set score = ? where sid = 1";
                        String ssql="select * from highest where sid = ?";
                        String sssql="select * from highest";
                        Map<String, Object> stringObjectMap = doa.queryForMap(ssql, 1);
                        int score1 = (int)stringObjectMap.get("score");
                        System.out.println(score1);
                        java.util.List<Stu> query = doa.query(sssql, new BeanPropertyRowMapper<Stu>(Stu.class));
                        for (Stu stu:query) {
                            System.out.println(stu);
                        }

                        if (score > score1) {
                            doa.update(sql,score);
                        }
                        else {

                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                 init();

                }
            }
        }
        tme.start();
    }
}
