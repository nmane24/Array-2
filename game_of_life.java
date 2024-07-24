// Apporach 1 
// Time Complexity : O(2*n*m) == O(n * m)  ... n = number of rows and m = number of columns          
// Space Complexity : O(1)   ..... hasmap is used to store data 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/game-of-life/
*/


/*
'dir' array is used to get index of neighbour in all eight directions.
Using temporary state change pattern as we want make changes in place.
Any live cell is becoming dead, we need to mark with a temporary number on board i.e -1
Any dead cell becoming live we mark it with -2.
*/


public class game_of_life {
    
}
