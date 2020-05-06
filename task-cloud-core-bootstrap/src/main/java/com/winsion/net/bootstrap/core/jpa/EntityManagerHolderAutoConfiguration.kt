package com.winsion.net.bootstrap.core.jpa


import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager

@Configuration
open class EntityManagerHolderAutoConfiguration(
        @Autowired private val applicationContext: ApplicationContext
) : InitializingBean {
    override fun afterPropertiesSet() {
        EntityManagerHolder.setEntityManager(applicationContext.getBean(EntityManager::class.java))
    }
}