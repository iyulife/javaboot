# JavaBoot（微服务核心）

## 规范

### 注解

- 一律使用方法上/** **/方式，不允许出现//的注解

### 代码规范

- 超过2层变量必须声明,例如：`对象A.对象B`是正确的，但是`对象A.对象B.对象C`是错误的
-

### 类注释规范

```aidl
/**
 * Description: UUID工具类
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
```

### 类文件自定义规则

- 前面加custom

### 日志

- 统一采用注解式

``` java
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;

  @Slf4j
  public  class Test(){
    public void test(){
      logger.info("...");
    }
  }
  ```

## 项目结构

### ---bootstrap 启动器

### ---cloud-starter 微服务自动装配器

### ---core 核心器

### ---log-starter 日志自动装配器

## 说明

- 引入spring boot 3.0.4
- 引入jdk 17.06
- 如果报错找不到“C:\Windows\Temp",在启动时加入参数`-Djava.io.tmpdir=D:\TEMP`
- 如果profile设置为Dev则日志只会输出到控制台，否则输出到/val/log目录下
- 刚安装好nacos点击startup.cmd时出现报错`java.io.IOException: java.lang.IllegalArgumentException: db.num is null`
## 开发计划

- 日志链路跟踪（√）
- 集成spring boot admin，支持上下线发邮件、在线查看日志（√）
- 集成feign

## 参照

- https://github.com/986223663/spring-cloud-alibaba-dubbo
- https://gitee.com/log4j/pig?_from=gitee_search#https://gitee.com/link?target=https%3A%2F%2Fpaper.pigx.vip
