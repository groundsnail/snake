import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    int length;
    int[] x =new int[100];
    int[] y =new int[100];

    public Panel() {
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
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        Data.app.paintIcon(this,g,x[0],y[0]);
        for (int i = 1; i < length; i++) {
            Data.ibody.paintIcon(this,g,x[i],y[i]);
        }
    }
}
