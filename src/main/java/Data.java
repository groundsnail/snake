import javax.swing.*;
import java.net.URL;

public class Data {
   public static URL headURL = Data.class.getResource("right.png");
   public static ImageIcon app = new ImageIcon(headURL);
   public static URL body =Data.class.getResource("body.png" );
   public static ImageIcon ibody =new ImageIcon(body);
   public static URL lT = Data.class.getResource("left.png");
   public static ImageIcon appL = new ImageIcon(lT);
   public static URL dN = Data.class.getResource("down.png");
   public static ImageIcon appD = new ImageIcon(dN);
   public static URL uP = Data.class.getResource("up.png");
   public static ImageIcon appU = new ImageIcon(uP);
   public static URL fD = Data.class.getResource("food.png");
   public static ImageIcon food = new ImageIcon(fD);

}