package org.simulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageBox {
    private static final List<String> messageBox = new ArrayList<>();

    public void addMessage(String message) {
        messageBox.add(message);
    }

    public void getMessage() {
        Iterator<String> iterator = messageBox.iterator();
        while (iterator.hasNext()) {
            String message = iterator.next();
            System.out.println(message);
            iterator.remove();
        }
    }

}