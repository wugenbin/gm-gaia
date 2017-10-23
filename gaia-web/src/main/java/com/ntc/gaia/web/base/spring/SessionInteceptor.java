package com.ntc.gaia.web.base.spring;

import com.ntc.gaia.base.utils.tools.StringUtil;
import com.ntc.gaia.web.base.vo.SessionLogic;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ntc.gaia.web.base.constants.ENIPConstants;
/**
 * WEB UI系统会话拦截器
 *
 * @author David
 * @datetime 2017-07-20
 */
@Component("SessionInteceptor")
public class SessionInteceptor extends HandlerInterceptorAdapter {

    private Logger log = Logger.getLogger(SessionInteceptor.class.getName());

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        super.afterCompletion(request, response, handler, ex);

    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request,
                                               HttpServletResponse response, Object handler) throws Exception {

        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);

        // 在request中设置会话SN
        request.setAttribute(ENIPConstants.US_SN,
                request.getParameter(ENIPConstants.US_SN));
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Object loginUser = request.getSession().getAttribute(
                ENIPConstants.LOGIN_SESSION_KEY);

        // 如果请求会话未丢失,但是SN错误或者服务器不存在就跳到登录界面
        String UID = request.getParameter(ENIPConstants.US_SN);
        if (StringUtil.notEmpty(UID)) {

            Object sessionObj = SessionLogic.getInstance().getLoginUC(UID);
            if (sessionObj != null) {
                request.setAttribute(ENIPConstants.US_SN, UID);
            } else {
                loginUser = null;
            }

        }
        if (loginUser == null) {

            // AJAX请求验证Session超时,返回状态结果600
            if (request.getHeader("x-requested-with") != null
                    && request.getHeader("x-requested-with").equalsIgnoreCase(
                    "XMLHttpRequest")) {

                // session 超时(返回600)
                response.setStatus(ENIPConstants.AJAX_TIMEOUT);
                return false;

            } else {

                log.log(Level.INFO, "Customer not login!");
                String url = "/?redirectUrl=" + request.getRequestURI();
                request.getRequestDispatcher(url).forward(request,
                        response);
                return false;
            }
        }

        return super.preHandle(request, response, handler);
    }
}
