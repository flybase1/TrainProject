package com.example.project03.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            // 查看你的哪个方法被拦截住
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            String methodname = method.getName();
            log.info("====拦截到了方法：{}，在该方法执行之前执行====", methodname);
            // 返回 true 才会继续执行，返回 false 则取消当前请求
//            String token = request.getParameter("token");
//            if (token == null || token.equals("")) {
//                log.error("用户未登录");
//                return false;
//            }

            UnInterception unInterception = method.getAnnotation(UnInterception.class);
            if (null != unInterception) {
                return true;
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String path = request.getRequestURI();
        log.info("postHandle-------------------请求路径：" + path + "。执行完方法之后执行(Controller 方法调用之后)，但是此时还没进行视图渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        String path = request.getRequestURI();
        log.info("afterCompletion---------------请求路径：" + path + "。整个请求都处理完，DispatcherServlet 也渲染了对应的视图，此时我可以做一些清理的工作了");
    }
}
