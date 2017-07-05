package com.wind.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.wind.common.base.BaseServiceMock;
import com.wind.upms.dao.mapper.UpmsPermissionMapper;
import com.wind.upms.dao.model.UpmsPermission;
import com.wind.upms.dao.model.UpmsPermissionExample;
import com.wind.upms.rpc.api.UpmsPermissionServiceMock;

/**
* 降级实现UpmsPermissionService接口
* Created by liuqijie on 2017/6/27.
*/
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {
	private static Logger _log = LoggerFactory.getLogger(UpmsPermissionServiceMock.class);

    @Override
    public JSONArray getTreeByRoleId(Integer roleId) {
        _log.info("UpmsPermissionServiceMock => getTreeByRoleId");
        return null;
    }

    @Override
    public JSONArray getTreeByUserId(Integer usereId, Byte type) {
        _log.info("UpmsPermissionServiceMock => getTreeByUserId");
        return null;
    }
}
