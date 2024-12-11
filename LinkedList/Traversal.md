```cpp
class Node {
public:
    int data;    // Data stored in the node
    Node* next;  // Pointer to the next node

    // Constructor to initialize the node
    Node(int val) {
        data = val;
        next = nullptr;
    }
};

void traverseLinkedList(Node* head) {
    Node* temp = head;
    while (temp != nullptr) {
        std::cout << temp->data << " "; // Output: 1 2 3
        temp = temp->next;
    }
}

// Test cases
int main() {
    Node* head = new Node(1); // First node with data 1
    Node* second = new Node(2); // Second node with data 2
    Node* third = new Node(3); // Third node with data 3

    // Linking the nodes
    head->next = second; // Link first node to second node
    second->next = third; // Link second node to third node

    // Traversing the list
    traverseLinkedList(head);

    return 0;
}
