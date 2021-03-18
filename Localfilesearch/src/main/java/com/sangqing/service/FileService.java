package com.sangqing.service;

import com.sangqing.dao.QueryDAO;
import com.sangqing.dao.SaveDAO;
import com.sangqing.model.FileMeta;
import com.sangqing.util.ListUtil;
import com.sangqing.dao.DeleteDAO;

import java.util.List;
import java.util.stream.Collectors;

// 主要提供给文件扫描时，处理扫描结果和DB中结果差集时使用
public class FileService {
    private final SaveDAO saveDAO = new SaveDAO();
    private final DeleteDAO deleteDAO = new DeleteDAO();
    private final QueryDAO queryDAO = new QueryDAO();

    private void saveFileList(List<FileMeta> fileList) {
        saveDAO.save(fileList);
    }

    private void deleteFileList(List<FileMeta> fileList) {
        List<Integer> idList = fileList.stream().map(FileMeta::getId).collect(Collectors.toList());
        deleteDAO.delete(idList);
    }

    public void service(String path, List<FileMeta> scanResultList) {
        List<FileMeta> queryResultList = queryDAO.queryByPath(path);

        // 1. queryResultList - scanResultList
        List<FileMeta> ds1 = ListUtil.differenceSet(queryResultList, scanResultList);
        deleteFileList(ds1);

        // 2. scanResultList - queryResultList
        List<FileMeta> ds2 = ListUtil.differenceSet(scanResultList, queryResultList);
        saveFileList(ds2);
    }

    public List<FileMeta> query(String keyword) {
        return queryDAO.query(keyword);
    }
}
