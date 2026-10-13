class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode *slow, *fast, *mid;
        slow = fast = head;

        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        mid = slow;

        ListNode* first = head;
        ListNode* second = reverse(mid);

        while (second != nullptr) {
            if (first->val != second->val)
                return false;

            first = first->next;
            second = second->next;
        }

        return true;
    }

    ListNode* reverse(ListNode* head) {
        ListNode *prev, *current, *nextnode;
        prev = nullptr;
        current = head;

        while (current != nullptr) {
            nextnode = current->next;
            current->next = prev;
            prev = current;
            current = nextnode;
        }

        return prev;
    }
};