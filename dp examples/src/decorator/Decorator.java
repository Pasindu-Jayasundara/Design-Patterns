package decorator;

interface Coffee {

    double cost();
    String description();
}

class SimpleCoffee implements Coffee{

    @Override
    public double cost() {
        return 500;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee{
    
    protected Coffee coffee;
    
    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator{
    
    public MilkDecorator(Coffee coffee){
        super(coffee); 
    }

    @Override
    public double cost() {
        return coffee.cost() + 100;
    }

    @Override
    public String description() {
        return coffee.description()+", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.coffee.cost() + 50;
    }

    @Override
    public String description() {
        return super.coffee.description()+", Sugar";
    }
}

public class Decorator {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        
        System.out.println("cose: "+ coffee.cost());
        System.out.println("Desc: "+ coffee.description());
        
    }
}
