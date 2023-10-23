import javax.swing.ImageIcon;

public class ImageClass {
    public ImageIcon rightmouth;
    public ImageIcon leftmouth;
    public ImageIcon upmouth;
    public ImageIcon downmouth;
    public ImageIcon snakeimage;
    public ImageIcon enemy;

    public ImageClass() {
        rightmouth = new ImageIcon(ImageClass.class.getResource("rightmouth.png"));
        leftmouth = new ImageIcon(ImageClass.class.getResource("leftmouth.png"));
        upmouth = new ImageIcon(ImageClass.class.getResource("upmouth.png"));
        downmouth = new ImageIcon(ImageClass.class.getResource("downmouth.png"));
        snakeimage = new ImageIcon(ImageClass.class.getResource("snakeimage.png"));
        enemy = new ImageIcon(ImageClass.class.getResource("enemy.png"));
    }
}