import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class PirexGUI extends JFrame {
	private static final long serialVersionUID = 2908649342413183726L;
	
    public PirexGUI() {
       Container     contentPane;
       JPanel        search, load, summarize;
       JTabbedPane   tabbedPane;
    
       //Menu bar
	   JMenuBar menuBar;
	   JMenu file, help;
	   JMenuItem exit, about, test;
	   menuBar = new JMenuBar();
	   file = new JMenu("File");	
	   exit = new JMenuItem(new AbstractAction("exit")
	   {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		file.add(exit);
		menuBar.add(file);
		
		help = new JMenu("Help");
		
		about = new JMenuItem(new AbstractAction("about")
				{
					public void actionPerformed(ActionEvent e) {
						JFrame helpWindow = new JFrame();
						helpWindow.setTitle("Help");
						helpWindow.setSize(300,400);
						helpWindow.setVisible(true);
						JLabel text = new JLabel("This is a test run for the help menu", JLabel.CENTER);
						helpWindow.add(text);
					}
				});
		help.add(about);
		menuBar.add(help);
		
		setJMenuBar(menuBar);
      
		//Pirex header
       ImageIcon icon = new ImageIcon("icons/icon.png");       
       setIconImage(icon.getImage());
       setTitle("Pirex");
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       contentPane = getContentPane();

       contentPane.setLayout(new BorderLayout());
       tabbedPane = new JTabbedPane();
       contentPane.add(tabbedPane, BorderLayout.CENTER);
       
       //search for document tab
       search = new JPanel();
       search.setLayout(new BorderLayout());
       search.add(new JLabel("Things you like about this class:"),
                       BorderLayout.NORTH);
       search.add(new JTextArea(), BorderLayout.CENTER);
      
       //load document tab
       load = new JPanel();
       load.setLayout(new BorderLayout());
       load.add(new JLabel("Things you dislike about this class:"),
                      BorderLayout.NORTH);
       
       //summarize document tab
       summarize = new JPanel();
       summarize.setLayout(new BorderLayout());
       

       tabbedPane.addTab("Search for Documents", search);
       tabbedPane.addTab("Load Documents",  load);
       tabbedPane.addTab("Summarize Documents", summarize);
    }
}