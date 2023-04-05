package abstraction.interfaces;

import java.util.ArrayList;

public class Realme implements  Mobile{
    ArrayList<String> contacts = new ArrayList<String>();
    @Override
    public void calling(String phoneNumber) {
        System.out.println("calling..."+phoneNumber);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("sending message..."+message);
    }

    @Override
    public void addContact(String phoneNumber) {
        contacts.add(phoneNumber);
        System.out.println("contact added succesfully");
    }

    public static void main(String[] args) {
        Realme myPhone = new Realme();
        myPhone.calling("9704276705");
        myPhone.sendMessage("How are you?");
        myPhone.addContact("7780722901");
    }
}
