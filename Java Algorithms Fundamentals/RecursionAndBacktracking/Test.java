package RecursionAndBacktracking;

public class Test {

    private static int[] arr = {1, 2, 3,4};

    public static void main(String[] args) {

        solution(0);
    }

    private static void solution(int index) {

        if (index >= arr.length) {

            print();
            return;
        }

        for (int i = index; i < arr.length; i++) {

            swap(i, index);
            solution(index + 1);
            swap(i, index);
        }
    }

    private static void print() {

        for (int i = 0;i < arr.length;i++){

            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    private static void swap(int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
