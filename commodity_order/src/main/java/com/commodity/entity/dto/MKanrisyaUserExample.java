package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MKanrisyaUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MKanrisyaUserExample() {
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

        public Criteria andKanriUserIdIsNull() {
            addCriterion("KANRI_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdIsNotNull() {
            addCriterion("KANRI_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdEqualTo(String value) {
            addCriterion("KANRI_USER_ID =", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdNotEqualTo(String value) {
            addCriterion("KANRI_USER_ID <>", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdGreaterThan(String value) {
            addCriterion("KANRI_USER_ID >", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("KANRI_USER_ID >=", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdLessThan(String value) {
            addCriterion("KANRI_USER_ID <", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdLessThanOrEqualTo(String value) {
            addCriterion("KANRI_USER_ID <=", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdLike(String value) {
            addCriterion("KANRI_USER_ID like", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdNotLike(String value) {
            addCriterion("KANRI_USER_ID not like", value, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdIn(List<String> values) {
            addCriterion("KANRI_USER_ID in", values, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdNotIn(List<String> values) {
            addCriterion("KANRI_USER_ID not in", values, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdBetween(String value1, String value2) {
            addCriterion("KANRI_USER_ID between", value1, value2, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserIdNotBetween(String value1, String value2) {
            addCriterion("KANRI_USER_ID not between", value1, value2, "kanriUserId");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordIsNull() {
            addCriterion("KANRI_USER_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordIsNotNull() {
            addCriterion("KANRI_USER_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordEqualTo(String value) {
            addCriterion("KANRI_USER_PASSWORD =", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordNotEqualTo(String value) {
            addCriterion("KANRI_USER_PASSWORD <>", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordGreaterThan(String value) {
            addCriterion("KANRI_USER_PASSWORD >", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("KANRI_USER_PASSWORD >=", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordLessThan(String value) {
            addCriterion("KANRI_USER_PASSWORD <", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("KANRI_USER_PASSWORD <=", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordLike(String value) {
            addCriterion("KANRI_USER_PASSWORD like", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordNotLike(String value) {
            addCriterion("KANRI_USER_PASSWORD not like", value, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordIn(List<String> values) {
            addCriterion("KANRI_USER_PASSWORD in", values, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordNotIn(List<String> values) {
            addCriterion("KANRI_USER_PASSWORD not in", values, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordBetween(String value1, String value2) {
            addCriterion("KANRI_USER_PASSWORD between", value1, value2, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserPasswordNotBetween(String value1, String value2) {
            addCriterion("KANRI_USER_PASSWORD not between", value1, value2, "kanriUserPassword");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmIsNull() {
            addCriterion("KANRI_USER_NM is null");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmIsNotNull() {
            addCriterion("KANRI_USER_NM is not null");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmEqualTo(String value) {
            addCriterion("KANRI_USER_NM =", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmNotEqualTo(String value) {
            addCriterion("KANRI_USER_NM <>", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmGreaterThan(String value) {
            addCriterion("KANRI_USER_NM >", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmGreaterThanOrEqualTo(String value) {
            addCriterion("KANRI_USER_NM >=", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmLessThan(String value) {
            addCriterion("KANRI_USER_NM <", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmLessThanOrEqualTo(String value) {
            addCriterion("KANRI_USER_NM <=", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmLike(String value) {
            addCriterion("KANRI_USER_NM like", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmNotLike(String value) {
            addCriterion("KANRI_USER_NM not like", value, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmIn(List<String> values) {
            addCriterion("KANRI_USER_NM in", values, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmNotIn(List<String> values) {
            addCriterion("KANRI_USER_NM not in", values, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmBetween(String value1, String value2) {
            addCriterion("KANRI_USER_NM between", value1, value2, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andKanriUserNmNotBetween(String value1, String value2) {
            addCriterion("KANRI_USER_NM not between", value1, value2, "kanriUserNm");
            return (Criteria) this;
        }

        public Criteria andSvFlgIsNull() {
            addCriterion("SV_FLG is null");
            return (Criteria) this;
        }

        public Criteria andSvFlgIsNotNull() {
            addCriterion("SV_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andSvFlgEqualTo(String value) {
            addCriterion("SV_FLG =", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgNotEqualTo(String value) {
            addCriterion("SV_FLG <>", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgGreaterThan(String value) {
            addCriterion("SV_FLG >", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgGreaterThanOrEqualTo(String value) {
            addCriterion("SV_FLG >=", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgLessThan(String value) {
            addCriterion("SV_FLG <", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgLessThanOrEqualTo(String value) {
            addCriterion("SV_FLG <=", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgLike(String value) {
            addCriterion("SV_FLG like", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgNotLike(String value) {
            addCriterion("SV_FLG not like", value, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgIn(List<String> values) {
            addCriterion("SV_FLG in", values, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgNotIn(List<String> values) {
            addCriterion("SV_FLG not in", values, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgBetween(String value1, String value2) {
            addCriterion("SV_FLG between", value1, value2, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSvFlgNotBetween(String value1, String value2) {
            addCriterion("SV_FLG not between", value1, value2, "svFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgIsNull() {
            addCriterion("SIYOU_KAHI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgIsNotNull() {
            addCriterion("SIYOU_KAHI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgEqualTo(String value) {
            addCriterion("SIYOU_KAHI_FLG =", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgNotEqualTo(String value) {
            addCriterion("SIYOU_KAHI_FLG <>", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgGreaterThan(String value) {
            addCriterion("SIYOU_KAHI_FLG >", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgGreaterThanOrEqualTo(String value) {
            addCriterion("SIYOU_KAHI_FLG >=", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgLessThan(String value) {
            addCriterion("SIYOU_KAHI_FLG <", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgLessThanOrEqualTo(String value) {
            addCriterion("SIYOU_KAHI_FLG <=", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgLike(String value) {
            addCriterion("SIYOU_KAHI_FLG like", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgNotLike(String value) {
            addCriterion("SIYOU_KAHI_FLG not like", value, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgIn(List<String> values) {
            addCriterion("SIYOU_KAHI_FLG in", values, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgNotIn(List<String> values) {
            addCriterion("SIYOU_KAHI_FLG not in", values, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgBetween(String value1, String value2) {
            addCriterion("SIYOU_KAHI_FLG between", value1, value2, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andSiyouKahiFlgNotBetween(String value1, String value2) {
            addCriterion("SIYOU_KAHI_FLG not between", value1, value2, "siyouKahiFlg");
            return (Criteria) this;
        }

        public Criteria andKoushinBiIsNull() {
            addCriterion("KOUSHIN_BI is null");
            return (Criteria) this;
        }

        public Criteria andKoushinBiIsNotNull() {
            addCriterion("KOUSHIN_BI is not null");
            return (Criteria) this;
        }

        public Criteria andKoushinBiEqualTo(Date value) {
            addCriterion("KOUSHIN_BI =", value, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiNotEqualTo(Date value) {
            addCriterion("KOUSHIN_BI <>", value, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiGreaterThan(Date value) {
            addCriterion("KOUSHIN_BI >", value, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiGreaterThanOrEqualTo(Date value) {
            addCriterion("KOUSHIN_BI >=", value, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiLessThan(Date value) {
            addCriterion("KOUSHIN_BI <", value, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiLessThanOrEqualTo(Date value) {
            addCriterion("KOUSHIN_BI <=", value, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiIn(List<Date> values) {
            addCriterion("KOUSHIN_BI in", values, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiNotIn(List<Date> values) {
            addCriterion("KOUSHIN_BI not in", values, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiBetween(Date value1, Date value2) {
            addCriterion("KOUSHIN_BI between", value1, value2, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinBiNotBetween(Date value1, Date value2) {
            addCriterion("KOUSHIN_BI not between", value1, value2, "koushinBi");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridIsNull() {
            addCriterion("KOUSHIN_USERID is null");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridIsNotNull() {
            addCriterion("KOUSHIN_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridEqualTo(String value) {
            addCriterion("KOUSHIN_USERID =", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridNotEqualTo(String value) {
            addCriterion("KOUSHIN_USERID <>", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridGreaterThan(String value) {
            addCriterion("KOUSHIN_USERID >", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridGreaterThanOrEqualTo(String value) {
            addCriterion("KOUSHIN_USERID >=", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridLessThan(String value) {
            addCriterion("KOUSHIN_USERID <", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridLessThanOrEqualTo(String value) {
            addCriterion("KOUSHIN_USERID <=", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridLike(String value) {
            addCriterion("KOUSHIN_USERID like", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridNotLike(String value) {
            addCriterion("KOUSHIN_USERID not like", value, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridIn(List<String> values) {
            addCriterion("KOUSHIN_USERID in", values, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridNotIn(List<String> values) {
            addCriterion("KOUSHIN_USERID not in", values, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridBetween(String value1, String value2) {
            addCriterion("KOUSHIN_USERID between", value1, value2, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andKoushinUseridNotBetween(String value1, String value2) {
            addCriterion("KOUSHIN_USERID not between", value1, value2, "koushinUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuBiIsNull() {
            addCriterion("TOUROKU_BI is null");
            return (Criteria) this;
        }

        public Criteria andTourokuBiIsNotNull() {
            addCriterion("TOUROKU_BI is not null");
            return (Criteria) this;
        }

        public Criteria andTourokuBiEqualTo(Date value) {
            addCriterion("TOUROKU_BI =", value, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiNotEqualTo(Date value) {
            addCriterion("TOUROKU_BI <>", value, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiGreaterThan(Date value) {
            addCriterion("TOUROKU_BI >", value, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiGreaterThanOrEqualTo(Date value) {
            addCriterion("TOUROKU_BI >=", value, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiLessThan(Date value) {
            addCriterion("TOUROKU_BI <", value, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiLessThanOrEqualTo(Date value) {
            addCriterion("TOUROKU_BI <=", value, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiIn(List<Date> values) {
            addCriterion("TOUROKU_BI in", values, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiNotIn(List<Date> values) {
            addCriterion("TOUROKU_BI not in", values, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiBetween(Date value1, Date value2) {
            addCriterion("TOUROKU_BI between", value1, value2, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuBiNotBetween(Date value1, Date value2) {
            addCriterion("TOUROKU_BI not between", value1, value2, "tourokuBi");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridIsNull() {
            addCriterion("TOUROKU_USERID is null");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridIsNotNull() {
            addCriterion("TOUROKU_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridEqualTo(String value) {
            addCriterion("TOUROKU_USERID =", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridNotEqualTo(String value) {
            addCriterion("TOUROKU_USERID <>", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridGreaterThan(String value) {
            addCriterion("TOUROKU_USERID >", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridGreaterThanOrEqualTo(String value) {
            addCriterion("TOUROKU_USERID >=", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridLessThan(String value) {
            addCriterion("TOUROKU_USERID <", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridLessThanOrEqualTo(String value) {
            addCriterion("TOUROKU_USERID <=", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridLike(String value) {
            addCriterion("TOUROKU_USERID like", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridNotLike(String value) {
            addCriterion("TOUROKU_USERID not like", value, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridIn(List<String> values) {
            addCriterion("TOUROKU_USERID in", values, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridNotIn(List<String> values) {
            addCriterion("TOUROKU_USERID not in", values, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridBetween(String value1, String value2) {
            addCriterion("TOUROKU_USERID between", value1, value2, "tourokuUserid");
            return (Criteria) this;
        }

        public Criteria andTourokuUseridNotBetween(String value1, String value2) {
            addCriterion("TOUROKU_USERID not between", value1, value2, "tourokuUserid");
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