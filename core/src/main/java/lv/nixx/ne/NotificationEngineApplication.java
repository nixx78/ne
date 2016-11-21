package lv.nixx.ne;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class NotificationEngineApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.sources(NotificationEngineApplication.class)
			.profiles("NetworkDB")
			.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.profiles("NetworkDB");
		return application.sources(NotificationEngineApplication.class);
	}
}
