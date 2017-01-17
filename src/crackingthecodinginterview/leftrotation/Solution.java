package crackingthecodinginterview.leftrotation;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] result = new int[n];

        // Need to mod by n because it might be shifted more than n times, in which case the shifting will go all the way around again
        int startPos = n - (k % n);

        // index starts at the startPos and keep putting in a[pos] (starting at 0) until the end of the array.
        int pos = 0;
        for (int index = startPos; index < n; ++index) {
            result[index] = a[pos];
            ++pos;
        }

        // Start at the beginning of the result array and enter a[pos] values until the startPos.
        for (int index2 = 0; index2 < startPos; ++index2) {
            result[index2] = a[pos];
            ++pos;
        }

        // Print all the results
        System.out.print(result[0]);
        for (int i = 1; i < n; ++i) {
            System.out.print(" " + result[i]);
        }
    }
}
