package composite;

import java.util.ArrayList;
import java.util.List;

interface FileComponent{
    void showDetails(String indent);
}

class File implements FileComponent{
    private String name;
    
    public File(String name){
        this.name = name;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent+" File: "+name);
    }
    
}

class Folder implements FileComponent{
    private String folderName;
    private List<FileComponent> child = new ArrayList<>();
    
    public Folder(String folderName){
        this.folderName = folderName;
    }
    
    public void add(FileComponent component){
        child.add(component);
    }
    
    public void remove(FileComponent component){
        child.remove(component);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent+" Folder: "+folderName);
        for(FileComponent c:child){
            c.showDetails(indent+" ");
        } 
    }
    
}

public class Composite {
    public static void main(String[] args) {
        
        FileComponent file1 = new File("Resume.pdf");
        FileComponent file2 = new File("Budget.xlsx");
        FileComponent file3 = new File("Photo.jpg");
        
        Folder folder1 = new Folder("Documents");
        folder1.add(file1);
        folder1.add(file2);
        
        Folder folder2 = new Folder("Images");
        folder2.add(file3);
        
        Folder root = new Folder("root");
        root.add(folder1);
        root.add(folder2);
        
        root.showDetails(""); 
    }
}
