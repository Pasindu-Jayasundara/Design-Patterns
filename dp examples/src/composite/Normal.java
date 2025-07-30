package composite;

import java.util.ArrayList;
import java.util.List;

class File{
    private String name;
    
    public File(String name){
        this.name = name;
    }
    
    public void open(){
        System.out.println("openning file: "+name);
    }
}

class Folder{
    private String folderName;
    private List<File> files = new ArrayList<>();
    private List<Folder> subFolders = new ArrayList<>();
    
    public Folder(String folderName){
        this.folderName = folderName;
    }
    
    public void addFile(File file){
        files.add(file);
    }
    
    public void addFolder(Folder folder){
        subFolders.add(folder);
    }
    
    public void openAll(){
        System.out.println("openning folder: "+ folderName);
        for(File file:files){
            file.open();
        }
        for(Folder folder:subFolders){
            folder.openAll();
        }
    }
}

public class Normal {
    public static void main(String[] args) {
        
        File file1 = new File("Resume.pdf");
        File file2 = new File("Budget.xlsx");
        File file3 = new File("Photo.jpg");
        
        Folder folder1 = new Folder("Documents");
        folder1.addFile(file1);
        folder1.addFile(file2);
        
        Folder folder2 = new Folder("Images");
        folder2.addFile(file3);
        
        Folder root = new Folder("root");
        root.addFolder(folder1);
        root.addFolder(folder2);
        
        root.openAll();
    }
}
