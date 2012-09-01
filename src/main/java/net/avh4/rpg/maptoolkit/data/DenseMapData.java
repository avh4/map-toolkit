package net.avh4.rpg.maptoolkit.data;

public class DenseMapData<T> extends MapDataBase<T> {
    private final Object[][] data;

    public DenseMapData(String name, int maxX, int maxY) {
        super(name, maxX, maxY);
        data = new Object[maxX][maxY];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getData(int x, int y) {
        return (T) data[x][y];
    }

    @Override
    public void setData(int x, int y, T value) {
        data[x][y] = value;
    }
}
