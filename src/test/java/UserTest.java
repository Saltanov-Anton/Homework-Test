import org.apache.commons.lang3.StringUtils;
import org.example.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    private static final String LOGIN_TEST = "user";
    private static final String CORRECT_EMAIL_TEST = "user@mail.ru";



    @Test
    public void shouldBeLoginAndEmail() {
        User user = new User(LOGIN_TEST, CORRECT_EMAIL_TEST);
        Assertions.assertFalse(StringUtils.isEmpty(user.getLogin()));
        Assertions.assertFalse(StringUtils.isEmpty(user.getEmail()));
    }

    @Test
    public void shouldBeWithoutLoginAndEmail() {
        User user = new User();
        Assertions.assertTrue(StringUtils.isEmpty(user.getLogin()));
        Assertions.assertTrue(StringUtils.isEmpty(user.getEmail()));
    }

    @Test
    public void shouldBeCorrectEmail() {
        User user = new User(LOGIN_TEST, CORRECT_EMAIL_TEST);
        Assertions.assertTrue(StringUtils.containsAny("@", user.getEmail()));
        Assertions.assertTrue(StringUtils.containsAny(".", user.getEmail()));
    }

    @Test
    public void shouldBeDifferentLoginAndEmail() {
        User user = new User(LOGIN_TEST, CORRECT_EMAIL_TEST);
        Assertions.assertNotEquals(user.getEmail(), user.getLogin());
    }
}
