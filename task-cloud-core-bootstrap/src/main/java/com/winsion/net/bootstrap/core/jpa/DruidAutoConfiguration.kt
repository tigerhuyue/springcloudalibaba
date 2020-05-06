package com.winsion.net.bootstrap.core.jpa

import com.alibaba.druid.pool.DruidDataSource
import com.winsion.net.bootstrap.common.*;
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.sql.SQLException
import javax.sql.DataSource

@Configuration
open class DruidAutoConfiguration {
    @Value("\${spring.datasource.url}")
    private val dbUrl: String? = null
    @Value("\${spring.datasource.username}")
    private val username: String? = null
    @Value("\${spring.datasource.password}")
    private val password: String? = null
    @Value("\${spring.datasource.driver-class-name}")
    private val driverClassName: String? = null
    @Value("\${spring.datasource.initialSize}")
    private val initialSize: Int = 0
    @Value("\${spring.datasource.minIdle}")
    private val minIdle: Int = 0
    @Value("\${spring.datasource.maxActive}")
    private val maxActive: Int = 0
    @Value("\${spring.datasource.maxWait}")
    private val maxWait: Int = 0
    @Value("\${spring.datasource.timeBetweenEvictionRunsMillis}")
    private val timeBetweenEvictionRunsMillis: Int = 0
    @Value("\${spring.datasource.minEvictableIdleTimeMillis}")
    private val minEvictableIdleTimeMillis: Int = 0
    @Value("\${spring.datasource.validationQuery}")
    private val validationQuery: String? = null
    @Value("\${spring.datasource.testWhileIdle}")
    private val testWhileIdle: Boolean = false
    @Value("\${spring.datasource.testOnBorrow}")
    private val testOnBorrow: Boolean = false
    @Value("\${spring.datasource.testOnReturn}")
    private val testOnReturn: Boolean = false
    @Value("\${spring.datasource.poolPreparedStatements}")
    private val poolPreparedStatements: Boolean = false
    @Value("\${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private val maxPoolPreparedStatementPerConnectionSize: Int = 0
    @Value("\${spring.datasource.filters}")
    private val filters: String? = null
    @Value("{spring.datasource.connectionProperties}")
    private val connectionProperties: String? = null

    @Bean
    @Primary
    open fun dataSource(): DataSource {
        val datasource = DruidDataSource()

        datasource.url = this.dbUrl
        datasource.username = username
        datasource.password = password
        datasource.driverClassName = driverClassName

        datasource.initialSize = initialSize
        datasource.minIdle = minIdle
        datasource.maxActive = maxActive
        datasource.maxWait = maxWait.toLong()
        datasource.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis.toLong()
        datasource.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis.toLong()
        datasource.validationQuery = validationQuery
        datasource.isTestWhileIdle = testWhileIdle
        datasource.isTestOnBorrow = testOnBorrow
        datasource.isTestOnReturn = testOnReturn
        datasource.isPoolPreparedStatements = poolPreparedStatements
        datasource.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize

        try {
            datasource.setFilters(filters)
        } catch (e: SQLException) {
            LogUtil.error(e)
        }

        datasource.setConnectionProperties(connectionProperties)
        return datasource
    }
}