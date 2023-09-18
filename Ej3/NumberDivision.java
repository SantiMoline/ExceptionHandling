package Ej3;

public class NumberDivision {
    private int num1;
    private int num2;


    public NumberDivision(int num1, int num2) {
        setNum1(num1);
        setNum2(num2);
    }

    public int getNum1() {
        return this.num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return this.num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;

    }

    public int division() throws ArithmeticException {
        return num1 /num2;
    }
}
