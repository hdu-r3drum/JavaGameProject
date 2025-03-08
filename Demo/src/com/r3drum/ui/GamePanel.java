package com.r3drum.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements KeyListener{
    private int X = 50;
    private int Y = 50;
    private final int SQUARE_SIZE = 30;
    private final int MOVE_DISTANCE = 10;
    private Image characterImage;

    public GamePanel() {
        // 设置面板的首选大小
        this.setPreferredSize(new Dimension(400, 400));
        // 设置面板为可聚焦，以便接收键盘事件
        this.setFocusable(true);
        // 添加键盘监听器
        this.addKeyListener(this);
        try {
            characterImage = ImageIO.read(new File("lib\\Image\\Character\\pixil-frame-0.png"));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (characterImage == null) return;
        int imageWidth = characterImage.getWidth(this);
        int imageHeight = characterImage.getHeight(this);
        // 根据按下的键更新方块的位置
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                Y = Math.max(Y - MOVE_DISTANCE, 0);
                break;
            case KeyEvent.VK_DOWN:
                Y = Math.min(Y + MOVE_DISTANCE, getHeight() - imageHeight);
                break;
            case KeyEvent.VK_LEFT:
                X = Math.max(X - MOVE_DISTANCE, 0);
                break;
            case KeyEvent.VK_RIGHT:
                X = Math.min(X + MOVE_DISTANCE, getWidth() - imageWidth);
                break;
        }
        // 重新绘制面板
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 不需要处理
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 不需要处理
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 清除之前的绘制
        g.clearRect(0, 0, getWidth(), getHeight());
        // 绘制方块
        // g.setColor(Color.RED);
        // g.fillRect(squareX, squareY, SQUARE_SIZE, SQUARE_SIZE);
        if (characterImage != null) {
            g.drawImage(characterImage, X, Y, this);
        }
    }
}