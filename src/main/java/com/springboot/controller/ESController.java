package com.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.ArticleSearchRepository;
import com.springboot.entity.Article;

import cn.hutool.json.JSONUtil;


@RestController
public class ESController {
    @Autowired
    ArticleSearchRepository articleSearchRepository;
 
    /**
     * 保存
     * @return
     */
    @RequestMapping("/add")
    public String testSaveArticleIndex() {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setContent("elasticsearch based on lucene");
        article.setPostTime(new Date());
        articleSearchRepository.save(article);
        return "Ok";
    }
 
    /**
     * 查询
     * @param queryString
     * @return
     */
    @RequestMapping("/query")
    public List<Map<String,Object>> testSearch(String queryString) {
    	
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
      
        
        List<Map<String,Object>> returnMapList = new ArrayList<Map<String,Object>>();
      
        while (iterator.hasNext()) {
        	Map<String,Object> returnMap = new HashMap<String,Object>();
        	
            Article article = iterator.next();
            
            returnMap.put("article", article);
            System.out.println("content:"+article.getContent());
            
            returnMapList.add(returnMap);
            
        }
        
        

        
        return returnMapList;
        
    }
}
	
