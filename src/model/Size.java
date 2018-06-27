public abstract class Size {
    private int width;
    private int height;

    public Size() {
        this.width = 0;
        this.height = 0;
    }

    public Size(int _width, int _height) {
        this.width = _width;
        this.height = _height;
    }

    public void setWidth(int _width) {
        this.width = _width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int _height) {
        this.height = _height;
    }

    public int getHeight() {
        return this.height;
    }

}
