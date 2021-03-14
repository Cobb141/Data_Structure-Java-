package problem;

import java.util.*;
public class DP02 {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int maxV = 100000;
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<=i;j++)
                matrix[i][j] = in.nextInt();
                
        int[][] state = new int[matrix.length][matrix.length];
        state[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) state[i][j] = state[i - 1][j] + matrix[i][j];
                else if (j == matrix[i].length - 1) state[i][j] = state[i - 1][j - 1] + matrix[i][j];
                else {
                    int top1 = state[i - 1][j - 1];
                    int top2 = state[i - 1][j];
                    state[i][j] = Math.max(top1, top2) + matrix[i][j];
                }
            }
        }
        int maxDis = -1;
        for (int i = 0; i < matrix[matrix.length - 1].length; i++) {
            int distance = state[matrix.length - 1][i];
            if (distance > maxDis) maxDis = distance;
        }
        System.out.print(maxDis);

        in.close();
    }
}