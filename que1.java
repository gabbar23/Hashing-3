Time Complexity (TC): O(n)
Space Complexity (SC): O(n)

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10; // Length of the DNA sequence we're looking for
        if (s.length() < L) return new ArrayList<>(); // Edge case: if the string is shorter than 10
        
        // Base for rolling hash (arbitrary, 4 works because we have 4 unique characters A, C, G, T)
        int base = 4;
        // Map characters to unique integers (e.g., A -> 0, C -> 1, G -> 2, T -> 3)
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        //power
        long power=(long)Math.pow(base,L);
        long hash=0;
        HashSet<Long>seen=new HashSet<>();
        HashSet<String>res=new HashSet<>();
        for(int i=0;i<s.length();i++){
            hash=hash*base +map.get(s.charAt(i));
            //if i is past atleast 10 characters 
            if(i>=L-1){
                if(i>=L){
                    hash=hash-power*map.get(s.charAt(i-L));
                }
                
                    if(seen.contains(hash)){
                        res.add(s.substring(i-L+1,i+1));
                    }
                    else{
                        seen.add(hash);
                    }
                
            }
        }

       
        
        // Convert the result set to a list and return
        return new ArrayList<>(res);
    }
}
