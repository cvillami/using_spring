package com.test.sbb;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.test.sbb.log.LogBatch;
import com.test.sbb.model.VwAlert;
import com.test.sbb.processor.ProcessorBatch;



@ComponentScan("com.test.sbb")
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@PropertySource("classpath:application.properties")
public class AgentBatchPM {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;
	
	@Autowired
	private LocalContainerEntityManagerFactoryBean lcemfb;
	

	/**
     * JPAPagingItemReader
     *
     * @return
     */
    @Bean
    public ItemReader<VwAlert> reader() throws Exception {
    	
        String jpqlQuery = "select a from VwAlert a";
 
		JpaPagingItemReader<VwAlert> reader = new JpaPagingItemReader<VwAlert>();
		reader.setEntityManagerFactory(lcemfb.getObject());
		reader.setQueryString(jpqlQuery);
		reader.setPageSize(10);
		reader.afterPropertiesSet();
		reader.setSaveState(false);
		reader.setTransacted(false);
		
		return reader;
    }
	
    @Bean
    public ItemWriter<VwAlert> writer() {
    	return new LogBatch();
    }
    
    /**
     * The ItemProcessor is called after a new record is read and it allows the developer
     * to transform the data read
     * In our example it simply read and write the data
     *
     * @return
     */
    @Bean
    public ItemProcessor<VwAlert, VwAlert> processor() {
        return new ProcessorBatch();
    }
    
	@Bean
	protected Tasklet tasklet() {
		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution,
					ChunkContext context) {
				return RepeatStatus.FINISHED;
			}
		};
	}

	@Bean
	public Job job() throws Exception {
		return this.jobs.get("job").start(step1()).build();
	}

	@Bean
	protected Step step1() throws Exception {
		return this.steps.get("step1")
				.<VwAlert,VwAlert>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
}
