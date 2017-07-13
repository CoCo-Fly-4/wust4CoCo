## 整体设计 
 +  Heritrix爬虫和Lucene索引技术获取、处理数据源
 +  Jsp+Servlet+Mysql搭建网站
 +  实现影视在线观看、评论、评分，管理员管理影视资源、用户信息等  
 
![整体设计图片](http://chuantu.biz/t5/125/1499172857x974338535.png) 

## (一) 关于Heritrix爬虫  

![Heritrix设计](http://chuantu.biz/t5/125/1499179381x974338535.png)

+  目标网站：good影视网、电影天堂
+  种子网站：
+  过滤要求：

主要爬取内容：  
+  影视外链
+  视频名称、介绍、分类等
+  图片链接

## (二) 关于Lucene索引

![Lucene设计](http://chuantu.biz/t5/125/1499179395x974338535.png)

+  将爬取到的内容转化为文本
+  生成索引文件
+  通过索引完成后期的搜索引擎及排序

## (三) 数据库设计
数据库 ：Mysql5.6  环境：java
表设计：   
+  user表         属性：
+  movie表        属性：
+  actor表        属性：
+  info表         属性：
+  comment表      属性：

## (四) 网站设计
网页 | 功能 |备注
----|------|----
register.jsp | 用户注册  | 客户端已完成
login.jsp | 用户登录  | 客户端已完成
index.jsp | 主页  | 暂缺
search.jsp |搜索  | 暂缺
movie.jsp | 影视分页  | 暂缺
actor.jsp | 按演员分页  | 暂缺
destial.jsp | 影视详情页  | 暂缺
play.jsp | 播放页  | 暂缺

## (五) 后台设计
1.注册与登录设计  
2.主页设计  
3.搜索设计  
4.分类分页设计  
5.个性化推荐设计  












