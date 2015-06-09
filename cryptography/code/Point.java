
public class Point 
{
	protected int x, y;

	  public Point(int a, int b) { setPoint(a, b); }

	  public void setPoint(int a, int b)
	  {
	    x = a;
	    y = b;
	  }
	  public boolean Equal(Point p)
	  {
	    if ((x == p.x) && (y == p.y))
	      return true;

	    else
	      return false;
	  }
	  void show()
	  {
	      System.out.println("("+x+","+y+")");
	  }
}
