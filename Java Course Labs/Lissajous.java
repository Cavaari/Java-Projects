import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.Dimension;


public class Lissajous extends JPanel{
    
    JTextField a, b, delta;
    double aField, bField, dField = 0;
    int size; 

    public Lissajous(int size){


        setPreferredSize(new Dimension(size, size));
        this.size = size;
        
        a = new JTextField(5);
        a.setText("6");
        
        b = new JTextField(5);
        b.setText("5");
        
        delta = new JTextField(5);
        delta.setText("0.5");
    

        this.setLayout(new FlowLayout());
        this. add(new JLabel("a: "));
        this. add(a);
        this. add(new JLabel("b: "));
        this. add(b);
        this. add(new JLabel("delta: "));
        this. add(delta);

        a.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                repaint();
            }
        });

        b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                repaint();
            }
        });

        delta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });


    }

    @Override

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

            try{
                  aField = Double.parseDouble(a.getText());
                  bField = Double.parseDouble(b.getText());
                  dField = Double.parseDouble(delta.getText());
            } catch (Exception e){
            
            }
            double t = 0;
            double currX = size /2 + 2 * size /5 * Math.sin(aField * t * Math.PI + dField);
            double currY = size /2 + 2 * size /5 * Math.sin(bField * t * Math.PI);
            
            for (t = 0; t <= (aField + bField) * Math.PI; t += 0.009){
                            double newX = size /2 + 2 * size /5 * Math.sin(aField * t * Math.PI + dField);
                            double newY = size /2 + 2 * size /5 * Math.sin(bField * t * Math.PI);
                        
                            g.drawLine((int)currX, (int)currY, (int)newX, (int)newY);
                            Graphics2D g2 = (Graphics2D) g; 
                            g2.setStroke(new BasicStroke(4));

                            currX = newX;
                            currY = newY;
            }
    
    }


    
}


