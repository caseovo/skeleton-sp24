import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

//     @Test
//     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
//     void noNonTrivialFields() {
//         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
//                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
//                 .toList();
//
//         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
//     }
@Test
/** In this test, we have three different assert statements that verify that addFirst works correctly. */
public void addFirstTestBasic() {
    Deque61B<String> lld1 = new ArrayDeque61B<>();

    lld1.addFirst("back"); // after this call we expect: ["back"]
    assertThat(lld1.toList()).containsExactly("back").inOrder();

    lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
    assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

    lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
    assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
}

    @Test
    /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
     *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new ArrayDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    // Below, you'll write your own tests for LinkedListDeque61B.
    @Test
    public void isEmptyTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        assert lld1.isEmpty();
        lld1.addFirst(1);  // [1]
        assert !lld1.isEmpty();
    }
    public void sizeTest(){
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        assert lld1.size() == 0;
        lld1.addFirst(1);
        assert lld1.size() == 1;
        lld1.addFirst(1);
        lld1.addFirst(4);
        lld1.addFirst(5);
        lld1.addFirst(1);
        lld1.addFirst(4);
        assert lld1.size() == 6;
    }
    @Test
    public void getTest(){
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(1);
        lld1.addLast(1);
        lld1.addLast(4);
        lld1.addLast(5);
        lld1.addLast(1);
        lld1.addLast(4);
        lld1.addFirst(0);//[0,1,1,4,5,1,4]
        assert lld1.get(0) == 0;
        assert lld1.get(3) == 4;
        assert lld1.get(5) == 1;
        assert lld1.get(10) == null;
        assert lld1.get(-1) == 4;
        assert lld1.get(-7) == 0;
    }
    @Test
    public void removeTest(){
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(1);
        lld1.addLast(1);
        lld1.addLast(4);
        lld1.addLast(5);
        lld1.addLast(1);
        lld1.addLast(4);//[1,1,4,5,1,4]
        lld1.removeFirst();//[1,4,5,1,4]
        assertThat(lld1.toList()).containsExactly(1, 4, 5, 1, 4).inOrder();
        lld1.removeLast();//[1,4,5,1]
        assertThat(lld1.toList()).containsExactly(1, 4, 5, 1).inOrder();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();//[]
        lld1.addFirst(1);//[1]
        assertThat(lld1.toList()).containsExactly(1).inOrder();
        lld1.removeLast();//[]
        assert lld1.removeLast() == null;//[]
        assertThat(lld1.toList()).containsExactly().inOrder();
    }
    @Test
    public void toListTest(){
        Deque61B<String> lld1 = new ArrayDeque61B<>();
        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();//[]
        assertThat(lld1.toList()).containsExactly().inOrder();
    }
}