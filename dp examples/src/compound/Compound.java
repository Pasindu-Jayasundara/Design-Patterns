package compound;

import java.util.ArrayList;
import java.util.List;

// observer dp - observer
interface Observer{
    void update();
}

class StudentModel{
    
    private String name;
    private int age;
    private List<Observer> observers = new ArrayList<>();
    
    public void setStudentData(String name, int age){
        this.name = name;
        this.age = age;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    private void notifyObservers(){
        for(Observer ob:observers){
            ob.update();
        }
    }
}

// view
class StudentView implements Observer{
    private StudentModel model;
    
    public StudentView(StudentModel model){
        this.model = model;
        model.addObserver(this); 
    }
    
    public void displayStudent(){
        System.out.println("==================");
        System.out.println("Name: "+ model.getName());
        System.out.println("Age :"+model.getAge());
        System.out.println("===================");
    }

    @Override
    public void update() {
        displayStudent();
    }
}

// strategy dp - controller
interface ActionStrategy{
    void execute(StudentModel model, String name, int age);
}

class AddStudentAction implements ActionStrategy{

    @Override
    public void execute(StudentModel model, String name, int age) {
        System.out.println("[controller] adding new student...");
    }
}

class UpdateStudentAction implements ActionStrategy{

    @Override
    public void execute(StudentModel model, String name, int age) {
        System.out.println("[controller] updating student...");
    }
}

class StudentController{
    
    private StudentModel model;
    private ActionStrategy strategy;
    
    public StudentController(StudentModel model, ActionStrategy strategy){
        this.model = model;
        this.strategy = strategy;
    }
    
    public void setActionStrategy(ActionStrategy strategy){
        this.strategy = strategy;
    }
    
    public void handleRequest(String name, int age){
        strategy.execute(model, name, age); 
    }
}

public class Compound {
    public static void main(String[] args) {
        
        StudentModel model = new StudentModel(); // create model
        StudentView view = new StudentView(model); // attach view to model
        StudentController controller = new StudentController(model, new AddStudentAction()); // create new controller with strategy
        controller.handleRequest("Shan", 15); // add student
        controller.setActionStrategy(new UpdateStudentAction()); // change stategy to update
        controller.handleRequest("Sahan", 10);
    }
}
