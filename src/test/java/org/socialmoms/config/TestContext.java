package org.socialmoms.config;

import org.junit.experimental.categories.Category;
import org.socialmoms.init.AppInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by: Bilal Clarance, bclarance@apple.com
 * On: 4/28/14 10:00 AM
 * social-moms
 */
@Configuration
@ContextConfiguration(classes = AppInitializer.class)
@ComponentScan(basePackages = { "org.socialmoms" })
@EnableWebMvc
@Category(IntegrationTest.class)
public class TestContext extends WebMvcConfigurerAdapter {
}
