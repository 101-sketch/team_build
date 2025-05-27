import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class sample {
    public static void main(String[] args) {

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 500);
        mainFrame.setLocationRelativeTo(null);

        // メインパネル（中央寄せ）
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel resultLabel = new JLabel("ボタンを押しておみくじを引こう！", SwingConstants.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(28.0f));

        JLabel resultLabel1 = new JLabel("", SwingConstants.CENTER);
        JLabel resultLabel2 = new JLabel("", SwingConstants.CENTER);
        JLabel resultLabel3 = new JLabel("", SwingConstants.CENTER);
        resultLabel1.setFont(resultLabel1.getFont().deriveFont(22.0f));
        resultLabel2.setFont(resultLabel2.getFont().deriveFont(20.0f));
        resultLabel3.setFont(resultLabel3.getFont().deriveFont(20.0f));

        JButton drawButton = new JButton("おみくじを引く");
        drawButton.setFont(drawButton.getFont().deriveFont(26.0f));

        gbc.gridy = 0;
        mainPanel.add(resultLabel, gbc);
        gbc.gridy = 1;
        mainPanel.add(resultLabel1, gbc);
        gbc.gridy = 2;
        mainPanel.add(resultLabel2, gbc);
        gbc.gridy = 3;
        mainPanel.add(resultLabel3, gbc);
        gbc.gridy = 4;
        mainPanel.add(drawButton, gbc);

        mainFrame.setContentPane(mainPanel);

        String[] fortunes = {
                "おひつじ座", "おうし座", "ふたご座", "かに座",
                "しし座", "おとめ座", "てんびん座", "さそり座",
                "いて座", "やぎ座", "みずがめ座", "うお座"
        };

        String[] results = {
                "今日は最高の一日になるでしょう！",
                "チャンスが訪れる日です。",
                "人間関係が良好です。",
                "新しい挑戦が吉。",
                "控えめな行動が成功を呼びます。",
                "予想外のラッキーがあるかも！",
                "慎重な判断が運を呼びます。",
                "健康に気を配ると良い日です。",
                "リラックスを大切に。",
                "感謝の気持ちを忘れずに。"
        };
        String[] luckyItems = {
                "ペン", "スマホ", "手帳", "鍵", "財布", "イヤリング", "時計", "マグカップ", "ハンカチ", "本"
        };

        String[] luckyColors = {
                "赤", "青", "黄色", "緑", "紫", "ピンク", "オレンジ", "白", "黒", "水色"
        };

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawButton.setEnabled(false);
                resultLabel.setText("おみくじを引いています...");
                resultLabel1.setText("");
                resultLabel2.setText("");
                resultLabel3.setText("");
                Timer timer = new Timer(1200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Random rand = new Random();
                        int idx = rand.nextInt(fortunes.length);
                        int idx1 = rand.nextInt(results.length);
                        int idx2 = rand.nextInt(luckyItems.length);
                        int idx3 = rand.nextInt(luckyColors.length);
                        resultLabel.setText("<html><center>◆◇◆ 結果発表 ◆◇◆<br>" + fortunes[idx] + "</center></html>");
                        resultLabel1.setText("今日の運勢: " + results[idx1]);
                        resultLabel2.setText("ラッキーアイテム: " + luckyItems[idx2]);
                        resultLabel3.setText("ラッキー色: " + luckyColors[idx3]);
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