package com.sandra.gate.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author: lenovo
 * @Description: 访问过滤器
 * @Date: 2019/7/10 10:21
 **/
@Component
public class AccessFilter extends ZuulFilter {

  @Override
  public String filterType() {

    return "pre";
  }

  @Override
  public int filterOrder() {

    return 0;
  }

  @Override
  public boolean shouldFilter() {

    return true;
  }

  @Override
  public Object run() throws ZuulException {

    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    Object accessToken = request.getParameter("token");
    if (accessToken == null) {
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      try {
        ctx.getResponse().getWriter().write("token is empty!");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
