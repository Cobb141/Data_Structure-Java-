package tree;

public class TriadiusMinHeap {
    private Elem[] heap;
    private int size;
    private int n;
    
    public TriadiusMinHeap(Elem[] h, int num, int max){
        heap = h;
        n = num;
        size = max;
        buildHeap();
    }

    public int heapSize(){ return n; }

    public boolean isLeaf(int pos){
        return (pos >= (n+1)/3) && (pos<n);
    }

    public int leftChild(int pos){
        // if(pos >= n/3){
        //     System.out.println("Position has no leftChild");
        //     return -1;
        // } 
        return 3 * pos + 1;
    }

    public int midChild(int pos){
        // if(pos >= (n-1)/3){
        //     System.out.println("Position has no midChild");
        //     return -1;
        // }
        return 3 * pos + 2;
    }

    public int rightChild(int pos){
        // if(pos >= (n-1)/3){
        //     System.out.println("Position has no rightChild");
        //     return -1;
        // }
        return 3 * pos + 3;
    }
     public int parent(int pos){
         if(pos<=0){
             System.out.println("Position has no parent");
             return -1;
         }
         return (pos - 1)/3;
     }

     public void buildHeap(){
         for(int i = (n+1)/3 - 1;i>=0;i--)
            siftdown(i);
     }

     public void siftdown(int pos){
         if(pos<0 || pos>=n){
            System.out.println("Illegal heap position");
            return;
         } 
         while(!isLeaf(pos)){
            int j = leftChild(pos);
            if((j<(n-1)) && (heap[j].key() > heap[j+1].key())){
                j++;
                if((j<(n-1)) && (heap[j].key() > heap[j+1].key()))
                    j++;
            }else if((j<(n-2)) && (heap[j].key() > heap[j+2].key())){
                j = j + 2;
            }     
            if(heap[pos].key() <= heap[j].key()) return;
            swap(heap, pos ,j);
            pos = j;
         }
     }
     private void swap(Elem[] h, int i, int j){
         Object temp = new Object();
         temp = h[i];
         h[i] = h[j];
         h[j] = (Elem)temp;
     }

     public void insert(Elem val){
        if(n>=size){
            System.out.println("heap is full");
            return;
        }
        int curr = n++;
        heap[curr] = val;
        while((curr!=0) && (heap[curr].key()<heap[parent(curr)].key())){
            swap(heap, curr, parent(curr));
            curr = parent(curr);
        }
        
     }

     public Elem removeMin(){
         if(n<=0){
             System.out.println("heap is empty");
             return null;
         }
         swap(heap, 0, --n);
         if(n!=0) siftdown(0);
         return heap[n];
     }

     public int getMin(){
         return heap[0].key();
     }

     public Elem delete(int pos){
        if(pos<0 || pos>=n){
            System.out.println("Illegal heap position");
            return null;
        }
        swap(heap, pos, --n);
        if(n!=0) siftdown(pos);
        return heap[n];
     }

     public void print(){
         for(int i=0;i<n;i++)
            System.out.print(heap[i].key() + " ");
        System.out.println();
     }

     public static void main(String[] args){
        Elem[] hl = new Elem01[20];
        hl[0] = new Elem01(1);
        hl[1] = new Elem01(7);
        hl[2] = new Elem01(6);
        hl[3] = new Elem01(2);
        hl[4] = new Elem01(3);
        hl[5] = new Elem01(8);
        hl[6] = new Elem01(3);
        MinHeap h = new MinHeap(hl, 7, 20);
        h.print();
        System.out.println(h.heapSize());
        h.removeMin();
        h.print();
        System.out.println(h.heapSize());
        h.insert(new Elem01(100));
        System.out.println(h.heapSize());
        h.print();
        System.out.println(h.getMin());
    }
}