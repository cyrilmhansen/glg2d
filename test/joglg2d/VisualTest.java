package joglg2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import joglg2d.util.Painter;
import joglg2d.util.TestWindow;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author borkholder
 * @created Feb 6, 2010
 */
public class VisualTest {
  static TestWindow tester;

  @BeforeClass
  public static void initialize() {
    tester = new TestWindow();
  }

  @AfterClass
  public static void close() {
    tester.close();
  }

  @Test
  public void lineTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.drawLine(10, 10, 50, 50);
      }
    });

    tester.assertSame();
  }

  @Test
  public void fillRectTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 123, 99, 7);
      }
    });

    tester.assertSame();
  }

  @Test
  public void lineWidthTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(8, 99, 143, 400);
      }
    });

    tester.assertSame();
  }

  @Test
  public void drawRectTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.drawRect(50, 90, 70, 32);
      }
    });

    tester.assertSame();
  }

  @Test
  public void rectangleShapeTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.draw(new Rectangle2D.Float(48, 123, 49, 34));
      }
    });

    tester.assertSame();
  }

  @Test
  public void strokedShapeTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2d.draw(new Rectangle2D.Float(48, 123, 49, 34));
      }
    });

    tester.assertSame();
  }

  @Test
  public void roundRectShapeTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new RoundRectangle2D.Float(99, 40, 230, 493, 90, 70));
      }
    });

    tester.assertSame();
  }

  @Test
  public void drawPolylineTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
        g2d.drawPolyline(new int[] {8, 43, 94, 16}, new int[] {43, 99, 34, 75}, 4);
      }
    });

    tester.assertSame();
  }

  @Test
  public void drawPolygonTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.drawPolygon(new int[] {8, 23, 98, 42}, new int[] {47, 23, 43, 25}, 4);
      }
    });

    tester.assertSame();
  }

  @Test
  public void fillPolygonTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.setColor(Color.CYAN);
        g2d.fillPolygon(new int[] {8, 23, 98, 42}, new int[] {47, 23, 43, 25}, 4);
      }
    });

    tester.assertSame();
  }

  @Test
  public void drawStringTest() throws Exception {
    tester.setPainter(new Painter() {
      @Override
      public void paint(Graphics2D g2d) {
        g2d.drawString("Hello JOGL", 90, 32);
      }
    });

    tester.assertSame();
  }
}
