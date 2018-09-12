package com.open.mis.config.dao;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 配置数据源，这里用的是alibaba的连接池， 以后也可以配置多数据源，命名为不同的source
 */
@Configuration
@MapperScan("com.open.mis.**")
public class DataSourceConfiguration {

	@Value("${spring.datasource.driver-class-name}")
	private String driver;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.data-username}")
	private String username;

	@Value("${spring.datasource.data-password}")
	private String password;

	@Bean(name = "masteDataSource")
	public DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
