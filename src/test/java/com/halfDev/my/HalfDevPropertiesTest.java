package com.halfDev.my;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.halfdev.my.HalfDevConfiguration;
import com.halfdev.my.HalfDevProperties;
import com.halfdev.my.HalfDevSpringBean;
import com.halfdev.my.domain.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class HalfDevPropertiesTest {

	@Value("${com.halfdev.my.url}")
    private String jdbcUrl;

    @Value("${com.halfdev.my.username}")
    private String jdbcUsername;

    @Value("${com.halfdev.my.password}")
    private String jdbcPassword;

    @Value("${com.halfdev.my.tables}")
    private List<String> tables;
    
    @Autowired
    private HalfDevProperties properties;
    
    @Test
//    @Order(1)
    public void configurationTest() {
    	ApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("classpath:configuration.xml");
    	HalfDevSpringBean xmlSpringBean = genericXmlApplicationContext.getBean("xmlSpringBean", HalfDevSpringBean.class);
        Assertions.assertEquals("xmlSpringBean", xmlSpringBean.getName());
        log.info(xmlSpringBean.getName());

        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(HalfDevConfiguration.class);
        HalfDevSpringBean annotationSpringBean = annotationConfigApplicationContext.getBean("annotationSpringBean", HalfDevSpringBean.class);
        Assertions.assertEquals("annotationSpringBean", annotationSpringBean.getName());
    }
    
    @Test
//    @Order(2)
    public void valueTest() {
        Assertions.assertEquals(jdbcUrl, "jdbc:mysql://localhost:3306/bootcommunity");
        Assertions.assertEquals(jdbcUsername, "halfdev");
        Assertions.assertEquals(jdbcPassword, "halfdev");
//        Assertions.assertEquals(tables, List.of("user", "role"));
        Assertions.assertEquals(tables, Arrays.asList("user", "role"));
    }
    @Test
//    @Order(3)
    public void propertiesTest() {
        Assertions.assertEquals(properties.getUrl(), "jdbc:mysql://localhost:3306/bootcommunity");
        Assertions.assertEquals(properties.getUsername(), "halfdev");
        Assertions.assertEquals(properties.getPassword(), "halfdev");
//        Assertions.assertEquals(properties.getUsers(), List.of(User.builder().id(1l).email("community").build(), User.builder().id(2l).email("community2").build()));
        Assertions.assertEquals(properties.getUsers(), Arrays.asList(User.builder().id(1l).email("community").build(), User.builder().id(2l).email("community2").build()));
    }
}
