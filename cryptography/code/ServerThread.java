/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */


public class ServerThread extends Thread
{
        Socket s = null;
		String name = "";
        static Object o = null;
        private 
        static int NodeCount = 0;       

        ServerThread() 
        {
            System.out.println("From ServerThread");            
        }
        
        
	ServerThread(Socket s)
	{
		this.s  = s;
	}

        public ServerThread(Object o)
        {
            this.o = o;
        }
        
	public void run()
	{
		try
		{
            String sen="";    
			DataInputStream opsa=new DataInputStream(s.getInputStream());
			DataOutputStream out1=new DataOutputStream(s.getOutputStream());
			//Scanner in = new Scanner(System.in);
                        System.out.println("From server Thread : ");
                        String dar=opsa.readUTF();
                        System.out.println("Name received : " + dar );
                        
                        ////////////*************Maintaining the TreeMap*************//////////
                        
                        Object temp = (Object)StaticClass.getS();
                        TreeMap tMap = StaticClass.getSocketMap();
                        tMap.put(dar, temp);
                        StaticClass.setSocketMap(tMap);
                        
                        ////////////*************Maintaining the TreeMap*************//////////
                        
                       
                        System.out.println("Name Printed");                       

                        //TreeMap<String,Object> key=new TreeMap<String, Object>();
                        /////  To read message
                        while(true)
                        {
							System.out.println("******----Enter reading part----******");
                            DataInputStream opsa2=new DataInputStream(s.getInputStream());
                            String nextSend = opsa2.readUTF();
							 System.out.println("Text received  : " + nextSend );
                            String[] nextSendSplit = nextSend.split("###");
                            int i=1;
                            int j=0;
                            if(nextSendSplit[0].equalsIgnoreCase("message"))
							System.out.println("-------------------------------------------------------");
							System.out.println("-------------------------------------------------------");
							sen="message"+"###"+nextSendSplit[2]+"###"+nextSendSplit[3];
							System.out.println(sen);
							System.out.println("-------------------------------------------------------");
							System.out.println("-------------------------------------------------------");
                            //while(i<nextSendSplit.length)
                            {
                               writeToClient(nextSendSplit[1],sen );
                               
                            }
                        }
		}
                
		catch (Exception e)
		{
                    System.out.println("Exception  from ServerThread : run(): " + e.getMessage() + "   " + e);
		}
	}
        
        
        void writeToClient(String nodeName,String o)
        {
            Socket s = new ServerClass().getSocket(nodeName);
            try 
            {
                DataOutputStream out1=new DataOutputStream(s.getOutputStream());
//                ObjectOutputStream outOb = new ObjectOutputStream(s.getOutputStream());
//                outOb.writeObject(o);
                out1.writeUTF(o);
				System.out.println("-----------Text written  : " + o);
            }
            catch (Exception ex) 
            {
                System.out.println("Exception from ServerThread : writeToClient2() : " + ex.getMessage() + ex);                
            }
        }        
}