package Server.Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.Icon;

public class ArrowIcon implements Icon{

	 public static final int UP = 0;
	  public static final int DOWN = 1;
	  private int direction;

	  private Polygon pagePolygon = new Polygon(new int[] { 2, 4, 4, 10, 10, 2 },
	      new int[] { 4, 4, 2, 2, 12, 12 }, 6);

	  private int[] arrowX = { 4, 9, 6 };

	  private Polygon arrowUpPolygon = new Polygon(arrowX,
	      new int[] { 10, 10, 4 }, 3);

	  private Polygon arrowDownPolygon = new Polygon(arrowX,
	      new int[] { 6, 6, 11 }, 3);

	  public ArrowIcon(int which) {
	    direction = which;
	  }

	  public int getIconWidth() {
	    return 14;
	  }

	  public int getIconHeight() {
	    return 14;
	  }

	@Override
	public void paintIcon(Component c, Graphics arg1, int x, int y) {
		arg1.setColor(Color.black);
	    pagePolygon.translate(x, y);
	    arg1.drawPolygon(pagePolygon);
	    pagePolygon.translate(-x, -y);
	    if (direction == UP) {
	      arrowUpPolygon.translate(x, y);
	      arg1.fillPolygon(arrowUpPolygon);
	      arrowUpPolygon.translate(-x, -y);
	    } else {
	      arrowDownPolygon.translate(x, y);
	      arg1.fillPolygon(arrowDownPolygon);
	      arrowDownPolygon.translate(-x, -y);
	    }
	}

}
