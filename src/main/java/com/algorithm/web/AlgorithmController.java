package com.algorithm.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algorithm.service.AlgorithmService;
import com.algorithm.vo.AlgorithmListVO;
import com.algorithm.vo.AlgorithmVO;

@Controller
public class AlgorithmController {

	@Resource
	private AlgorithmService algorithmSvc;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) throws Exception {
		List<AlgorithmListVO> algorithmList = new ArrayList<>();
		algorithmList = algorithmSvc.getAlgorithmList();
		
		model.addAttribute("algorithmList", algorithmList);
		return "index";
	}
	
	@RequestMapping(value="/algorithm", method=RequestMethod.GET)
	public String algorithm(Model model, @RequestParam("id") String uuid) throws Exception {
		AlgorithmVO algorithmInfo = new AlgorithmVO();
		algorithmInfo = algorithmSvc.getAlgorithmInfo(uuid);
		model.addAttribute("algorithmInfo", algorithmInfo);
		return "algorithm";
	}

}
