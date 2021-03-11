package com.sangqing.model;

public class Message {
    public int id;
    public String who;
    public String when;
    public String what;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", who='" + who + '\'' +
                ", when='" + when + '\'' +
                ", what='" + what + '\'' +
                '}';
    }
}
