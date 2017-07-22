/*
 * Copyright (c) 2017 Nextiva, Inc. to Present.
 * All rights reserved.
 */
package hello;

import java.util.Random;

/**
 * Class Description goes here.
 * Created by dmitrypashkov on 7/22/17
 */
public class MovableObject {

    private String targetId;
    private int x = new Random().nextInt(1000);
    private int y = new Random().nextInt(1000);

    public MovableObject(String targetId) {
        this.targetId = targetId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
