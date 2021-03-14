package problem;

import java.util.*;
public class temp {
    
    public static int findMax(double[] den){
        double max = -1;
        int maxIndex = 0;
        for(int i=0;i<den.length;i++){
            if(den[i]>max){
                max = den[i];
                maxIndex = i;
            } 
        }
        return maxIndex;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t, m;
        t = in.nextInt();
        m = in.nextInt();
        int[] times = new int[m];
        int[] values = new int[m];
        double[] den = new double[m];
        double t1,t2;
        for(int i=0;i<m;i++){
            times[i] = in.nextInt();
            values[i] = in.nextInt();
            t1 = times[i];
            t2 = values[i];
            den[i] = t2/t1;
        }
        int ans = 0;
        double max = -1;
        int maxIndex = 0;
        maxIndex = findMax(den);
        max = den[maxIndex];
        while(t>0){
            if(den[maxIndex]==-1) break;
            if((t-times[maxIndex])>=0){
                ans += values[maxIndex];
                t = t - times[maxIndex];
            }else{
                den[maxIndex] = -1;
                maxIndex = findMax(den);
            }
        }
        System.out.println(ans);
        in.close();
    }
}