package com.avdbearing;

import com.avdbearing.domain.core.Part;
import com.avdbearing.repositories.PartRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@SpringBootApplication
public class AvdbearingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvdbearingApplication.class, args);
    }

}


@Component
class AppStartupRunner implements ApplicationRunner {
    @Resource
    PartRepository partRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Part firstPart = new Part();

        partRepository.save(firstPart);

    }
}