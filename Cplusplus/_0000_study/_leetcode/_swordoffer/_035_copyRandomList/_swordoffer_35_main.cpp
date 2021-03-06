// Created by WXX on 2021/7/19 14:55
#include <iostream>

using namespace std;

class Node {
public:
    int val;
    Node *next;
    Node *random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

class Solution {
public:
    Node *copyRandomList(Node *head) {

        for (auto p = head; p; p = p->next->next) {  // 复制一个小弟
            auto q = new Node(p->val);
            q->next = p->next;
            p->next = q;
        }

        // 复制random指针
        for (auto p = head; p; p = p->next->next)
            if (p->random)
                p->next->random = p->random->next;  // p的小弟的random 指向 p的random的小弟

        // 拆分成两个链表
        auto dummy = new Node(-1), cur = dummy;
        for (auto p = head; p; p = p->next) {
            auto q = p->next;
            cur->next = q, cur = q;
            p->next = q->next;
        }
        return dummy->next;
    }
};
