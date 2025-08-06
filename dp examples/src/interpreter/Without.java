package interpreter;

class Calculator{
    
    public int calculate(String expression){
        
        String token[] = expression.split(" ");
        int result = Integer.parseInt(token[0]);
        
        for(int i = 1; i < token.length; i+=2){
            
            String operator = token[i];
            int number = Integer.parseInt(token[i+1]);
            
            switch(operator){
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
            }
        }
        return result;
    }
}

public class Without {
    public static void main(String[] args) {
        
        Calculator cal = new Calculator();
        System.out.println("Resul: "+cal.calculate("50 + 30 - 60"));
    }
}
