package basic.spring.beanfind;

import basic.spring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig .class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames){
            Object bean = context.getBean(beanName);
            System.out.println("bean name = " + bean + " object = " + bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean(){
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames){
            BeanDefinition bean = context.getBeanDefinition(beanName);


            // ROLE_APPLICATION - 사용자가 설정한 빈, ROLE_INFRASTRUCTURE- 스프링 내부에서 사용하는 빈
            if(bean.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object contextBean = context.getBean(beanName);

                System.out.println("bean name = " + bean + " object = " + contextBean );
            }
        }
    }
}
