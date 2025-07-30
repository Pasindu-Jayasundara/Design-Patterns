package cor;

class HelpDesk{
    
    public void Handler(String issueType){
        
        if(issueType.equals("basic")){
            System.out.println("Level 01");
        }else if(issueType.equals("intermediate")){
            System.out.println("Level 02");
        }else if(issueType.equals("advanced")){
            System.out.println("Level 03");
        }else{
            System.out.println("Cannot handle the request");
        }
    }
}
public class Without {
    public static void main(String[] args) {
        
    }
}
