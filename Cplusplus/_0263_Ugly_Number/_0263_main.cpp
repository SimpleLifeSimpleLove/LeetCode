// Created by WXX on 2021/1/29 20:14
#include <iostream>

using namespace std;

/**
 * 执行用时：4 ms, 在所有 C++ 提交中击败了43.46%的用户
 * 内存消耗：5.7 MB, 在所有 C++ 提交中击败了97.61%的用户
 */
class Solution {
public:
    bool isUgly(int num) {

        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
};

int main() {

    cout << Solution().isUgly(6) << endl;  // true
    cout << Solution().isUgly(8) << endl;  // true
    cout << Solution().isUgly(14) << endl;  // false

    return 0;
}
