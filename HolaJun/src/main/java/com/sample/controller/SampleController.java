package com.sample.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	Logger log = LoggerFactory.getLogger(this.getClass());
    
	@RequestMapping(value="/main.do")
	public ModelAndView home() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home.jsp");
		mv.addObject("value", "임정훈");
		log.debug("modelandview home() 테스트");
		
		return mv;
	}
	
    @RequestMapping(value="/sample/openSampleList.do")
    public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("");
        log.debug("인터셉터 테스트");
         
        return mv;
    }
}
