package com.springboot.entity;


import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;
 
@Document(indexName ="es_article",type = "article",indexStoreType = "fs",shards = 5,replicas = 1)
@Data
public class Article implements Serializable {
    @Id
    private Long id; //ID
    private String title;  //标题
    private String abstracts;  //摘要
    private String content;  //内容
    private Date postTime;  //发表时间
 
 

}