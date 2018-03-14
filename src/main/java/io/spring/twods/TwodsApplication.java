package io.spring.twods;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableTask
public class TwodsApplication {

	@Autowired
	List<DataSource> dataSources;

	@Autowired
	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(TwodsApplication.class, args);
	}


	@Bean
	public CommandLineRunner cmdRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("The number of dataSources returned from Autowired=>" + dataSources.size());
				System.out.println("the DataSource names:");
				int dataSourceCount = context.getBeanNamesForType(DataSource.class).length;
				for(String name : context.getBeanNamesForType(DataSource.class)) {
					System.out.println("===>" + name);
				}
				System.out.println("The number of datasource names returned by type=>" + dataSourceCount);

			}
		};
	}
}
