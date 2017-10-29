

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class LifeGame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final World world;
	
	public LifeGame(int rows, int columns)
	{
		world = new World(rows, columns);
		new Thread(world).start();
		add(world);
	}
	
    public static void main(String[] args) 
    {
    	LifeGame frame = new LifeGame(40, 50);
    	
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        
        JMenu options = new JMenu("graph");
        menu.add(options);
        
        JMenuItem graph1 = options.add("pulsar");
        graph1.addActionListener(frame.new GraphActionListener1());
     
        
        JMenuItem graph2 = options.add("line");
        graph2.addActionListener(frame.new GraphActionListener2());
        

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 859);
        frame.setTitle("The game of life");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }	
    
    class GraphActionListener1 implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setGraph1();
    	}
    }
    
    class GraphActionListener2 implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		world.setGraph2();
    	}
    }
}
