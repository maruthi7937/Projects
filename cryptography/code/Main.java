/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author spiro13
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static String nod,xCord,yCord,passwd,srcNode;
    public static void main(String[] args) {
        // TODO code application logic here
        new DBClass().createTable("Neigh","Nname","public_key","private_key");
        new Node_Registration();
    }

}
