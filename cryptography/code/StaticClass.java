/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.Socket;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author Admin
 * 
 */
public class StaticClass 
{
    
    static Object o[] = new Object[50];
    static int ObjectCount = 0;
    static Vector v = new Vector();
    static String myName;
    static int PrevNode = 0;
    static String ipAdrress = "";
    static Vector forLinkTable = new Vector();
    static TreeMap<Integer,String> receivedPacket= new TreeMap<Integer, String>();
   static TreeMap<String,Socket> tr= new TreeMap<String, Socket>();
    static Socket s = null;

    public static Socket getS()
    {
        return s;
    }

    public static void setS(Socket s)
    {
        StaticClass.s = s;
    }

    public static TreeMap<String, Socket> getSocketMap()
    {
        return tr;
    }

     public static void  setSocketMap(TreeMap<String, Socket> t)
    {
         StaticClass.tr = t;
    }
    

    public static TreeMap<Integer, String> getReceivedPacket()
    {
        return receivedPacket;
    }
    
    public static void setReceivedPacket(TreeMap<Integer, String> receivedPacket)
    {
        StaticClass.receivedPacket = receivedPacket;
    }
    
    public static Vector getForLinkTable() 
    {
        return forLinkTable;
    }

    public static void setForLinkTable(Vector forLinkTable) 
    {
        StaticClass.forLinkTable = forLinkTable;
    }    
    
    public static String getIpAdrress() 
    {
        return ipAdrress;
    }

    public static void setIpAdrress(String ipAdrress)
    {
        StaticClass.ipAdrress = ipAdrress;
    }    
    
    public static int getPrevNode()
    {
        return PrevNode;
    }

    public static void setPrevNode(int PrevNode)
    {
        StaticClass.PrevNode = PrevNode;
    }
    
    public static String getMyName() 
    {
        return myName;
    }

    public static void setMyName(String myName)
    {
        StaticClass.myName = myName;
    }

    
    public static Vector getV() 
    {
        return v;
    }

    public static void setV(Vector v) 
    {
        StaticClass.v = v;
    }

    
    public static int getObjectCount()
    {
        return ObjectCount;
    }

    public static void setObjectCount(int ObjectCount) 
    {
        StaticClass.ObjectCount = ObjectCount;
    }

    
    public static Object[] getO() 
    {
        return o;
    }

    public static void setO(Object[] o)
    {
        StaticClass.o = o;
    }
    

}
