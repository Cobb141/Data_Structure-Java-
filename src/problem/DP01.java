package problem;

import java.util.*;
public class DP01 {   
    //使用二维数组实现
    public static int dp1(int[] times, int[] values, int M, int T){
        int[][] state = new int[M][T+1];
        for(int i=0;i<M;i++){
            for(int j=0;j<T+1;j++){
                state[i][j] = -1;
            }
        }
        state[0][0] = 0;
        if(times[0]<=T){
            state[0][times[0]] = values[0];
        }
        for(int i=1;i<M;i++){
            for(int j=0;j<=T;j++){
                if(state[i-1][j]>=0)
                    state[i][j] = state[i-1][j];
            }
            for(int j=0;j<=T-times[i];j++){
                if(state[i-1][j]>=0){
                    int temp = state[i-1][j] + values[i];
                    if(state[i][j+times[i]]<temp){
                        state[i][j+times[i]] = temp;
                    }
                }
            }
        }
        int maxValue = -1;
        for(int i=0;i<=T;i++){
            if(state[M-1][i]>maxValue)
                maxValue = state[M-1][i];
        }
        return maxValue;
    }

    //使用一维数组实现
    public static int dp2(int[] times, int[] values, int M, int T){
        int[] state = new int[T+1];
        for(int j=0;j<T+1;j++){
                state[j] = -1;
        }
        
        state[0] = 0;
        if(times[0]<=T){
            state[times[0]] = values[0];
        }
        for(int i=1;i<M;i++){
            for(int j=T-times[i];j>=0;j--){
                if(state[j]>=0){
                    int temp = state[j] + values[i];
                    if(state[j+times[i]]<temp){
                        state[j+times[i]] = temp;
                    }
                }
            }
        }
        int maxValue = -1;
        for(int i=0;i<=T;i++){
            if(state[i]>maxValue)
                maxValue = state[i];
        }
        return maxValue;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T, M;
        T = in.nextInt();
        M = in.nextInt();
        int[] times = new int[M];
        int[] values = new int[M];
        for(int i=0;i<M;i++){
            times[i] = in.nextInt();
            values[i] = in.nextInt();
        }

        int ans;
        ans = dp2(times, values, M, T);
        System.out.print(ans);
        in.close();
    }
}