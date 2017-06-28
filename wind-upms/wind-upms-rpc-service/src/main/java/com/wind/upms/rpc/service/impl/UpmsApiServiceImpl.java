package com.wind.upms.rpc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wind.upms.dao.model.UpmsLog;
import com.wind.upms.dao.model.UpmsOrganization;
import com.wind.upms.dao.model.UpmsOrganizationExample;
import com.wind.upms.dao.model.UpmsPermission;
import com.wind.upms.dao.model.UpmsRole;
import com.wind.upms.dao.model.UpmsRolePermission;
import com.wind.upms.dao.model.UpmsSystem;
import com.wind.upms.dao.model.UpmsSystemExample;
import com.wind.upms.dao.model.UpmsUser;
import com.wind.upms.dao.model.UpmsUserPermission;
import com.wind.upms.rpc.api.UpmsApiService;
import com.wind.upms.dao.mapper.UpmsLogMapper;
import com.wind.upms.dao.mapper.UpmsOrganizationMapper;
import com.wind.upms.dao.mapper.UpmsRolePermissionMapper;
import com.wind.upms.dao.mapper.UpmsSystemMapper;
import com.wind.upms.dao.mapper.UpmsUserMapper;
import com.wind.upms.dao.mapper.UpmsUserPermissionMapper;
import com.wind.upms.rpc.mapper.UpmsApiMapper;
import com.wind.upms.dao.model.UpmsRolePermissionExample;
import com.wind.upms.dao.model.UpmsUserPermissionExample;
import com.wind.upms.dao.model.UpmsUserExample;

/**
 * Api接口实现 Created by liuqijie on 2017/6/28.
 */
@Service
@Transactional
public class UpmsApiServiceImpl implements UpmsApiService {
	private static Logger _log = LoggerFactory
			.getLogger(UpmsApiServiceImpl.class);

	@Autowired
	UpmsUserMapper upmsUserMapper;

	@Autowired
	UpmsApiMapper upmsApiMapper;

	@Autowired
	UpmsRolePermissionMapper upmsRolePermissionMapper;

	@Autowired
	UpmsUserPermissionMapper upmsUserPermissionMapper;

	@Autowired
	UpmsSystemMapper upmsSystemMapper;

	@Autowired
	UpmsOrganizationMapper upmsOrganizationMapper;

	@Autowired
	UpmsLogMapper upmsLogMapper;

	/**
	 * 根据用户id获取所拥有的权限
	 * 
	 * @param upmsUserId
	 * @return
	 */
	@Override
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(
			Integer upmsUserId) {
		// 用户不存在或锁定状态
		UpmsUser upmsUser = upmsUserMapper.selectByPrimaryKey(upmsUserId);
		if (null == upmsUser || 1 == upmsUser.getLocked()) {
			_log.info("selectUpmsPermissionByUpmsUserId : upmsUserId={}",
					upmsUserId);
			return null;
		}
		List<UpmsPermission> upmsPermissions = upmsApiMapper
				.selectUpmsPermissionByUpmsUserId(upmsUserId);
		return upmsPermissions;
	}

	/**
	 * 根据用户id获取所拥有的权限-缓存
	 * 
	 * @param upmsUserId
	 * @return
	 */
	@Override
	@Cacheable(value = "wind-upms-rpc-service-ehcache", key = "'selectUpmsPermissionByUpmsUserId_' + #upmsUserId")
	public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(
			Integer upmsUserId) {
		return selectUpmsPermissionByUpmsUserId(upmsUserId);
	}

	/**
	 * 根据用户id获取所属的角色
	 * 
	 * @param upmsUserId
	 * @return
	 */
	@Override
	public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
		// 用户不存在或锁定状态
		UpmsUser upmsUser = upmsUserMapper.selectByPrimaryKey(upmsUserId);
		if (null == upmsUser || 1 == upmsUser.getLocked()) {
			_log.info("selectUpmsRoleByUpmsUserId : upmsUserId={}",
					upmsUserId);
			return null;
		}
		
		List<UpmsRole> upmsRoles = upmsApiMapper.selectUpmsRoleByUpmsUserId(upmsUserId);
		return upmsRoles;
	}

	/**
	 * 根据用户id获取所属的角色-缓存
	 * 
	 * @param upmsUserId
	 * @return
	 */
	@Override
	@Cacheable(value = "wind-upms-rpc-service-ehcache", key = "'selectUpmsRoleByUpmsUserId_' + #upmsUserId")
	public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
		return selectUpmsRoleByUpmsUserId(upmsUserId);
	}

	 /**
     * 根据角色id获取所拥有的权限
     * @param upmsRoleId
     * @return
     */
	@Override
	public List<UpmsRolePermission> selectUpmsRolePermisstionByUpmsRoleId(
			Integer upmsRoleId) {
		UpmsRolePermissionExample upmsRolePermissionExample = new UpmsRolePermissionExample();
        upmsRolePermissionExample.createCriteria()
                .andRoleIdEqualTo(upmsRoleId);
        List<UpmsRolePermission> upmsRolePermissions = upmsRolePermissionMapper.selectByExample(upmsRolePermissionExample);
        return upmsRolePermissions;
	}

	 /**
     * 根据用户id获取所拥有的权限
     * @param upmsUserId
     * @return
     */
	@Override
	public List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(
			Integer upmsUserId) {
		UpmsUserPermissionExample upmsUserPermissionExample = new UpmsUserPermissionExample();
        upmsUserPermissionExample.createCriteria()
                .andUserIdEqualTo(upmsUserId);
        List<UpmsUserPermission> upmsUserPermissions = upmsUserPermissionMapper.selectByExample(upmsUserPermissionExample);
        return upmsUserPermissions;
	}

	/**
     * 根据条件获取系统数据
     * @param upmsSystemExample
     * @return
     */
	@Override
	public List<UpmsSystem> selectUpmsSystemByExample(
			UpmsSystemExample upmsSystemExample) {
		return upmsSystemMapper.selectByExample(upmsSystemExample);
	}

	/**
     * 根据条件获取组织数据
     * @param upmsOrganizationExample
     * @return
     */
	@Override
	public List<UpmsOrganization> selectUpmsOrganizationByExample(
			UpmsOrganizationExample upmsOrganizationExample) {
		return upmsOrganizationMapper.selectByExample(upmsOrganizationExample);
	}

	/**
     * 根据username获取UpmsUser
     * @param username
     * @return
     */
	@Override
	public UpmsUser selectUpmsUserByUsername(String username) {
		UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andUsernameEqualTo(username);
        List<UpmsUser> upmsUsers = upmsUserMapper.selectByExample(upmsUserExample);
        if (null != upmsUsers && upmsUsers.size() > 0) {
            return upmsUsers.get(0);
        }
        return null;
	}

	/**
     * 写入操作日志
     * @param record
     * @return
     */
	@Override
	public int insertUpmsLogSelective(UpmsLog record) {
		return upmsLogMapper.insertSelective(record);
	}

}
