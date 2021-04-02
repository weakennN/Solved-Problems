package Polymorphism.Calculator;

public class Division extends Operation {
    @Override
    public int processOperation(int currentResult, int value) {
        return currentResult / value;
    }
}
