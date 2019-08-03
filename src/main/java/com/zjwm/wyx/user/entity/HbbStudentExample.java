package main.java.com.zjwm.wyx.user.entity;

import java.util.ArrayList;
import java.util.List;

public class HbbStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HbbStudentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSnumIsNull() {
            addCriterion("snum is null");
            return (Criteria) this;
        }

        public Criteria andSnumIsNotNull() {
            addCriterion("snum is not null");
            return (Criteria) this;
        }

        public Criteria andSnumEqualTo(String value) {
            addCriterion("snum =", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotEqualTo(String value) {
            addCriterion("snum <>", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThan(String value) {
            addCriterion("snum >", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThanOrEqualTo(String value) {
            addCriterion("snum >=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThan(String value) {
            addCriterion("snum <", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThanOrEqualTo(String value) {
            addCriterion("snum <=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLike(String value) {
            addCriterion("snum like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotLike(String value) {
            addCriterion("snum not like", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumIn(List<String> values) {
            addCriterion("snum in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotIn(List<String> values) {
            addCriterion("snum not in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumBetween(String value1, String value2) {
            addCriterion("snum between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotBetween(String value1, String value2) {
            addCriterion("snum not between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNull() {
            addCriterion("weixin is null");
            return (Criteria) this;
        }

        public Criteria andWeixinIsNotNull() {
            addCriterion("weixin is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinEqualTo(String value) {
            addCriterion("weixin =", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotEqualTo(String value) {
            addCriterion("weixin <>", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThan(String value) {
            addCriterion("weixin >", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinGreaterThanOrEqualTo(String value) {
            addCriterion("weixin >=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThan(String value) {
            addCriterion("weixin <", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLessThanOrEqualTo(String value) {
            addCriterion("weixin <=", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinLike(String value) {
            addCriterion("weixin like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotLike(String value) {
            addCriterion("weixin not like", value, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinIn(List<String> values) {
            addCriterion("weixin in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotIn(List<String> values) {
            addCriterion("weixin not in", values, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinBetween(String value1, String value2) {
            addCriterion("weixin between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andWeixinNotBetween(String value1, String value2) {
            addCriterion("weixin not between", value1, value2, "weixin");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andStuAddressIsNull() {
            addCriterion("stu_address is null");
            return (Criteria) this;
        }

        public Criteria andStuAddressIsNotNull() {
            addCriterion("stu_address is not null");
            return (Criteria) this;
        }

        public Criteria andStuAddressEqualTo(String value) {
            addCriterion("stu_address =", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotEqualTo(String value) {
            addCriterion("stu_address <>", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressGreaterThan(String value) {
            addCriterion("stu_address >", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressGreaterThanOrEqualTo(String value) {
            addCriterion("stu_address >=", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLessThan(String value) {
            addCriterion("stu_address <", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLessThanOrEqualTo(String value) {
            addCriterion("stu_address <=", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressLike(String value) {
            addCriterion("stu_address like", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotLike(String value) {
            addCriterion("stu_address not like", value, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressIn(List<String> values) {
            addCriterion("stu_address in", values, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotIn(List<String> values) {
            addCriterion("stu_address not in", values, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressBetween(String value1, String value2) {
            addCriterion("stu_address between", value1, value2, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andStuAddressNotBetween(String value1, String value2) {
            addCriterion("stu_address not between", value1, value2, "stuAddress");
            return (Criteria) this;
        }

        public Criteria andSchNameIsNull() {
            addCriterion("sch_name is null");
            return (Criteria) this;
        }

        public Criteria andSchNameIsNotNull() {
            addCriterion("sch_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchNameEqualTo(String value) {
            addCriterion("sch_name =", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotEqualTo(String value) {
            addCriterion("sch_name <>", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameGreaterThan(String value) {
            addCriterion("sch_name >", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameGreaterThanOrEqualTo(String value) {
            addCriterion("sch_name >=", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameLessThan(String value) {
            addCriterion("sch_name <", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameLessThanOrEqualTo(String value) {
            addCriterion("sch_name <=", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameLike(String value) {
            addCriterion("sch_name like", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotLike(String value) {
            addCriterion("sch_name not like", value, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameIn(List<String> values) {
            addCriterion("sch_name in", values, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotIn(List<String> values) {
            addCriterion("sch_name not in", values, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameBetween(String value1, String value2) {
            addCriterion("sch_name between", value1, value2, "schName");
            return (Criteria) this;
        }

        public Criteria andSchNameNotBetween(String value1, String value2) {
            addCriterion("sch_name not between", value1, value2, "schName");
            return (Criteria) this;
        }

        public Criteria andSchShengIsNull() {
            addCriterion("sch_sheng is null");
            return (Criteria) this;
        }

        public Criteria andSchShengIsNotNull() {
            addCriterion("sch_sheng is not null");
            return (Criteria) this;
        }

        public Criteria andSchShengEqualTo(String value) {
            addCriterion("sch_sheng =", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengNotEqualTo(String value) {
            addCriterion("sch_sheng <>", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengGreaterThan(String value) {
            addCriterion("sch_sheng >", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengGreaterThanOrEqualTo(String value) {
            addCriterion("sch_sheng >=", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengLessThan(String value) {
            addCriterion("sch_sheng <", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengLessThanOrEqualTo(String value) {
            addCriterion("sch_sheng <=", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengLike(String value) {
            addCriterion("sch_sheng like", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengNotLike(String value) {
            addCriterion("sch_sheng not like", value, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengIn(List<String> values) {
            addCriterion("sch_sheng in", values, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengNotIn(List<String> values) {
            addCriterion("sch_sheng not in", values, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengBetween(String value1, String value2) {
            addCriterion("sch_sheng between", value1, value2, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShengNotBetween(String value1, String value2) {
            addCriterion("sch_sheng not between", value1, value2, "schSheng");
            return (Criteria) this;
        }

        public Criteria andSchShiIsNull() {
            addCriterion("sch_shi is null");
            return (Criteria) this;
        }

        public Criteria andSchShiIsNotNull() {
            addCriterion("sch_shi is not null");
            return (Criteria) this;
        }

        public Criteria andSchShiEqualTo(String value) {
            addCriterion("sch_shi =", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiNotEqualTo(String value) {
            addCriterion("sch_shi <>", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiGreaterThan(String value) {
            addCriterion("sch_shi >", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiGreaterThanOrEqualTo(String value) {
            addCriterion("sch_shi >=", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiLessThan(String value) {
            addCriterion("sch_shi <", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiLessThanOrEqualTo(String value) {
            addCriterion("sch_shi <=", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiLike(String value) {
            addCriterion("sch_shi like", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiNotLike(String value) {
            addCriterion("sch_shi not like", value, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiIn(List<String> values) {
            addCriterion("sch_shi in", values, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiNotIn(List<String> values) {
            addCriterion("sch_shi not in", values, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiBetween(String value1, String value2) {
            addCriterion("sch_shi between", value1, value2, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchShiNotBetween(String value1, String value2) {
            addCriterion("sch_shi not between", value1, value2, "schShi");
            return (Criteria) this;
        }

        public Criteria andSchQuIsNull() {
            addCriterion("sch_qu is null");
            return (Criteria) this;
        }

        public Criteria andSchQuIsNotNull() {
            addCriterion("sch_qu is not null");
            return (Criteria) this;
        }

        public Criteria andSchQuEqualTo(String value) {
            addCriterion("sch_qu =", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuNotEqualTo(String value) {
            addCriterion("sch_qu <>", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuGreaterThan(String value) {
            addCriterion("sch_qu >", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuGreaterThanOrEqualTo(String value) {
            addCriterion("sch_qu >=", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuLessThan(String value) {
            addCriterion("sch_qu <", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuLessThanOrEqualTo(String value) {
            addCriterion("sch_qu <=", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuLike(String value) {
            addCriterion("sch_qu like", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuNotLike(String value) {
            addCriterion("sch_qu not like", value, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuIn(List<String> values) {
            addCriterion("sch_qu in", values, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuNotIn(List<String> values) {
            addCriterion("sch_qu not in", values, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuBetween(String value1, String value2) {
            addCriterion("sch_qu between", value1, value2, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchQuNotBetween(String value1, String value2) {
            addCriterion("sch_qu not between", value1, value2, "schQu");
            return (Criteria) this;
        }

        public Criteria andSchAddressIsNull() {
            addCriterion("sch_address is null");
            return (Criteria) this;
        }

        public Criteria andSchAddressIsNotNull() {
            addCriterion("sch_address is not null");
            return (Criteria) this;
        }

        public Criteria andSchAddressEqualTo(String value) {
            addCriterion("sch_address =", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressNotEqualTo(String value) {
            addCriterion("sch_address <>", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressGreaterThan(String value) {
            addCriterion("sch_address >", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressGreaterThanOrEqualTo(String value) {
            addCriterion("sch_address >=", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressLessThan(String value) {
            addCriterion("sch_address <", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressLessThanOrEqualTo(String value) {
            addCriterion("sch_address <=", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressLike(String value) {
            addCriterion("sch_address like", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressNotLike(String value) {
            addCriterion("sch_address not like", value, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressIn(List<String> values) {
            addCriterion("sch_address in", values, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressNotIn(List<String> values) {
            addCriterion("sch_address not in", values, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressBetween(String value1, String value2) {
            addCriterion("sch_address between", value1, value2, "schAddress");
            return (Criteria) this;
        }

        public Criteria andSchAddressNotBetween(String value1, String value2) {
            addCriterion("sch_address not between", value1, value2, "schAddress");
            return (Criteria) this;
        }

        public Criteria andFanweiIsNull() {
            addCriterion("fanwei is null");
            return (Criteria) this;
        }

        public Criteria andFanweiIsNotNull() {
            addCriterion("fanwei is not null");
            return (Criteria) this;
        }

        public Criteria andFanweiEqualTo(String value) {
            addCriterion("fanwei =", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiNotEqualTo(String value) {
            addCriterion("fanwei <>", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiGreaterThan(String value) {
            addCriterion("fanwei >", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiGreaterThanOrEqualTo(String value) {
            addCriterion("fanwei >=", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiLessThan(String value) {
            addCriterion("fanwei <", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiLessThanOrEqualTo(String value) {
            addCriterion("fanwei <=", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiLike(String value) {
            addCriterion("fanwei like", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiNotLike(String value) {
            addCriterion("fanwei not like", value, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiIn(List<String> values) {
            addCriterion("fanwei in", values, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiNotIn(List<String> values) {
            addCriterion("fanwei not in", values, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiBetween(String value1, String value2) {
            addCriterion("fanwei between", value1, value2, "fanwei");
            return (Criteria) this;
        }

        public Criteria andFanweiNotBetween(String value1, String value2) {
            addCriterion("fanwei not between", value1, value2, "fanwei");
            return (Criteria) this;
        }

        public Criteria andCengciIsNull() {
            addCriterion("cengci is null");
            return (Criteria) this;
        }

        public Criteria andCengciIsNotNull() {
            addCriterion("cengci is not null");
            return (Criteria) this;
        }

        public Criteria andCengciEqualTo(String value) {
            addCriterion("cengci =", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciNotEqualTo(String value) {
            addCriterion("cengci <>", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciGreaterThan(String value) {
            addCriterion("cengci >", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciGreaterThanOrEqualTo(String value) {
            addCriterion("cengci >=", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciLessThan(String value) {
            addCriterion("cengci <", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciLessThanOrEqualTo(String value) {
            addCriterion("cengci <=", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciLike(String value) {
            addCriterion("cengci like", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciNotLike(String value) {
            addCriterion("cengci not like", value, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciIn(List<String> values) {
            addCriterion("cengci in", values, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciNotIn(List<String> values) {
            addCriterion("cengci not in", values, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciBetween(String value1, String value2) {
            addCriterion("cengci between", value1, value2, "cengci");
            return (Criteria) this;
        }

        public Criteria andCengciNotBetween(String value1, String value2) {
            addCriterion("cengci not between", value1, value2, "cengci");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Integer value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Integer value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Integer value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Integer value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Integer> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Integer> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}