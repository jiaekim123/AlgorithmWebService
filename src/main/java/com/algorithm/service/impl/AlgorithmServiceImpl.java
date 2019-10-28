package com.algorithm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.algorithm.mapper.AlgorithmMapper;
import com.algorithm.service.AlgorithmService;
import com.algorithm.vo.AlgorithmListVO;
import com.algorithm.vo.AlgorithmVO;

@Service
public class AlgorithmServiceImpl implements AlgorithmService{
	
	@Resource
	private AlgorithmMapper algorithmDao;
	
	@Override
	public List<AlgorithmListVO> getAlgorithmList() throws Exception {
		return algorithmDao.selectAlgorithmList();
	}

	@Override
	public AlgorithmVO getAlgorithmInfo(String uuid) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("uuid", uuid);
		return algorithmDao.getAlgorithmInfo(parameters);
	}
}
