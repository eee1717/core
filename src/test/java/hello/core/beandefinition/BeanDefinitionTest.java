package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
 //  우회해서 bean등록방식 factorybean 를통해서 우회해서 연결


     //xml방식
     // 직접 bean 등록방식
      GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    @Test
    @DisplayName("빈 설정메타정보확인")
    void findApplicationBean(){
     String[] beanDefinitionNames =   ac.getBeanDefinitionNames();
     for (String beanDefinitionName : beanDefinitionNames){
         BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

         if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
             System.out.println("beanDefinitionName =" + beanDefinitionName +
                     " deanDefinition =" + beanDefinition);
         }

     }
    }
}
