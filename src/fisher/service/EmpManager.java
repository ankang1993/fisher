package fisher.service;

import fisher.domain.AttendType;
import fisher.domain.MyFile;
import fisher.domain.Manager;
import fisher.exception.HrException;
import fisher.vo.AttendBean;
import fisher.vo.FileBean;

import java.util.List;

public interface EmpManager {
    // 登录失败
    public static final int LOGIN_FAIL = 0;
    // 以普通员工登录
    public static final int LOGIN_EMP = 1;
    // 以经理登录
    public static final int LOGIN_MGR = 2;

    // 不能打卡
    public static final int NO_PUNCH = 0;
    // 只能上班打卡
    public static final int COME_PUNCH = 1;
    // 只能下班打卡
    public static final int LEAVE_PUNCH = 2;
    // 既可以上班，也可以下班打卡
    public static final int BOTH_PUNCH = 3;

    // 打卡失败
    public static final int PUNCH_FAIL = 0;
    // 已经打卡
    public static final int PUNCHED = 1;
    // 打卡成功
    public static final int PUNCH_SUCC = 2;

    // 以上午11点为上午时间的截止点
    public static final int AM_LIMIT = 11;


    // 以上午9点之前为正常上班
    public static final int COME_LIMIT = 9;
    // 以上午9~11点之间算迟到
    public static final int LATE_LIMIT = 11;
    // 以下午17点之后算正常下班
    public static final int LEAVE_LIMIT = 17;
    // 以上午16~17点之间算早退
    public static final int EARLY_LIMIT = 16;

    /**
     * 以经理身份来验证登录
     *
     * @param mgr 登录的经理身份
     * @return 登录后的身份确认:0为登录失败，1为登录emp 2为登录mgr
     */
    int validLogin(Manager mgr);

    /**
     * 自动打卡，周一到周五，早上7：00、中午12：00为每个员工插入旷工记录
     */
    void autoPunch();

    /**
     * 验证某个员工是否可打卡
     *
     * @param user    员工名
     * @param dutyDay 日期
     * @return 可打卡的类别
     */
    int validPunch(String user, String dutyDay);

    /**
     * 打卡
     *
     * @param user    员工名
     * @param dutyDay 打卡日期
     * @param isCome  是否是上班打卡
     * @return 打卡结果
     */
    int punch(String user, String dutyDay, boolean isCome);

    /**
     * 员工查看自己的最近三天非正常打卡
     *
     * @param empName 员工名
     * @return 该员工的最近三天的非正常打卡
     */
    List<AttendBean> unAttend(String empName);

    /**
     * 返回全部的出勤类别
     *
     * @return 全部的出勤类别
     */
    List<AttendType> getAllType();

    /**
     * 添加申请
     *
     * @param attId  申请的出勤ID
     * @param typeId 申请的类型ID
     * @param reason 申请的理由
     * @return 添加的结果
     */
    boolean addApplication(int attId, int typeId, String reason);

    /**
     * 返回全部文件
     *
     * @param page 页码
     * @param pageSize 每页数量
     * @return 全部文件
     */
    List<FileBean> getFiles(int page, int pageSize);

    /**
     * 返回文件总数
     *
     * @return 文件总数
     */
    long getCount();

    /**
     * 返回符合名字要求的文件
     *
     * @param name 文件名
     * @return 符合名字要求的全部文件
     */
    List<FileBean> getFilesByName(String name);

    /**
     * 下载指定文件
     *
     * @param fileId 文件ID
     * @return File文件
     */
    MyFile downloadFile(int fileId) throws HrException;

    /**
     * 上传新文件
     *
     * @param fileName 文件名
     * @param path 文件地址
     * @param type 文件类型
     * @return
     */
    void uploadFile(String fileName, String path, String type) throws HrException;

    /**
     * 删除指定文件
     *
     * @param fileId 文件名
     * @return
     */
    void deleteFile(int fileId) throws HrException;;

    /**
     * 修改密码
     *
     * @param mgrName 员工名
     * @param newPass 新密码
     * @return 更改成功与否
     */
    String editPassword(String mgrName, String newPass, String originalPass);
}
