package Grafik.Editor;

class Circle extends Figure {
    private int radius;

    Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    int getRadius() {
        return radius;
    }
}
