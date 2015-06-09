/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class ServerClass extends Thread
{
    private final static int BUFSIZE = 20;
    
    static Thread threadCollection[] = new Thread[50];
    
    Thread t = null;
    
    ServerThread sObj;
    
    @Override
    public void run()
    {
        int clientNumber = 1;
        String threadName = "client" + clientNumber;
        
        try
	{
            int port = 4555;
            ServerSocket ss =  new ServerSocket(port);
            System.out.println("Waiting for client.....");	  
            String name = "";                      
            //StaticClass.v.add("node1");
            
            while(true)
            {
               	Socket s = ss.accept();
                StaticClass.setS(s);
            	System.out.println("Accepted a client.....");                
                sObj = new ServerThread(s);
                sObj.start();
                
               // int ObjectCount = StaticClass.ObjectCount;
                
//                System.out.println("Started Thread for client : " + ObjectCount);
//                Object o[] = StaticClass.getO();
//                o[ObjectCount] = s;
//                ObjectCount += 1;
//
//                StaticClass.setObjectCount(ObjectCount);
//                StaticClass.setO(o);
//
//                clientNumber += 1;
//                threadName = "client" + clientNumber;
            }
         }
         catch (Exception e)
         {
               System.out.println("Exception form ServerClass : run() : " + e.getMessage());
         }
        
    }
    
    public Socket getSocket(String nodeName)
    {
        TreeMap tMap = StaticClass.getSocketMap();
        Object o = tMap.get(nodeName);  
        return (Socket)o;
    }
}


