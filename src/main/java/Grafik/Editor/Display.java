package Grafik.Editor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JFrame implements MouseListener {
    private List<Figure> figures = new ArrayList<Figure>();

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    Display() {
        Dimension windowSize = new Dimension(800, 600);
        setSize(windowSize);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowPositionX = (screenSize.width - windowSize.width) / 2;
        int windowPositionY = (screenSize.height - windowSize.height) / 2;
        Point windowPosition = new Point(windowPositionX, windowPositionY);
        setLocation(windowPosition);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createAndAddDrawingPanel();
        setVisible(true);
        addMouseListener(this);
        setFocusable(true);
    }

    private void createAndAddDrawingPanel() {
        add(new JPanel() {
            // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
            // Methode beim Dsiplay aufruft.
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawFigures(g);
            }
        });
    }

    private void drawFigures(Graphics g) {
        for (Figure f : figures) {
            if (f instanceof Rectangle) {
                Rectangle r = (Rectangle) f;
                g.drawRect(r.x, r.y, r.getWidth(), r.getHeight());
            } else if (f instanceof Line) {
                Line l = (Line) f;
                g.drawLine(l.x, l.y, l.getX2(), l.getY2());
            } else if (f instanceof Circle) {
                Circle c = (Circle) f;
                g.drawOval(c.x, c.y, c.getRadius() * 2, c.getRadius() * 2);
            }
        }
    }

    void addFigure(Figure figure) {
        figures.add(figure);
        repaint();
    }

    public void deleteAll() {
        figures.clear();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.startX = e.getX();
        this.startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.endX = e.getX();
        this.endY = e.getY();
        Rectangle rectangle = new Rectangle(this.startX, this.startY, this.endX - this.startX, this.endY - this.startY);
        addFigure(rectangle);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
