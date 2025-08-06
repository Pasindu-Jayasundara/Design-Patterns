package interpreter;

import java.util.Stack;

interface Expression{
    int interprete();
}

class Number implements Expression{
    private int number;
    
    public Number(int number){
        this.number = number;
    }
    
    @Override
    public int interprete() {
        return number;
    }
}

class ExpressionParser{
    
    public static Expression parse(String expression){
        
        String tokens[] = expression.split(" ");
        Stack<Expression> stack = new Stack<>();
        
        for(int i = 1; i < tokens.length; i++){
            String token = tokens[i];
            
            if(token.equals("+")){
                
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Add(left,right));
                
            }else if(token.equals("-")){
                
                Expression left = stack.pop();
                Expression right = new Number(Integer.parseInt(tokens[++i]));
                stack.push(new Substract(left,right));
                
            }else{
                stack.push(new Number(Integer.parseInt(token)));
            }
        }
        return stack.pop();
    }
}

class Add implements Expression{
    private Expression left, right;
    
    public Add(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int interprete() {
        return left.interprete() + right.interprete();
    }
}

class Substract implements Expression{
    private Expression left, right;
    
    public Substract(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int interprete() {
        return left.interprete() - right.interprete();
    }
}

public class Interpreter {
    public static void main(String[] args) {
        
        String input = "10 - 2 + 4";
        Expression expression = ExpressionParser.parse(input);
        int result = expression.interprete();
        
        System.out.println("Result: "+result);
    }
}
