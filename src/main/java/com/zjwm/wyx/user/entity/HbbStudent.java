package com.zjwm.wyx.user.entity;

public class HbbStudent {
    private Integer id;

    private Integer userId;

    private String name;

    private Integer sex;

    private String snum;

    private String qq;

    private String weixin;

    private String phone;

    private String stuAddress;

    private String schName;

    private String schSheng;

    private String schShi;

    private String schQu;

    private String schAddress;

    private String fanwei;

    private String cengci;

    private String grade;

    private String major;

    private Integer createTime;

    private Integer updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum == null ? null : snum.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName == null ? null : schName.trim();
    }

    public String getSchSheng() {
        return schSheng;
    }

    public void setSchSheng(String schSheng) {
        this.schSheng = schSheng == null ? null : schSheng.trim();
    }

    public String getSchShi() {
        return schShi;
    }

    public void setSchShi(String schShi) {
        this.schShi = schShi == null ? null : schShi.trim();
    }

    public String getSchQu() {
        return schQu;
    }

    public void setSchQu(String schQu) {
        this.schQu = schQu == null ? null : schQu.trim();
    }

    public String getSchAddress() {
        return schAddress;
    }

    public void setSchAddress(String schAddress) {
        this.schAddress = schAddress == null ? null : schAddress.trim();
    }

    public String getFanwei() {
        return fanwei;
    }

    public void setFanwei(String fanwei) {
        this.fanwei = fanwei == null ? null : fanwei.trim();
    }

    public String getCengci() {
        return cengci;
    }

    public void setCengci(String cengci) {
        this.cengci = cengci == null ? null : cengci.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}