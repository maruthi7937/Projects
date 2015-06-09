
/****************************************************************/
/*                      Node	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.security.PrivateKey;
import java.security.PublicKey;


/**
 * Summary description for Node
 *
 */
public class Node extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JTextField jTextField1;
	private JComboBox jComboBox1;
	private JTextArea jTextArea1;
	static JTextArea jTextArea2;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JPanel contentPane;
	String sourceNode="";
	String sourceClusterHead="";
	String otherNodes[]=new String[10];
	String url="";
	String destinationNode="";
	String clusterHeadAddress="";
	int clusterHeadPortNo;
	
	//String destClusterhead="";
	String file="";
	//Connection con,con1,con2;
	//Statement st,st1,st2;
	//ResultSet rs,rs1,rs2;
	//String nodes[]=new String[20];
	File filename=null;
	FileInputStream fin=null;
	String str="";
	//String destNode="";
	int ch;
	PrivateKey pr;

	
	// End of variables declaration
	Node()
	{
		super();
		initializeComponent();
		this.setVisible(true);
	}
	


	public Node(String sourceNode,String sourceClusterHead,String sourceAddress,String sourcePortNo)
	{
		super();
		//System.out.println("Node is --------------->"+srcNode+"Port No is -------------->"+portno);
		this.sourceNode=sourceNode;
		this.sourceClusterHead=sourceClusterHead;
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
		this.setTitle("Message Transfer");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		jTextField1 = new JTextField();
		
		/*
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:EC");
			st=con.createStatement();
			rs=st.executeQuery("select node from node_registration where node !='"+sourceNode+"'");
			int i=0;
			while(rs.next())
			{
				nodes[i]=rs.getString(1).trim();
				i++;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		*/
		try
		{
			url="rmi://127.0.0.1/ecobj";
			ECInterface ecIntf=(ECInterface) Naming.lookup(url);
			otherNodes=ecIntf.getNeighbour(Main.nod);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		jComboBox1 = new JComboBox(otherNodes);
		jTextArea1 = new JTextArea();
		jTextArea2 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jScrollPane2 = new JScrollPane();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		contentPane = (JPanel)this.getContentPane();
		

		//
		// jLabel1
		//
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel1.setText(sourceNode);
		//
		// jLabel2
		//
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel2.setText("Cluster Head");
		//
		// jLabel3
		//
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel3.setText(sourceClusterHead);
		//
		// jLabel4
		//
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel4.setText("Enter Message");
		//
		// jLabel5
		//
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel5.setText("Destination");
		//
		// jLabel6
		//
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel6.setText("Attach File");
		//
		// jLabel7
		//
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel7.setText("File Content");
		//
		// jTextField1
		//
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jComboBox1
		//
		jComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jComboBox1_actionPerformed(e);
			}

		});
		//
		// jTextArea1
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1);
		//
		// jTextArea2
		//
		//
		// jScrollPane2
		//
		jScrollPane2.setViewportView(jTextArea2);
		//
		// jButton1
		//
		jButton1.setText("Send");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		//
		// jButton2
		//
		jButton2.setText("Exit");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
				System.exit(1);
			}

		});
		//
		// jButton3
		//
		jButton3.setText("Browse");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		addComponent(contentPane, jLabel1, 204,12,100,33);
                

		addComponent(contentPane, jLabel2, 119,62,83,30);
		addComponent(contentPane, jLabel3, 245,61,84,27);
		addComponent(contentPane, jLabel4, 109,111,112,31);
		addComponent(contentPane, jLabel5, 116,214,79,27);
		addComponent(contentPane, jLabel6, 113,171,78,25);
		addComponent(contentPane, jLabel7, 45,320,78,25);
		addComponent(contentPane, jTextField1, 255,171,127,25);
		addComponent(contentPane, jComboBox1, 257,218,126,25);
		addComponent(contentPane, jScrollPane1, 255,107,128,37);
		addComponent(contentPane, jButton1, 179,276,83,28);
		addComponent(contentPane, jButton2, 300,276,83,28);
		addComponent(contentPane, jButton3, 382,171,83,25);
		addComponent(contentPane, jScrollPane2, 50,350,500,200);
		//System.out.println("\n"+(c[i].toString().substring(12,c[i].toString().indexOf("[") )));
		//
		// Node
		//
		this.setTitle(sourceNode);
		//this.setLocation(new Point(121, 5));
		this.setSize(new Dimension(600, 600));

                
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jComboBox1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njComboBox1_actionPerformed(ActionEvent e) called.");		
		Object o = jComboBox1.getSelectedItem();
		destinationNode=o.toString();
		System.out.println(destinationNode);
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
		// TODO: Add any handling code here for the particular object being selected

		
	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		
		try
		{		
			url="rmi://127.0.0.1/ecobj";
			System.out.println("-----EcImpl Called------");
			ECInterface ecIntf=(ECInterface) Naming.lookup(url);			
			PublicKey pb=ecIntf.getPublic(destinationNode);
			
			System.out.println("-----PUBLIC KEY FOR "+destinationNode+" ------  "+pb);
			System.out.println("-----Encryption CALLING------");
			new Encrypt().encryption(destinationNode,(String)jTextArea1.getText(),pr,pb);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		/*
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("jdbc:odbc:EC");
			st1=con1.createStatement();
			rs1=st1.executeQuery("select clusterhead from node_registration where node='"+destNode+"'");
			
			while(rs1.next())
			{
				
				destClusterhead=rs1.getString(1).trim();
			}
		}
		catch (Exception ex1)
		{
			ex1.printStackTrace();
		}
		new Cluster_Head(srcClusterhead,0,srcNode,destClusterhead,destNode);
		*/

	}
	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}
	private void jButton3_actionPerformed(ActionEvent e)
	{
		// TODO: Add any handling code here
		System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");		
		FileDialog fd=new FileDialog(this,"Open",FileDialog.LOAD);
		fd.show();
		file=fd.getDirectory()+fd.getFile();
		System.out.println(file);
		jTextField1.setText(file);
		try
		{
			filename=new File(file);
			fin=new FileInputStream(filename);
			
			str=fd.getFile()+"\n\n";
			while((ch=fin.read())!=-1)
			{
				str=str+((char)ch);
			}
			fin.close();
			System.out.println("File Content is:");
			System.out.println(str);
			
			jTextArea2.append(str);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		
		
		

	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//






























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new Node("","","","");
	}
//= End of Testing =


}
