package builder;

public class Meal {

    private final String burger;
    private final String drink;
    private final String fries;
    private final String dessert;

    public Meal(Builder builder) {
        this.burger = builder.burger;
        this.drink = builder.drink;
        this.fries = builder.fries;
        this.dessert = builder.dessert;
    }

    public void display() {
        System.out.println("Meal includes,");
        System.out.println(burger + ", ");
        System.out.println(drink + ", ");
        System.out.println(fries + ", ");
        System.out.println(dessert + ", ");
    }

    public static class Builder {

        private String burger;
        private String drink;
        private String fries;
        private String dessert;

        public Builder setBurger(String burger) {
            this.burger = burger;
            return this;
        }

        public Builder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder setFries(String fries) {
            this.fries = fries;
            return this;
        }

        public Builder setDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }

        public static void main(String[] args) {

            Meal meal = new Meal.Builder()
                    .setBurger("Veg burger")
                    .setDrink("Iced coffee")
                    .build();
            meal.display();
        }
    }
}
