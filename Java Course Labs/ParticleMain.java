import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ParticleMain{
    
    public static void main(String[] args) {
       
        JFrame f = new JFrame("Concurrency in Animation");

        ParticleField obj = new ParticleField(270000, 1525, 1080);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                obj.terminate(); // first stop the timer of the ImageTimerPanel component
                f.dispose(); // and now we can safely dispose of the frame
            }
        });
        f.setLayout(new FlowLayout());
        f.add(obj);
        f.pack();
        f.setVisible(true);
    }
}