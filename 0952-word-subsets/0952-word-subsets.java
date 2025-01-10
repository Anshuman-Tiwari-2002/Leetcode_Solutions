class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(String a: words2){
            char ch[] = a.toCharArray();
            HashMap<Character,Integer> temp = new HashMap<>();
            for(char c : ch ){
                temp.put(c , temp.getOrDefault(c,0)+1);
            }
            for(char c : temp.keySet()){
                map.put(c,Math.max(map.getOrDefault(c,0),temp.get(c)));
            }
        }
        for(String a : words1){
            char ch [] = a.toCharArray();
            HashMap<Character,Integer> mp = new HashMap<>();
            for(char c : ch){
                mp.put(c,mp.getOrDefault(c,0)+1);

            }
            boolean flag = true;
            for(char c: map.keySet()){
                if(mp.getOrDefault(c,0)<map.get(c)){
                flag = false;
                break;
                }
            }
            if(flag== true){
                list.add(a);
            }
        }
        return list;
        
    }
}