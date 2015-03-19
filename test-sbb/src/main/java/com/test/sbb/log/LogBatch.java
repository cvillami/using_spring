package com.test.sbb.log;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.test.sbb.model.VwAlert;


public class LogBatch implements ItemWriter<VwAlert> {


	@Override
	public void write(List<? extends VwAlert> items) throws Exception {
		for(VwAlert a: items){
			System.out.println("Write   : " + a.toString() + "\n");
		}
	}

	

}