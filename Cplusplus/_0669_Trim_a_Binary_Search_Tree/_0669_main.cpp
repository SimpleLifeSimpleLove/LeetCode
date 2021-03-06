// Created by WXX on 2021/3/2 15:45
#include "MyTree.h"

using namespace std;

/**
 * 执行用时：16 ms, 在所有 C++ 提交中击败了91.00%的用户
 * 内存消耗：23.3 MB, 在所有 C++ 提交中击败了73.19%的用户
 */
class Solution {
public:
    TreeNode *trimBST(TreeNode *root, int low, int high) {

        if (!root) return nullptr;
        if (root->val < low) return trimBST(root->right, low, high);
        if (root->val > high) return trimBST(root->left, low, high);
        root->left = trimBST(root->left, low, high);
        root->right = trimBST(root->right, low, high);
        return root;
    }
};

int main() {

    int nu = INT_MAX;
    vector<int> nums = {
            3,
            0, 4,
            nu, 2, nu, nu,
            nu, nu, 1
    };
    TreeNode *root = MyTree(nums).getRoot();
    root = Solution().trimBST(root, 1, 3);
    OutputBasicArray2D1(MyTree().levelOrder(root));

    return 0;
}
