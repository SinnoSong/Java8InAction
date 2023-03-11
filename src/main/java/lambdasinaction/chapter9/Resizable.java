package lambdasinaction.chapter9;

public interface Resizable extends Drawable {
    public int getWidth();

    public int getHeight();

    public void setWidth(int width);

    public void setHeight(int height);

    public void setAbsoluteSize(int width, int height);
}
