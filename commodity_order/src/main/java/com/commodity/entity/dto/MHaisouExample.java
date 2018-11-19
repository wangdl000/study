package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MHaisouExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MHaisouExample() {
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

        public Criteria andHaisouCdIsNull() {
            addCriterion("HAISOU_CD is null");
            return (Criteria) this;
        }

        public Criteria andHaisouCdIsNotNull() {
            addCriterion("HAISOU_CD is not null");
            return (Criteria) this;
        }

        public Criteria andHaisouCdEqualTo(String value) {
            addCriterion("HAISOU_CD =", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdNotEqualTo(String value) {
            addCriterion("HAISOU_CD <>", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdGreaterThan(String value) {
            addCriterion("HAISOU_CD >", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdGreaterThanOrEqualTo(String value) {
            addCriterion("HAISOU_CD >=", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdLessThan(String value) {
            addCriterion("HAISOU_CD <", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdLessThanOrEqualTo(String value) {
            addCriterion("HAISOU_CD <=", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdLike(String value) {
            addCriterion("HAISOU_CD like", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdNotLike(String value) {
            addCriterion("HAISOU_CD not like", value, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdIn(List<String> values) {
            addCriterion("HAISOU_CD in", values, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdNotIn(List<String> values) {
            addCriterion("HAISOU_CD not in", values, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdBetween(String value1, String value2) {
            addCriterion("HAISOU_CD between", value1, value2, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouCdNotBetween(String value1, String value2) {
            addCriterion("HAISOU_CD not between", value1, value2, "haisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouNameIsNull() {
            addCriterion("HAISOU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andHaisouNameIsNotNull() {
            addCriterion("HAISOU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andHaisouNameEqualTo(String value) {
            addCriterion("HAISOU_NAME =", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameNotEqualTo(String value) {
            addCriterion("HAISOU_NAME <>", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameGreaterThan(String value) {
            addCriterion("HAISOU_NAME >", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameGreaterThanOrEqualTo(String value) {
            addCriterion("HAISOU_NAME >=", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameLessThan(String value) {
            addCriterion("HAISOU_NAME <", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameLessThanOrEqualTo(String value) {
            addCriterion("HAISOU_NAME <=", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameLike(String value) {
            addCriterion("HAISOU_NAME like", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameNotLike(String value) {
            addCriterion("HAISOU_NAME not like", value, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameIn(List<String> values) {
            addCriterion("HAISOU_NAME in", values, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameNotIn(List<String> values) {
            addCriterion("HAISOU_NAME not in", values, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameBetween(String value1, String value2) {
            addCriterion("HAISOU_NAME between", value1, value2, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouNameNotBetween(String value1, String value2) {
            addCriterion("HAISOU_NAME not between", value1, value2, "haisouName");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlIsNull() {
            addCriterion("HAISOU_STATUS_URL is null");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlIsNotNull() {
            addCriterion("HAISOU_STATUS_URL is not null");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlEqualTo(String value) {
            addCriterion("HAISOU_STATUS_URL =", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlNotEqualTo(String value) {
            addCriterion("HAISOU_STATUS_URL <>", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlGreaterThan(String value) {
            addCriterion("HAISOU_STATUS_URL >", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlGreaterThanOrEqualTo(String value) {
            addCriterion("HAISOU_STATUS_URL >=", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlLessThan(String value) {
            addCriterion("HAISOU_STATUS_URL <", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlLessThanOrEqualTo(String value) {
            addCriterion("HAISOU_STATUS_URL <=", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlLike(String value) {
            addCriterion("HAISOU_STATUS_URL like", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlNotLike(String value) {
            addCriterion("HAISOU_STATUS_URL not like", value, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlIn(List<String> values) {
            addCriterion("HAISOU_STATUS_URL in", values, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlNotIn(List<String> values) {
            addCriterion("HAISOU_STATUS_URL not in", values, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlBetween(String value1, String value2) {
            addCriterion("HAISOU_STATUS_URL between", value1, value2, "haisouStatusUrl");
            return (Criteria) this;
        }

        public Criteria andHaisouStatusUrlNotBetween(String value1, String value2) {
            addCriterion("HAISOU_STATUS_URL not between", value1, value2, "haisouStatusUrl");
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