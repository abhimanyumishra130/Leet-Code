/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i])+1);
            }else map.put(words[i],1);
        }
        
        System.out.print(map);
        int ind =0;
        String[] str = new String[map.size()];
        int[] count = new int[map.size()];
        
        for(Map.Entry<String, Integer> m:map.entrySet()){
            str[ind] = m.getKey();
            count[ind] = m.getValue();
            ind++;
        }
        
        sortArrays(str, count);
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<k; i++) list.add(str[i]);
        return list;
    }
    
    public void sortArrays(String[] str, int[] count){
        for(int i=0; i<str.length; i++){
            for(int j=0; j<str.length-i-1; j++){
                if(count[j] < count[j+1]){
                    int t = count[j];
                    count[j] = count[j+1];
                    count[j+1] = t;
                    
                    String s = str[j];
                    str[j] = str[j+1];
                    str[j+1] = s;
                }else if(count[j] == count[j+1]){
                    if(str[j].compareTo(str[j+1])>0){
                        String s = str[j];
                        str[j] = str[j+1];
                        str[j+1] = s;
                    }
                }
            }
        }
    }
}
