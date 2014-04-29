package org.socialmoms.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.socialmoms.config.IntegrationTest;
import org.socialmoms.config.TestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by: Bilal Clarance, bclarance@apple.com
 * On: 4/28/14 4:34 PM
 * social-moms
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Category(IntegrationTest.class)
@ContextConfiguration(classes = TestContext.class)
public class IndexControllerIntegrationTest {

    /** The wac. */
    @Autowired
    private WebApplicationContext wac;

    /** The session. */
    @Autowired
    private MockHttpSession session;

    /** The mock mvc. */
    private MockMvc mockMvc;

    /** The result actions. */
    private ResultActions resultActions;

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testShowIndex() throws Exception {
        resultActions = mockMvc.perform(get("/").session(session));

        resultActions.andDo(print());

        resultActions.andExpect(status().is(200));
        resultActions.andExpect(content().contentType("application/json"));
        String response = resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(response);
        assertEquals("Hello world", response);
    }
}
