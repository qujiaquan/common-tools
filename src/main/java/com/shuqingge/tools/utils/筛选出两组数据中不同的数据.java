package com.shuqingge.tools.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;

    public class 筛选出两组数据中不同的数据 extends JFrame {
        private JTextArea inputList1;
        private JTextArea inputList2;
        private JButton compareButton;
        private JTextArea outputList1;
        private JTextArea outputList2;

        public 筛选出两组数据中不同的数据() {
            super("筛选两组数据中不同的数据");
            // 将JFrame置于屏幕中央
            setLocationRelativeTo(null);
            initializeUI();
        }

        private void initializeUI() {
            setLayout(new GridLayout(3, 2, 10, 10)); // 设置布局

            inputList1 = new JTextArea(5, 20);
            inputList2 = new JTextArea(5, 20);
            compareButton = new JButton("Compare");
            outputList1 = new JTextArea(5, 20);
            outputList2 = new JTextArea(5, 20);

            inputList1.setBorder(BorderFactory.createTitledBorder("Input List 1"));
            inputList2.setBorder(BorderFactory.createTitledBorder("Input List 2"));
            outputList1.setBorder(BorderFactory.createTitledBorder("Unique in List 1"));
            outputList2.setBorder(BorderFactory.createTitledBorder("Unique in List 2"));

            add(inputList1);
            add(inputList2);
            add(compareButton);
            add(new JLabel()); // 占位
            add(outputList1);
            add(outputList2);

            compareButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    compareArrays();
                }
            });

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 400);
            setLocationRelativeTo(null); // 在屏幕中间显示
        }

        private void compareArrays() {
            String[] list1 = inputList1.getText().split("\\n");
            String[] list2 = inputList2.getText().split("\\n");

            HashSet<String> set1 = new HashSet<>(Arrays.asList(list1));
            HashSet<String> set2 = new HashSet<>(Arrays.asList(list2));

            // 计算差集
            HashSet<String> uniqueList1 = new HashSet<>(set1);
            uniqueList1.removeAll(set2);
            HashSet<String> uniqueList2 = new HashSet<>(set2);
            uniqueList2.removeAll(set1);

            // 显示结果
            outputList1.setText(String.join("\n", uniqueList1));
            outputList2.setText(String.join("\n", uniqueList2));
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new 筛选出两组数据中不同的数据().setVisible(true);
                }
            });
        }
    }
