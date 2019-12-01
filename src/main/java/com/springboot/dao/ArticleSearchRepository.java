package com.springboot.dao;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Article;

@Repository
public interface ArticleSearchRepository extends ElasticsearchRepository<Article,Long> {
 
}
