package com.example.demo.service;

import com.example.demo.model.News;
import com.example.demo.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public boolean isExist(String newsTitle) {
        boolean isTrue = false;
        List<News> all = newsRepository.findAll();
        for (News news : all) {
            if (news.getTitle().equals(newsTitle)) {
                isTrue = true;
            }
        }
        return isTrue;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
