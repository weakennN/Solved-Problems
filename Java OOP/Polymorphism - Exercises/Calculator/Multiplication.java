package Polymorphism.Calculator;

public class Multiplication extends Operation{
    @Override
    public int processOperation(int currentResult, int value) {
        return currentResult * value;
    }
}
