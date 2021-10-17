import java.util.Scanner;

public class LongestCommonSubsequenceDP {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstWord = scan.nextLine();
        String secondWord = scan.nextLine();

        int[][] lcs = new int[firstWord.length() + 1][secondWord.length() + 1];

        for (int i = 1; i < lcs.length; i++) {
            for (int j = 1; j < lcs[0].length; j++) {
                if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        System.out.println(lcs[lcs.length - 1][lcs[0].length - 1]);
    }
}
