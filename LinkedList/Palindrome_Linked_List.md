# 234. Palindrome Linked List

## Problem Statement

    Given the head of a singly linked list, return **true** if it is a palindrome.

## Example

- **Input:** head = [1,2,2,1]
- **Output:** true

## Explanation

1. **Find the Middle:** First, we find the middle of the linked list to divide it into two halves.
2. **Reverse the First Half:** Then, we reverse the first half of the linked list.
3. **Compare Values:** After that, we compare the values of the first and second halves.
4. **Check Completion:** We continue this process until the second half reaches the end. If it does, we return **true**; otherwise, we return **false**.

## Approach

- Use the **two-pointer technique** to find the middle of the list.
- Reverse the second half of the list.
- Compare the two halves for equality.

## Complexity Analysis

- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1), as we are using a constant amount of space.

```cpp
class Solution {
public:
    ListNode* reverse(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* forw = nullptr;

        while (curr != nullptr) {
            forw = curr->next;
            curr->next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    bool isPalindrome(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return true;
        }

        ListNode* fast = head;
        ListNode* slow = head;

        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }

        slow = reverse(slow);
        ListNode* secondHalf = slow;

        while (slow != nullptr) {
            if (head->val != slow->val) {
                return false;
            }
            head = head->next;
            slow = slow->next;
        }

        return true;
    }
};
```
