package com.wind.upms.rpc.service.impl;

import com.wind.common.annotation.BaseService;
import com.wind.common.base.BaseServiceImpl;
import com.wind.upms.dao.mapper.UpmsLogMapper;
import com.wind.upms.dao.model.UpmsLog;
import com.wind.upms.dao.model.UpmsLogExample;
import com.wind.upms.rpc.api.UpmsLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsLogService实现
* Created by liuqijie on 2017/6/27.
*/
@Service
@Transactional
@BaseService
public class UpmsLogServiceImpl extends BaseServiceImpl<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

    private static Logger _log = LoggerFactory.getLogger(UpmsLogServiceImpl.class);

    @Autowired
    UpmsLogMapper upmsLogMapper;

}