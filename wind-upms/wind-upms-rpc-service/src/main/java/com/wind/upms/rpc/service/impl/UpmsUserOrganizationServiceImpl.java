package com.wind.upms.rpc.service.impl;

import com.wind.common.annotation.BaseService;
import com.wind.common.base.BaseServiceImpl;
import com.wind.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.wind.upms.dao.model.UpmsUserOrganization;
import com.wind.upms.dao.model.UpmsUserOrganizationExample;
import com.wind.upms.rpc.api.UpmsUserOrganizationService;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UpmsUserOrganizationService实现 Created by liuqijie on 2017/6/27.
 */
@Service
@Transactional
@BaseService
public class UpmsUserOrganizationServiceImpl
		extends
		BaseServiceImpl<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample>
		implements UpmsUserOrganizationService {

	private static Logger _log = LoggerFactory
			.getLogger(UpmsUserOrganizationServiceImpl.class);

	@Autowired
	UpmsUserOrganizationMapper upmsUserOrganizationMapper;

	@Override
	public int organization(String[] organizationIds, int id) {
		int result = 0;
		// 删除旧记录
		UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
		upmsUserOrganizationExample.createCriteria().andUserIdEqualTo(id);
		upmsUserOrganizationMapper.deleteByExample(upmsUserOrganizationExample);
		// 增加新记录
		if (null != organizationIds) {
			for (String organizationId : organizationIds) {
				if (StringUtils.isBlank(organizationId)) {
					continue;
				}
				UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
				upmsUserOrganization.setUserId(id);
				upmsUserOrganization.setOrganizationId(NumberUtils
						.toInt(organizationId));
				result = upmsUserOrganizationMapper
						.insertSelective(upmsUserOrganization);
			}
		}
		return result;
	}

}