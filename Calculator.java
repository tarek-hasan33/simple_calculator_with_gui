public class Calculator {

    //Variables
    private double operand1 = 0;
    private double operand2 = 0;
    private String operator = "";

    //Setter Getters
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getOperator() {
        return operator;
    }


    //Main Calculation Happens Here
    public double performCalculation() throws ArithmeticException {
        double result = 0;

        if ("+".equals(operator)) {
            result = operand1 + operand2;
        } else if ("-".equals(operator)) {
            result = operand1 - operand2;
        } else if ("*".equals(operator)) {
            result = operand1 * operand2;
        } else if ("/".equals(operator)) {
            if (operand2 != 0) {
                result = operand1 / operand2;
            } else {
                throw new ArithmeticException("Undefined");
            }
        }

        return result;
    }
}
