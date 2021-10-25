package DynamicProgramming;

public class FibonacciTabulation {

    public static void main(String[] args) {

        int n = 6;
        int[] tabulation = new int[n + 1];
        tabulation[1] = 1;

        for (int i = 2;i <= n;i++){
            tabulation[i] = tabulation[i - 1] + tabulation[i - 2];
        }

        System.out.println(tabulation[n]);
    }
}
