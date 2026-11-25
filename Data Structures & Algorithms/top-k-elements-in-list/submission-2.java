// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {

//         int [] res = new int[k];

//         Map<Integer,Integer> map = new HashMap<>();

//         for(int i : nums){
//             map.put(i , map.getOrDefault(i,0)+1);
//         }

//         LinkedHashMap<Integer , Integer> ordr = new LinkedHashMap<>();

//         map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> ordr.put(x.getKey(), x.getValue()));

//         for(int n :  ordr.keySet()){
//             res[res.length - (k--)] = n;

//             if(k == 0){
//                 break;
//             }
//         }

//         return res;
//     }
// }



class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return map.entrySet()
                  .stream()
                  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                  .limit(k)
                  .mapToInt(Map.Entry::getKey)
                  .toArray();
    }
}
