package com.wind.upms.rpc.api;

import com.wind.common.base.BaseService;
import com.wind.upms.dao.model.UpmsUserRole;
import com.wind.upms.dao.model.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* Created by liuqijie on 2017/6/27.
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {
	/**
     * 用户角色
     * @param roleIds 角色ids
     * @param id 用户id
     * @return
     */
    int role(String[] roleIds, int id);

}