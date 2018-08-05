public class Layer extends Node {
    private int z;

    public Layer() {
        this.z = 0;
    }

    public Layer(int _z) {
        if(_z>0)
            this.z = z;
        else
            this.z=0;
    }

    public void setZ(int _z) {
        if(_z>0)
            this.z = _z;
        else
            this.z=0;
    }

    public int getZ() {
        return this.z;
    }
}
