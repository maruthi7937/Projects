import java.awt.Button;
import java.awt.Canvas;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.rmi.Naming;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;
import java.awt.Color;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Picture extends javax.swing.JFrame implements Runnable{
	public static JPanel jPanel1;
	private JButton btnReg;
	private JButton btnClear;
	private JTextField jTextField2;
	private JTextField txtClust_Name;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private static Canvas canvas1;
	private JPanel jPanel2;
	static boolean [] pFlag=new boolean[20];
	/**
	* Auto-generated main method to display this JFrame
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Picture inst = new Picture();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	public void run()
	{
		
		
	}
	void callMe(int i)
	{
		NewCanvas.option=i;
		repaint();
	}
	public Picture() 
	{
		initGUI();
		setLocationRelativeTo(null);
		setVisible(true);
		this.setTitle("Cluster Header");
		callMe(2);
	}
	
	 void set(int i)
	{
		//canvas1.setView(5,pFlag);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(900, 680));
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(28, 12, 211, 350);
				jPanel1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Cluster Name");
					jLabel1.setBounds(6, 89, 82, 14);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("Cluster Node");
					jLabel2.setBounds(4, 127, 86, 14);
				}
				{
					txtClust_Name = new JTextField();
					jPanel1.add(txtClust_Name);
					txtClust_Name.setBounds(88, 86, 73, 21);
				}
				{
					jTextField2 = new JTextField();
					jPanel1.add(jTextField2);
					jTextField2.setBounds(88, 124, 73, 21);
				}
				{
					btnReg = new JButton();
					jPanel1.add(btnReg);
					btnReg.setText("Register");
					btnReg.setBounds(14, 165, 82, 22);
					btnReg.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//System.out.println("jButton1.actionPerformed, event="+evt);
							//TODO add your code for jButton1.actionPerformed
							register();
						}
					});
				}
				{
					btnClear = new JButton();
					jPanel1.add(btnClear);
					btnClear.setText("Clear");
					btnClear.setBounds(107, 164, 66, 23);
				}
			}
			{
				jPanel1.setVisible(false);
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setBounds(245, 12, 350, 350);
				jPanel2.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				jPanel2.setLayout(null);
				{
					canvas1 = new NewCanvas();
					jPanel2.add(canvas1);
					canvas1.setBounds(2, 8, 325, 325);
					jPanel2.setBackground(Color.WHITE);
				}
			}
			pack();
			this.setSize(650,450);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean action(Event e, Object o)
	   {
	     if (e.target instanceof Button) {

	        if (e.target == btnClear) {
	           //canvas1.setView(5,pFlag);
	        }
	        if (e.target == btnReg) {
	           register();
	        }
	        repaint();

	        return true;
	     }
	     return true;
	   }

	
	void register()
	   {
	       System.out.println("/njButton1_actionPerformed(ActionEvent e) called.");
			// TODO: Add any handling code here
			String address="";
			String portNo="";
			String url="";
			String clusterHead=txtClust_Name.getText().trim();
			try
			{
				address=InetAddress.getLocalHost().getHostAddress();
				String ran=Double.toString(Math.random());
				for(int i=2;i<6;i++)
				{
					portNo=portNo+ran.charAt(i);
				}

				System.out.println(clusterHead);
				System.out.println(address);
				System.out.println(portNo);
				url="rmi://127.0.0.1/ecobj";
				ECInterface ecIntf=(ECInterface) Naming.lookup(url);
				String s[]=ecIntf.getNodePassword(clusterHead,"Header",address,portNo);
				JOptionPane.showMessageDialog(null,"Your Password is "+s[0]);
				repaint();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
	   }
}
