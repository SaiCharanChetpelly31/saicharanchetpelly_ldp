package lsp2.corrected;

public class Rectangle implements Shape {
    private int width;
    private int height;
    @Override
    public void setWidth(int w) {
        this.width = w;
    }

    @Override
    public void setHeight(int h) {
        this.height=h;
    }

    @Override
    public int area() {
        return this.width*this.height;
    }
}
