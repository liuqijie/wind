package com.wind.upms.rpc.api;

import com.wind.common.base.BaseServiceMock;
import com.wind.upms.dao.mapper.UpmsLogMapper;
import com.wind.upms.dao.model.UpmsLog;
import com.wind.upms.dao.model.UpmsLogExample;

/**
* 降级实现UpmsLogService接口
* Created by liuqijie on 2017/6/27.
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
