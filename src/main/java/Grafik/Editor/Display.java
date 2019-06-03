package Grafik.Editor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verfuegung, in welchem
 * Figure-Objekte dargestellt werden koennen.
 * Siehe auch Java-Grundkurs Abschnitt 10.2 und 10.3.
 *
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {
    /**
     * Die Liste der dargestellten Figure-Objekte
     */
    private List<Figure> figures = new ArrayList<Figure>();

    /**
     * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und erzeugt ein
     * JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
     */
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

    /**
     * Zeichnet alle Figuren.
     *
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */
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

    /**
     * Fuegt eine weitere Figure hinzu und loest die Auffrischung des Fensterinhaltes aus.
     *
     * @param figure Referenz auf das weitere Figure-Objekt.
     */
    void addFigure(Figure figure) {
        figures.add(figure);
        repaint();
    }

    /**
     * Loescht alle Figuren und loest die Auffrischung des Fensterinhaltes aus.
     */
    public void deleteAll() {
        figures.clear();
        repaint();
    }
}
