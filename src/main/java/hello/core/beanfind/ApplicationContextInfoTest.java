package hello.core.beanfind;

import hello.core.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

 AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisPlayName("모든 빈 출력")

    void  findAllBean(){
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for ( String beanDefinitionName : beanDefinitionNames){

    }
    }

}
