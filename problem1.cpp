#include<iostream>
#include<vector>
#include<queue>

using namespace std;

// time limit exceeded. Maybe Due To Bubble Down.

class Solution {
    void swap(int& a,int& b){
        int temp = a;
        a = b;
        b = temp;
    }
    int getParent(int a){
        if(a%2 == 0) return a/2-1;
        else return a/2;
    }

    //buble down
    void bubbleDown(vector<int>& arr,int parent){
        int n = arr.size();
        if(parent>n-1) return;
        int childLeft{2*parent+1};
        if(childLeft<n && !(arr.at(parent)<arr.at(childLeft))){
            swap(arr.at(parent),arr.at(childLeft));
            bubbleDown(arr,childLeft);
        }
        int childRight{2*parent+2};
        if(childRight<n && !(arr.at(parent)<arr.at(childRight))){
            swap(arr.at(parent),arr.at(childRight));
            bubbleDown(arr,childRight);
        }
        
    }

    //bubble up
    void bubbleUp(vector<int>& arr){
        int n = arr.size();
        int child = n-1;
        int parent = getParent(child);
        while(parent>=0 && !(arr.at(parent)<arr.at(child))){
            swap(arr.at(parent),arr.at(child));
            child = parent;
            parent = getParent(child);
        }
    }


    int getMin(const vector<int>& arr){
        return arr.at(0);
    }
    void removeMin(vector<int>& arr){
        int n = arr.size();
        swap(arr.at(0),arr.at(n-1));
        arr.pop_back();
        bubbleDown(arr,0);
    }
    void insert(vector<int>& arr,int val,int k){
        int n = arr.size();
        if(n<k){
            arr.push_back(val);
            bubbleUp(arr); // dont need bubble down after bubble up because topmost was smaller than both of them
            //hence if any one child is smaller it would be smaller than the other child too while bubble up.
        }
        else if(val>getMin(arr)){
            arr.push_back(val);
            removeMin(arr);
        }
        
    }
public:
    int findKthLargest(vector<int>& nums, int k) {
        vector<int> res;
        for(int& num:nums){
            insert(res,num,k);
        }
        return getMin(res);
    }
};

//Edited the part to comparare with both the children and bubbledown on the smallest one of them instead.

class Solution {
    void swap(int& a,int& b){
        int temp = a;
        a = b;
        b = temp;
    }
    int getParent(int a){
        if(a%2 == 0) return a/2-1;
        else return a/2;
    }

    //buble down
    void bubbleDown(vector<int>& arr,int parent){
        int n = arr.size();
        if(parent>n-1) return;
        int smallest = parent;
        int childLeft{2*parent+1};
        if(childLeft<n && !(arr.at(smallest)<arr.at(childLeft))){
            smallest = childLeft;
        }
        int childRight{2*parent+2};
        if(childRight<n && !(arr.at(smallest)<arr.at(childRight))){
            smallest = childRight;
        }
        if(smallest!=parent){
            swap(arr.at(smallest),arr.at(parent));
            bubbleDown(arr,smallest);
        }
        
    }

    //bubble up
    void bubbleUp(vector<int>& arr){
        int n = arr.size();
        int child = n-1;
        int parent = getParent(child);
        while(parent>=0 && !(arr.at(parent)<arr.at(child))){
            swap(arr.at(parent),arr.at(child));
            child = parent;
            parent = getParent(child);
        }
    }


    int getMin(const vector<int>& arr){
        return arr.at(0);
    }
    void removeMin(vector<int>& arr){
        int n = arr.size();
        swap(arr.at(0),arr.at(n-1));
        arr.pop_back();
        bubbleDown(arr,0);
    }
    void insert(vector<int>& arr,int val,int k){
        int n = arr.size();
        if(n<k){
            arr.push_back(val);
            bubbleUp(arr);
        }
        else if(val>getMin(arr)){
            arr.push_back(val);
            removeMin(arr);
        }
        
    }
public:
    int findKthLargest(vector<int>& nums, int k) {
        vector<int> res;
        for(int& num:nums){
            insert(res,num,k);
        }
        return getMin(res);
    }
};

// solving using priority queue

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        //default priority queue is max heap;
        //default priority queue priority_queue<int> pq;
        size_t gg = k-1;
        priority_queue<int,vector<int>,greater<int>> pq;
        for(int i{};i<k;++i) pq.push(nums.at(i));
        for(int i{k};i<nums.size();++i){
            if(nums.at(i)>pq.top()){
                pq.push(nums.at(i));
                pq.pop();
            }
        }
        return pq.top();
    }
};