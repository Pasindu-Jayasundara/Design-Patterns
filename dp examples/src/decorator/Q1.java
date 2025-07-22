package decorator;

import java.util.Scanner;

interface Coffee {

    double cost();
}

class BasicCoffee implements Coffee {

    @Override
    public double cost() {
        return 500;
    }
}

abstract class BasicCoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public BasicCoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends BasicCoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.coffee.cost() + 100;
    }
}

class SugarDecorator extends BasicCoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.coffee.cost() + 50;
    }
}

class WhippedCreamDecorator extends BasicCoffeeDecorator {

    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.coffee.cost() + 25;
    }
}

class ChocolateDecorator extends BasicCoffeeDecorator {

    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.coffee.cost() + 150;
    }
}

public class Q1 {

    public static void main(String[] args) {

        Coffee coffee = new BasicCoffee();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\nChoose add-ons");
            System.out.println("1. Milk");
            System.out.println("2. Sugar");
            System.out.println("3. Whipped Cream");
            System.out.println("4. Chocolate");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            String nextLine = scanner.nextLine();
            switch (nextLine) {
                case "0" -> {
                    System.exit(0);
                }
                case "1" -> {
                    coffee = new MilkDecorator(coffee);
                }
                case "2" -> {
                    coffee = new SugarDecorator(coffee);
                }
                case "3" -> {
                    coffee = new WhippedCreamDecorator(coffee);
                }
                case "4" -> {
                    coffee = new ChocolateDecorator(coffee);
                }
                default -> {
                    System.out.println("Invalid Input");
                }
            }
            System.out.println("Price: " + coffee.cost());

        } while (true);

    }
}
