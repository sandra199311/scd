import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author sandra
 * @date 2019/9/20
 */

public class Test {

    public static void main(final String[] args) {

        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String encodePasswd = passwordEncoder.encode("{bcrypt}123456");
        System.out.print(encodePasswd);

    }

}
