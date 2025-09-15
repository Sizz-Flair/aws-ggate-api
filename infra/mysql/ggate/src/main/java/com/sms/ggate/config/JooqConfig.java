package com.sms.ggate.config;

import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.jooq.tools.LoggerListener;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {
    @Bean
    public DefaultConfiguration configuration(DataSource dataSource, PlatformTransactionManager transactionManager) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();

        // Spring의 DataSource를 jOOQ에 연결
        jooqConfiguration.set(
                new DataSourceConnectionProvider(
                        new TransactionAwareDataSourceProxy(dataSource)
                )
        );

        // Spring 트랜잭션을 jOOQ에서도 사용 가능하게 연결
        jooqConfiguration.set(
                new SpringTransactionProvider(transactionManager)
        );

        jooqConfiguration.set(settings());

        // 사용할 DB Dialect (MySQL, PostgreSQL 등)
        jooqConfiguration.set(SQLDialect.MARIADB);

        jooqConfiguration.set(new DefaultExecuteListenerProvider(new LoggerListener()));

        return jooqConfiguration;
    }

    private Settings settings() {
        return new Settings()
                .withExecuteWithOptimisticLocking(true)
                .withUpdateRecordVersion(true)
                .withExecuteLogging(true)
                .withRenderFormatted(true)
                .withInsertUnchangedRecords(false);
    }
}