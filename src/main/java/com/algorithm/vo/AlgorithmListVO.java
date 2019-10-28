package com.algorithm.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("algorithmListVO")

public class AlgorithmListVO {
	public String uuid;
	public String name;
	public String site;
	public String type;
	public String url;
}