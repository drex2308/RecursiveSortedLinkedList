/**
 * SortedLinkedList Implementation with Recursion.
 *
 * @author Dhanush Venkataramu
 */
public class SortedLinkedList implements MyListInterface {
    /**
     * Instance variable head, pointing to start of my LinkedList.
     */
    private Node head;
    /**
     * Constructor for the class with no-args.
     */
    SortedLinkedList() {
        head = null;
    }
    /**
     * Constructor with array of words to be inserted in sorted LL.
     * @param arr specifies the array with unsorted words.
     */
    SortedLinkedList(String[] arr) {
        head = null;
        addArray(arr, 0);
    }
    /**
     * Implementation to add strings to sorted LL.
     */
    @Override
    public void add(String value) {
        if (!validate(value)) {
            return;
        }
        if (contains(value)) {
            return;
        }
        if (head == null || head.data.compareTo(value) > 0) {
            head = new Node(value, head);
            return;
        }
        sortedAdd(value, head);
    }
    /**
     * Implementation to return size of the sorted LL.
     */
    @Override
    public int size() {
        Node cur = head;
        return findCount(cur);
    }
    /**
     * Implementation to display the elements in sorted LL.
     */
    @Override
    public void display() {
        System.out.print("[");
        recurDisplay(head);
        System.out.println("]");
    }
    /**
     * Implementation to search for key in sorted LL.
     */
    @Override
    public boolean contains(String key) {
        return linearFind(key, head);
    }
    /**
     * Implementation to check if LL is empty.
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
    /**
     * Implementation to remove first element in sorted LL.
     */
    @Override
    public String removeFirst() {
        String remData;
        if (isEmpty()) {
            return null;
        }
        if (head.next == null) {
            remData = head.data;
            return remData;
        }
        remData = head.data;
        head = head.next;
        return remData;
    }
    /**
     * Implementation to remove element at index of sorted LL.
     */
    @Override
    public String removeAt(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index >= size()) {
            throw new RuntimeException("invalid input for removeAt()");
        }
        if (index == 0) {
            String remData = head.data;
            head = head.next;
            return remData;
        }
        Node prev = null;
        Node cur = head;
        return removeRecur(index, prev, cur);
    }
    /**
     * helper method to recursively finding size of sorted LL.
     * @param cur specifies the traversing node of sorted LL. Initially head.
     * @return the total nodes in sorted LL to size() method.
     *
     * Recursion details:
     * Base case: cur node is null, reached end of LL, add zero.
     * Recursion Case: increment 1 and
     * pass link to next node on each recursive call till we hit base case.
     */
    private int findCount(Node cur) {
        if (cur == null) {
            return 0;
        }
        return 1 + findCount(cur.next);
    }
    /**
     * Helper method to search the key in sorted LL recursively in linear fashion.
     * @param key specifies the key being searched.
     * @param cur specifies the traversing node during search.
     * @return true if key found, false if not found.
     *
     * Recursion details:
     * Base case: 1) cur node is null (not found),
     * 2) data of current node equals key value.
     * Recursion case: pass the key and next node on each pass till we hit base case.
     */
    private boolean linearFind(String key, Node cur) {
        if (cur == null) {
            return false;
        }
        if (cur.data.equals(key)) {
            return true;
        }
        return linearFind(key, cur.next);
    }
    /**
     * Helper method to add the element in its position in sorted array recursively.
     * @param value specifies the string value to be added.
     * @param cur specifies the traversing node during add operation.
     *
     * Recursion Details:
     * Base Case: if cur is null (end of LL) or data of cur is greater than new value,
     * add element before the current node position.
     * Recursion case: pass the next node on each pass and key to compare
     * till we hit base case.
     */
    private void sortedAdd(String value, Node cur) {
        if (cur.next == null || cur.next.data.compareTo(value) > 0) {
            cur.next = new Node(value, cur.next);
            return;
        }
        sortedAdd(value, cur.next);
    }
    /**
     * Helper method to add all elements in array passed to constructor recursively.
     * @param arr specifies the array containing elements to be added.
     * @param index specifies the index of element being added.
     *
     * Recursion Details:
     * Base Case: if reach end of input array, return to original method.
     * Recursion Case: add current array element to list,
     * pass the index to next element to next call, till we reach arr end.
     */
    private void addArray(String[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        add(arr[index]);
        addArray(arr, index + 1);
    }
    /**
     * Helper method to check the validity of string being added to sorted LL.
     * @param str string object to be checked.
     * @return true if it is a word, false if null,not word or empty.
     */
    private boolean validate(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-z]+$");
    }
    /**
     * Helper method to display all elements in list recursively.
     * @param cur specifies the current transit node during display operation.
     *
     * Recursion Details:
     * Base Case: cur node is null (end of list),
     * print the element with no space.
     * Recursion Case: print node data and comma with space for readability,
     * pass the next node to be printed to recursive call till we reach end.
     */
    private void recurDisplay(Node cur) {
        if (cur.next == null) {
            System.out.print(cur.data);
            return;
        }
        System.out.print(new StringBuilder().append(cur.data).append(", ").toString());
        recurDisplay(cur.next);
    }
    /**
     * Helper method to remove the element at index in sorted LL.
     * @param index specifies the index of the element to be deleted. Decreases recursively.
     * @param prev specifies the node previous to current node being traversed.
     * @param cur specifies the current node being traversed during remove operation.
     * @return the string object of the node being deleted to removeAt() method.
     *
     * Recursion Details:
     * Base Case: if index has decremented to zero,
     * remove the cur element at this LL position, return string object to caller.
     * Recursion Case: pass the link to next node and
     * decremented index to next recursive call, until we hit index is zero.
     * The bounds are checked in the initial caller method.
     */
    private String removeRecur(int index, Node prev, Node cur) {
        if (index == 0) {
            String remData = cur.data;
            prev.next = cur.next;
            return remData;
        }
        return removeRecur(index - 1, cur, cur.next);
    }
    /**
     * Static nested class for Node in sorted LL.
     */
    private static class Node {
        /**
         * instance variable for the data in each Node.
         */
        private String data;
        /**
         * instance variable for the link to next node in each Node.
         */
        private Node next;
        /**
         * Constructor for creating new Node.
         * @param newData specifies the data to be stored in Node.
         * @param newNext specifies the link to the next node of the Node.c
         */
        Node(String newData, Node newNext) {
            data = newData;
            next = newNext;
        }
    }
}
