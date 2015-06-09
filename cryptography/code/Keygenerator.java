/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author spiro13
 */
public class Keygenerator {
    final static String ECDSA="RSA";
    static public PrivateKey priv[]=new PrivateKey[NewCanvas.MAXSPOTS+1];
    static public PublicKey pub[]=new PublicKey[NewCanvas.MAXSPOTS+1];
    KeyPairGenerator keyGen;
    SecureRandom random;
    KeyPair pair;
	byte b1[]=new byte[50];
	byte b2[]=new byte[50];
    long pr;
    public  KeyPair generateKey(String nod) {
        try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:EC");
            Statement st=con.createStatement();
            // TODO code application logic here
			System.out.println("----- Basic generateKey Function----");
            for(int i=1;i<=NewCanvas.MAXSPOTS;i++)
            {
					keyGen = KeyPairGenerator.getInstance(ECDSA);
					random = SecureRandom.getInstance("SHA1PRNG", "SUN");
					keyGen.initialize(1024, random);
					KeyPair pair = keyGen.generateKeyPair();
					priv[i] = pair.getPrivate();
					pub[i] = pair.getPublic();
					System.out.println("::::: Node"+i+":::::");
					System.out.println("----- Private Key----  "+priv[i]);
					System.out.println("----- Public Key----  "+pub[i]);
					b1=priv[i].getEncoded();
					b2=priv[i].getEncoded();
					
					int k=st.executeUpdate("insert into keys values('"+nod+"','"+b1+"','"+b2+"')");
					System.out.println("---val of i---"+k);
            }
            con.close();
        }
        catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pair;
    }

}