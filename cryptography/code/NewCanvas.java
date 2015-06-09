import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;


public class NewCanvas extends Canvas
{
	public static int MAXSPOTS;
	 String neighbr[][];
	 String sNode;
	 String eNode;
	 int cnt[];
	 int m=2;
	  final int MAXLINES = 6*5/2;
	  Point starts[] = new Point[MAXLINES];
	  Point ends[] = new Point[MAXLINES];
	  Point anchor; // start of current line
	  Point currentpoint; // end of current line
	  Point mystarts[] = new Point[MAXLINES];
	  Point myends[] = new Point[MAXLINES];
	  Point MSTstarts[] = new Point[60];
	  Point MSTends[] = new Point[60];
	  int currline = 0;; // number of lines
	  static int option, spots;
	  int xspots[] = new int[50];
	  int yspots[] = new int[50];
	  static boolean picFlag[]=new boolean[20];
	  double edges[] = new double[50];
	  double MST[] = new double[50];
	  int distance = 0;
	  int yourdis = 0;
	  double d2[] = new double[60];
	  int currspots = 0;
	  boolean visited [] = new boolean[60];
	  int current[] = new int[60];
	  double D[][] =new double[20][20];
	  static String node[]=new String[50];
	  Image img;

	   NewCanvas()
	   {
	        MAXSPOTS=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter no of  nodes in a cluster"));
	        for (int i = 0; i < MAXSPOTS; i++) {
	            xspots[i] = (int)(Math.random() * 300);
	            yspots[i] = (int)(Math.random() * 300);
	            node[i]="node"+(i+1);
	          }
	         new DBClass().createTable("node","name","id","x","y","flag","address","port","status");
	         for (int i = 0; i < MAXSPOTS; i++)
	          {
	                String s1=((Object)xspots[i]).toString();
	                String s2=((Object)yspots[i]).toString();
	                new DBClass().insertRow("node",node[i],"",s1,s2,"0","","","");
	           }
	         //initNeighbr();////// to initialize 2 dimensional array
	         mygraph();
	         Toolkit tool = Toolkit.getDefaultToolkit();
			 img = tool.getImage("C:/Documents and Settings/Administrator/Desktop/computer-orange-icon-small.png");
	   }

	   public boolean mouseDown(Event e, int x, int y)  {
	     Point d = new Point(x, y);

	      if (error_checking(d))
	      {
	          JOptionPane.showMessageDialog(null, "Register");;
	          Picture.jPanel1.setVisible(true);
	         //anchor = new Point(rd.x, rd.y);
	      }
	      else {
	             anchor = null;
	              JOptionPane.showMessageDialog(null, "Only cluster header can be registered here");
		    // System.out.println("Please click on the existed points");
		   }

	      return true;
	    }


	  void addline(int x,int y) {
	 	  starts[currline]=anchor;
	 	  ends[currline]=new Point(x,y);
	 	  currline++;
	 	  repaint();
	     }

	   public boolean error_checking(Point p) {
	       int rx, ry;
	       Point R;
	       System.out.println(p.x+","+p.y);
	       System.out.println(MSTstarts[0].x+","+MSTstarts[0].y);
	          rx = Math.abs(p.x - MSTstarts[0].x);
	          ry = Math.abs(p.y - MSTstarts[0].y);

	          if ( (rx < 30) && (ry < 30) )
		       	     return true;
	          return false;

	       }

	    public String find(Point p) {
	        int rx, ry;
	       Point R;

	       for (int i = 0; i < MAXSPOTS; i++) {
	          rx = Math.abs(p.x - xspots[i]);
	          ry = Math.abs(p.y - yspots[i]);
	          if ( (rx < 30) && (ry < 30) )
	  	     return ("node"+(i+1));
	       }
	       return null;
	       }


