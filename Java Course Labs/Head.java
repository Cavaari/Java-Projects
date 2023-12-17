import java.awt.*;
import java.awt.geom.*;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


public class Head extends JPanel{
    private boolean mouseInside = false;

    private class MyMouseListener extends MouseAdapter{
        public void mouseEntered(MouseEvent me){
            mouseInside = true;
            repaint();
        }
        public void mouseExited(MouseEvent me){
            mouseInside = false;
            repaint();
        }
    }
    public Head(){
        this.setPreferredSize(new Dimension(500, 500));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        MyMouseListener obj = new MyMouseListener();
        this.addMouseListener(obj);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3.0f));
        Ellipse2D.Double faceBorder = new Ellipse2D.Double(100,100,300,300);
        g2.draw(faceBorder);
        java.awt.geom.Rectangle2D.Double mouth = new Rectangle2D.Double(200,300,100,50);
        g2.draw(mouth);

        if(mouseInside){
            Ellipse2D.Double leftEye = new Ellipse2D.Double(150,200,30,30);
            g2.draw(leftEye);
            Ellipse2D.Double rightEye = new Ellipse2D.Double(320,200,30,30);
            g2.draw(rightEye);
        }
        else{
            java.awt.geom.Line2D.Double leftEye = new Line2D.Double(150,200,180,200);
            g2.draw(leftEye);
            java.awt.geom.Line2D.Double rightEye = new Line2D.Double(320,200,350,200);
            g2.draw(rightEye);
        }

    }
}
