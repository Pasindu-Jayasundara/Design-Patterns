package composite;

import java.util.ArrayList;
import java.util.List;

// component interface
interface DocumentElement{
    void render();
    void move(int x, int y);
    void resize(double factor);
}

// leaf classes
class Textbox implements DocumentElement{
    private int x;
    private int y;
    private double size;
    
    public Textbox(int x, int y, double size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void render() {
        System.out.println("Rendering Textbox at "+x+", "+y+" with the size "+size);
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        
        System.out.println("Textbox moved to ("+x+", "+y+")");
    }

    @Override
    public void resize(double factor) {
        size *= factor;
        System.out.println("Textbox resized by factor "+factor);
        System.out.println("New Textbox size "+size);
    }
}

class Chart implements DocumentElement{

    @Override
    public void render() {
    }

    @Override
    public void move(int x, int y) {
    }

    @Override
    public void resize(double factor) {
    }
    
}
// other leaf classes....

// composite class
class Page implements DocumentElement{
    private String name;
    private List<DocumentElement> elements = new ArrayList<>();

    public Page(String name){
        this.name = name;
    }
    
    public void addElement(DocumentElement element){
        elements.add(element);
    }
    
    public void removeElement(DocumentElement element){
        elements.remove(element);
    }
    
    @Override
    public void render() {
        System.out.println("Rendering page "+name);
        for(DocumentElement element: elements){
            element.render();
        }
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Moving page "+name);
        for(DocumentElement element: elements){
            element.move(x,y);
        }
    }

    @Override
    public void resize(double factor) {
        System.out.println("Resizing page "+name);
        for(DocumentElement element: elements){
            element.resize(factor); 
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        
        DocumentElement tb1 = new Textbox(10,10,100);
        
        Page pg1 = new Page("Introduction");
        pg1.addElement(tb1); 
        
        pg1.render();
        pg1.resize(1.5);
        pg1.move(50, 30);
    }
}
