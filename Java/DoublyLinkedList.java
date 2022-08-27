class DoublyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    public void setHead(Node<T> node) {
        if (node == head)
            return;
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        insertBefore(head, node);
    }

    public void setTail(Node<T> node) {
        if (node == tail)
            return;
        if (tail == null) {
            head = node;
            tail = node;
            return;
        }
        insertAfter(tail, node);
    }

    public void insertBefore(Node<T> node, Node<T> nodeToInsert) {
        if (node.prev == nodeToInsert)
            return;

        remove(nodeToInsert);
        nodeToInsert.next = node;
        nodeToInsert.prev = node.prev;
        if (node.prev != null) {
            node.prev.next = nodeToInsert;
        } else {
            head = nodeToInsert;
        }
        node.prev = nodeToInsert;
    }

    public void insertAfter(Node<T> node, Node<T> nodeToInsert) {
        if (node.next == nodeToInsert)
            return;

        remove(nodeToInsert);
        nodeToInsert.next = node.next;
        nodeToInsert.prev = node;
        if (node.next != null) {
            node.next.prev = nodeToInsert;
        } else {
            tail = nodeToInsert;
        }
        node.next = nodeToInsert;
    }

    public void insertAtPosition(int position, Node<T> nodeToInsert) {
        if (head == null) {
            head = nodeToInsert;
            tail = nodeToInsert;
            return;
        }

        Node<T> positionNode = head;
        for (int i = 1; i < position & positionNode != null; ++i) {
            positionNode = positionNode.next;
        }
        insertBefore(positionNode, nodeToInsert);
    }

    public void removeNodesWithValue(T value) {
        Node<T> currentNode = head, previousNode;
        while (currentNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            if (previousNode.value == value)
                remove(previousNode);
        }
    }

    public void remove(Node<T> node) {
        if (node == head)
            head = head.next;
        if (node == tail)
            tail = tail.prev;

        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;

        node.next = node.prev = null;
    }

    public boolean containsNodeWithValue(T value) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public void print() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}