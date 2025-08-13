package visitor;

abstract class Client{
    String name;
    
    public Client(String name){
        this.name = name;
    }
    
    abstract void calculatePremium();
    abstract void generateReport();
}

class IndividualClinet extends Client{
    
    int age;
    
    public IndividualClinet(String name, int age){
        super(name);
        this.age = age;
    }

    @Override
    void calculatePremium() {
        double premiun;
        
        if(age < 30){
            premiun = 300;
        }else {
            premiun = 500;
        }
        
        System.out.println("Individual Premium for "+name+" : Rs."+premiun); 
    }

    @Override
    void generateReport() {
        System.out.println("Individual Report : "+name+", age :"+age); 
    }   
}

class BusinessClient extends Client{
    
    double revenue;
    int employee;
    
    public BusinessClient(String name, double revenue, int employee){
        super(name);
        this.revenue = revenue;
        this.employee = employee;
    }

    @Override
    void calculatePremium() {
        
        double premium = revenue * 0.001 + employee * 50;
        System.out.println("Nusiness Premium for "+name+" : Rs."+premium); 
    }

    @Override
    void generateReport() {
        System.out.println("Business report for: "+name+" with the revenue: "+revenue);
    }
}

public class Without {
    public static void main(String[] args) {
        
        Client[] clients = [
                       new IndividualClinet("John Doe", 28), 
                       new BusinessClient("TecCorp", 50000,50)
                ];
                       
        for(Client client:clients){
            client.calculatePremium();
            client.generateReport();
        }
    }
}
