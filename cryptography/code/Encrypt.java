/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author spiro13
 */
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.*;
import javax.crypto.*;

class Encrypt{
byte[] ciphertext;
public  void encryption (String node,String plain,PrivateKey pr,PublicKey pb) throws NoSuchAlgorithmException,
InvalidKeyException, IllegalBlockSizeException, NoSuchProviderException,
BadPaddingException, NoSuchPaddingException

{

/* Generate a RSA key pair */
//KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
//SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
//keyGen.initialize(1024, random);
//KeyPair pair = keyGen.generateKeyPair();
//PrivateKey priv = pair.getPrivate();
//PublicKey pub = pair.getPublic();
System.out.println("-----Encryption fUNCTION------");
System.out.println(pr);
System.out.println(pb);
/* Create the cipher */
Cipher eCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

// Initialize the cipher for encryption
if(pr==null)
eCipher.init(Cipher.ENCRYPT_MODE, pb);
else
 eCipher.init(Cipher.ENCRYPT_MODE, pr);

// Cleartext
//String plaintext;
//plaintext= "This is Bilal";
//byte[] cleartext = plaintext.getBytes();
byte[] cleartext = plain.getBytes();
System.out.println("the original cleartext is:"+ plain);

// Encrypt the cleartext
ciphertext = null;
ciphertext = eCipher.doFinal(cleartext);
String ciphertxt=new String(ciphertext)+"###"+plain;
System.out.println("the encrypted text is: " + new String(ciphertext));
Node.jTextArea2.append( new String(ciphertext));
Node_Registration.cc.writeToServer(node,(ciphertxt));


// Initialize the same cipher for decryption
// Decrypt the ciphertext
//byte[] cleartext1 = rsaCipher.doFinal(ciphertext);
//System.out.println("the final cleartext is: " + new String(cleartext1));

}
}
