package net.avh4.rpg.maptoolkit.data;

public class DenseMapData<T> extends MapDataBase<T> {
    private final Object[][] data;

    public DenseMapData(int maxX, int maxY) {
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

    @Override
    public int getWidth() {
        return data.length;
    }

    @Override
    public int getHeight() {
        return data[0].length;
    }
}
