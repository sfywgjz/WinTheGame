package com.sf.Job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.sf.mapper.MarketGroupDetailMapper;

public class JobService {

	@Autowired
	private MarketGroupDetailMapper marketGroupDetailMapper;

    public void generateGroup() {
        System.out.println("check generate group on :" + new Date());
        int count = 0;
        try{
	        count = marketGroupDetailMapper.updateEndingMarket();
	        System.out.println("update record number :" + count);
        }catch(Exception e){
        	System.out.println(e.toString());
        }

        try{
	        count = marketGroupDetailMapper.newMarket();
	        System.out.println("new record number :" + count);
        }catch(Exception e){
        	System.out.println(e.toString());
        }
    }

}
