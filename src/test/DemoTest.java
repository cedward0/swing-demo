import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DemoTest {


    private FrameFixture demo;

    @Before
    public void setUp() {
        demo = new FrameFixture(new Demo());
    }

    @After
    public void tearDown() {
        demo.cleanUp();
    }

    @Test
    public void testLocal() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("A", "B", "C"));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            iterator.remove();
            System.out.println("Removed element " + next);
        }
        System.out.println(list);
        list.addAll(Arrays.asList("A", "B", "C"));
        for (String next : list) {
            if (next.equals("B")) {
                list.remove(next);
                System.out.println("Removed found element " + next + " and then stopped");
                break;
            }
        }
        System.out.println(list);
    }

    @Test
    public void test() throws InterruptedException {
        demo.label("myLabel").requireText("Button wasn't clicked!");
        Thread.sleep(2000);
        demo.button("myButton").click();
        demo.label("myLabel").requireText("Button was clicked! 1");
        Thread.sleep(2000);
        demo.button("myButton").click();
        demo.label("myLabel").requireText("Button was clicked! 2");
        Thread.sleep(2000);

        demo.label("myLabel2").requireText("");
        demo.textBox("myTextField").setText("123 my text");
        Thread.sleep(2000);
        demo.button("myButton2").click();
        demo.label("myLabel2").requireText("123 my text");
        Thread.sleep(2000);
    }
}