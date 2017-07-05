package com.wind.upms.rpc.api;

import com.wind.common.base.BaseServiceMock;
import com.wind.upms.dao.mapper.UpmsUserMapper;
import com.wind.upms.dao.model.UpmsUser;
import com.wind.upms.dao.model.UpmsUserExample;

/**
 * 降级实现UpmsUserService接口 Created by liuqijie on 2017/6/27.
 */
public class UpmsUserServiceMock extends
		BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements
		UpmsUserService {
	@Override
	public UpmsUser createUser(UpmsUser upmsUser) {
		return null;
	}
}
