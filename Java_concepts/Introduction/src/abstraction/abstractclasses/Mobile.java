package abstraction.abstractclasses;

import java.util.ArrayList;

abstract public class Mobile {
    ArrayList<String> contacts = new ArrayList<>();
    abstract void calling(String phoneNumber);
    abstract void sendMessage(String message);

    public void addContact(String phoneNumber){
        contacts.add(phoneNumber);
    }
}
