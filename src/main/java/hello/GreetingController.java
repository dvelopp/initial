/*
 * Copyright (c) 2017 Nextiva, Inc. to Present.
 * All rights reserved.
 */
package hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Class Description goes here.
 * Created by dmitrypashkov on 7/22/17
 */
@Controller
public class GreetingController {

    private Map<String, MovableObject> clients = new HashMap<>();

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public MovableObject greeting(Message message) throws Exception {
        MovableObject position = clients.getOrDefault(message.getTargetId(), new MovableObject(message.getTargetId()));
        clients.putIfAbsent(message.getTargetId(), position);
        switch (message.getCharacter()) {
            case "a":
                position.setX(position.getX() - 10);
                break;
            case "d":
                position.setX(position.getX() + 10);
                break;
            case "w":
                position.setY(position.getY() - 10);
                break;
            case "s":
                position.setY(position.getY() + 10);
                break;
        }
        return position;
    }

}
