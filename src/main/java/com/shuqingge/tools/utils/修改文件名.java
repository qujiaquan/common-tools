package com.shuqingge.tools.utils;

import java.io.File;
import java.nio.file.Files;

// 修改文件名
public class 修改文件名 {
    public static void main(String[] args) {
        String directoryPath = "G:\\Desktop\\小红书let's go\\素材\\简历如何写"; // 修改为实际目录路径
        String name = "手把手教你改简历";
        File dir = new File(directoryPath);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            int fileCount = 1;

            for (File file : files) {
                // 检查文件名是否包含括号，这个是删除重复文件
                if (file.getName().contains("(1)") || file.getName().contains("(2)")) {
                    try {
                        // 删除包含括号的文件
                        Files.delete(file.toPath());
                        System.out.println("Deleted: " + file.getName());
                    } catch (Exception e) {
                        System.out.println("Failed to delete: " + file.getName());
                        e.printStackTrace();
                    }
                } else {
                    String newFileName = name + fileCount++ + getFileExtension(file);
                    File newFile = new File(dir, newFileName);

                    // 重命名文件
                    if (file.renameTo(newFile)) {
                        System.out.println("Renamed " + file.getName() + " to " + newFileName);
                    } else {
                        System.out.println("Failed to rename " + file.getName());
                    }
                }
            }
        } else {
            System.out.println(directoryPath + " is not a directory.");
        }
    }

    // 获取文件的扩展名
    static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}
