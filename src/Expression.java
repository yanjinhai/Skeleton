import java.util.ArrayList;

public class Expression {

    String value;
    ArrayList subExpressions;// can be none, indicating a lone number or variable
    Operator operator;// can be none, indicating a lone number or variable

    public Expression (String expression) {
        value = expression;
        subExpressions = new ArrayList<Expression>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            switch (current){
                case '+':
                    break;
                default:
//                    if (Character.isDigit(current)) {
//                        String string = "";
//                        while (Character.isDigit(current)) {
//                            current = expression.charAt(i);
//                            string += current;
//                            i++;
//                        }
//
//                    }
                    break;
            }

        }

    }

    public class Operator {

    }

}
