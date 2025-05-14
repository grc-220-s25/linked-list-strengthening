import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

/**
 * JUnit tests for Exercises linked-list methods.
 */
public class ExercisesTest {

    /** Helper to build a linked list from an array of values. */
    private ListNode buildList(int... values) {
        if (values == null || values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    /**
     * Helper to convert a list to a string, detecting cycles gracefully.
     * Format: data1 -> data2 -> ...
     */
    private String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (visited.contains(curr)) {
                sb.append(" -> ...(cycle detected)...");
                break;
            }
            visited.add(curr);
            sb.append(curr.data);
            curr = curr.next;
            if (curr != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    
}
