package com.crawler.mama;

import com.crawler.mama.pipeline.MamaPipeline;
import com.crawler.mama.processor.MamaPageProcessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@SpringBootApplication
@MapperScan("**.*.mapper")
@Component
public class MamaApplication {

    private static MamaPipeline mamaPipeline;

    @Autowired
    public MamaApplication(MamaPipeline mamaPipeline) {
        MamaApplication.mamaPipeline = mamaPipeline;
    }

    public static void main(String[] args) {
        SpringApplication.run(MamaApplication.class, args);

        Spider.create(new MamaPageProcessor())
                .addUrl("http://www.mama.cn/q/tlq/group/20562/1/")
                .addPipeline(mamaPipeline)
                .thread(10).run();
    }

}
