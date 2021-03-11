package com.sangqing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sangqing.model.Message;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        /*
        String s = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"who\": \"达摩老祖\",\n" +
                "    \"when\": \"2020-12-09 10:34:07\",\n" +
                "    \"what\": \"快去休闲\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"who\": \"达摩老祖2\",\n" +
                "    \"when\": \"2020-12-08 10:34:07\",\n" +
                "    \"what\": \"快去休闲吧\"\n" +
                "  }\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Message.class);
        List<Message> messageList = mapper.readValue(s, type);
        System.out.println(messageList);

         */

        String s = "{\n" +
                "    \"id\": 1,\n" +
                "    \"who\": \"达摩老祖\",\n" +
                "    \"when\": \"2020-12-09 10:34:07\",\n" +
                "    \"what\": \"快去休闲\"\n" +
                "  }";
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(s, Message.class);
        System.out.println(message);
    }
}
