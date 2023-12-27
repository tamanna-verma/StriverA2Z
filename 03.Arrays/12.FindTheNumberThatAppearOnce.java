// way 1= we will be maintaining counts of each number in hashmap and return the 1 whose count is 1 

//way 2 = better approach 

// use the hashmap to check if the value is already present in the hashmap , 
//if it is , then remove the value from the hashmap , and remove the value which will be removing in the end in the hashmap 

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer> ();
        for ( int i=0;i< nums.length ;i++){
            int x = nums[i];
           if(!(set.contains(x)))  set.add(x);
            else set.remove(x);
        }
        
        Iterator<Integer> itr = set.iterator();
        if(itr.hasNext())
        { int value = itr.next();
           return value;
        } 
        return 0;
    }
}

// add(E e)	Used to add the specified element if it is not present, if it is present then return false.
// clear()	Used to remove all the elements from the set.
// contains(Object o)	Used to return true if an element is present in a set.
// remove(Object o)                                                           	Used to remove the element if it is present in set.
// iterator()	 Used to return an iterator over the element in the set.
// isEmpty()	Used to check whether the set is empty or not. Returns true for empty and false for a non-empty condition for set.
// size()	Used to return the size of the set.
// clone()                                         


//way 3 = optimal way , use the xor method , initially keep value of ans as 0 because something xor 0 is that number itself  

class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for (int i=0;i<nums.length;i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
