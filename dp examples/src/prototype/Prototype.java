package prototype;

import java.util.HashMap;

interface DocumentPrototype extends Cloneable{
    DocumentPrototype clone();
}

class Document implements DocumentPrototype{
    private String type;
    private String content;
    
    public Document(String type, String content){
        this.type = type;
        this.content = content;
        
        System.out.println("Created: "+type);
    }

    @Override
    public DocumentPrototype clone() {
        return new Document(type, content);
    }
    
    public void show(){
        System.out.println("Type: "+type+" | Content: "+content);
    }
}

class DocumentManager{
    private static HashMap<String, DocumentPrototype> prototypes = new HashMap<>();
    
    public static void loadDocument(){
        prototypes.put("invoice", new Document("invoice", "invoice content"));
        prototypes.put("resume", new Document("resume", "resume content"));
        prototypes.put("letter", new Document("letter", "letter content"));
    }
    
    public static DocumentPrototype getDocument(String type){
        return prototypes.get(type);
    }
}

public class Prototype {
    public static void main(String[] args) {
        
        DocumentManager.loadDocument();
        
        DocumentPrototype doc1 = DocumentManager.getDocument("invoice").clone();
        DocumentPrototype doc2 = DocumentManager.getDocument("letter").clone();
        DocumentPrototype doc3 = DocumentManager.getDocument("resume").clone();
        
        ((Document) doc1).show();
        ((Document) doc2).show();
        ((Document) doc3).show();
    }
}
