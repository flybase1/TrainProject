package com.example.project03.config;

//@Configuration
public class DruidConfiguration {
//    private static final String DB_PREFIX = "spring.datasource";
//
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        //创建 servlet 注册实体
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new
//                StatViewServlet(), "/druid/*");
//        //设置 ip 白名单
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        //设置 ip 黑名单，如果 allow 与 deny 共同存在时,deny 优先于 allow
//        servletRegistrationBean.addInitParameter("deny", "192.168.0.19");
//        //设置控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", "druid");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        //是否可以重置数据
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean statFilter() { //创建过滤器
//
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new
//                WebStatFilter());
//        //设置过滤器过滤路径
//        filterRegistrationBean.addUrlPatterns("/*"); //忽略过滤的形式
//        filterRegistrationBean.addInitParameter("exclusions",
//                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}
