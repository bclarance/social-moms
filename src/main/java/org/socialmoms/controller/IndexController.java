package org.socialmoms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

	@RequestMapping(value="/index")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("index");
	}

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return "Hello world";
    }
}
