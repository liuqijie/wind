package com.wind.upms.rpc.service.impl;

import com.wind.common.annotation.BaseService;
import com.wind.common.base.BaseServiceImpl;
import com.wind.upms.dao.mapper.UpmsRolePermissionMapper;
import com.wind.upms.dao.model.UpmsRolePermission;
import com.wind.upms.dao.model.UpmsRolePermissionExample;
import com.wind.upms.rpc.api.UpmsRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRolePermissionService实现
* Created by liuqijie on 2017/6/27.
*/
@Service
@Transactional
@BaseService
public class UpmsRolePermissionServiceImpl extends BaseServiceImpl<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsRolePermissionServiceImpl.class);

    @Autowired
    UpmsRolePermissionMapper upmsRolePermissionMapper;

}