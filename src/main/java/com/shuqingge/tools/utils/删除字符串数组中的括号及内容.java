package com.shuqingge.tools.utils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 删除字符串数组中的括号及内容 extends JFrame {
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton convertButton;
    private JButton convertButton1;

    public 删除字符串数组中的括号及内容() {
        // 创建窗口
        setTitle("删除字符串数组中的括号");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 将JFrame置于屏幕中央
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 输入区域
        inputArea = new JTextArea();
        inputArea.setBorder(BorderFactory.createTitledBorder("输入字符串数组"));
        add(new JScrollPane(inputArea), BorderLayout.NORTH);

        // 输出区域
        outputArea = new JTextArea();
        outputArea.setBorder(BorderFactory.createTitledBorder("输出结果"));
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // 按钮
        convertButton = new JButton("删括号");
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
        String[] lines = inputArea.getText().split("\\n");
        StringBuilder formatted = new StringBuilder();
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                String output = line.replaceAll("\\(.*?\\)", "") + "\n";
                formatted.append(output);
            }
        }
        outputArea.setText(formatted.toString());
    }

    public static void main(String[] args) {
        new 删除字符串数组中的括号及内容(); // 创建并显示GUI
    }
}
