package com.crawler.mama;

import com.crawler.mama.pipeline.MamaPipeline;
import com.crawler.mama.processor.MamaPageProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MamaApplicationTests {


    /*@Autowired
    private MamaPipeline mamaPipeline;*/

    @Test
    public void contextLoads() {

        /*Spider.create(new MamaPageProcessor())
                .addUrl("http://www.mama.cn/q/tlq/group/20562/1/")
                .addPipeline(mamaPipeline)
                .thread(5).run();*/
    }

}
