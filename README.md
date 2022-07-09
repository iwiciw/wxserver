# 说明
## 代码
### 启动过程
1. 建立本地数据库，执行db目录中的sql
2. 修改application.yml中的数据库信息

### sql代码生成
1. 类com.wx.utils.CodeGenerator修改数据源
2. 运行CodeGenerator
3. 控制台输入表名，执行


### api文档
1. 运行com.wx.utils.DocsGenerator方法


## sprint 1

### 接口

#### 品牌库
- 根据条件查品牌信息：com.wx.controller.TeaBrandController.list

#### 我的品牌
本期不做编辑

- 自定义添加：com.wx.controller.UserTeaBrandController.create
- 从品牌库添加：com.wx.controller.UserTeaBrandController.createFromLibary
- 删除：com.wx.controller.UserTeaBrandController.delete
- 列表：com.wx.controller.UserTeaBrandController.list

#### 打卡
- ~~创建奶茶消费记录：com.wx.controller.t.create~~
- ~~删除奶茶消费记录：com.wx.controller.TeaRecordController.delete~~
- ~~编辑奶茶消费记录：com.wx.controller.TeaRecordController.update~~
- ~~查询奶茶消费记录：com.wx.controller.TeaRecordController.list~~

#### 统计
- 打卡页面奶茶统计：com.wx.controller.TeaStatisticController.statistic

#### 排行榜
- 排行榜查询：com.wx.controller.TeaRankController.list

#### 图片上传 
开发完成，可采用前端开发方式
- ~~上传：com.wx.controller.os.CosController.upload~~
- ~~删除：com.wx.controller.os.CosController.delete~~



