package com.wind.upms.rpc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wind.common.base.BaseServiceMock;
import com.wind.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.wind.upms.dao.model.UpmsUserOrganization;
import com.wind.upms.dao.model.UpmsUserOrganizationExample;
import com.wind.upms.rpc.api.UpmsUserOrganizationServiceMock;

/**
* 降级实现UpmsUserOrganizationService接口
* Created by liuqijie on 2017/6/27.
*/
public class UpmsUserOrganizationServiceMock extends BaseServiceMock<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {
	private static Logger _log = LoggerFactory.getLogger(UpmsUserOrganizationServiceMock.class);

    @Override
    public int organization(String[] organizationIds, int id) {
        _log.info("UpmsUserOrganizationServiceMock => organization");
        return 0;
    }
}
