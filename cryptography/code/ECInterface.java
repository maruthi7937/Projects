

import java.rmi.*;
import java.security.PrivateKey;
import java.security.PublicKey;
public interface ECInterface extends Remote 
{
	String[] getNodePassword(String node,String clusterHead,String address,String portNo) throws RemoteException;
	
	String getClusterHeadPassword(String clusterHead,String Cluster,String address,String portNo) throws RemoteException;

	String[] getClusterHeads() throws RemoteException;

	String[] getNodeDetails() throws RemoteException;

	String[] getClusterHeadDetails(String category,String clusterHead,String pwd) throws RemoteException;

	String[] getOtherNodes(String sourceNode) throws RemoteException;
	
	String[] getClusterNodes(String sourceClusterHead) throws RemoteException;

	String getClusterHeadAddress(String sourceClusterHead) throws RemoteException;

	int getClusterHeadPortNo(String sourceClusterHead) throws RemoteException;

	void setClusterHead(String sourceClusterHead) throws RemoteException;

	String getClusterHead() throws RemoteException;

	String[] getClusterDetails(String clusterHead) throws RemoteException;

        String[] requestMST(String nod,String ID,String x,String y) throws RemoteException;

        String[] getNeighbour(String nod) throws RemoteException;

        PrivateKey getPrivate(String nod) throws RemoteException;

        PublicKey getPublic(String nod) throws RemoteException;

        int requestKey(String nod,String ID,String x,String y) throws RemoteException;

}
