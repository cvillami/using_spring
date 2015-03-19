package com.test.sbb.processor;

import org.springframework.batch.item.ItemProcessor;

import com.test.sbb.model.VwAlert;

public class ProcessorBatch implements ItemProcessor<VwAlert, VwAlert> {

	@Override
	public VwAlert process(VwAlert item) throws Exception {
		
		System.out.println("................");
		System.out.println(item.toString());
		System.out.println("................");
		
		return item;
	}

}
