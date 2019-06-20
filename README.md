# 结构

```
com.mingrn.itumate.global
.
├── annotation                  // 元注解
├── aspect                      // AOP
├── config                      // 基本配置, MVC,BEAN
├── constants                   // 常量,响应状态码...
├── enums                       // 枚举
├── exception                   // 自定义异常
├── filter                      // 过滤器
├── handle                      // 全局处理,全局异常处理,Swagger配置
└── result                      // 统一消息响应
```

# application.properties 配置

其他工程在引用该模块时需要配置 `Swagger RestFul API` 基本信息，如下：

```properties
# 工程(服务)名称,必须
restful.api.title=
# 工程(服务)版本号
restful.api.version=
# 工程(服务)包路径,必须
restful.api.web.base.package=
# 工程(服务)地址
restful.api.contact.url=
# 工程(服务)基本描述信息
restful.api.description=
# 工程(服务)负载人
restful.api.contact.name=
# 工程(服务)负责人联系邮箱
restful.api.contact.email=
# 团队等服务地址
restful.api.termsOfServiceUrl=
```