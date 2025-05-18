public class Exercises {
    /**
     * Returns a count of how many nodes are in the linked list.
     * 
     * Returns 0 if head is null.
     * 
     * Example: 
     * Input: 9 -> 2 -> 10 -> 1
     * Output: 4
     * 
     * @param head the head of the linked list
     * @return the length of the list
     */
    public static int length(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Adds a new value to the front of the list and returns the new head.
     * 
     * Example:
     * head: 7 -> 6 -> 0
     * toAdd: 4
     * 
     * Output: 4 -> 7 -> 6 -> 0
     * 
     * @param head the head of the linked list
     * @param toAdd the value to add to the front
     * @return the new head of the linked list
     */
    public static ListNode prepend(ListNode head, int toAdd) {
        return new ListNode(toAdd, head);
    }

    /**
     * Removes the last element in the linked list and returns the head.
     * 
     * If head is null or the only element in the list, returns null.
     * 
     * Example:
     * Input: 6 -> 4 -> 9 -> 2
     * Output: 6 -> 4 -> 9
     *  
     * @param head the head of the linked list
     * @return the head of the list with the last element removed
     */
    public static ListNode removeLast(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode current = head;
        while (current != null) {
            if (current.next.next == null) {
                current.next = null;
            }
            current = current.next;
        }

        return head;
    }

    /**
     * Returns the minimum value in the linked list, or Integer.MAX_VALUE if
     * head is null.
     * 
     * Example:
     * Input: 3 -> -4 -> 9 -> 2
     * Output: -4
     * 
     * @param head the head of the linked list
     * @return the minimum value in the list 
     */
    public static int min(ListNode head) {
        if (head == null) return Integer.MAX_VALUE;

        int min = head.data;
        ListNode current = head;
        while (current != null) {
            if (current.data < min) min = current.data;
            current = current.next;
        }

        return min;
    }

    /**
     * Removes the first instance of the node with the minimum value from the
     * list and returns the head. If head is null or the only element in the list,
     * returns null.
     * 
     * Examples:
     * Input: 3 -> 9 -> 0 -> -1 -> 5
     * Output: 3 -> 9 -> 0 -> 5
     * 
     * Input: 2 -> 4 -> 2 -> 9
     * Output: 4 -> 2 -> 9
     * 
     * HINT: use min as a helper method
     * 
     * @param head the head of the linked list
     * @return the head of the list with the first instance of the minimum value removed
     */
    public static ListNode removeMin(ListNode head) {
        if (head == null || head.next == null) return null;

        int min = min(head);
        ListNode current = head;

        if (head.data == min) {
            head = head.next;
            return head;
        }

        while (current != null) {
            if (current.next != null) {
                if (current.next.data == min) {
                    current.next = current.next.next;
                    return head;
                }
            }
            current = current.next;
        }
        return head;
    }

    /* ------ OPTIONAL CHALLENGE PROBLEMS ------ */

    /**
     * Returns whether two lists are of equal length AND each value in bigList is double
     * that of the corresponding value in smallList. Returns false otherwise.
     * 
     * If BOTH lists are null, returns true.
     * 
     * Example:
     * smallHead: 4 -> 3 -> 9
     * bigHead:   8 -> 6 -> 18
     * Output: true
     * 
     * smallHead: 4 -> 3 -> 9
     * bigHead:   8 -> 6 -> 7
     * Output: false
     * 
     * 
     * @param smallHead the head of the list with the half values
     * @param bigHead the head of the list with the doubled values
     * @return whether the values in bigList are twice the values in smallList
     */
    public static boolean isDoubled(ListNode smallList, ListNode bigList) {
        if (smallList == null && bigList == null) return true;

        ListNode currentSmall = smallList;
        ListNode currentBig = bigList;

        if (currentSmall == null || currentBig == null) {
            return false;
        }

        while (currentSmall != null && currentBig != null) {
            if (currentSmall.data * 2 != currentBig.data) {
                return false;
            } else if (currentSmall.next == null && currentBig.next != null) {
                return false;
            } else if (currentSmall.next != null && currentBig.next == null) {
                return false;
            }
            currentSmall = currentSmall.next;
            currentBig = currentBig.next;
        } 

        return true;
    }

    /**
     * Rotates a list by k elements to the left and returns the new head.
     * 
     * If head is null, return null.
     * 
     * Example:
     * head: 1 -> 2 -> 3 -> 4 -> 5
     * k: 2
     * Output: 3 -> 4 -> 5 -> 1 -> 2
     * 
     * @param head the head of the linked list
     * @param k the number of positions to rotate
     * @return the head of the new list after k rotations to the left
     */
    public static ListNode rotateLeft(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (k == 0) return head;

        ListNode newList = head;

        for (int i = 0; i < k; i++) {
            ListNode prevList = newList;
            newList = newList.next;
            ListNode current = newList;
            while (current != null) {
                if (current.next == null) {
                    current.next = prevList;
                    current.next.next = null;
                }
                current = current.next;
            }
        }
        return newList;
    }
}
