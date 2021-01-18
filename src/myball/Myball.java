
package myball;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


class Enemy extends JPanel
{
    public Enemy()
    {
        setOpaque(false);
        repaint();
    }
    @Override
    public void paint(Graphics G)
    {
        G.setColor(Color.RED);
        G.fillRect(250,300,250,20);
    }
}

class Enemytwo extends JPanel implements ActionListener
{
    int ex=20;
    int ey=100;
    public Enemytwo()
    {
        setOpaque(false);
        repaint();
    }
    @Override
    public void paint(Graphics G)
    {
        G.setColor(Color.ORANGE);
        G.fillRect(ex,ey,80,80);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ex=ex+5;
        repaint();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Enemytwo.class.getName()).log(Level.SEVERE, null, ex);
        }
        ex=ex-5;
        repaint();
    }

}


public class Myball extends JFrame
{
    private boolean move=false;
    private Timer timer;
    private Timer timer2;
    private Timer timer3;
    private boolean have=false;
    Player player =new Player();
    int time=0;
    JLabel messageLabel;
    JLabel playerSmartisLabel;

    private ArrayList<Smartiz> smartizes = new ArrayList<>();
    private ArrayList<Smartiz> playerSmartises = new ArrayList<>();
    private ArrayList<Smartiz> shootedSmartizes = new ArrayList<>();

    Myball()
    {
        setSize(500,600);
        setVisible(true);
        Container contentPane = getContentPane();
        setFocusable(true);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*****************************************************/

        /*****ADD PLAYER*******/
//        player.painting();
//        contentPane.add(player);
        contentPane.setFocusable(true);
//        player.setOpaque(false);
//        player.setSize(500,600);
        /**ADD ENEMIES**/
        Enemy en=new Enemy();
        contentPane.add(en);
        en.setSize(500,600);

        Enemytwo en2=new Enemytwo();
        contentPane.add(en2);
        en2.setSize(500, 600);
        //**************************************************
//        Smartiz s=new Smartiz();
//        contentPane.add(s);

/*
        Givesmarties gs=new Givesmarties();
        gs.setSize(500, 600);
        contentPane.add(gs);
*/

        timer3 = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRandomSmartisToBoard();
            }
        });
        timer3.setInitialDelay(0);
        timer3.start();

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (move)
                {
                    player.y_pos= player.y_pos-20;
                    time++;
                }
            }
        }).start();

        /**************************************************/

        playerSmartisLabel = new JLabel("Smarties : ");
        playerSmartisLabel.setForeground(Color.YELLOW);
        addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e)
            {
                int key = e.getKeyCode();
                System.out.println("key = " + key);
                if (key == KeyEvent.VK_LEFT) {
                    player.moveleft();

                }
                if (key == KeyEvent.VK_RIGHT) {
                    player.moveright();
                }
                if(key==KeyEvent.VK_ENTER)
                {
                    if(playerSmartises.size() > 0)
                    {
                        Smartiz smartiz = playerSmartises.remove(0);
                        playerSmartisLabel.setText("Smarties : " + playerSmartises.size());
                        shootedSmartizes.add(smartiz);
                        smartiz.setLocation(player.x_pos, player.y_pos);
                        smartiz.setShow(true);
                        timer = new Timer(10,smartiz);
                        timer.setInitialDelay(0);
                        timer.start();
                    }
                }

            }
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {      }

        });


        //*****************************************//
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.YELLOW);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                boolean stop=true;
                //infini loop
                while (stop)
                {
                    if (!move)
                    {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            //do nothing
                        }
                        continue;
                    }

                    repaint();

//                     double distance = Math.pow(((player.x_pos)-(gs.getx())) * ((player.x_pos)-(gs.getx()))
//                             + ((player.y_pos)-(gs.gety())) * ((player.y_pos)-(gs.gety())), 0.5);
//
////                     if(player.x_pos==gs.getx() && player.y_pos==gs.gety())
////                     {

////                     }

                    if(player.x_pos==110 /*&& (player.y_pos>=100)&&(player.y_pos<=195)*/ )
                    {
/* commented
                        timer2 = new Timer(10,en2);
                        timer2.setInitialDelay(0);
                        timer2.start();
*/
                    }

                    for (int i = 0; i < smartizes.size(); i++)
                    {
                        Smartiz smartize = smartizes.get(i);
                        if (Math.abs(player.x_pos-smartize.getx()) < 30 && Math.abs(player.y_pos -smartize.gety()) < 30)
                        {
                            System.out.println("hello");
//                            timer3.stop();
//                            have=true;
                            smartizes.remove(smartize);
                            smartize.setShow(false);
                            playerSmartises.add(smartize);
                            playerSmartisLabel.setText("Smarties : " + playerSmartises.size());
                        }
                    }

                    if((player.y_pos>=300)&&(player.y_pos<=320)&&(player.x_pos>=230)&&(player.x_pos<=500) )
                    {
//                        JOptionPane.showMessageDialog(null,"you losed :(");
                        messageLabel.setText("you loosed :(");
                        stop=false;
                    }
                    if((player.y_pos>=100)&&(player.y_pos<=180)&&(player.x_pos>=20)&&(player.x_pos<=100))
                    {
//                        JOptionPane.showMessageDialog(null,"you losed :(");
                        messageLabel.setText("you loosed :(");
                        stop=false;
                    }
/*  commented
                    if((s.gety()>=300)&&(s.gety()<=320)&&(s.getx()>=250)&&(s.getx()<=500))
                    {
                        System.out.println("impact)");

                    }
*/

                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex)
                    {
                        //do nothing
                    }
                    if(time==21)
                    {
                        stop=false;
                    }
                }
            }
        });

        //make jbutton
        JPanel jPanel = new JPanel();
        contentPane.add(jPanel,BorderLayout.SOUTH);
        jPanel.setBackground(Color.BLUE);
        JButton b=new JButton("start");
        b.setFocusable(false);
        b.setSize(50,50);
        jPanel.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //t.start();
                move=!move;
                b.setText(move ? "stop" : "start");
            }
        } );

        jPanel.add(playerSmartisLabel);
        jPanel.add(messageLabel);

        t.start();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < smartizes.size(); i++)
        {
            Smartiz smartize = smartizes.get(i);
            smartize.paint(g);
        }

        for (int i = 0; i < playerSmartises.size(); i++)
        {
            Smartiz smartize = playerSmartises.get(i);
            smartize.paint(g);
        }

        for (int i = 0; i < shootedSmartizes.size(); i++)
        {
            Smartiz smartize = shootedSmartizes.get(i);
            smartize.paint(g);
        }

        player.paint(g);
    }

    private void addRandomSmartisToBoard() {
        Smartiz s = new Smartiz(new Random().nextInt(500), new Random().nextInt(300) + 250);
        smartizes.add(s);
    }

    public static void main(String[] args)
    {
        new Myball();
    }
}
