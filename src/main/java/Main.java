import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Main {

    public static void main(String[] args) {
        Properties properties = loadProperties("Main.properties");
        int[] dimensions = chooseScreenSize(properties);
        if (dimensions == null) {
            System.exit(1);
        }
        createGameWindow(dimensions[0], dimensions[1]);
    }

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input != null) {
                properties.load(input);
            } else {
                System.out.println(fileName + " not found.");
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return properties;
    }

    public static int[] chooseScreenSize(Properties properties) {
        int windowWidth = Integer.parseInt(properties.getProperty("windowWidth"));
        int windowHeight = Integer.parseInt(properties.getProperty("windowHeight"));
        int mwindowWidth = Integer.parseInt(properties.getProperty("mwindowWidth"));
        int mwindowHeight = Integer.parseInt(properties.getProperty("mwindowHeight"));
        int percent = Integer.parseInt(properties.getProperty("percent"));

        String[] options = { "Small", "Medium", "Custom" };
        int choice = JOptionPane.showOptionDialog(null, "Select screen size, small by default", "Snake Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                return new int[] { windowWidth, windowHeight };
            case 1:
                return new int[] { mwindowWidth, mwindowHeight };
            case 2:
                return chooseCustomSize(percent, mwindowWidth, mwindowHeight);
            default:
                return new int[0];
        }
    }

    public static int[] chooseCustomSize(int percent, int mwindowWidth, int mwindowHeight) {
        String widthInput = JOptionPane.showInputDialog("Enter the width of the game window (greater than 1200):");
        String heightInput = JOptionPane.showInputDialog("Enter the height of the game window (greater than 800):");

        if (widthInput == null || heightInput == null) {
            JOptionPane.showMessageDialog(null, "You haven't entered any values. Please enter values.");
            return new int[0];
        }

        int w = Integer.parseInt(widthInput) % percent;
        int h = Integer.parseInt(heightInput) % percent;

        int windowWidth = Integer.parseInt(widthInput) + percent - w;
        int windowHeight = Integer.parseInt(heightInput) + percent - h;

        if (windowWidth <= mwindowWidth || windowHeight <= mwindowHeight) {
            JOptionPane.showMessageDialog(null, "Custom size must be greater than 1200x800.");
            return new int[0];
        }
        return new int[] { windowWidth, windowHeight };
    }

    public static void createGameWindow(int windowWidth, int windowHeight) {
        JFrame frame = new JFrame("Snake Game");
        frame.setBounds(10, 10, windowWidth, windowHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel(windowWidth, windowHeight);
        panel.setBackground(Color.DARK_GRAY);
        frame.add(panel);
        frame.setVisible(true);
    }
}
