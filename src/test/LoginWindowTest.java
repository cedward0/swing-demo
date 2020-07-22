import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginWindowTest {
 
    private FrameFixture login;
 
         

    @Before
    public void setUp() {
         login = new FrameFixture(new LoginWindow());
         login.show();
        
    }
 
         

    @Test
    public void shouldShowErrorIfUsernameIsMissing() {
         login.textBox("username").deleteText();
         login.textBox("password").enterText("secret");
         login.comboBox("domain").selectItem("USERS");
         login.button("ok").click();
         login.optionPane().requireErrorMessage().requireMessage("Please enter your username");
        
    }
    

    @After
    public void tearDown() {
        login.cleanUp();
        
    }
}