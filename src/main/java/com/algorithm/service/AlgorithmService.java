package com.algorithm.service;

import java.util.List;

import com.algorithm.vo.AlgorithmListVO;
import com.algorithm.vo.AlgorithmVO;

public interface AlgorithmService {
	List<AlgorithmListVO> getAlgorithmList() throws Exception;
	AlgorithmVO getAlgorithmInfo(String uuid) throws Exception;
}
