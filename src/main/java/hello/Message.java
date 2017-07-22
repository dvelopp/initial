package hello;/*
 * Copyright (c) 2017 Nextiva, Inc. to Present.
 * All rights reserved.
 */

/**
 * Class Description goes here.
 * Created by dmitrypashkov on 7/22/17
 */
public class Message {

    private String targetId;
    private String character;

    public Message() {
    }

    public Message(String name) {
        this.character = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
