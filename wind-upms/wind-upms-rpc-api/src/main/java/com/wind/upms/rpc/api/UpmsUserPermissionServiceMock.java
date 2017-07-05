package com.wind.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.wind.common.base.BaseServiceMock;
import com.wind.upms.dao.mapper.UpmsUserPermissionMapper;
import com.wind.upms.dao.model.UpmsUserPermission;
import com.wind.upms.dao.model.UpmsUserPermissionExample;
import com.wind.upms.rpc.api.UpmsUserPermissionServiceMock;

/**
* 降级实现UpmsUserPermissionService接口
* Created by liuqijie on 2017/6/27.
*/
public class UpmsUserPermissionServiceMock extends BaseServiceMock<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {
	private static Logger _log = LoggerFactory.getLogger(UpmsUserPermissionServiceMock.class);

    @Override
    public int permission(JSONArray datas, int id) {
        _log.info("UpmsUserPermissionServiceMock => permission");
        return 0;
    }
}
