package com;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
    public static List<String> FileToList(String resourcePath){
        ArrayList<String> FilePath= new ArrayList<>();
        findAllClass(resourcePath,FilePath);
        return FilePath.stream().map(path -> {
            String filePath = new File(resourcePath).getAbsolutePath();
            return path.replace(filePath + "\\", "").
                    replaceAll("\\\\", ".").
                    replace(".class", "");

        }).collect(Collectors.toList());
    }


    private static void findAllClass(String path, List<String> FilePath){
        File file = new File(path);
        File[] files = file.listFiles((p, n) -> new File(p, n).isDirectory() || n.contains("class"));
        for (File file1 : files) {
            if(file1.isDirectory()){
                findAllClass(file1.toString(), FilePath);
            }
            else {
                FilePath.add(file1.getAbsolutePath());
            }
        }
    }
}
