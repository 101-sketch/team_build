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
        JLabel resultLabel1 = new JLabel("", SwingConstants.CENTER);
        JLabel resultLabel2 = new JLabel("", SwingConstants.CENTER);
        JLabel resultLabel3 = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(24.0f));
        mainFrame.add(resultLabel);
        mainFrame.add(resultLabel1);
        mainFrame.add(resultLabel2);
        mainFrame.add(resultLabel3);

        JButton drawButton = new JButton("おみくじを引く");
        drawButton.setFont(drawButton.getFont().deriveFont(24.0f));
        mainFrame.add(drawButton);

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
                Timer timer = new Timer(1200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Random rand = new Random();
                        int idx = rand.nextInt(fortunes.length);
                        int idx1 = rand.nextInt(results.length);
                        int idx2 = rand.nextInt(luckyItems.length);
                        int idx3 = rand.nextInt(luckyColors.length);
                        resultLabel.setText("<html><center>◆◇◆ 結果発表 ◆◇◆<br>" + fortunes[idx] + "</center><br></html>");
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