package com.wind.upms.rpc.service.impl;

import com.wind.common.annotation.BaseService;
import com.wind.common.base.BaseServiceImpl;
import com.wind.upms.dao.mapper.UpmsUserPermissionMapper;
import com.wind.upms.dao.model.UpmsUserPermission;
import com.wind.upms.dao.model.UpmsUserPermissionExample;
import com.wind.upms.rpc.api.UpmsUserPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserPermissionService实现
* Created by liuqijie on 2017/6/27.
*/
@Service
@Transactional
@BaseService
public class UpmsUserPermissionServiceImpl extends BaseServiceImpl<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserPermissionServiceImpl.class);

    @Autowired
    UpmsUserPermissionMapper upmsUserPermissionMapper;

}