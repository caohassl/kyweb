package com.kyweb.handlerInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Created by Caomr on 2017/9/12.
 */
@lombok.extern.slf4j.Slf4j
public class MyHandlerInterceptor implements HandlerInterceptor{

    private static String ip;
    /**
     * 打印用户的ip和访问路径
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
          ip = httpServletRequest.getHeader("x-forwarded-for");
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = httpServletRequest.getHeader("Proxy-Client-IP");
                     }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                        ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
                    }
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                        ip = httpServletRequest.getHeader("HTTP_CLIENT_IP");
                     }
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = httpServletRequest.getHeader("HTTP_X_FORWARDED_FOR");
                    }
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                        ip = httpServletRequest.getRemoteAddr();
                     }
        log.info("remote user ip :{} login in and request : {}",ip,httpServletRequest.getRequestURI());
                 if("/kyweb/error".equals(httpServletRequest.getRequestURI())){
//                     httpServletRequest.red
                     httpServletResponse.sendRedirect("standard/getLastDays");
                 }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
            log.info("user ip :{} has finished",ip);
    }
}
