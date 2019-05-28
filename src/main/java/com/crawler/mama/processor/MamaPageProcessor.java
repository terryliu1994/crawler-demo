package com.crawler.mama.processor;

import com.crawler.mama.model.Mama;
import org.springframework.util.CollectionUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MamaPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(200);


    @Override
    public void process(Page page) {

        //page.addTargetRequests(page.getHtml().links().regex("(http://www\\.mama\\.cn/q/tlq/group/20562/\\d+/)").all());
        //page.addTargetRequests(page.getHtml().links().regex("(http://www\\.mama\\.cn/q/tlq/group_token/20562/\\d+/\\?t=\\d+&token=\\w+)").all());

        //page.putField("items", page.getHtml().xpath("//*[@id=\"threadlist\"]/div/div/dl/"));
        List<Selectable> pageList = page.getHtml().xpath("//*[@id=\"threadlist\"]/div/div/dl").nodes();
        if (CollectionUtils.isEmpty(pageList)) {
            return;
        }
        List<Mama> mamaList = new ArrayList<>(pageList.size());
        pageList.forEach(item -> mamaList.add(new Mama().setTitle(item.xpath("//dt/a/text()").toString())
                .setUserName(item.xpath("//dd/span[1]/a/text()").toString())
                .setAge(item.xpath("//dd/span[2]/text()").toString())
                .setCity(item.xpath("//dd/span[3]/text()").toString())
                .setHeat(item.xpath("//dd/div[@class='timebar']/span[1]/text()").toString())
                .setLastActiveTime(item.xpath("//dd/div[@class='timebar']/span[2]/text()").toString())
        ));
        page.putField("mamaList", mamaList);

        /*List<Selectable> pageNode = page.getHtml().xpath("//*[@class='pages']/div[@class='pg']/a[@class='nxt']").nodes();
        if(CollectionUtils.isEmpty(pageNode)) {
            return;
        }
        Selectable lastNode = pageNode.get(pageNode.size() - 1);
        if ("下一页".equals(lastNode.xpath("//a[@class='nxt']/text()").get())) {
            page.addTargetRequests(lastNode.links().all());
        }*/

        List<String> nextUrl = page.getHtml().xpath("//*[@class='pages']/div[@class='pg']/").nodes()
                .stream().filter(button -> "下一页".equals(button.xpath("//a[@class='nxt']/text()").get()))
                .map(button -> button.xpath("//a[@class='nxt']/@href").get()).collect(Collectors.toList());

        // 使用下一页按钮获取链接
        page.addTargetRequests(nextUrl);

    }

    @Override
    public Site getSite() {
        return site;
    }
}
