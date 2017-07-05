package com.wind.upms.rpc.api;

import com.wind.common.base.BaseService;
import com.wind.upms.dao.model.UpmsUser;
import com.wind.upms.dao.model.UpmsUserExample;

/**
* UpmsUserService接口
* Created by liuqijie on 2017/6/27.
*/
public interface UpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {
	UpmsUser createUser(UpmsUser upmsUser);
}