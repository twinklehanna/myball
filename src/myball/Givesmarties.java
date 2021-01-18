package myball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;

public class Givesmarties extends JPanel
{
    int x;
    int y;


     @Override
    public void paint(Graphics G)
    {
        G.setColor(Color.blue);
        G.fillOval(x,y,30,30);
    }
    
    public void actionPerformed(ActionEvent e) {
        x=randx();
        y=randy();
        repaint();
    }
    public int randx()
    {
        Random rand=new Random();
        int ranx=rand.nextInt(500);
        return ranx;
    }
    public int randy()
    {
        Random rand=new Random();
        int rany=rand.nextInt(300)+250;
        return rany;
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
            
    
}
