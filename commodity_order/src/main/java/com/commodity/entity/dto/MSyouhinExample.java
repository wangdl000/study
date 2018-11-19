package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MSyouhinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MSyouhinExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSyouhinCdIsNull() {
            addCriterion("SYOUHIN_CD is null");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdIsNotNull() {
            addCriterion("SYOUHIN_CD is not null");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdEqualTo(String value) {
            addCriterion("SYOUHIN_CD =", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdNotEqualTo(String value) {
            addCriterion("SYOUHIN_CD <>", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdGreaterThan(String value) {
            addCriterion("SYOUHIN_CD >", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdGreaterThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_CD >=", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdLessThan(String value) {
            addCriterion("SYOUHIN_CD <", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdLessThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_CD <=", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdLike(String value) {
            addCriterion("SYOUHIN_CD like", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdNotLike(String value) {
            addCriterion("SYOUHIN_CD not like", value, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdIn(List<String> values) {
            addCriterion("SYOUHIN_CD in", values, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdNotIn(List<String> values) {
            addCriterion("SYOUHIN_CD not in", values, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdBetween(String value1, String value2) {
            addCriterion("SYOUHIN_CD between", value1, value2, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinCdNotBetween(String value1, String value2) {
            addCriterion("SYOUHIN_CD not between", value1, value2, "syouhinCd");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromIsNull() {
            addCriterion("TODOKEBI_YUUKOU_FROM is null");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromIsNotNull() {
            addCriterion("TODOKEBI_YUUKOU_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM =", value, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromNotEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM <>", value, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromGreaterThan(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM >", value, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM >=", value, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromLessThan(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM <", value, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM <=", value, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM in", values, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromNotIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM not in", values, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM between", value1, value2, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouFromNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_FROM not between", value1, value2, "todokebiYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToIsNull() {
            addCriterion("TODOKEBI_YUUKOU_TO is null");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToIsNotNull() {
            addCriterion("TODOKEBI_YUUKOU_TO is not null");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO =", value, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToNotEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO <>", value, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToGreaterThan(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO >", value, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO >=", value, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToLessThan(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO <", value, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO <=", value, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO in", values, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToNotIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO not in", values, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO between", value1, value2, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andTodokebiYuukouToNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKEBI_YUUKOU_TO not between", value1, value2, "todokebiYuukouTo");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgIsNull() {
            addCriterion("HANBAI_SYUURYOU_FLG is null");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgIsNotNull() {
            addCriterion("HANBAI_SYUURYOU_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgEqualTo(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG =", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgNotEqualTo(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG <>", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgGreaterThan(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG >", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgGreaterThanOrEqualTo(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG >=", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgLessThan(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG <", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgLessThanOrEqualTo(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG <=", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgLike(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG like", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgNotLike(String value) {
            addCriterion("HANBAI_SYUURYOU_FLG not like", value, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgIn(List<String> values) {
            addCriterion("HANBAI_SYUURYOU_FLG in", values, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgNotIn(List<String> values) {
            addCriterion("HANBAI_SYUURYOU_FLG not in", values, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgBetween(String value1, String value2) {
            addCriterion("HANBAI_SYUURYOU_FLG between", value1, value2, "hanbaiSyuuryouFlg");
            return (Criteria) this;
        }

        public Criteria andHanbaiSyuuryouFlgNotBetween(String value1, String value2) {
            addCriterion("HANBAI_SYUURYOU_FLG not between", value1, value2, "hanbaiSyuuryouFlg");
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