package com.sf.Job;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sf.mapper.MarketGroupDetailMapper;
public class JobService {

	@Autowired
	private MarketGroupDetailMapper marketGroupDetailMapper;
	
	private org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JobService.class);

    public void generateGroup() {
    	LOGGER.info("check generate group on :" + new Date());
        int count = 0;
        try{
	        count = marketGroupDetailMapper.updateEndingMarket();
	        LOGGER.info("update record number :" + count);
        }catch(Exception e){
        	LOGGER.error(e.toString());
        }

        try{
	        count = marketGroupDetailMapper.newMarket();
	        LOGGER.info("new record number :" + count);
        }catch(Exception e){
        	LOGGER.error(e.toString());
        }
    }

}
