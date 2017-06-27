package com.wind.upms.common.constant;

import com.wind.common.base.BaseResult;

/**
 * upms系统常量枚举类
 * Created by liuqijie on 2017/6/27.
 */
public class UpmsResult extends BaseResult {
	public UpmsResult(UpmsResultConstant upmsResultConstant, Object data){
		super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
	}
}
