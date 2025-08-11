package mediator;

import java.util.ArrayList;
import java.util.List;

// mediator interface
interface MediatorInteface{
    void sendMessage(String message, User sender);
    void addUser(User user);
}

// concrete mediator
class ChatRoom implements MediatorInteface{
    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User sender) {
        for(User user:users){
            if(user != sender){
                user.receive(message,sender.getName());
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

// colegue
class User{
    private String name;
    private MediatorInteface mediator;
    
    public User(String name, MediatorInteface mediator){
        this.name = name;
        this.mediator = mediator;
    }
    
    public String getName(){
        return name;
    }
    
    public void send(String message){
        mediator.sendMessage(message, this); 
    }
    
    public void receive(String message, String senderName){
        System.out.println(senderName+" to "+name+" : "+message);
    }
}

public class Mediator {
    public static void main(String[] args) {
        
        ChatRoom chat = new ChatRoom();
        
        User sahan = new User("Sahan", chat);
        User dinuka = new User("Dinuka", chat);
        User prabath = new User("Prabath", chat);
        
        chat.addUser(sahan);
        chat.addUser(dinuka);
        chat.addUser(prabath);
        
        sahan.send("Hello!");
        dinuka.send("Good Morning!");
        prabath.send("Whatsup");
    }
}
