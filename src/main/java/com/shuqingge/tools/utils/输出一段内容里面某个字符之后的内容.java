package com.shuqingge.tools.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 输出一段内容里面某个字符之后的内容 extends JFrame {
        private JTextArea inputTextArea;
        private JTextArea outputTextArea;
        private JButton processButton;

        public 输出一段内容里面某个字符之后的内容() {
            super("Apex String Processor");
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 将JFrame置于屏幕中央
            setLocationRelativeTo(null);
            initializeUI();
            setVisible(true);
        }

        private void initializeUI() {
            // Layout
            setLayout(new BorderLayout());

            // Input area
            inputTextArea = new JTextArea(10, 40);
            inputTextArea.setBorder(BorderFactory.createTitledBorder("Input Strings"));
            add(new JScrollPane(inputTextArea), BorderLayout.NORTH);

            // Output area
            outputTextArea = new JTextArea(10, 40);
            outputTextArea.setBorder(BorderFactory.createTitledBorder("Output Strings"));
            outputTextArea.setEditable(false);
            add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

            // Process button
            processButton = new JButton("Process");
            processButton.setSize(500, 100);
            processButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    processInput();
                }
            });
            add(processButton, BorderLayout.SOUTH);
        }

        private void processInput() {
            String[] lines = inputTextArea.getText().split("\n");
//            StringBuilder outputBuilder = new StringBuilder();
            StringBuilder output = new StringBuilder();
            for (String line : lines) {
                // 使用正则表达式查找模式
                Pattern pattern = Pattern.compile("==/(.+?\\-)");
                Matcher matcher = pattern.matcher(line);

                // 如果找到匹配，将结果添加到输出StringBuilder
                if (matcher.find()) {
                    output.append(matcher.group(1)).append("\n");
                }
            }
            outputTextArea.setText(output.toString());
        }

        public static void main(String[] args) {
            new 输出一段内容里面某个字符之后的内容();
        }
    }
