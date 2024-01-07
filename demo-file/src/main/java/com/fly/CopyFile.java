package com.fly;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String inputFilePath = projectPath + File.separator + "demo" + File.separator + "demo-empty" + File.separator + "demo-empty";
        String outputFilePath = projectPath;
        doCopyFile(inputFilePath, outputFilePath);
    }

    public static void doCopyFile(String inputFilePath, String outputFilePath) throws IOException {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        doCopy(inputFile, outputFile);
    }

    public static void doCopy(File inputFile, File outputFile) throws IOException {
        // 判断输入文件是否为文件夹
        if (inputFile.isDirectory()) {
            System.out.println("文件夹名: " + inputFile.getName());
            // 建立新的文件夹
            File newDir = new File(outputFile, inputFile.getName());
            // 判断新的文件夹是否存在
            if (!newDir.exists()) {
                newDir.mkdirs();
            }
            // 遍历文件
            File[] files = inputFile.listFiles();
            // 需要判空
            if (files == null) {
                return;
            }
            for (File file : files) {
                // 递归调用，复制文件夹内的每个文件或子文件夹
                doCopy(file, newDir);
            }
        } else {
            // 是文件
            System.out.println("文件名称: " + inputFile.getName());
            System.out.println("文件大小: " + inputFile.length());
            // 构建目标文件路径
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            // 使用Java NIO的Files.copy方法复制文件，替换已存在的目标文件
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
