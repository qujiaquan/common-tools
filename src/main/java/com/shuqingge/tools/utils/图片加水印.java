package com.shuqingge.tools.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class 图片加水印 {


    public static void main(String[] args) throws IOException {

        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);


        // 原路径
        String oldFile = "G:\\无伤大雅\\副业汇总\\拼多多商品图片\\简历模板\\原图片";
        File dir = new File(oldFile);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            int fileCount = 1;
            for (File file : files) {
                String newFileName = "G:\\无伤大雅\\副业汇总\\拼多多商品图片\\简历模板\\水印\\" + fileCount++ + ".jpg";
                File newFile = new File(dir, newFileName);
                System.out.println(file);
                BufferedImage image = ImageIO.read(file);
                addTextWaterMark(image, Color.BLACK, 45, "@嘿科技", newFileName, 0.8f);//0.2f表示的是水印的透明度

            }
        } else {
            System.out.println(oldFile + " is not a directory.");
        }
//        File file = new File("G:\\无伤大雅\\副业汇总\\拼多多商品图片\\java源码\\选课管理系统\\1720264929645.jpg");
//        BufferedImage image = ImageIO.read(file);
//        addTextWaterMark(image, Color.BLACK, 45, "by 苏雨只会喵喵", "G:\\无伤大雅\\副业汇总\\拼多多商品图片\\java源码\\选课管理系统\\test\\1.jpg",0.2f);//0.2f表示的是水印的透明度
    }

    public static void addTextWaterMark(BufferedImage targetImg, Color textColor, int fontSize, String text, String outPath, float alpha) {
        try {
            //图片宽
            int width = targetImg.getWidth();
            //图片高
            int height = targetImg.getHeight();
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(targetImg, 0, 0, width, height, null);
            g.setColor(textColor); //水印颜色
            g.setFont(new Font("微软雅黑", Font.ITALIC, fontSize));
            // 水印内容放置在右下角
//            int x = width - (text.length() - 1) * fontSize;
//            int x = width - (int) ((text.length() - 2)) * fontSize - fontSize * 2;
//
//            int y = height - fontSize * 2;

            int x = width / 2 - (text.length() - 1) * fontSize;
            int y = height / 2 + fontSize;

            // 设置水印透明度
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g.setComposite(alphaComposite);

            g.drawString(text, x, y);


            FileOutputStream outImgStream = new FileOutputStream(outPath);
            // 这里的“jpg”，笔者更多的理解为是一个形式参数，最后生成的效果图的图片格式跟这个jpg没有太多的关系
            ImageIO.write(bufferedImage, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
            g.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
