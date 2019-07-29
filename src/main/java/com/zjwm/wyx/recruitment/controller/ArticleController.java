/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: ArticleController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.recruitment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.recruitment.entity.Article;
import com.zjwm.wyx.recruitment.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * Description: 我的求职-收藏攻略
 * version 2018.3
 */
@RestController
@RequestMapping("/article")
@Api(description = "我的求职-收藏攻略")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     *功能描述：查询所有文章
     *@author 王俊涛
     *@version 2018.3
     *@param currPage 当前页，默认是1
     *@return com.github.pagehelper.PageInfo<com.zjwm.wyx.recruitment.entity.Article>
     */
    @GetMapping("/list")
    @ApiOperation(value = "查询所有文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", required = false, dataType = "int"),
    })
    public PageInfo<Article> list(Integer currPage) {
        currPage = (currPage == null) ? 1 : currPage;
        PageHelper.startPage(currPage, 14);
        // 查询列表数据
        List<Article> articles = articleService.queryList();
        PageInfo<Article> page = new PageInfo<>(articles);
        return page;
    }

    /**
     *功能描述：根据id获取文章信息
     *@author 王俊涛
     *@version 2018.3
     *@param id 文章id
     *@return com.zjwm.wyx.recruitment.entity.Article
     */
    @GetMapping("/info")
    @ApiOperation(value = "根据id获取文章信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "文章id,如2", required = true, dataType = "int"),
    })

    public Article info(Integer id) {
        Article userArticle = articleService.queryObject(id);

        return userArticle;
    }

    /**
     * 删除
     */
    @GetMapping("/delete")
    @ApiOperation(value = "根据id删除文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "文章id", required = true, dataType = "int"),
    })
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
