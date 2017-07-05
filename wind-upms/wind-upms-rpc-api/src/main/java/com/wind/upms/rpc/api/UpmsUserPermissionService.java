package com.wind.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.wind.common.base.BaseService;
import com.wind.upms.dao.model.UpmsUserPermission;
import com.wind.upms.dao.model.UpmsUserPermissionExample;

/**
* UpmsUserPermissionService接口
* Created by liuqijie on 2017/6/27.
*/
public interface UpmsUserPermissionService extends BaseService<UpmsUserPermission, UpmsUserPermissionExample> {
	/**
     * 用户权限
     * @param datas 权限数据
     * @param id 用户id
     * @return
     */
    int permission(JSONArray datas, int id);
}