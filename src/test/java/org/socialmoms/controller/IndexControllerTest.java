package org.socialmoms.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.socialmoms.config.UnitTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by: Bilal Clarance, bclarance@gmail.com
 * On: 4/28/14 9:45 AM
 * social-moms
 */
@Category(UnitTest.class)
@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class IndexControllerTest {

    /** The session. */
    @Mock
    private MockHttpSession session;

    /** The access controller. */
    @InjectMocks
    private IndexController indexController;

    /** The mock mvc. */
    private MockMvc mockMvc;

    /** The result actions. */
    private ResultActions resultActions;

    /** The InternalResourceViewResolver */
    private InternalResourceViewResolver viewResolver;

    @Before
    public void setUp() {
        viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
        //MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).setViewResolvers(viewResolver).build();
    }

     @Test
    public void testShowIndex() throws Exception {
            resultActions = mockMvc.perform(get("/").session(session));
            resultActions.andDo(print());
            resultActions.andExpect(status().is(200));
    }
}
