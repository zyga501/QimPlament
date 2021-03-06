package com;

import com.framework.utils.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxActionSupport extends ActionSupport {
    private final static String AJAXACTIONCOMPLETED = "ajaxActionCompleted";
    private final static String PAGE404 = "page404";
    private ArrayList<String> skipAction = new ArrayList<String>() {{
        add("user!login");
        add("user!logout");
        add("user!bindwx");
        add("user!getdt");
        add("khzlgl!login");
        add("khzlgl!fetchopenid");
        add("auth!generateverifycode");
        add("g!fetchgoodsinfo");
        add("g!goodsinfo");
        add("g!getgoodspaypic");
        add("g!goodspaypic");
    }};

    public HttpServletResponse getResponse() {
        return (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
    }

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
    }

    public String getAttribute(String key) {
        if (getRequest().getSession(false) != null) {
            return StringUtils.convertNullableString(getRequest().getSession(false).getAttribute(key));
        }
        return new String();
    }

    public void setAttribute(String key, Object value) {
        getRequest().getSession(true).setAttribute(key, value);
    }

    public void removeAttribute(String key) {
        if (getRequest().getSession(false) != null) {
            getRequest().getSession(false).removeAttribute(key);
        }
    }

    public void validate() {
        // lazyvalidate
        ActionContext context = ActionContext.getContext();
        String actionName = context.getName();
        if (getAttribute("uid").isEmpty() && !skipAction.contains(actionName.toLowerCase())) {
            try {
                System.out.println("url:"+getRequest().getRequestURL());
                getResponse().sendRedirect(getRequest().getScheme()+"://" + getRequest().getServerName() + getRequest().getContextPath() +"/login.jsp");
            } catch (Exception e) {
                System.out.println(actionName);
                e.printStackTrace();
            }
        }
        parameterMap_ = context.getParameters();
    }

    public Object getParameter(String paramterName) {
        if (parameterMap_ == null || parameterMap_.size() == 0) {
            return null;
        }

        try {
            if (parameterMap_.containsKey(paramterName)) {
                return ((Object[]) parameterMap_.get(paramterName))[0];
            }
        }
        catch (ClassCastException classCastException) {
            return parameterMap_.get(paramterName);
        }

        return null;
    }

    public void setParameter(Map<String, Object> parameters) {
        ActionContext.getContext().setParameters(parameters);
    }

    public String getAjaxActionResult() {
        return ajaxActionResult_;
    }
    public String AjaxActionComplete() {
        return AJAXACTIONCOMPLETED;
    }
    public String AjaxActionComplete(String pagename) {
        if (pagename.toLowerCase().equals("page404"))
            return PAGE404;
        else
            return "";
    }
    public String AjaxActionComplete( Map resultMap) {
        ajaxActionResult_ = JSONObject.fromObject(resultMap).toString();
        return AJAXACTIONCOMPLETED;
    }

//    public String AjaxActionComplete( Object resultObj) {
//        ajaxActionResult_ = JSONObject.fromObject(resultObj).toString();
//        return AJAXACTIONCOMPLETED;
//    }
//
    public String AjaxActionComplete(List resultList) {
        ajaxActionResult_ = JSONArray.fromObject(resultList).toString();
        return AJAXACTIONCOMPLETED;
    }

    public String AjaxActionComplete(boolean result) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("resultCode", "Failed");
        if (result) {
            resultMap.put("resultCode", "Succeed");
        }
        return AjaxActionComplete(resultMap);
    }

    public String AjaxActionComplete(boolean result, Map resultMap) {
        resultMap.put("resultCode", "Failed");
        if (result) {
            resultMap.put("resultCode", "Succeed");
        }

        return AjaxActionComplete(resultMap);
    }

    private String ajaxActionResult_;
    private Map parameterMap_;
}