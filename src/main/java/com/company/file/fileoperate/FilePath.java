package com.company.file.fileoperate;

import java.io.File;

/**
 * Created by lilei on 2017/9/4 下午3:45.
 */
public class FilePath {
    public static void main(String[] args) {
        File file1 = new File("./file/jack.txt");
        File file2 = new File("./file/jack.txt");
        if (file1.compareTo(file2) == 0) {
            System.out.println("文件路径一致！");
        } else {
            System.out.println("文件路径不一致！");
        }
    }
}
