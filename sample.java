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

        // メインパネル（縦並び）
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        JLabel resultLabel = new JLabel("ボタンを押しておみくじを引こう！", SwingConstants.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(28.0f));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel resultLabel1 = new JLabel("", SwingConstants.CENTER);
        JLabel resultLabel2 = new JLabel("", SwingConstants.CENTER);
        JLabel resultLabel3 = new JLabel("", SwingConstants.CENTER);
        resultLabel1.setFont(resultLabel1.getFont().deriveFont(22.0f));
        resultLabel2.setFont(resultLabel2.getFont().deriveFont(20.0f));
        resultLabel3.setFont(resultLabel3.getFont().deriveFont(20.0f));
        resultLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton drawButton = new JButton("おみくじを引く");
        drawButton.setFont(drawButton.getFont().deriveFont(26.0f));
        drawButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 余白を追加
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(resultLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(resultLabel1);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(resultLabel2);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(resultLabel3);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(drawButton);

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