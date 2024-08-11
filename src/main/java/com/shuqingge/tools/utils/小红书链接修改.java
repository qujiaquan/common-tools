package com.shuqingge.tools.utils;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 小红书链接修改 extends JFrame {
        private JTextArea inputArea;
        private JTextArea outputArea;
        private JButton convertButton;
        private JButton convertButton1;

        public 小红书链接修改() {
            // 创建窗口
            setTitle("小红书链接修改");
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 将JFrame置于屏幕中央
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            // 输入区域
            inputArea = new JTextArea();
            inputArea.setBorder(BorderFactory.createTitledBorder("输入链接"));
            add(new JScrollPane(inputArea), BorderLayout.NORTH);

            // 输出区域
            outputArea = new JTextArea();
            outputArea.setBorder(BorderFactory.createTitledBorder("输出结果"));
            outputArea.setEditable(false);
            add(new JScrollPane(outputArea), BorderLayout.CENTER);

            // 按钮
            convertButton = new JButton("修改");
            convertButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formatAndDisplay();
                }
            });
            add(convertButton, BorderLayout.EAST);
            // 按钮
            convertButton1 = new JButton("清空数据");
            convertButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    inputArea.setText("");
                    outputArea.setText("");
                }
            });
            add(convertButton1, BorderLayout.SOUTH);

            // 显示窗口
            setVisible(true);
        }

        private void formatAndDisplay() {
            String inputText = inputArea.getText();

            Pattern pattern = Pattern.compile("https?://[^\\s]+");
            Matcher matcher = pattern.matcher(inputText);
            String res = "";
            if (matcher.find()) {
                res = matcher.group();
            } else {
                System.out.println("没有找到链接。");
            }

            /*String replacement = "V2.3最新版植物大战僵尸杂交版安装包" + res.substring(res.length()-44, res.length()-9) + " \n" +
                    "(所有版本都在压缩包里面，找到对应版本下载)复制不了的截屏提取文字。或者关注我找我直接要。 \n" +
                    "(注:下载后浏览器不要删除，后续新版本都会及时在uc更新) 注:uC里面的教程很重要！";*/

            String replacement = "V1.1最新版简历资料领取" + res.substring(res.length()-44, res.length()-9) + " \n" +
                    "(所有都在压缩包里面)复制不了的截屏提取文字。或者关注我找我直接要。 \n" +
                    "(注:下载后浏览器不要删除，后续新更新都会及时在uc更新) 注:uC里面的教程很重要！";
            outputArea.setText(replacement);
        }

        public static void main(String[] args) {
            new com.shuqingge.tools.utils.小红书链接修改(); // 创建并显示GUI
        }
    }
