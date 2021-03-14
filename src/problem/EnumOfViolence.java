package problem;

import java.util.Scanner;
public class EnumOfViolence {
    
    public static void print_permutation(int n, int[] arr, int curr){
        if(curr==n){
            for(int i : arr)
                System.out.print(i);
            System.out.println();
        }else{
            for(int i=1;i<=n;i++){
                boolean temp = true;
                for(int j=0;j<curr;j++){
                    if(i==arr[j]) temp = false;
                }
                if(temp){
                    arr[curr] = i;
                    print_permutation(n, arr, curr+1);
                } 
            }
        }
    }

    public static int lgCF922B(int n){
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                inner:for(int k=j;k<=n;k++){
                    if(!istriangle(i, j, k)) break inner;
                    if((i^j^k)==0 && istriangle(i, j, k)){
                        ans++;
                        //System.out.printf("%d %d %d\n",i,j,k);
                    }
                }
            }
        }
        return ans;
    }

    public static boolean istriangle(int a,int b,int c){
        if(((a+b)>c) && ((a+c)>b) && ((b+c)>a))
            return true;
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(lgCF922B(n));
        in.close();
    }
}