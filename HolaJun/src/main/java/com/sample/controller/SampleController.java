package com.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.service.SampleService;

@Controller
public class SampleController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="sampleService")
    private SampleService sampleService;
    
	@RequestMapping(value="/")
	public ModelAndView home() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/home.jsp");
		mv.addObject("value", "임정훈");
		log.debug("modelandview home() 테스트");
		
		return mv;
	}
	
	@RequestMapping(value="/sample/openSampleBoardList.do")
    public ModelAndView openSampleBoardList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/boardList");
         
        List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
        mv.addObject("list", list);
         
        return mv;
    }

}
