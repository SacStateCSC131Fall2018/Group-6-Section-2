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