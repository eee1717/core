package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void  findAllBean(){
        String[] beanfinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanfinitionNames ){
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + "object = "+ bean);
        }
    }



    //Role ROLE_APPLICATION :직접 등록한 애플리캐이션 빈
    //Role ROLE_INFRASTRUCTURE :스프링이 내부에서사용하는  빈

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void  findApplicationAllBean(){
        String[] beanfinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanfinitionNames ){
          BeanDefinition beanDefinition =  ac.getBeanDefinition(beanDefinitionName);

          if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
              Object bean = ac.getBean(beanDefinitionName);
              System.out.println("name=" + beanDefinitionName + "object = "+ bean);
            }
          }


        }
    }






