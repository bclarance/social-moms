package org.socialmoms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by: Bilal Clarance, bclarance@gmail.com
 * On: 4/27/14 4:38 PM
 * social-moms
 */
@Configuration
@ComponentScan(basePackages="org.socialmoms", excludeFilters = { @ComponentScan.Filter(Configuration.class) })
@PropertySource("classpath:application.properties")
class AppConfig {
}
