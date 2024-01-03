// This is done using basic BFS TECHNIQUE

//we need to reach from start to destination 
// we will be starting from start 
// we will be converting start to every possible node and check if this is a word that can be made , if it can be made then put it into the queue and remove (erase) from the hashset 
// in the queue , we woll be storing the word , with its number in it 
// then we will be removing the number and then change it to new new words , whchever word is present in hashset ,
//we remove it from set and put it in queue
// as soon as we encounter the popped word is equals end word , we return its number

class Pair{
    String word;
    int number;
    Pair(String word , int number){
        this.word=word;
        this.number=number;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(beginWord,1));
        HashSet<String> set= new HashSet();
        for(int i=0;i<wordList.size();i++)set.add(wordList.get(i));
        if(set.contains(beginWord))  set.remove(beginWord);
        if(!set.contains(endWord))return 0;
        
        while(!queue.isEmpty()){
            Pair popped = queue.remove();
            String word = popped.word;
            int number= popped.number;
            if(word.equals(endWord))return number;
            
           
            for(int i=0;i<word.length();i++){
            for(Character c= 'a'; c<='z';c++){
                
                StringBuilder str= new StringBuilder(word);
                char ch=str.charAt(i);
                str.setCharAt(i,c);
                
                if(set.contains(str.toString())){
                    set.remove(str.toString());
                    queue.add(new Pair (str.toString(),number+1));
                }
                str.setCharAt(i,ch);
             }
            }
          
            
        }
        return 0;
    }
    
}



