package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MReadJyogaiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MReadJyogaiExample() {
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

        public Criteria andTodokeFukabiIsNull() {
            addCriterion("TODOKE_FUKABI is null");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiIsNotNull() {
            addCriterion("TODOKE_FUKABI is not null");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_FUKABI =", value, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiNotEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_FUKABI <>", value, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiGreaterThan(Date value) {
            addCriterionForJDBCDate("TODOKE_FUKABI >", value, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_FUKABI >=", value, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiLessThan(Date value) {
            addCriterionForJDBCDate("TODOKE_FUKABI <", value, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_FUKABI <=", value, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKE_FUKABI in", values, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiNotIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKE_FUKABI not in", values, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKE_FUKABI between", value1, value2, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeFukabiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKE_FUKABI not between", value1, value2, "todokeFukabi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiIsNull() {
            addCriterion("TODOKE_HENKOUBI is null");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiIsNotNull() {
            addCriterion("TODOKE_HENKOUBI is not null");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI =", value, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiNotEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI <>", value, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiGreaterThan(Date value) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI >", value, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI >=", value, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiLessThan(Date value) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI <", value, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI <=", value, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI in", values, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiNotIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI not in", values, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI between", value1, value2, "todokeHenkoubi");
            return (Criteria) this;
        }

        public Criteria andTodokeHenkoubiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKE_HENKOUBI not between", value1, value2, "todokeHenkoubi");
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