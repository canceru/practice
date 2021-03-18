package com.sangqing.service;

import com.sangqing.dao.InitDAO;

public class DBService {
    private final InitDAO initDAO = new InitDAO();

    public void init() {
        initDAO.init();
    }
}
