package com.zjwm.wyx.recruitment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.recruitment.entity.Article;
import com.zjwm.wyx.recruitment.service.ArticleService;
import com.zjwm.wyx.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public PageInfo<Article> list(Integer currPage) {
        currPage = (currPage == null) ? 1 : currPage;
        PageHelper.startPage(currPage, 14);
        // 查询列表数据
        List<Article> articles = articleService.queryList();
        for (Article userArticle : articles) {
            int time = userArticle.getCreateTime();
            String dateTime = DateUtils.timeStampToDate(String.valueOf(time), "yyyy-MM-dd");
            userArticle.setDateTime(dateTime);
        }
        PageInfo<Article> page = new PageInfo<>(articles);
        return page;
    }
    /**
     * 信息
     */
    @RequestMapping("/info")
    public Article info(Integer id) {
        Article userArticle = articleService.queryObject(id);

        return userArticle;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
