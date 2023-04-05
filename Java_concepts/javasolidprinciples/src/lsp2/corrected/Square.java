package lsp2.corrected;

public class Square implements Shape{
    private int width;
    private int height;
    @Override
    public void setWidth(int w) {
        this.width = w;
        this.height = w;
    }

    @Override
    public void setHeight(int h) {
        this.height = h;
        this.width = h;
    }

    @Override
    public int area() {
        return this.width* this.height;
    }
}
