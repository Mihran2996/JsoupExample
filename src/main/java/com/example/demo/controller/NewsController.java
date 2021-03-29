package com.example.demo.controller;

import com.example.demo.model.News;
import com.example.demo.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping("/")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }
}
