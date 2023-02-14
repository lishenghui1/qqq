//package com.hhh.jjj.untils;
//
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginHandlerInterceptor  implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //  未进controller方法
//        //  true  ---继续执行controller方法
//        //  false ---无法进行controller方法
//        Object user = request.getSession().getAttribute("user");
//        if(user==null){  // session  未登录
//            request.setAttribute("msg","您暂未登录，请您登录后再试！");
//            request.getRequestDispatcher("/").forward(request,response);// 登录界面
//            return false;
//        }
//        return  true;//放行
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
//
//
