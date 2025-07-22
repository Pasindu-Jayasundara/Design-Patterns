package decorator;

import java.util.Scanner;

// component interface
interface Beverage {

    double getPrice();

    String getDescription();
}

// concrete components
class Coffee implements Beverage {

    @Override
    public double getPrice() {
        return 500;
    }

    @Override
    public String getDescription() {
        return "Make Coffee";
    }
}

class Tea implements Beverage {

    @Override
    public double getPrice() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Make Tea";
    }
}

// decorators
abstract class Decorator implements Beverage {

    protected Beverage beverage;

    public Decorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

class SugarDecorator extends Decorator {

    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 50;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Sugar";
    }
}

class MilkDecorator extends Decorator {

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 100;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Milk";
    }
}

class WhippedCreamDecorator extends Decorator {

    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 40;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Whipped Cream";
    }
}

class ChocolateDecorator extends Decorator {

    public ChocolateDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice() + 120;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Chocolate";
    }
}

public class Q1 {

    public static void main(String[] args) {
        
        Beverage beverage = new Coffee();
        beverage = new MilkDecorator(beverage);
        beverage = new SugarDecorator(beverage);
        System.out.println("Total price for Coffee: "+beverage.getPrice());
        System.out.println("Description for Coffee: "+beverage.getDescription());
        
        Beverage beverage1 = new Tea();
        beverage1 = new WhippedCreamDecorator(beverage1);
        beverage1 = new ChocolateDecorator(beverage1);
        System.out.println("Total price for Tea: "+beverage1.getPrice());
        System.out.println("Description for Tea: "+beverage1.getDescription());

    }
}
