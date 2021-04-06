// Created by WXX on 2021/4/6 15:35
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 具体分析参考：https://blog.csdn.net/weixin_42638946/article/details/114502760?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161769890016780255260256%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=161769890016780255260256&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_v2~rank_v29-1-114502760.nonecase&utm_term=%E6%A0%91%E7%8A%B6
/**
 * 执行用时：200 ms, 在所有 C++ 提交中击败了35.38%的用户
 * 内存消耗：11.8 MB, 在所有 C++ 提交中击败了70.56%的用户
 */
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>> &people) {

        // 按照第一维降序，第二维升序排列
        sort(people.begin(), people.end(), [](const vector<int> &a, const vector<int> &b) {
            if (a[0] == b[0]) return a[1] < b[1];
            return a[0] > b[0];
        });

        vector<vector<int>> res;
        for (auto &p : people) {
            res.insert(res.begin() + p[1], p);
        }

        return res;
    }
};

void OutputBasicArray2D1(vector<vector<int>> nums) {

    cout << "[";
    for (int i = 0; i < nums.size(); i++) {
        cout << "[";
        for (int j = 0; j < nums[i].size(); j++) {
            cout << nums[i][j];
            if (j != nums[i].size() - 1) cout << ", ";
        }
        cout << "]";
        if (i != nums.size() - 1) cout << ", ";
    }
    cout << "]" << endl;
}

int main() {

    vector<vector<int>> people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    OutputBasicArray2D1(Solution().reconstructQueue(people));

    return 0;
}
