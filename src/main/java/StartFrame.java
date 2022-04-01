import javax.swing.*;

public class StartFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(100,100,1024,768);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(new Panel());
    }
}
