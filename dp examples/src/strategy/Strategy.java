package strategy;

interface PaymentStrategy{
    void pay(double amount);
}

class CashPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Rs. "+amount+" paid with cash");
    }
}

class CardPayment implements PaymentStrategy{

    @Override 
    public void pay(double amount) {
        System.out.println("Rs. "+amount+" paid with card");
    }
}

class ShoppingCart{
    
    private PaymentStrategy paymentStrategy;
    
    public void setStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    
    public void checkout(double amount){
        paymentStrategy.pay(amount);
    }
}

public class Strategy {

    public static void main(String[] args) {
        
        ShoppingCart cart = new ShoppingCart();
        cart.setStrategy(new CardPayment());
        cart.checkout(500);

    }
}
