package Polymorphism.Calculator;

public class InputInterpreter {

    public int interpretLine(String line) {
        String[] lineSplit = line.split("\\s+");
        int result = 1;
        int number = -1;
        Operation operation = null;
        result = Integer.parseInt(lineSplit[0]);

        for (int i = 1; i < lineSplit.length; i++) {

            // end in the middle of sequence
            if (lineSplit[i].equals("end"))
                break;

            try {
                // a number

                if (!lineSplit[i].equals("mr"))
                    number = Integer.parseInt(lineSplit[i]);
                else {
                    number = MemorySafe.storedResults.pop();
                    if (operation == null)
                        result = number;
                }

                if (operation != null) {
                    result = operation.processOperation(result, number);
                    operation = null;
                }
            } catch (Exception exc) {
                // not a number
                String op = lineSplit[i];

                if (op.equals("ms"))
                    MemorySafe.storedResults.push(result);
                else if (op.equals("*"))
                    operation = new Multiplication();
                else if (op.equals("/"))
                    operation = new Division();
            }
        }
        return result;
    }
}
