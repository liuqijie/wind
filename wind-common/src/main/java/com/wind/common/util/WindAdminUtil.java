package com.wind.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 启动解压windAdmin-x.x.x.jar到resources目录
 * Created by liuqijie on 2017/6/26.
 */
public class WindAdminUtil implements InitializingBean, ServletContextAware {

    private static Logger _log = LoggerFactory.getLogger(WindAdminUtil.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        _log.info("===== 开始解压wind-admin =====");
        String version = PropertiesFileUtil.getInstance("wind-admin-client").get("wind.admin.version");
        _log.info("wind-admin.jar 版本: {}", version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/wind-admin-" + version + ".jar");
        _log.info("wind-admin.jar 包路径: {}", jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/wind-admin";
        _log.info("wind-admin.jar 解压到: {}", resources);
        JarUtil.decompress(jarPath, resources);
        _log.info("===== 解压wind-admin完成 =====");
    }

}
