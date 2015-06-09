

import java.rmi.Naming;

public class ECServer 
{
	static Object o = null;
	static Object o1 = null;
	public static void main(String[] args) 
	{
		try
		{
			ECImpl ecImpl=new ECImpl();
			Naming.rebind("ecobj",ecImpl);	
			Picture pic = new Picture();
			o = pic;
			System.out.println("##############*******************###############");
			ServerClass ser=new ServerClass();
			o1=ser;
			ser.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
