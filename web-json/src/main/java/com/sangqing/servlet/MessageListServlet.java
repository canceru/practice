package com.sangqing.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sangqing.model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/message-list.json")
public class MessageListServlet extends HttpServlet {
    private static DataSource dataSource;

    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");
        mysqlDataSource.setDatabaseName("db2020");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        dataSource = mysqlDataSource;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messageList = getMessageList();

        String jsonMessage = buildJSONByJackson(messageList);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        writer.println(jsonMessage);
    }

    private String buildJSONByJackson(List<Message> messageList) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(messageList);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    private List<Message> getMessageList() {
        List<Message> messageList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT id, who, `when`, what FROM message  ORDER BY id DESC";
            try (PreparedStatement s = connection.prepareStatement(sql)) {
                try (ResultSet rs = s.executeQuery()) {
                    while (rs.next()) {
                        Message message = new Message();

                        message.id = rs.getInt("id");
                        message.who = rs.getString("who");
                        message.when = rs.getString("when");
                        message.what = rs.getString("what");

                        messageList.add(message);
                    }
                    return messageList;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    private String buildJSON(List<Message> messageList) {
        StringBuilder sb = new StringBuilder("[");

        for (Message message : messageList) {
            sb.append("{\n");
            sb.append("    \"id\":");
            sb.append(message.id);
            sb.append(",\n");
            sb.append("    \"who\":");
            sb.append("\"");
            sb.append(message.who);
            sb.append("\"");
            sb.append("},\n");
        }

        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");

        return sb.toString();
    }
     */

    /*
    private List<Message> getMessageList() {
        List<Message> messageList = new ArrayList<>();

        Message m1 = new Message();
        m1.id = 1;
        m1.who = "达摩老祖";
        messageList.add(m1);

        Message m2 = new Message();
        m2.id = 2;
        m2.who = "达摩老祖2";
        messageList.add(m2);

        Message m3 = new Message();
        m3.id = 3;
        m3.who = "达摩老祖3";
        messageList.add(m3);

        Message m4 = new Message();
        m4.id = 4;
        m4.who = "达摩老祖4";
        messageList.add(m4);

        return messageList;
    }

     */
}
