package lv.nixx.ne.config;

import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("NetworkDB")
public class NetworkDBConfig {
	
	@Bean
	public DataSource dataSource() {
		ClientDataSource ds = new ClientDataSource();
		ds.setDatabaseName("NotificationEngineDB");
		ds.setCreateDatabase("create");
		ds.setServerName("localhost");
		ds.setPortNumber(1527);

		return ds;
	}


}