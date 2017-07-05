package com.wind.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wind.common.base.BaseServiceMock;
import com.wind.upms.dao.mapper.UpmsUserRoleMapper;
import com.wind.upms.dao.model.UpmsUserRole;
import com.wind.upms.dao.model.UpmsUserRoleExample;
import com.wind.upms.rpc.api.UpmsUserRoleServiceMock;

/**
* 降级实现UpmsUserRoleService接口
* Created by liuqijie on 2017/6/27.
*/
public class UpmsUserRoleServiceMock extends BaseServiceMock<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {
	private static Logger _log = LoggerFactory.getLogger(UpmsUserRoleServiceMock.class);

	@Override
	public int role(String[] arg0, int arg1) {
		 _log.info("UpmsUserRoleServiceMock => role");
	        return 0;
	}
}
