package com.expressway.electronicbill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.deploy.ContextResource;
import org.apache.catalina.startup.Tomcat;
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
		// 应用程序初始化
		new Application.ApplicationInitilizer().run();

		// 运行应用程序
		SpringApplication.run(Application.class);
	}

	/**
	 * 为集成的Tomcat配置JNDI数据源
	 * 
	 * @return
	 */
	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
		return new TomcatEmbeddedServletContainerFactory() {

			/**
			 * 设置容器的属性
			 * 
			 * @param tomcat
			 * @return
			 */
			@Override
			protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
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

	/**
	 * 应用程序初始化函数，用来加载应用程序配置信息
	 * 
	 * @author Ajaxfan
	 */
	private static class ApplicationInitilizer {
		/** 用户目录 */
		private static final String USER_HOME = "user.home";
		/** 应用程序目录 */
		private static final String APP_HOME = ".bill";

		/**
		 * 执行应用程序初始化
		 */
		public void run() {
			/** 应用程序目录 */
			File directory = new File(System.getProperty(USER_HOME) + File.separator + APP_HOME);

			// 如果应用程序目录不存在，则创建目录并拷贝配置文件到该目录中
			checkPropertieFiles(directory);

			// 加载资源文件
			loadPropertie();
		}

		/**
		 * 从磁盘目录加载配置信息
		 */
		private void loadPropertie() {
		}

		/**
		 * 拷贝配置文件到磁盘目录
		 * 
		 * @param directory
		 */
		private void checkPropertieFiles(File directory) {
			if (!directory.exists()) {
				directory.mkdir();
			}
			URL url = Application.class.getResource("/com/expressway/electronicbill/configs");
			
			outter_loop:
			for (File f : new File(url.getFile()).listFiles()) {
				for (File l : directory.listFiles()) {
					if (!f.getName().equals(l.getName())) {
						continue outter_loop;
					}
				}
				try {
					InputStream in = new FileInputStream(f);
					OutputStream out = new FileOutputStream(directory + File.separator + f.getName());

					byte[] buffer = new byte[2048];

					int n = 0;
					while ((n = in.read(buffer)) != -1) {
						out.write(buffer, 0, n);
					}
					out.close();
					in.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
