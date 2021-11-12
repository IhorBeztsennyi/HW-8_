public class MyLinkedList {
    private Node head;
    private Node tail;
    int size = 0;

    private static class Node {
        Object object;
        Node next;
        Node previous;

        public Node(Object element) {
            this.object = element;
        }

        public Object getObject() {
            return object;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = null;
            newNode.previous = null;
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;

    }

    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node element = getNode(index);
            Node nodeBefore = getPrevious(element);
            if (nodeBefore == null) {
                head = head.next;
                size--;
            } else  {
                if (tail.object == element) {
                    nodeBefore.next = null;
                    tail = nodeBefore;
                } else {
                    nodeBefore.next = nodeBefore.next.next;
                }
                size--;
            }
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(int index){
        Node node = getNode(index);
        return node.getObject();
    }

    private Node getNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (head == null) {
            throw new IndexOutOfBoundsException();

        }
        if (index == 0) {
            return head;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Node getPrevious(Object value) {
        if (head.object == value) {
            return new Node(value);
        }
        Node node = head;
        while (node.next != null) {
            if (node.next.object == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
