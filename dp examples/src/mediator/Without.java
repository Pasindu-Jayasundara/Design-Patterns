package mediator;

class User{
    private String name;
    
    public User(String name){
        this.name = name;
    }
    
    public void sendMessage(String message,User receiver){
        System.out.println("From: " +this.name+" To: "+receiver.name+" : "+message);
    }
}

public class Without {
    public static void main(String[] args) {
        
        User u1 = new User("Kamal");
        User u2 = new User("Sahan");
        
        u1.sendMessage("Good Morning", u2);
        u2.sendMessage("Same to you", u1);
    }
}
