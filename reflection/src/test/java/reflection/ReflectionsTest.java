package reflection;

import annotation.Controller;
import annotation.Repository;
import annotation.Service;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void showAnnotationClass() throws Exception {
        Reflections reflections = new Reflections("examples");
        final Set<Class<?>> clazzWithControllerAnnotation = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> clazz : clazzWithControllerAnnotation) {
            log.info(clazz.getName());
        }

        final Set<Class<?>> clazzWithServiceAnnotation = reflections.getTypesAnnotatedWith(Service.class);
        for (Class<?> clazz : clazzWithServiceAnnotation) {
            log.info(clazz.getName());
        }

        final Set<Class<?>> clazzWithRepositoryAnnotation = reflections.getTypesAnnotatedWith(Repository.class);
        for (Class<?> clazz : clazzWithRepositoryAnnotation) {
            log.info(clazz.getName());
        }
        // TODO 클래스 레벨에 @Controller, @Service, @Repository 애노테이션이 설정되어 모든 클래스 찾아 로그로 출력한다.
    }
}
