//TODO Remove unnecessary imports so we don't lose points. 
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
		JMenu file, help, options;
		JMenuItem exit, about, test, export, save, sources, documents;
		menuBar = new JMenuBar();
		file = new JMenu("File");	
		exit = new JMenuItem(new AbstractAction("Exit")
		{
			//Serialize
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		
		save = new JMenuItem(new AbstractAction("Save Query")
		{
			  //Serialize
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				JFrame exportWindow = new JFrame();
				exportWindow.setTitle("Save Query");
				exportWindow.setSize(300,400);
				exportWindow.setVisible(true);
				JLabel text = new JLabel("Your Query has been saved", JLabel.CENTER);
				exportWindow.add(text);
			}	
		});
		
		export = new JMenuItem(new AbstractAction("Export")
		{
			//Serialize
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				JFrame exportWindow = new JFrame();
				exportWindow.setTitle("Export");
				exportWindow.setSize(300,400);
				exportWindow.setVisible(true);
				JLabel text = new JLabel("Select file you wish to EXPORT", JLabel.CENTER);
				exportWindow.add(text);
			}	
		});
		
		
		file.add(save);
		file.add(export);
		file.add(exit);
		menuBar.add(file);

		help = new JMenu("Help");

		about = new JMenuItem(new AbstractAction("About")
		{
			 //Serialize
			private static final long serialVersionUID = 1L;

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
		
		options = new JMenu("Options");
		
		sources = new JMenuItem(new AbstractAction("Sources")
		{
			 //Serialize
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				JFrame sourceWindow = new JFrame();
				sourceWindow.setTitle("Source");
				sourceWindow.setSize(300,400);
				sourceWindow.setVisible(true);
				JLabel text = new JLabel("This is a test run for the SOURCE FEATURE", JLabel.CENTER);
				sourceWindow.add(text);
			}
		});
		
		documents = new JMenuItem(new AbstractAction("Documents")
		{
			 //Serialize
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				JFrame docWindow = new JFrame();
				docWindow.setTitle("Documents");
				docWindow.setSize(300,400);
				docWindow.setVisible(true);
				JLabel text = new JLabel("Your saved DOCUMENTS", JLabel.CENTER);
				docWindow.add(text);
			}
		});
		
		options.add(sources);
		options.add(documents);
		menuBar.add(options);

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
		search.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,10,5,10);
		c.gridx = 0;
		c.gridy = 0;
		search.add(new JLabel("Query:"), c);
		c.gridx = 1;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		JTextField queryText = new JTextField();
		search.add(queryText, c);
		c.gridx = 2;
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		JButton clearBut = new JButton("Clear");
		clearBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				queryText.setText("");
			}
		});
		search.add(clearBut, c);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.5;
		DefaultListModel<String> documentList = new DefaultListModel<String>();
		documentList.addElement("Test");
		JList<String> list = new JList<String>(documentList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(-1);
		JScrollPane documentListScrollPane = new JScrollPane(list);
		documentListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		search.add(documentListScrollPane, c);
		c.gridy = 2;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		c.weighty = 0;
		JLabel retrievedDocs = new JLabel("Retrieved # Documents");
		search.add(retrievedDocs, c);
		JTextArea documentText = new JTextArea();
		documentText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(documentText);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.5;
		search.add(scrollPane, c);

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