package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginType {

    LoginTypeNames value();

    enum LoginTypeNames {
        NO_LOGIN,
        LOGIN_FIRSTPAGE,
        LOGIN_SECPAGE;
    }
}
