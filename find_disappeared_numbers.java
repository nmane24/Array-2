
// Approach 1
// Time Complexity : O(n)  ... n is number of elements in given array           
// Space Complexity : O(n)   ..... hasmap is used to store data 
//
// Approach 2 (Optimization in space)
// Time Complexity : O(n)  ... n is number of elements in given array           
// Space Complexity : O(1)   // as we used in place temporary state change
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]

Code Explanation
Approach 1 : Sort the array and then maintain a current variable  starting from 1 and a pointer variable 
which can check if that unique number is present
If present increment the curr by 1 and move the pointer to the unique element , as we encounter the numbers keep moving the pointer vairable
to next unique number and also increment the curr.
If the pointer is moved to next unique number and curr are not equal , then whatever is present in curr is added to list respresnting the 
missing number. We increment the curr by 1 but we do not move the pointer as the elenent did not match with curr in last pass. 

Time Complexity aprroach 1 : nlogn ( log n for the sorting and n for lenght of array)
Space complexity: O(1)

Aprroach 2 (Optimized approach using hashset)
Store everything in hashset

[4,3,1,7,2,8,2,1]
HS = [4, 3, 1, 7, 2, 8]
Again we maintain a curr variable and keep checking in hashset and for missing numbers we encounter we record it

Time Complexity : O(n)
Space : O(n) ; space is for the set


Aprroach 3 (Optimized approach Using array)
Take an array of same size as original elements, whatever is the element try to map it at the same index into the array
[4,3,1,7,2,8,2,1]

New Array
With Value  :   1   2   3   4   0   0   7   8
Index           0   1   2   3   4   5   6   7  

Whichever value is 0 is the missig number above.


Approach 4 : To save space utilized in hashset or array approach

In place optimizaiton on array , by marking the values negative checking with index. And whichever numbers are not negative would be the missing 
elements

Time Complexity : O(n) + ,:  O(n) + O(n) : 1 Pass in which we are making the elements negative and another O(n) 2nd pass for checking which
elements are missing : O(2n) = O(n)
Space : O(1) 

array = [4  3  1  7  2   8   2  1]
Below pattern is known as temporary state change pattern

Array
Value                       1   2   3   4   5   6   7   8
Actual Array Placement      -4  -3  -1  -7  2   8   -2  -1
Index                       0   1   2   3   4   5   6   7

The element at which we are interating lets say 4, we will go to index 3 and make the element at index 3 negative.
After we get the index where we have to go and make the element, we need to pre check that is the element already not negative. Also note
if the element is already negative, it means duplicate must be existing there and I dont have to do anything there. 
In next pass/ one more iteration (different for loop), we check where 
the numbers are positive and that index + 1 are nothing but the original elements.


*/

import java.util.ArrayList;
import java.util.List;

public class find_disappeared_numbers {
    // Using in place optimization in array using temporary state change pattern
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        for (int i = 0 ; i<n; i++){         //iterate over the array for getting the element; subtract - 1 to mapp index and make the ele -ve
              int idx = Math.abs(nums[i]) - 1; // get the element , by subtracting 1 from it.
              if(nums[idx] > 0){    // check if the element is positive then only make it negative, if already negative do nothing
                nums[idx] *= -1;
              }
        }

        for(int i =0; i<n; i++){        // 2nd iteration to retrieve the missing numbers & make positive the original ones
            if(nums[i] > 0){
                result.add(i+1);        // retrieving as it is positive indicating those are missing numbers.
            }
            else{
                nums[i]*= -1;           // making them positive again.
            }
        }
        return  result;
    }
    
}
