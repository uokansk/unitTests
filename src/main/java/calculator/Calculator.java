package calculator;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return (double) a / b;
    }

    public double calculateDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("can't be");
        } else if (0 < purchaseAmount && purchaseAmount < 100) {
            throw new IllegalArgumentException("Discount should be in limits: [0, 100]");
        }
        return  purchaseAmount * (1 - (double) discountAmount / 100);
    }
}
