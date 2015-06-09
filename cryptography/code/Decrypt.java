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

class Decrypt{
byte[] ciphertext;
byte[] plaintxt;
public  void decryption (String ciphertxt,PrivateKey pr,PublicKey pb) throws NoSuchAlgorithmException,
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

System.out.println("-----Decryption fUNCTION------");

System.out.println(pr);
System.out.println(pb);
/* Create the cipher transform is alg/mode/padding*/
Cipher eCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

// Initialize the cipher for encryption
if(pr==null)
	eCipher.init(Cipher.DECRYPT_MODE, pb);
else
	eCipher.init(Cipher.DECRYPT_MODE, pr);
System.out.println("the original cleartext is:"+ ciphertxt);
//ciphertext = rsaCipher.doFinal(ciphertxt);

// Encrypt the cleartext
// ciphertext = null;



// Initialize the same cipher for decryption



// Decrypt the ciphertext
byte n2[]=new byte[1000];
byte[] ciphertext = ciphertxt.getBytes();
for(int i=0;i<ciphertext.length;i++)
            n2[i]=ciphertext[i];
 System.out.println("--N2--"+new String(n2));
byte[] cleartext1 = eCipher.doFinal(ciphertext);
System.out.println("the final cleartext is: " + new String(cleartext1));

}
}
