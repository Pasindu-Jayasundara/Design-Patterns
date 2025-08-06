package flyweight;

import java.util.ArrayList;
import java.util.List;

class Tree {
    private String name;
    private String color;
    private String texture;
    private int x;
    private int y;
    
    public Tree(String name, String color, String texture, int x, int y){
        this.name = name;
        this.color = color;
        this.texture = texture;
        this.x = x;
        this.y = y;
    }
    
    public void draw(){
        System.out.println("creating a "+name+" at ("+x+","+y+") with color "+color+ " & the texture "+texture);
    }
}

class Forest{
    private List<Tree> trees = new ArrayList<>();
    
    public void plantTree(String name, String color, String texture, int x, int y){
        Tree tree = new Tree(name, color, texture,x, y);
        trees.add(tree);
    }
    
    public void drawForest(){
        for(Tree tree : trees){
            tree.draw();
        }
    }
}

public class Without {
    public static void main(String[] args) {
        Forest forest = new Forest();
        
        for(int i = 0; i <10; i++){
            forest.plantTree("Oak", "Green", "Rough", getRandomX(), getRandomY());
        }
        
        for(int i = 0; i <10; i++){
            forest.plantTree("Pine", "Yellow", "Smooth", getRandomX(), getRandomY());
        }
        
        forest.drawForest();
    }
    
    private static int getRandomX(){
        return (int) (Math.random()*10);
    }
    
    private static int getRandomY(){
        return (int) (Math.random()*10);
    }
}
