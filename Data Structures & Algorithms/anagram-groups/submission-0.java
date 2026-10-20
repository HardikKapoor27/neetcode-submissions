class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Create a map where the Key is the sorted word, and the Value is the list of anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();

        // 2. Iterate through each word in the input array
        for (String word : strs) {
            // Sort the word to create the unique anagram key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            // 3. If the key doesn't exist yet, initialize a new list for it
            if (!anagramMap.containsKey(sortedKey)) {
                anagramMap.put(sortedKey, new ArrayList<>());
            }

            // 4. Add the original word to its matching anagram group
            anagramMap.get(sortedKey).add(word);
        }

        // 5. Return all the grouped lists
        return new ArrayList<>(anagramMap.values());
    }
}
