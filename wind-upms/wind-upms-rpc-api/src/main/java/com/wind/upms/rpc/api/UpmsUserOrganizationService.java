package com.wind.upms.rpc.api;

import com.wind.common.base.BaseService;
import com.wind.upms.dao.model.UpmsUserOrganization;
import com.wind.upms.dao.model.UpmsUserOrganizationExample;

/**
* UpmsUserOrganizationService接口
* Created by liuqijie on 2017/6/27.
*/
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {
	/**
     * 用户组织
     * @param organizationIds 组织ids
     * @param id 用户id
     * @return
     */
    int organization(String[] organizationIds, int id);

}