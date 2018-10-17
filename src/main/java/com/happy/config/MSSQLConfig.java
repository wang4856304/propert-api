package com.happy.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wangjun
 * @Title: MSSQLConfig
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/15 12:21
 */
@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "spring.dataSource.mssqlMaster")
@EnableTransactionManagement
public class MSSQLConfig {

    private String url;

    private String username;

    private String password;

    private String driverClassName;

    private int initialSize;

    private int minIdle;

    private int maxActive;

    private int maxWait;

    private int timeBetweenEvictionRunsMillis;

    private int minEvictableIdleTimeMillis;

    private String validationQuery;

    private boolean testWhileIdle;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean poolPreparedStatements;

    private int maxPoolPreparedStatementPerConnectionSize;

    private String filters;

    private String connectionProperties;

    private String connectionInitSql;

    @Bean(name = "masterMSSqlDataSource")
    //@Primary
    public DataSource masterDataSource() throws SQLException {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        Collection<Object> initSql = new ArrayList<Object>();
        initSql.add(connectionInitSql);
        datasource.setConnectionInitSqls(initSql);
        datasource.setFilters(filters);

        return datasource;
    }

    @Bean(name = "masterMSSqlSessionFactory")
    //@Primary
    SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterMSSqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "masterMSSqlSessionTemplate")
    //@Primary
    SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterMSSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Bean(name = "transactionMSSqlManager")//事物
    //@Primary
    public DataSourceTransactionManager getTransactionManager(@Qualifier("masterMSSqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
