package cor;

// abstract handler
abstract class Handler{
    protected Handler nextHandler;
    
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    
    public abstract void handlingRequest(String issueType);
}

// concrete handler
class Level_1 extends Handler{

    @Override
    public void handlingRequest(String issueType) {
        if(issueType.equals("basic")){
            System.out.println("Handled : Level 01");
        }else if(nextHandler != null){
            nextHandler.handlingRequest(issueType); 
        }
    }
}

class Level_2 extends Handler{

    @Override
    public void handlingRequest(String issueType) {
        if(issueType.equals("intermediate")){
            System.out.println("Handled : Level 02");
        }else if(nextHandler != null){
            nextHandler.handlingRequest(issueType); 
        }
    }
}

class Level_3 extends Handler{

    @Override
    public void handlingRequest(String issueType) {
        if(issueType.equals("advance")){
            System.out.println("Handled : Level 03");
        }else{
            System.out.println("Request not handled");
        }
    }
}

public class COR {
    public static void main(String[] args) {
        
        Handler level1 = new Level_1();
        Handler level2 = new Level_2();
        Handler level3 = new Level_3();
        
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);
        
        level1.handlingRequest("advanced"); 
    }
}
