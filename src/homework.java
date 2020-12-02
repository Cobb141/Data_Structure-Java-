public class Homework {
    public static void swap(int[] list,int i,int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    } 
    
    public static double findMid(int[] array, int left,int right){
        if(array.length==1)return array[0];
        int i=left;
        for(int j=i+1;j<=right;j++){
            if(array[j]<array[left]){
                i++;
                swap(array,i,j);
            }
        }
        swap(array,left,i);
        if(i<array.length/2)return findMid(array,i+1,right);
        else if(i>array.length/2)return findMid(array,left,i-1);
        else{
            if(array.length%2!=0)return array[i];
            else{
                int l = array[0];
                for(int j=1;j<i;j++)
                    if(array[j]>l) l = array[j];
                return (double)(array[i] + l)/2;
            }
        }
    }
    public static void main(String[] args){
        int[] array = {1,4,7,2,3,6,5,8,10,9,12,11,13};
        System.out.println(findMid(array, 0, array.length-1));
    }
}

