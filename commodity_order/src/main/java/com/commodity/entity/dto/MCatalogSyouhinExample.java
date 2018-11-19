package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MCatalogSyouhinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MCatalogSyouhinExample() {
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

        public Criteria andCatalogIdIsNull() {
            addCriterion("CATALOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIsNotNull() {
            addCriterion("CATALOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdEqualTo(String value) {
            addCriterion("CATALOG_ID =", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotEqualTo(String value) {
            addCriterion("CATALOG_ID <>", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThan(String value) {
            addCriterion("CATALOG_ID >", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThanOrEqualTo(String value) {
            addCriterion("CATALOG_ID >=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThan(String value) {
            addCriterion("CATALOG_ID <", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThanOrEqualTo(String value) {
            addCriterion("CATALOG_ID <=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLike(String value) {
            addCriterion("CATALOG_ID like", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotLike(String value) {
            addCriterion("CATALOG_ID not like", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIn(List<String> values) {
            addCriterion("CATALOG_ID in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotIn(List<String> values) {
            addCriterion("CATALOG_ID not in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdBetween(String value1, String value2) {
            addCriterion("CATALOG_ID between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotBetween(String value1, String value2) {
            addCriterion("CATALOG_ID not between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdIsNull() {
            addCriterion("HAGAKI_SYOUHIN_CD is null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdIsNotNull() {
            addCriterion("HAGAKI_SYOUHIN_CD is not null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD =", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdNotEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD <>", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdGreaterThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD >", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdGreaterThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD >=", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdLessThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD <", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdLessThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD <=", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD like", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdNotLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD not like", value, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_CD in", values, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdNotIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_CD not in", values, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_CD between", value1, value2, "hagakiSyouhinCd");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdNotBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_CD not between", value1, value2, "hagakiSyouhinCd");
            return (Criteria) this;
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

        public Criteria andHagakiSyouhinKigouIsNull() {
            addCriterion("HAGAKI_SYOUHIN_KIGOU is null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouIsNotNull() {
            addCriterion("HAGAKI_SYOUHIN_KIGOU is not null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU =", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouNotEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU <>", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouGreaterThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU >", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouGreaterThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU >=", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouLessThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU <", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouLessThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU <=", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU like", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouNotLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU not like", value, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU in", values, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouNotIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU not in", values, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU between", value1, value2, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinKigouNotBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_KIGOU not between", value1, value2, "hagakiSyouhinKigou");
            return (Criteria) this;
        }

        public Criteria andChoiceSuIsNull() {
            addCriterion("CHOICE_SU is null");
            return (Criteria) this;
        }

        public Criteria andChoiceSuIsNotNull() {
            addCriterion("CHOICE_SU is not null");
            return (Criteria) this;
        }

        public Criteria andChoiceSuEqualTo(String value) {
            addCriterion("CHOICE_SU =", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuNotEqualTo(String value) {
            addCriterion("CHOICE_SU <>", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuGreaterThan(String value) {
            addCriterion("CHOICE_SU >", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuGreaterThanOrEqualTo(String value) {
            addCriterion("CHOICE_SU >=", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuLessThan(String value) {
            addCriterion("CHOICE_SU <", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuLessThanOrEqualTo(String value) {
            addCriterion("CHOICE_SU <=", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuLike(String value) {
            addCriterion("CHOICE_SU like", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuNotLike(String value) {
            addCriterion("CHOICE_SU not like", value, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuIn(List<String> values) {
            addCriterion("CHOICE_SU in", values, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuNotIn(List<String> values) {
            addCriterion("CHOICE_SU not in", values, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuBetween(String value1, String value2) {
            addCriterion("CHOICE_SU between", value1, value2, "choiceSu");
            return (Criteria) this;
        }

        public Criteria andChoiceSuNotBetween(String value1, String value2) {
            addCriterion("CHOICE_SU not between", value1, value2, "choiceSu");
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