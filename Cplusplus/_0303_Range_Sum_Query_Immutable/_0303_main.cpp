// Created by WXX on 2021/1/31 20:10
#include <iostream>
#include <vector>

using namespace std;

class NumArray {
public:

    vector<int> s;

    NumArray(vector<int> &nums) {

        int n = nums.size();
        s.resize(n + 1);
        for (int i = 0; i < n; i++) s[i + 1] = s[i] + nums[i];
    }

    int sumRange(int i, int j) {
        i++, j++;
        return s[j] - s[i - 1];
    }
};

int main() {

    vector<int> nums = {-2, 0, 3, -5, 2, -1};
    NumArray t = NumArray(nums);
    cout << t.sumRange(0, 2) << endl;  // 1
    cout << t.sumRange(2, 5) << endl;  // -1
    cout << t.sumRange(0, 5) << endl;  // -3

    return 0;
}
