package com.algorithm.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("algorithmVO")

public class AlgorithmVO {
	public String uuid;
	public String name;
	public String site;
	public String type;
	public String url;
}
