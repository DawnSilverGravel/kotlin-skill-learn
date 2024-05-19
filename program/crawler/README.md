# 网络爬虫

目标：https://wallhaven.cc/ （此网站目前只能通过特殊手段访问）

## 功能点

1. 爬取目标网站并解析指定页面参数数据：https://wallhaven.cc/search?q=anime%20girl&categories=111&purity=100&resolutions=1920x1080%2C2560x1440&ratios=16x9&sorting=favorites&order=desc&ai_art_filter=1&page=
2. 将图片下载到本地指定路径下，相同图片就直接覆盖掉即可
3. 将图片的信息以保存到指定文件中
4. 读取配置配置文件、修改配置文件以达到记录爬到了第几页的状态
