package com.wind.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.wind.common.base.BaseService;
import com.wind.upms.dao.model.UpmsRolePermission;
import com.wind.upms.dao.model.UpmsRolePermissionExample;

/**
* UpmsRolePermissionService接口
* Created by liuqijie on 2017/6/27.
*/
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {
	/**
     * 角色权限
     * @param datas 权限数据
     * @param id 角色id
     * @return
     */
    int rolePermission(JSONArray datas, int id);
}