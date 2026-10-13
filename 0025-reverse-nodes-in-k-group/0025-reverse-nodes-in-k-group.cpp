class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {

        ListNode* temp = head;

        // Check whether k nodes are available
        for (int i = 0; i < k; i++) {
            if (temp == nullptr)
                return head;
            temp = temp->next;
        }

        // Reverse k nodes
        ListNode* prev = nullptr;
        ListNode* current = head;

        for (int i = 0; i < k; i++) {
            ListNode* nextnode = current->next;
            current->next = prev;
            prev = current;
            current = nextnode;
        }

        // Connect reversed group with remaining list
        head->next = reverseKGroup(current, k);

        return prev;
    }
};
