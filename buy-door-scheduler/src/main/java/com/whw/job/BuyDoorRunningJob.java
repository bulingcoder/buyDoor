package com.whw.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author whw
 * @Title: HourRunningJob
 * @Date 2023/6/26 11:44
 */
@Slf4j
@Component
public class BuyDoorRunningJob {

    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB-whw-test, Hello World.");
    }

    @XxlJob(value = "HourRunningJob",init = "init",destroy = "destroy")
    public ReturnT<String> execute(String param){
        log.info("HourRunningJob execute 任务方法触发成功");
        return ReturnT.SUCCESS;
    }

    private void init(){
        log.info("执行 HourRunningJob init >>>>>");
    }

    private void destroy(){
        log.info("执行 HourRunningJob destroy >>>>>");
    }
}
