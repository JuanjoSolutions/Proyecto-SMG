package com.feedback2.proyectosmg.mision.batch;

import com.feedback2.proyectosmg.mision.model.MisionData;
import com.feedback2.proyectosmg.mision.repository.MisionRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilderFactory;
import org.springframework.batch.core.step.builder.StepBuilderFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;
import java.time.LocalDateTime;
import java.util.Collections;

@Configuration
@EnableBatchProcessing
public class MisionBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MisionRepository misionRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaPagingItemReader<MisionData> reader() {
        return new JpaPagingItemReaderBuilder<MisionData>()
                .name("misionDataReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT m FROM MisionData m WHERE m.timestamp >= :fechaInicio")
                .parameterValues(Collections.singletonMap("fechaInicio", LocalDateTime.now().minusDays(1)))
                .pageSize(10)
                .build();
    }

    @Bean
    public FlatFileItemWriter<MisionData> writer() {
        return new FlatFileItemWriterBuilder<MisionData>()
                .name("misionDataWriter")
                .resource(new org.springframework.core.io.FileSystemResource("mision-output.csv"))
                .delimited()
                .delimiter(",")
                .names(new String[]{"id", "sensor", "valor", "timestamp"})
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<MisionData, MisionData>chunk(10)
                .reader(reader())
                .writer(writer())
                .build();
    }

    @Bean
    public Job exportMisionJob() {
        return jobBuilderFactory.get("exportMisionJob")
                .flow(step1())
                .end()
                .build();
    }
}

