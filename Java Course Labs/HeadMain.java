import java.awt.*;
import javax.swing.*;

public class HeadMain {
   
    public static void main(String[] args){
        JFrame f = new JFrame("ShapePanel demo");

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new GridLayout(2,2));

        for(int i = 1; i<=4; i++){
            f.add(new Head());
        }
        f.pack();
        f.setVisible(true);
    }
}
