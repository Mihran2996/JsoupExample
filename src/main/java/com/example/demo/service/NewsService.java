package com.example.demo.service;

import com.example.demo.model.News;

import java.util.List;

public interface NewsService {
     void save(News news);

     boolean isExist(String newsTitle);

     List<News> getAllNews();
}
