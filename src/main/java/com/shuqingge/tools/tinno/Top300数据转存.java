package com.shuqingge.tools.tinno;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Top300数据转存 {
    public static void main(String[] args) {
        Path sourceDir = Paths.get("E:\\top300\\main\\testResult"); // 设置你的源目录路径
        Path targetDir = Paths.get("F:\\demo"); // 设置你的目标目录路径

        try {
            Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.getFileName().toString().equals("test_report.xlsx")) {
                        // 创建目标文件路径
                        Path target = targetDir.resolve(file.getParent().getFileName().toString() + ".xlsx");
                        // 复制文件
                        Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copied: " + file + " to " + target);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Failed to access file: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
