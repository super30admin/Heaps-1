//
// Created by shazm on 8/9/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <priority_queue>

using namespace std;

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<int,vector<int>,greater<int>> queue;
        for(vector<int> i : matrix){
            for(int j : i){
                queue.push(j);
            }
        }
        int temp = k;
        while(temp>1){
            queue.pop();
            temp--;
        }
        return queue.top();
    }
};