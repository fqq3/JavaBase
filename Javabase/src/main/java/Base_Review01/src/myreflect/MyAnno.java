package myreflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
/**
 * @author: fqq
 * @Date: 2025/5/15 - 05 - 15 - 22:03
 * @Description: myreflect
 * @version: 1.0
 */

@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,PACKAGE})
//@Target({ElementType.TYPE,
//        ElementType.FIELD,
//        ElementType.METHOD,
//        ElementType.PARAMETER,
//        ElementType.CONSTRUCTOR,
//        ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String value();
}
