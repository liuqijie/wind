package com.wind.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.wind.common.base.BaseService;
import com.wind.upms.dao.model.UpmsPermission;
import com.wind.upms.dao.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* Created by liuqijie on 2017/6/27.
*/
public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {

	JSONArray getTreeByRoleId(Integer roleId);

    JSONArray getTreeByUserId(Integer usereId, Byte type);
}