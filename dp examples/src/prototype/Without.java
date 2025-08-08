package prototype;

class Document {

    private String type;
    private String content;

    public Document(String type, String content) {
        this.type = type;
        this.content = content;

        System.out.println("Document created: " + type);
    }

    public void show() {
        System.out.println("Type: " + type + " | Content: " + content);
    }
}

public class Without {
    public static void main(String[] args) {
        
        Document doc1 = new Document("Invoice", "Invoice content");
        Document doc2 = new Document("Resume", "Resume content");
        Document doc3 = new Document("Letter", "Letter content");
        
        doc1.show();
        doc2.show();
        doc3.show();
    }
}
