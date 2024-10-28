package com.shuqingge.tools.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class 粉碎文件夹下所有文件 {
    public static void main(String[] args) {
        String folderPath = "H:\\SteamLibrary\\steamapps\\downloading"; // 指定文件夹路径
        File folder = new File(folderPath);
        deleteFolderContents(folder);
    }

    // 递归删除文件夹内容
    public static void deleteFolderContents(File folder) {
        System.out.println("删除-------");
        File[] files = folder.listFiles();
        if (files != null) { // 确保目录不为空
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolderContents(file);
                } else {
                    shredFile(file);
                    file.delete();
                }
            }
        }
    }

    // 文件粉碎方法，尝试覆写文件数据
    public static void shredFile(File file) {
        System.out.println("继续删除-----------------");
        SecureRandom random = new SecureRandom();
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] data = new byte[1024];
            long length = file.length();
            int toWrite = length > 1024 ? 1024 : (int) length;

            // 重复写入随机数据来覆盖文件
            while (length > 0) {
                random.nextBytes(data);
                fos.write(data, 0, toWrite);
                length -= toWrite;
                toWrite = length > 1024 ? 1024 : (int) length;
            }
        } catch (IOException e) {
            System.out.println("Error while shredding file: " + file.getName());
            e.printStackTrace();
        }
    }
}
