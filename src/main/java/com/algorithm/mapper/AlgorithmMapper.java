package com.algorithm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.algorithm.vo.AlgorithmListVO;
import com.algorithm.vo.AlgorithmVO;

@Mapper
public interface AlgorithmMapper {
	List<AlgorithmListVO> selectAlgorithmList() throws Exception;
	AlgorithmVO getAlgorithmInfo(Map<String, Object> parameter) throws Exception;
}
