

/****************************************************************/
/*                      Node_Registration	                            */
/*                                                              */
/****************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.rmi.*;
import java.net.*;
/**
 * Summary description for Node_Registration
 *
 */
public class Node_Registration extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
    private JLabel jLabel4;
	private JTextField jTextField1;
	private JComboBox jComboBox1;
    private JComboBox jComboBox2;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel contentPane;
	private JPanel jp1;
	Connection con1;
	Statement st1;
	ResultSet rs1;
	String clusterHeads[]=new String[4];
    String nodes[]=new String[50];
	int i=0;
    String nod,xCord,yCord,passwd;
	static ClientClass cc;
	// End of variables declaration


	public Node_Registration()
	{
		super();
		try
		{
			String url="rmi://127.0.0.1/ecobj";
			ECInterface ecIntf=(ECInterface) Naming.lookup(url);
			clusterHeads=ecIntf.getClusterHeads();
            nodes=ecIntf.getNodeDetails();
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//
		this.setVisible(true);
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


		jTextField1 = new JTextField();
		jComboBox1 = new JComboBox(clusterHeads);
                jComboBox2 = new JComboBox(nodes);
		jButton1 = new JButton();
		jButton2 = new JButton();
		contentPane = (JPanel)this.getContentPane();
		jp1=new JPanel();

		//
		// jLabel1
		//
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel1.setText("Node Registration");
		//
		// jLabel2
		//
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel2.setText("Node Name");
		//
		// jLabel3
		//
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabel3.setText("Cluster Head");
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
		// jButton1
		//
                
		jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton1.setText("Register");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		//
		// jButton2
		//
		jButton2.setHorizontalTextPosition(SwingConstants.CENTER);
		jButton2.setText("Cancel");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		jp1.setLayout(null);

		addComponent(jp1, jLabel1, 172,22,148,26);
		addComponent(jp1, jLabel2, 114,89,92,26);
		addComponent(jp1, jLabel3, 107,138,87,30);
		addComponent(jp1, jComboBox2, 252,91,100,22);
		addComponent(jp1, jComboBox1, 251,142,100,22);
		addComponent(jp1, jButton1, 139,221,83,28);
		addComponent(jp1, jButton2, 251,221,83,28);
		addComponent(contentPane,jp1,20,20,480,350);
		//
		// Node_Registration
		//
		this.setTitle("Node Registration");
		//this.setLocation(new Point(3, -6));
		this.setSize(500, 386);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
    }

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jComboBox1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njComboBox1_actionPerformed(ActionEvent e) called.");		
		Object o = jComboBox1.getSelectedItem();
		System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
		// TODO: Add any handling code here for the particular object being selected
		
	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		String address="";
		String portNo="";
		String url="";
		String node=jComboBox2.getSelectedItem().toString();
        Main.nod=jComboBox2.getSelectedItem().toString();
		String clusterHead=((String)jComboBox1.getSelectedItem()).trim();
        new DBClass().insertRow("Neigh","header","","");
		try
		{
			address=InetAddress.getLocalHost().getHostAddress();	
			String ran=Double.toString(Math.random());
			for(int i=2;i<6;i++)
			{
				portNo=portNo+ran.charAt(i);	
			}
			System.out.println(node);
			System.out.println(clusterHead);
			System.out.println(address);
			System.out.println(portNo);
			url="rmi://127.0.0.1/ecobj";
			ECInterface ecIntf=(ECInterface) Naming.lookup(url);
			String s[]=ecIntf.getNodePassword(node,"node",address,portNo);
                        Main.xCord=s[1];
                        Main.yCord=s[2];
                        Main.passwd=s[0];
                        JOptionPane.showMessageDialog(null,"Your ID is "+s[0]);
                        //int i=JOptionPane.showConfirmDialog(null,"Remember password????");
                        this.dispose();
                        new Mst();
						System.out.println("#######--- Clent Socket Called----######");
						cc=new ClientClass(node);
						cc.start();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		System.exit(0);

	}



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
		new Node_Registration();
	}
}
