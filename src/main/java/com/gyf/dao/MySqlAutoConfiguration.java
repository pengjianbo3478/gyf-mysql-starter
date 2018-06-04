package com.gyf.dao;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ServletComponentScan("com.gyf.dao.monitor")
//@MapperScan("com.gl365")
public class MySqlAutoConfiguration {
	private static final Logger LOG = LoggerFactory.getLogger(MySqlAutoConfiguration.class);

	@Bean
	@Primary
    public Object druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver,
                                      @Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.username}") String username,
                                      @Value("${spring.datasource.password}") String password,
//                                      @Value("${spring.datasource.testOnBorrow:false}") boolean testOnBorrow, 
//                                      @Value("${spring.datasource.testOnReturn:false}") boolean testOnReturn, 
//                                      @Value("${spring.datasource.testWhileIdle:false}") boolean testWhileIdle, 
//                                      @Value("${spring.datasource.poolPreparedStatements:false}") boolean poolPreparedStatements,
//                                      @Value("${spring.datasource.maxCreateTaskCount:10}") int maxCreateTaskCount, 
//                                      @Value("${spring.datasource.maxEvictableIdleTimeMillis:30000}") long maxEvictableIdleTimeMillis, 
//                                      @Value("${spring.datasource.maxOpenPreparedStatements:-1}") int maxOpenPreparedStatements, 
//                                      @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize:20}") int maxPoolPreparedStatementPerConnectionSize, 
//                                      @Value("${spring.datasource.maxWait:2000}") long maxWait, 
//                                      @Value("${spring.datasource.maxWaitThreadCount:}") int maxWaitThreadCount
                                      @Value("${spring.datasource.initialSize:1}") int initialSize,
                                      @Value("${spring.datasource.minIdle:1}") int minIdle,
                                      @Value("${spring.datasource.maxActive:16}") int maxActive) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setValidationQuery("select 0");
        druidDataSource.setTestOnReturn(true);
        druidDataSource.setTestOnBorrow(true);
//        druidDataSource.setTestOnBorrow(testOnBorrow);
//        druidDataSource.setTestOnReturn(testOnReturn);
//        druidDataSource.setTestWhileIdle(testWhileIdle);
//        druidDataSource.setMaxCreateTaskCount(maxCreateTaskCount);
//        druidDataSource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);
//        druidDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
//        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        druidDataSource.setMaxWait(maxWait);
//        druidDataSource.setMaxWaitThreadCount(maxWaitThreadCount);
//        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        try {
            druidDataSource.setFilters("stat, wall, log4j");
        } catch (SQLException e) {
        	LOG.debug(e.getMessage(), e);
        }
        return druidDataSource;
    }
}
