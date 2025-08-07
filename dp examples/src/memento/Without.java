package memento;

class TextEditor{
    private String content = "";
    
    public void type(String words){
        this.content += words;
    }
    
    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
public class Without {
    public static void main(String[] args) {
        
        TextEditor doc1 = new TextEditor();
        doc1.type("Hello");
        doc1.type("Java");
        
        String saved = doc1.getContent(); // manually save
        System.out.println("Before Undo: "+doc1.getContent());
        
        doc1.setContent(saved);// manually restore
        System.out.println("After Undo: "+doc1.getContent());
    }
}
