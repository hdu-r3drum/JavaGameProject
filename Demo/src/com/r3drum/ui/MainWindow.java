package com.r3drum.ui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame{
    public MainWindow() {
        init();

        initJMenuBar();
        
        this.setVisible(true);
    }
    private void init(){
        this.setTitle("Game");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        this.setResizable(false);
        // this.pack();
        // this.setLocationRelativeTo(null);
        gamePanel.requestFocusInWindow();
        // this.add(new GamePanel());
    }

    private void initJMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("Fuction");
        JMenu helpJMenu = new JMenu("Help");
        JMenu aboutJMenu = new JMenu("About");

        JMenuItem restartJMenuItem = new JMenuItem("Restart");
        JMenuItem reloginJMenuItem = new JMenuItem("Relogin");
        JMenuItem exitJMenuItem = new JMenuItem("Exit");

        JMenuItem helpJMenuItem = new JMenuItem("How to play");

        JMenuItem aboutJMenuItem = new JMenuItem("Contect us");

        functionJMenu.add(restartJMenuItem);
        functionJMenu.add(reloginJMenuItem);
        functionJMenu.add(exitJMenuItem);

        helpJMenu.add(helpJMenuItem);

        aboutJMenu.add(aboutJMenuItem);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(helpJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }
}
