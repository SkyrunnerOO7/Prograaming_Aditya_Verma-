# Linked List Operations

Key Point: Never miss your node reference! Otherwise, you will lose your linked list.

## Insertion

### Function: `insertNode(Node* &head, int data, int position)`
This function inserts a new node with the given data at the specified position in the linked list.

### Example Usage:
```cpp
void insertNode(Node* &head, int data, int position) {
    Node* newNode = new Node(data);
    if (position == 0) {
        newNode->next = head;
        head = newNode;
    } else {
        Node* prev = head;
        for (int i = 0; i < position - 1; i++) {
            prev = prev->next;
        }
        newNode->next = prev->next;
        prev->next = newNode;
    }
}

// Example usage:
int main() {
    Node* head = new Node(5);
    head->next = new Node(10);
    head->next->next = new Node(5);
    head->next->next->next = new Node(24);
    head->next->next->next->next = new Node(40);

    insertNode(head, 30, 3);

    // Print the updated linked list
    Node* temp = head;
    while (temp != nullptr) {
        std::cout << temp->data << " ";
        temp = temp->next;
    }

    return 0;
}
```

### Expected Output After Insertion:

```
5 -> 10 -> 5 -> 30 -> 24 -> 40
```

## Deletion

### Function: `deleteNode(Node*& head, int pos)`
This function deletes a node at the specified position in the linked list.

### Example Usage:

```cpp

#include <iostream>

// Definition of a Linked List Node
struct Node {
    int data;
    Node* next;

    Node(int val) {
        data = val;
        next = nullptr;
    }
};

// Function to delete a node at a given position
void deleteNode(Node*& head, int pos) {
    if (head == nullptr) {
        // If the list is empty, there's nothing to delete
        return;
    }

    if (pos == 0) {
        // Deleting the head node
        Node* temp = head;      // Store the current head
        head = head->next;      // Move head to the next node
        delete temp;            // Free the old head node's memory
        return;
    }

    Node* curr = head;
    for (int i = 0; curr != nullptr && i < pos - 1; i++) {
        curr = curr->next;
    }

    if (curr == nullptr || curr->next == nullptr) {
        // If position is out of bounds (greater than the list size)
        return;
    }

    Node* temp = curr->next;    // Node to be deleted
    curr->next = curr->next->next; // Unlink the node from the linked list
    delete temp;                // Free memory
}

// Function to print the linked list
void printList(Node* head) {
    Node* temp = head;
    while (temp != nullptr) {
        std::cout << temp->data << " ";
        temp = temp->next;
    }
    std::cout << std::endl;
}

// Main function to test the deleteNode function
int main() {
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    Node* head = new Node(1);
    head->next = new Node(2);
    head->next->next = new Node(3);
    head->next->next->next = new Node(4);
    head->next->next->next->next = new Node(5);

    std::cout << "Original List: ";
    printList(head);

    // Test case 1: Deleting the head node (position 0)
    deleteNode(head, 0);
    std::cout << "After deleting position 0: ";
    printList(head); // Expected output: 2 3 4 5

    // Test case 2: Deleting a middle node (position 2)
    deleteNode(head, 2);
    std::cout << "After deleting position 2: ";
    printList(head); // Expected output: 2 3 5

    // Test case 3: Deleting the last node (position 2 after previous deletions)
    deleteNode(head, 2);
    std::cout << "After deleting position 2 (last node): ";
    printList(head); // Expected output: 2 3

    // Test case 4: Deleting a node at an out-of-bounds position (position 10)
    deleteNode(head, 10);
    std::cout << "After trying to delete position 10 (out-of-bounds): ";
    printList(head); // Expected output: 2 3 (no change)

    // Test case 5: Deleting the remaining nodes
    deleteNode(head, 0);
    deleteNode(head, 0);
    std::cout << "After deleting all nodes: ";
    printList(head); // Expected output: (empty list)

    return 0;
}

```