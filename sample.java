import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class sample {
    public static void main(String[] args) {

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new GridLayout(2, 1));

        JLabel resultLabel = new JLabel("ボタンを押しておみくじを引こう！", SwingConstants.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(24.0f));
        mainFrame.add(resultLabel);

        JButton drawButton = new JButton("おみくじを引く");
        drawButton.setFont(drawButton.getFont().deriveFont(24.0f));
        mainFrame.add(drawButton);

        String[] fortunes = {
                "中吉: ",
                "小吉: ",
                "吉: ",
                "末吉: ",
                "凶: "
        };

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawButton.setEnabled(false);
                resultLabel.setText("おみくじを引いています...");
                Timer timer = new Timer(1200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Random rand = new Random();
                        int idx = rand.nextInt(fortunes.length);
                        resultLabel.setText("<html><center>◆◇◆ 結果発表 ◆◇◆<br>" + fortunes[idx] + "</center></html>");
                        drawButton.setEnabled(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        mainFrame.setVisible(true);
    }
}