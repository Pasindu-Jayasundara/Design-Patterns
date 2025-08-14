package visitor;

// visitor interface

import java.util.ArrayList;
import java.util.List;

interface ClientVisitor {

    void visit(BusinessClient business);

    void visit(IndividualClient individual);
}

// element interface
interface ClientElement {

    void accept(ClientVisitor visitor);
}

// concrete visitor
class ReportGeneratorVisitor implements ClientVisitor {

    @Override
    public void visit(BusinessClient business) {
        System.out.println("Business report for : " + business.getName() + " with revenue: Rs." + business.getRevenue());
    }

    @Override
    public void visit(IndividualClient individual) {
        System.out.println("Individual report for: " + individual.getName() + ", age: " + individual.getAge());
    }
}

class PremiumCalculatorVisitor implements ClientVisitor {

    @Override
    public void visit(BusinessClient business) {
        double premium = business.getRevenue() * 0.01 + business.getEmployees() * 50;
        System.out.println("Business premium for: " + business.getName() + " Rs." + premium);
    }

    @Override
    public void visit(IndividualClient individual) {
        double premium;
        if (individual.getAge() < 30) {
            premium = 300;
        } else {
            premium = 500;
        }
        System.out.println("Individual premium for: " + individual.getName() + " Rs." + premium);
    }
}

// concrete elements
class BusinessClient implements ClientElement {

    private String name;
    private double revenue;
    private int employees;

    public BusinessClient(String name, double revenue, int employees) {
        this.name = name;
        this.revenue = revenue;
        this.employees = employees;
    }

    @Override
    public void accept(ClientVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getEmployees() {
        return employees;
    }
}

class IndividualClient implements ClientElement {

    private String name;
    private int age;

    public IndividualClient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void accept(ClientVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Visitor{
    public static void main(String[] args) {
        
        List<ClientElement> clients = new ArrayList<>();
        clients.add(new BusinessClient("tecCorp", 50000, 50));
        clients.add(new IndividualClient("John Doe",23));
        
        ClientVisitor premiumCalculator = new PremiumCalculatorVisitor();
        ClientVisitor reportGenerator = new ReportGeneratorVisitor();
        
        for(ClientElement client: clients){
            client.accept(premiumCalculator);
            client.accept(reportGenerator); 
        }
    }
}
