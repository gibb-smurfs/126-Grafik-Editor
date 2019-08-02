package Grafik.Editor;

class Rectangle extends Figure {
    private int width;
    private int height;

    Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}
