package tree;

public class LettFreq {
        private char lett = '#';
        private int freq;
    
        public LettFreq(){
        }
        public LettFreq(int f, char l){
            freq = f;
            lett = l;
        } 
        public LettFreq(int f){ freq = f; }
        public int weight(){ return freq; }
        public char letter(){ return lett; }
}