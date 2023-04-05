package abstraction.abstractclasses;

public class Redmi extends Mobile{
    public void calling(String phoneNumber){
        System.out.println("calling from Redmi..."+phoneNumber);
    }

    public void sendMessage(String message){
        System.out.println("sending message from Redmi..."+message);
    }

    public static void main(String[] args) {
        Redmi myNewPhone = new Redmi();
        myNewPhone.calling("9704276705");
        myNewPhone.sendMessage("How are you doing");
        myNewPhone.addContact("7780722901");
    }
}
