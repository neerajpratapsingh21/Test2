import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test2 {
  //  Question 1: The Missing Seat Number
    // Time-Complexity - O(N)
    // Space-Complexity - O(1)
    public static int missingSeatNo(int[] nums){
        int  n = nums.length;
        long total = n*((n+1)/2);
        long sum = 0;
        for(int i : nums){
            sum+=i;
        }
        return (int)(total-sum);
    }
    //Question 2: Find the Best Pair of Students
    // Time-Complexity - O(N)
    // Space-Complexity - O(N)
    public static  int[] bestPair(int[] nums,int target){
        Map<Integer,Integer> seen = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int compliment = target - nums[i];
            if(seen.containsKey(compliment)){
                return  new int[]{seen.get(compliment),i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
    // Question 3: Find the Second-Highest Score
    // Time-Complexity - O(N)
    // Space-Complexity - O(1)
    public  static  int secondHighestScore(int[] nums){
        int largest = nums[0];
        int sLargest = -1;
        for(int i = 1; i<nums.length;i++){
            if(largest < nums[i]){
                sLargest = largest;
                largest = nums[i];
            }else if(nums[i] > sLargest && nums[i] < largest){
                sLargest = nums[i];
            }
        }
        return  sLargest;
    }
    //Question 4: Find the First Unique Letter
    // Time-Complexity - O(N)
    // Space-Complexity - O(N)
    public static  int firstUniqueLetter(String s){
        Map<Character,Integer> freq = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int  i = 0;i<s.length();i++){
            if(freq.get(s.charAt(i))  == 1) return  i;
        }
        return -1;
    }
    //Question 5: Find the First Repeated Roll Number
    // Time-Complexity - O(N)
    // Space-Complexity - O(N)
    public static boolean firstRepeatingRollNumber(int[] nums){
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return  false;
    }
    // Question 6: The Best Buy-and-Sell Day
    // Time-Complexity - O(N)
    // Space-Complexity - O(1)
    public static  int bestTimeToSell(int[] nums){
        int maxProfit = 0;
        int buy = nums[0];
        for(int i = 1; i< nums.length;i++){
            buy = Math.min(buy, nums[i]);
            maxProfit = Math.min(maxProfit, buy - nums[i]);
        }
        return  maxProfit;
    }
}