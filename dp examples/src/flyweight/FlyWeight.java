package flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// intrinsic
interface DrawableTree {

    void draw(int x, int y);
}

// extrinsic
class TreeType implements DrawableTree {

    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("drawing a " + name + " at (" + x + "," + y + ") with color " + color + " & the texture " + texture);
    }
}

class TreeFactory {

    private static final Map<String, DrawableTree> treeTypes = new HashMap<>();

    public static DrawableTree getTreeType(String name, String color, String texture) {

        String key = name + "_" + color + "_" + texture;
        if (!treeTypes.containsKey(key)) {

            treeTypes.put(key, new TreeType(name, color, texture));
        }
        return treeTypes.get(key);
    }

    public static int getTotalTypes() {
        return treeTypes.size();
    }
}

class Tree {

    private int x;
    private int y;
    private DrawableTree type;

    public Tree(int x, int y, DrawableTree type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

class Forest {

    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {

        DrawableTree type = TreeFactory.getTreeType(color, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void drawForest() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public int getTreeCount() {
        return trees.size();
    }
}

public class FlyWeight {
    
    public static void main(String[] args) {
        Forest forest = new Forest();
        
        for(int i = 0; i <10; i++){
            forest.plantTree(getRandomX(),getRandomY(), "Oak", "Green", "Rough");
        }
        
        for(int i = 0; i <10; i++){
            forest.plantTree(getRandomX(),getRandomY(), "Pine", "Yellow", "Smooth");
        }
        
        forest.drawForest();
        
        System.out.println("\nTotal Tree count: "+forest.getTreeCount());
        System.out.println("Total Tree types: "+TreeFactory.getTotalTypes());
    }

    private static int getRandomX() {
        return (int) (Math.random() * 10);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 10);
    }
}
