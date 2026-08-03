class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> anagrams = new ArrayList();
        Map<String, List<String>> anagramMap = new HashMap<>();
        int[] frequencyArr = new int[26];

        for (String str : strs) {
            // reset frequency array before use
            Arrays.fill(frequencyArr, 0);

            for (int i=0; i<str.length(); i++) {
                frequencyArr[str.charAt(i)-'a']++;
            }

            String anagramKey = Arrays.toString(frequencyArr);

            if (!anagramMap.containsKey(anagramKey)) {
                anagramMap.put(anagramKey, new ArrayList<String>());
            }

            anagramMap.get(anagramKey).add(str);
        }

        for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
            anagrams.add(entry.getValue());
        }

        return anagrams;
    }
}
