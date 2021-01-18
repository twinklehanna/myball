
package myball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


class Player
{
    int x_pos =250;
    int y_pos = 500;
    int radius =20;
    public Player()
    {

//        setOpaque(false);
//        setBackground(Color.BLACK);
    }
    public void painting()
    {
//        repaint();
    }
//    @Override
    public void paint(Graphics g)
    {
//        super.paint(G);
        g.setColor(Color.pink);
        g.fillOval(x_pos, y_pos, 2 * radius, 2 * radius);

    }
    public void moveleft()
    {
        x_pos=x_pos-10;
//        repaint();
    }
    public void moveright()
    {
        x_pos=x_pos+10;
//        repaint();
    }


}

