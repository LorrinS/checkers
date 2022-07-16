/*
Lorrin Shen
Partner: Mahir Rahman
June 3 2020
Assignment 21: Final Project
ICS3U7-01 Ms. Strelkovska
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckersMenu extends JPanel implements ActionListener{
	//variables
	JButton play, instruction, exit;
	CheckersGame cg;
	ImageIcon img;
	Color myGreen;
	JToolBar toolbar;
	//constructors
	public CheckersMenu() {

        this.setLayout(new BorderLayout());
        img = new ImageIcon("Checkers3.jpg");
        Color myGreen = new Color(0, 140, 0);
        play = new JButton("Play");
        instruction = new JButton("Rules");
        exit = new JButton("Exit");


        toolbar = new JToolBar("Toolbar");
        this.setPreferredSize( new Dimension(700,700));
        this.setBackground( Color.white );
        play.setBounds(250,250,100,100);
        instruction.setBounds(250,450,100,100);
        exit.setBounds(350,650,200,100);
        play.setBackground(Color.pink);
        instruction.setBackground(Color.pink);
        exit.setBackground(Color.pink);
        toolbar.add(play);
        toolbar.add(instruction);
        toolbar.add(exit);
        this.add(toolbar, BorderLayout.SOUTH);
        play.addActionListener(this);
        instruction.addActionListener(this);
        exit.addActionListener(this);
        this.setBackground(myGreen);
		this.setForeground(Color.RED);

    }
//methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
		/*Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = new Color(0, 102, 0);
        Color color2 = Color.GREEN;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h); */
        g.drawImage(img.getImage(), 100, 100, 500, 500, null);
}


     public void actionPerformed(ActionEvent e) {

              if(e.getSource()==play)
              {
                drawBoard();
              }
              else if(e.getSource()==instruction){
                //removeAll();
                //repaint();
                CheckersRules cr = new CheckersRules();
              }
              else if(e.getSource()==exit){
				int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if(confirmation == JOptionPane.YES_OPTION){
                //JOptionPane.showMessageDialog(null, "That was an exit button", "My exit message",JOptionPane.WARNING_MESSAGE ); 
				System.exit(0);
				
				}
              }
    }
    public void drawBoard()
    {
        CheckersGUI.getContainer().removeAll();
        CheckersGUI.getContainer().revalidate();
        repaint();

        cg = new CheckersGame();
        CheckersGUI.getContainer().add(cg, BorderLayout.CENTER);
        CheckersGUI.getContainer().add(toolbar, BorderLayout.SOUTH);
        repaint();
    }
}