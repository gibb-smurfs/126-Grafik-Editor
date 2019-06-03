package Grafik.Editor;


public class App {
    static Display addWindow(){
        return new Display();
    }

    static void drawFigures(Display mainWindow) {
        Figure rectangle = new Rectangle(10, 10, 50, 50);
        Figure circle = new Circle(100, 100, 100);
        Figure line = new Line(100, 100, 200, 200);
        mainWindow.addFigure(rectangle);
        mainWindow.addFigure(circle);
        mainWindow.addFigure(line);
    }

    public static void main(String[] args) {
        Display mainWindow = addWindow();
        drawFigures(mainWindow);
    }
}
