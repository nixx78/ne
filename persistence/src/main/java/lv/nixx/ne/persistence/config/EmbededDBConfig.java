package lv.nixx.ne.persistence.config;

import javax.sql.DataSource;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("EmbededDB")
public class EmbededDBConfig {
	
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDataSource ds = new EmbeddedDataSource();
		ds.setDatabaseName("derbyDB");
		ds.setCreateDatabase("create");
		
		return ds;
	}

}