	   public void paint(Graphics g) {


	           //generate random points
	      
	      
	          neighbr=new String[MAXSPOTS+1][10];
	          cnt=new int[MAXSPOTS+1];
			  //if(option==2)
			{
				System.out.println("-------Option2 called --------");
	          for (int i = 0; i < MAXSPOTS; i++)
	          {
	            g.setColor(Color.DARK_GRAY);
	             g.drawString(node[i], xspots[i]-10, yspots[i]-25);
	           System.out.println("Pic Flag :"+picFlag[i]);
	           if(!picFlag[i])
				  {
				      g.setColor(Color.LIGHT_GRAY);
	                g.fillOval(xspots[i], yspots[i], 10, 10);
				  }
	            else
	            {
	                 //g.drawImage(img, xspots[0], yspots[0],30,30, this);
	                
	                 g.drawImage(img, xspots[i], yspots[i],30,30, this);
	            }
				 g.setColor(Color.GREEN);
	              g.drawString("Cluster header", MSTstarts[0].x+10, MSTstarts[0].y+10);
	           }
	      currspots = 0;
		  currline = 0;
		  yourdis = 0;
		  distance = 0;   
		   }


	       if(option==5)
	       {
	            System.out.println("-------Option2 called --------");
	            g.setColor(Color.GRAY);     //draw the route computer chose
	           new DBClass().createTable("neighbour","node","neigh");
	           for (int i = 0; i <(MAXSPOTS-1); i++)
	           {
	               String s1=((Object)MSTstarts[i].x).toString();
	               String s2=((Object)MSTstarts[i].y).toString();
	               g.drawString(s1+","+s2, MSTstarts[i].x, MSTstarts[i].y);
	               String s3=((Object)MSTends[i].y).toString();
	               String s4=((Object)MSTends[i].y).toString();				    
	               g.drawString(s3+","+s4, MSTends[i].x, MSTends[i].y);
				   g.drawImage(img, xspots[i], yspots[i],30,30, this);
				   //g.setColor(Color.LIGHT_GRAY);
	               g.drawLine(MSTstarts[i].x, MSTstarts[i].y, MSTends[i].x, MSTends[i].y);
	               sNode=find(new Point(MSTstarts[i].x, MSTstarts[i].y));
	               eNode=find(new Point(MSTends[i].x, MSTends[i].y));               
	               //// Ist dimensional starts from 1 and 2nd from 0
	               new DBClass().insertRow("neighbour",sNode,eNode);
	               new DBClass().insertRow("neighbour",eNode,sNode);
	                
	           }
	           // updateNeighbrTable();
	            //g.drawOval(MSTstarts[0].x, MSTstarts[0].y, 10, 10);
	           
	       }
	               

	    }

	   void initNeighbr()
	   {
	       for(int i=1;i<10;i++)
	       {
	           neighbr[i][0]="neighbour";
	           neighbr[i][1]="node"+i;
	       }
	        for(int i=1;i<10;i++)
	        {
	            cnt[i]=2;
	        }
	   }
	//   boolean exists(int x,int y)
	//   {
//	       boolean f=false;
//	       for(int i=0;i<10;i++)
//	           if(neighbr[x][y].equalsIgnoreCase("node"+y))
//	               f=true;
//	       return f;
	//   }
	   void insert(int s,int e)
	   {
	       m=cnt[s];
	       neighbr[s][++m]=new String("node"+e);
	       cnt[s]++;
	   }
	   int getMax()
	   {
	       int max=cnt[1];
	       for(int i=1;i<=MAXSPOTS;i++)
	             if(max>cnt[i])
	                    max=cnt[i];
	       return max;
	   }

	   void updateNeighbrTable()
	   {
	       int i=getMax();
	       String val[]=new String[10];
	       val[0]=new String("neighbour");
	       val[1]=new String("node");
	       for(int j=2;j<=i;j++)
	           val[j]=new String("neibr"+j);
	       //new DBClass().createTable(val);
	       for(i=0;i<MAXSPOTS;i++)     
	{
	}	   
	              //new DBClass().insertRow(neighbr[i]);

	   }
	   void mygraph()     {
	       double d,minimum;
	       int numberinst=0;
	       int k = 0, n = 0;
	       //distance = 0;
	      for(int i=0;i<MAXSPOTS;i++)
		for(int j=0;j<MAXSPOTS;j++)
		  D[i][j]=0;

	      current[0] = 0;
	      visited[0] = true;
	      numberinst = 1;

	      for (int i = 1; i<MAXSPOTS; i++)
	        visited[i] = false;

	      //Construct the  distance adjacency matrix


	      for (int i = 0; i < MAXSPOTS; i++)
		{
		  for (int j = 0; j < MAXSPOTS; j++)
		    {
		      if (j != i)
	 		{
			d = (double) (Math.pow( (xspots[i] - xspots[j]), 2) +
			      Math.pow( (yspots[i] - yspots[j]), 2) );
			D[i][j] = Math.sqrt(d);
		      }
		  }
	      }
	      int kk=0, selstart=16, selend=16, i;

	      double minimumm;
	      while (kk < MAXSPOTS-1)
	       {
		 minimumm= 9999.0;

		 for(int l=0;l<numberinst;l++)
		   {
		     i = current[l];
		     for(int j=0;j<MAXSPOTS;j++)
		       {
			 if (visited[j] != true)
			   {
			     if (minimumm > D[i][j])
			       {
				 minimumm = D[i][j];
				 selend = j;
				 selstart=i;
			       }
			   }
		       }
		   }
			 visited[selend] = true;
	         System.out.println("****");
	         MSTstarts[kk] = new Point(xspots[selstart], yspots[selstart]);
	         MSTstarts[kk].show();
	         MSTends[kk] = new Point(xspots[selend], yspots[selend]);
	         MSTends[kk].show();
		 distance += (int)D[selstart][selend];
		 current[numberinst++] = selend;
		 kk++;
	       }
	    }

	  public void setView(int choice,boolean[] f) {
	      option = choice;
	      picFlag=f;
	      repaint();
	   }
}
