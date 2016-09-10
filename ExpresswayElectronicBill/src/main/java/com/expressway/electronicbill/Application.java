package com.expressway.electronicbill;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ImportResource("classpath*:spring-*.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     * 为集成的Tomcat配置JNDI数据源
     * @return
     */
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
        return new TomcatEmbeddedServletContainerFactory() {

            /**
             * 设置容器的属性
             * @param tomcat
             * @return
             */
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
                    Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }

            /**
             * 创建JNDI数据源
             * 
             * @param context
             */
            @Override
            protected void postProcessContext(Context context) {
                ContextResource resource = new ContextResource();
                resource.setName("jdbc/fxstduio");
                resource.setType(DataSource.class.getName());
                resource.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
                resource.setProperty("url", "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
                resource.setProperty("username", "mes");
                resource.setProperty("password", "mes");

                context.getNamingResources().addResource(resource);
            }
        };
    }
}
