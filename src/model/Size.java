public abstract class Size {
    private int width;
    private int height;

    public Size() {
        this.width = 0;
        this.height = 0;
    }

    public Size(int _width, int _height) {
        if(_width >0)
            this.width = _width;
        else
            this.width=0;
        if(_height>0)
            this.height = _height;
        else
            this.height=0;
    }

    public void setWidth(int _width) {
        if(_width>0)
            this.width = _width;
        else
            this.width=0;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int _height) {
        if(_height>0)
            this.height = _height;
        else
            this.height=0;
    }

    public int getHeight() {
        return this.height;
    }

}
