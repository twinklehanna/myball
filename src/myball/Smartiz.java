
package myball;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author RTACG
 */
public class Smartiz implements ActionListener
{
    int x;
    int y;
    private boolean show = true;

    public Smartiz(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setLocation(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }

    public void paint(Graphics g) {
        if (!show)
            return;

        g.setColor(Color.MAGENTA);
        g.fillOval(x,y,30,30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        y--;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}




