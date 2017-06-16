package com.gys.sm.item.listener;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.gys.sm.item.service.ISysInitService;
import com.gys.sm.item.service.impl.SysInitServiceImpl;


/**
 * 〈SystemListener.java〉
 * 〈系统初始化监听器,Spring容器启动完成立即加载系统初始化信息到静态缓存中〉
 * @author    yma
 * @version   V1.00 2015年11月21日[版本号, YYYY年MM月DD日]
 * @see       [相关类/方法]
 */
public class SystemInitListener implements ApplicationListener<ContextRefreshedEvent> {
    
    private static Logger logger = Logger.getLogger(SystemInitListener.class);
    
    @Autowired
    private ISysInitService iSysInitService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent ev) {
        //防止重复执行。
        if(ev.getApplicationContext().getParent() == null){
            logger.info("=========正在缓存系统数据字典信息=========");
            try {
            	
            	List<> iSysInitService.getDictionaryList();
            	
                SysDictionaryService sysConfigService = (SysDictionaryService) ev.getApplicationContext().getBean("sysDictionaryServiceImpl");
                List<SysDictionary> list = sysConfigService.getAllDictionary();
                for(SysDictionary dict : list){
                    DictionaryCache.put(dict);
                }
            } catch (Exception e) {
                logger.error("缓存系统数据字典出现异常",e);
            }
            logger.info("=========缓存系统数据字典信息完毕=========");
           
        }
    }

}

