package prototype;

interface Shape{
    Shape clone();
    void draw();
}

class Circle implements Shape{
    private String color;
    
    public Circle(String color){
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Circle(color);
    }

    @Override
    public void draw() {
        System.out.println("Draw a "+color+" circle");
    }
}

class ShapeClient{
    private Shape prototype;
    
    public ShapeClient(Shape prototype){
        this.prototype = prototype;
    }
    
    public Shape createShape(){
        return prototype.clone();
    }
}

public class Q1 {
    public static void main(String[] args) {
        
        Shape circle = new Circle("Red");
        ShapeClient circleClient = new ShapeClient(circle);
        
        Shape redCircle = circleClient.createShape();
        redCircle.draw();
    }
}
