package com.crawler.mama.pipeline;

import com.crawler.mama.mapper.MamaMapper;
import com.crawler.mama.model.Mama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

@Component
public class MamaPipeline implements Pipeline {

    private final MamaMapper mamaMapper;

    @Autowired
    public MamaPipeline(MamaMapper mamaMapper) {
        this.mamaMapper = mamaMapper;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {

        /*Map<String, Object> all = resultItems.getAll();
        all.forEach((k, v) -> {
            if (v instanceof ArrayList && "mamaList".equals(k)) {
                ((List<Mama>) v).forEach(mama -> {
                    mamaMapper.insert(mama);
                });
            }
        });*/
        List<Mama> mamaList = resultItems.get("mamaList");
        mamaList.forEach(mamaMapper::insert);

    }
}
