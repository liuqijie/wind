package com.wind.upms.client.shiro.session;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wind.common.util.RedisUtil;
import com.wind.upms.client.util.SerializableUtil;

/**
 * 基于redis的sessionDao，缓存共享session
 * Created by liuqijie on 2017/6/29.
 */
public class UpmsSessionDao extends CachingSessionDAO {
	private static Logger _log = LoggerFactory.getLogger(UpmsSessionDao.class);
	// 会话key
    private final static String WIND_UPMS_SHIRO_SESSION_ID = "wind-upms-shiro-session-id";
    // 全局会话key
    private final static String WIND_UPMS_SERVER_SESSION_ID = "wind-upms-server-session-id";
    // 全局会话列表key
    private final static String WIND_UPMS_SERVER_SESSION_IDS = "wind-upms-server-session-ids";
    // code key
    private final static String WIND_UPMS_SERVER_CODE = "wind-upms-server-code";
    // 局部会话key
    private final static String WIND_UPMS_CLIENT_SESSION_ID = "wind-upms-client-session-id";
    // 单点同一个code所有局部会话key
    private final static String WIND_UPMS_CLIENT_SESSION_IDS = "wind-upms-client-session-ids";

	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doDelete(Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        RedisUtil.set(WIND_UPMS_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
        _log.debug("doCreate >>>>> sessionId={}", sessionId);
        return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		String session = RedisUtil.get(WIND_UPMS_SHIRO_SESSION_ID + "_" + sessionId);
        _log.debug("doReadSession >>>>> sessionId={}", sessionId);
        return SerializableUtil.deserialize(session);
	}

}
