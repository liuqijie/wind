package com.wind.upms.rpc.mapper;

import java.util.List;

import com.wind.upms.dao.model.UpmsPermission;
import com.wind.upms.dao.model.UpmsRole;

/**
 * VOMapper
 * Created by liuqijie on 2017/6/28.
 */
public interface UpmsApiMapper {
	// 根据用户id获取所拥有的权限
	List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId);
	
	// 根据用户id获取所属的角色
	List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId);
}
