package com.sangqing.task;

import com.sangqing.model.FileMeta;
import com.sangqing.service.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {
    private final FileService fileService = new FileService();

    public void scan(File root) {
        scanDir(root);
    }

    private void scanDir(File root) {
        if (!root.isDirectory()) {
            return;
        }

        File[] children = root.listFiles();
        if (children == null) {
            return;
        }

        List<FileMeta> scanResultList = new ArrayList<>();
        for (File child : children) {
            scanDir(child);
            if (child.isFile()) {
                scanResultList.add(new FileMeta(child));
            }
        }

        fileService.service(root.getAbsolutePath(), scanResultList);
    }
}
