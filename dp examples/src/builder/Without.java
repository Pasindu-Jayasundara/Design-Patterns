package builder;

public class Without {
    
    private String burger;
    private String drink;
    private String fries;
    private String dessert;
    
    public Without(String burger){
        this.burger = burger;
    }
    
    public Without(String burger,String drink){
        this.burger = burger;
        this.drink = drink;
    }
    
    public Without(String burger,String drink, String fries){
        this.burger = burger;
        this.drink = drink;
        this.fries = fries;
    }
    
    public Without(String burger,String drink, String fries, String dessert){
        this.burger = burger;
        this.drink = drink;
        this.fries = fries;
        this.dessert = dessert;
    }
    
    public void display(){
        System.out.println("Meal-------------");
        System.out.println("Burger :"+burger);
        System.out.println("Fries :"+fries);
        System.out.println("Drinks :"+drink);
        System.out.println("Dessert :"+dessert);
    }
    
    public static void main(String[] args) {
        
        Without meal = new Without("Chicken Burger","Iced Coffee");
        meal.display();
    }
}
