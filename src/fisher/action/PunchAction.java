package fisher.action;

import com.opensymphony.xwork2.ActionContext;
import fisher.action.base.EmpBaseAction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PunchAction extends EmpBaseAction {
    // 封装处理结果的punchIsValid成员变量
    private int punchIsValid;

    // punchIsValid成员变量的setter和getter方法
    public void setPunchIsValid(int punchIsValid) {
        this.punchIsValid = punchIsValid;
    }

    public int getPunchIsValid() {
        return this.punchIsValid;
    }

    public String execute()
            throws Exception {
        // 创建ActionContext实例
        ActionContext ctx = ActionContext.getContext();
        // 获取HttpSession中的user属性
        String user = (String) ctx.getSession().get(WebConstant.USER);
        // 获取当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        // 格式化当前时间
        String dutyDay = sdf.format(c.getTime());
        // 调用业务逻辑方法处理用户请求
        int result = mgr.validPunch(user, dutyDay);
        setPunchIsValid(result);
        return SUCCESS;
    }
}