package reflection;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class Junit4TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;

        final Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(MyTest.class)) {
                declaredMethod.invoke(new Junit4Test());
            }
        }
        // TODO Junit4Test에서 @MyTest 애노테이션이 있는 메소드 실행
    }
}
