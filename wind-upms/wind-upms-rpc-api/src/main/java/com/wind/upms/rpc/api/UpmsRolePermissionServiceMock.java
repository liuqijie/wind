package com.wind.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.wind.common.base.BaseServiceMock;
import com.wind.upms.dao.mapper.UpmsRolePermissionMapper;
import com.wind.upms.dao.model.UpmsRolePermission;
import com.wind.upms.dao.model.UpmsRolePermissionExample;
import com.wind.upms.rpc.api.UpmsRolePermissionServiceMock;

/**
* 降级实现UpmsRolePermissionService接口
* Created by liuqijie on 2017/6/27.
*/
public class UpmsRolePermissionServiceMock extends BaseServiceMock<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {
	private static Logger _log = LoggerFactory.getLogger(UpmsRolePermissionServiceMock.class);

    @Override
    public int rolePermission(JSONArray datas, int id) {
        _log.info("UpmsRolePermissionServiceMock => rolePermission");
        return 0;
    }
}
