package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MMsgExample() {
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

        public Criteria andMsgNoIsNull() {
            addCriterion("MSG_NO is null");
            return (Criteria) this;
        }

        public Criteria andMsgNoIsNotNull() {
            addCriterion("MSG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMsgNoEqualTo(Long value) {
            addCriterion("MSG_NO =", value, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoNotEqualTo(Long value) {
            addCriterion("MSG_NO <>", value, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoGreaterThan(Long value) {
            addCriterion("MSG_NO >", value, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoGreaterThanOrEqualTo(Long value) {
            addCriterion("MSG_NO >=", value, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoLessThan(Long value) {
            addCriterion("MSG_NO <", value, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoLessThanOrEqualTo(Long value) {
            addCriterion("MSG_NO <=", value, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoIn(List<Long> values) {
            addCriterion("MSG_NO in", values, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoNotIn(List<Long> values) {
            addCriterion("MSG_NO not in", values, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoBetween(Long value1, Long value2) {
            addCriterion("MSG_NO between", value1, value2, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgNoNotBetween(Long value1, Long value2) {
            addCriterion("MSG_NO not between", value1, value2, "msgNo");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnIsNull() {
            addCriterion("MSG_KEISAI_KBN is null");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnIsNotNull() {
            addCriterion("MSG_KEISAI_KBN is not null");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnEqualTo(String value) {
            addCriterion("MSG_KEISAI_KBN =", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnNotEqualTo(String value) {
            addCriterion("MSG_KEISAI_KBN <>", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnGreaterThan(String value) {
            addCriterion("MSG_KEISAI_KBN >", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnGreaterThanOrEqualTo(String value) {
            addCriterion("MSG_KEISAI_KBN >=", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnLessThan(String value) {
            addCriterion("MSG_KEISAI_KBN <", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnLessThanOrEqualTo(String value) {
            addCriterion("MSG_KEISAI_KBN <=", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnLike(String value) {
            addCriterion("MSG_KEISAI_KBN like", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnNotLike(String value) {
            addCriterion("MSG_KEISAI_KBN not like", value, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnIn(List<String> values) {
            addCriterion("MSG_KEISAI_KBN in", values, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnNotIn(List<String> values) {
            addCriterion("MSG_KEISAI_KBN not in", values, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnBetween(String value1, String value2) {
            addCriterion("MSG_KEISAI_KBN between", value1, value2, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andMsgKeisaiKbnNotBetween(String value1, String value2) {
            addCriterion("MSG_KEISAI_KBN not between", value1, value2, "msgKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromIsNull() {
            addCriterion("KEISAI_FROM is null");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromIsNotNull() {
            addCriterion("KEISAI_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_FROM =", value, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromNotEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_FROM <>", value, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromGreaterThan(Date value) {
            addCriterionForJDBCDate("KEISAI_FROM >", value, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_FROM >=", value, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromLessThan(Date value) {
            addCriterionForJDBCDate("KEISAI_FROM <", value, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_FROM <=", value, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromIn(List<Date> values) {
            addCriterionForJDBCDate("KEISAI_FROM in", values, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromNotIn(List<Date> values) {
            addCriterionForJDBCDate("KEISAI_FROM not in", values, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("KEISAI_FROM between", value1, value2, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiFromNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("KEISAI_FROM not between", value1, value2, "keisaiFrom");
            return (Criteria) this;
        }

        public Criteria andKeisaiToIsNull() {
            addCriterion("KEISAI_TO is null");
            return (Criteria) this;
        }

        public Criteria andKeisaiToIsNotNull() {
            addCriterion("KEISAI_TO is not null");
            return (Criteria) this;
        }

        public Criteria andKeisaiToEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_TO =", value, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToNotEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_TO <>", value, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToGreaterThan(Date value) {
            addCriterionForJDBCDate("KEISAI_TO >", value, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_TO >=", value, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToLessThan(Date value) {
            addCriterionForJDBCDate("KEISAI_TO <", value, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("KEISAI_TO <=", value, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToIn(List<Date> values) {
            addCriterionForJDBCDate("KEISAI_TO in", values, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToNotIn(List<Date> values) {
            addCriterionForJDBCDate("KEISAI_TO not in", values, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("KEISAI_TO between", value1, value2, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andKeisaiToNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("KEISAI_TO not between", value1, value2, "keisaiTo");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderIsNull() {
            addCriterion("MSG_HEADER is null");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderIsNotNull() {
            addCriterion("MSG_HEADER is not null");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderEqualTo(String value) {
            addCriterion("MSG_HEADER =", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderNotEqualTo(String value) {
            addCriterion("MSG_HEADER <>", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderGreaterThan(String value) {
            addCriterion("MSG_HEADER >", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("MSG_HEADER >=", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderLessThan(String value) {
            addCriterion("MSG_HEADER <", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderLessThanOrEqualTo(String value) {
            addCriterion("MSG_HEADER <=", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderLike(String value) {
            addCriterion("MSG_HEADER like", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderNotLike(String value) {
            addCriterion("MSG_HEADER not like", value, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderIn(List<String> values) {
            addCriterion("MSG_HEADER in", values, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderNotIn(List<String> values) {
            addCriterion("MSG_HEADER not in", values, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderBetween(String value1, String value2) {
            addCriterion("MSG_HEADER between", value1, value2, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgHeaderNotBetween(String value1, String value2) {
            addCriterion("MSG_HEADER not between", value1, value2, "msgHeader");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouIsNull() {
            addCriterion("MSG_NAIYOU is null");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouIsNotNull() {
            addCriterion("MSG_NAIYOU is not null");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouEqualTo(String value) {
            addCriterion("MSG_NAIYOU =", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouNotEqualTo(String value) {
            addCriterion("MSG_NAIYOU <>", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouGreaterThan(String value) {
            addCriterion("MSG_NAIYOU >", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouGreaterThanOrEqualTo(String value) {
            addCriterion("MSG_NAIYOU >=", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouLessThan(String value) {
            addCriterion("MSG_NAIYOU <", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouLessThanOrEqualTo(String value) {
            addCriterion("MSG_NAIYOU <=", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouLike(String value) {
            addCriterion("MSG_NAIYOU like", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouNotLike(String value) {
            addCriterion("MSG_NAIYOU not like", value, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouIn(List<String> values) {
            addCriterion("MSG_NAIYOU in", values, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouNotIn(List<String> values) {
            addCriterion("MSG_NAIYOU not in", values, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouBetween(String value1, String value2) {
            addCriterion("MSG_NAIYOU between", value1, value2, "msgNaiyou");
            return (Criteria) this;
        }

        public Criteria andMsgNaiyouNotBetween(String value1, String value2) {
            addCriterion("MSG_NAIYOU not between", value1, value2, "msgNaiyou");
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