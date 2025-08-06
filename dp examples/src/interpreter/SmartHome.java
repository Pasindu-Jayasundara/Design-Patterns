package interpreter;

interface Expression{
    void interprete(Context context);
}

class Context{
    
    public void turnOnDevice(String device){
        System.out.println(device+" ON");
    }
    
    public void turnOffDevice(String device){
        System.out.println(device+" OFF");
    }
    
    public void increaseTemp(int amount){
        System.out.println(amount+ " Increased");
    }    
        
    public void decreaseTemp(int amount){
        System.out.println(amount+ " decreased");
    }    
}

class DeviceCommand implements Expression{
    
    private String action; // on off
    private String device;
    private String location;
    
    public DeviceCommand(String action, String device, String location){
        this.action = action;
        this.device = device;
        this.location = location;
    }
    
    @Override
    public void interprete(Context context) {
        
        if(action.equalsIgnoreCase("on")){
            context.turnOffDevice(device);
        }else if(action.equalsIgnoreCase("off")){
            context.turnOffDevice(device);
        }
    }
}

class TempratureCommand implements Expression{
    
    private String action; // increse decrease
    private int value;
    
    public TempratureCommand(String action, int value){
        this.action = action;
        this.value = value;
    }
    
    @Override
    public void interprete(Context context) {
        
        if(action.equalsIgnoreCase("increase")){
            context.increaseTemp(value);
        }else if(action.equalsIgnoreCase("decrease")){
            context.decreaseTemp(value);
        }
    }
}

class CommandParser{
    
    public static Expression parse(String input){
        
        String tokens[] = input.trim().split(" ");
        if(tokens[0].equalsIgnoreCase("turn")){
            
            String action = tokens[1];
            String location = tokens[2];
            String device = tokens[3];
            
            return new DeviceCommand(action, device, location);
        
        }else if(tokens[0].equalsIgnoreCase("increase") || tokens[0].equalsIgnoreCase("decrease")){
            
            String action = tokens[0];
            int value = Integer.parseInt(tokens[3]);
            
            return new TempratureCommand(action, value);
        }
        
        throw new IllegalArgumentException("Unsupported Command: "+input);
    }
}

public class SmartHome {
    public static void main(String[] args) {
        
        Context context = new Context();
        
        Expression ex1 = CommandParser.parse("Turn on kitchen light");
        ex1.interprete(context);
        
    }
}
