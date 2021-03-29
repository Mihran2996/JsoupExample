package com.example.demo;

import com.example.demo.model.News;
import com.example.demo.service.NewsServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParseTask {
    @Autowired
    private NewsServiceImpl newsService;

    @Scheduled(fixedDelay = 10000)
    public void parseNewNews() throws IOException {
        String url = "https://news.ycombinator.com";
        Document document = Jsoup.connect(url).get();
        Elements news = document.getElementsByClass("storylink");
        for (Element element : news) {
            String title = element.ownText();
            if (!newsService.isExist(title)) {
                News news1 = new News();
                news1.setTitle(title);
                newsService.save(news1);
            }
        }

    }
}
