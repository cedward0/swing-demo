import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

import static org.junit.Assert.assertEquals;

public class NaiveTest {
    private Naive naive;

    @Before
    public void setUp() {
        naive = new Naive();
        naive.setVisible(true);
    }

    @Test
    public void shouldChangeTextInTextFieldWhenClickingButton() throws AWTException {
        JButton button = naive.getButton();
        click(button);
        JTextField textField = naive.getTextField();
        assertEquals(textField.getText(), "Bye!");
    }

    private void click(JButton button) throws AWTException {
        Point point = button.getLocationOnScreen();
        Robot robot = new Robot();
        robot.setAutoWaitForIdle(true);
        robot.mouseMove(point.x + 10, point.y + 10);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
    }
}