import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class PirexGUI extends JFrame {
	private static final long serialVersionUID = 2908649342413183726L;
	
    public PirexGUI() {
       Container     contentPane;
       JPanel        complements, criticisms;
       JTabbedPane   tabbedPane;

       setTitle("Pirex");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       contentPane = getContentPane();

       contentPane.setLayout(new BorderLayout());
       tabbedPane = new JTabbedPane();
       contentPane.add(tabbedPane, BorderLayout.CENTER);

       complements = new JPanel();
       complements.setLayout(new BorderLayout());
       complements.add(new JLabel("Things you like about this class:"),
                       BorderLayout.NORTH);
       complements.add(new JTextArea(), BorderLayout.CENTER);

       criticisms = new JPanel();
       criticisms.setLayout(new BorderLayout());
       criticisms.add(new JLabel("Things you dislike about this class:"),
                      BorderLayout.NORTH);

       tabbedPane.addTab("Complements", complements);
       tabbedPane.addTab("Criticisms",  criticisms);
    }
}