package me.algo.leetcode;

public class SortCharactesByFrequency {
    public String frequencySort(String s) {
        int len = s.length();
        // Assuming Extended ASCII encoding.
        int[] freq = new int[256];

        // Step 1: Store freq of each character. c:3, r:2, w:2, t:1
        // And finding max vertical bucket levels.
        int bucketLevel = 0;
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i)]++;

            bucketLevel = Math.max(bucketLevel, freq[s.charAt(i)]);
        }

        // Step 2: Prepare multi storage bucket.
        // With each storage level characters with same frequency.
        StringBuilder[] bucketBuilder =
                new StringBuilder[bucketLevel + 1];

        for (int i = 0; i < bucketBuilder.length; i++) {
            bucketBuilder[i] = new StringBuilder();
        }
        // Step 3: bucket[3] = c , bucket[2] = rw , bucket[1] = t
        for (int i = 0; i < 256; i++) {

            int elemFreq = freq[i];
            if (elemFreq > 0) {
                bucketBuilder[elemFreq].
                        append((char) (i));
            }

        }

        // Step 4: Merge elements with same freq/bucket level in ans.
        StringBuilder ans = new StringBuilder();
        for (int i = bucketLevel; i > 0; i--) {

            char[] levelChars = bucketBuilder[i].
                    toString().toCharArray();

            for (char levelChar : levelChars) {

                for (int k = 0; k < i; k++) {
                    ans.append(levelChar);
                }

            }

        }

        return ans.toString();
    }
}
