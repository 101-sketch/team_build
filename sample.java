import java.awt.GridLayout;
import javax.swing.JFrame;

public class sample {
    public static void main(String[] args) {

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new GridLayout(2, 1));
        mainFrame.setVisible(true);

        
    }

}