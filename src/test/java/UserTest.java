import org.apache.commons.lang3.StringUtils;
import org.example.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    private static final String LOGIN_TEST = "user";
    private static final String CORRECT_EMAIL_TEST = "user@mail.ru";
    private static final String NOT_CORRECT_EMAIL_TEST = "user@mailru";



    @Test
    public void shouldBeLoginAndEmail() {
        User user = new User(LOGIN_TEST, CORRECT_EMAIL_TEST);
        Assertions.assertEquals(LOGIN_TEST, user.getLogin());
        Assertions.assertEquals(CORRECT_EMAIL_TEST, user.getEmail());
    }

    @Test
    public void shouldBeWithoutLoginAndEmail() {
        User user = new User();
        Assertions.assertTrue(StringUtils.isEmpty(user.getLogin()));
        Assertions.assertTrue(StringUtils.isEmpty(user.getEmail()));
    }

    @Test
    public void shouldBeCorrectEmail() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> new User(LOGIN_TEST, NOT_CORRECT_EMAIL_TEST));
    }

    @Test
    public void shouldBeDifferentLoginAndEmail() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> new User(CORRECT_EMAIL_TEST, CORRECT_EMAIL_TEST));
    }
}
