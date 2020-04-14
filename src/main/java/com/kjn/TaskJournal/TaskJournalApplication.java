package com.kjn.TaskJournal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kjn.TaskJournal.repository")
public class TaskJournalApplication {

	public static void main (String[] args) {
		SpringApplication.run(TaskJournalApplication.class, args);
	}

}
