package bridge;

interface Channel{
    void send(String message);
}

class Email implements Channel{

    @Override
    public void send(String message) {
        System.out.println("Email sent : "+message);
    }
}

class SMS implements Channel{

    @Override
    public void send(String message) {
        System.out.println("SMS sent : "+message);
    }
}

abstract class Notification{
    protected Channel channel;
    
    public Notification(Channel channel){
        this.channel = channel;
    }
    
    public abstract void notify(String message);
}

class EmailAlert extends Notification{
    
    public EmailAlert(Channel channel) {
        super(channel);
    }

    @Override
    public void notify(String message) {
        channel.send("[Alert] "+message); 
    }
    
}

public class Q1 {
    public static void main(String[] args) {
        
        Notification email = new EmailAlert(new Email());
        email.notify("buy one, get one"); 
    }
}
