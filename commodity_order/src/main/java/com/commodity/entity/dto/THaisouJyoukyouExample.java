package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class THaisouJyoukyouExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public THaisouJyoukyouExample() {
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

        public Criteria andToiawaseNoIsNull() {
            addCriterion("TOIAWASE_NO is null");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoIsNotNull() {
            addCriterion("TOIAWASE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoEqualTo(String value) {
            addCriterion("TOIAWASE_NO =", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoNotEqualTo(String value) {
            addCriterion("TOIAWASE_NO <>", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoGreaterThan(String value) {
            addCriterion("TOIAWASE_NO >", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoGreaterThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_NO >=", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoLessThan(String value) {
            addCriterion("TOIAWASE_NO <", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoLessThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_NO <=", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoLike(String value) {
            addCriterion("TOIAWASE_NO like", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoNotLike(String value) {
            addCriterion("TOIAWASE_NO not like", value, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoIn(List<String> values) {
            addCriterion("TOIAWASE_NO in", values, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoNotIn(List<String> values) {
            addCriterion("TOIAWASE_NO not in", values, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoBetween(String value1, String value2) {
            addCriterion("TOIAWASE_NO between", value1, value2, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNoNotBetween(String value1, String value2) {
            addCriterion("TOIAWASE_NO not between", value1, value2, "toiawaseNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoIsNull() {
            addCriterion("MEISAI_NO is null");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoIsNotNull() {
            addCriterion("MEISAI_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoEqualTo(String value) {
            addCriterion("MEISAI_NO =", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoNotEqualTo(String value) {
            addCriterion("MEISAI_NO <>", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoGreaterThan(String value) {
            addCriterion("MEISAI_NO >", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoGreaterThanOrEqualTo(String value) {
            addCriterion("MEISAI_NO >=", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoLessThan(String value) {
            addCriterion("MEISAI_NO <", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoLessThanOrEqualTo(String value) {
            addCriterion("MEISAI_NO <=", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoLike(String value) {
            addCriterion("MEISAI_NO like", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoNotLike(String value) {
            addCriterion("MEISAI_NO not like", value, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoIn(List<String> values) {
            addCriterion("MEISAI_NO in", values, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoNotIn(List<String> values) {
            addCriterion("MEISAI_NO not in", values, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoBetween(String value1, String value2) {
            addCriterion("MEISAI_NO between", value1, value2, "meisaiNo");
            return (Criteria) this;
        }

        public Criteria andMeisaiNoNotBetween(String value1, String value2) {
            addCriterion("MEISAI_NO not between", value1, value2, "meisaiNo");
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

        public Criteria andSyouhinNameIsNull() {
            addCriterion("SYOUHIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameIsNotNull() {
            addCriterion("SYOUHIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameEqualTo(String value) {
            addCriterion("SYOUHIN_NAME =", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameNotEqualTo(String value) {
            addCriterion("SYOUHIN_NAME <>", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameGreaterThan(String value) {
            addCriterion("SYOUHIN_NAME >", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_NAME >=", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameLessThan(String value) {
            addCriterion("SYOUHIN_NAME <", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameLessThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_NAME <=", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameLike(String value) {
            addCriterion("SYOUHIN_NAME like", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameNotLike(String value) {
            addCriterion("SYOUHIN_NAME not like", value, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameIn(List<String> values) {
            addCriterion("SYOUHIN_NAME in", values, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameNotIn(List<String> values) {
            addCriterion("SYOUHIN_NAME not in", values, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameBetween(String value1, String value2) {
            addCriterion("SYOUHIN_NAME between", value1, value2, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andSyouhinNameNotBetween(String value1, String value2) {
            addCriterion("SYOUHIN_NAME not between", value1, value2, "syouhinName");
            return (Criteria) this;
        }

        public Criteria andTodokeBiIsNull() {
            addCriterion("TODOKE_BI is null");
            return (Criteria) this;
        }

        public Criteria andTodokeBiIsNotNull() {
            addCriterion("TODOKE_BI is not null");
            return (Criteria) this;
        }

        public Criteria andTodokeBiEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_BI =", value, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiNotEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_BI <>", value, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiGreaterThan(Date value) {
            addCriterionForJDBCDate("TODOKE_BI >", value, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_BI >=", value, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiLessThan(Date value) {
            addCriterionForJDBCDate("TODOKE_BI <", value, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("TODOKE_BI <=", value, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKE_BI in", values, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiNotIn(List<Date> values) {
            addCriterionForJDBCDate("TODOKE_BI not in", values, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKE_BI between", value1, value2, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeBiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("TODOKE_BI not between", value1, value2, "todokeBi");
            return (Criteria) this;
        }

        public Criteria andTodokeStsIsNull() {
            addCriterion("TODOKE_STS is null");
            return (Criteria) this;
        }

        public Criteria andTodokeStsIsNotNull() {
            addCriterion("TODOKE_STS is not null");
            return (Criteria) this;
        }

        public Criteria andTodokeStsEqualTo(String value) {
            addCriterion("TODOKE_STS =", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsNotEqualTo(String value) {
            addCriterion("TODOKE_STS <>", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsGreaterThan(String value) {
            addCriterion("TODOKE_STS >", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsGreaterThanOrEqualTo(String value) {
            addCriterion("TODOKE_STS >=", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsLessThan(String value) {
            addCriterion("TODOKE_STS <", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsLessThanOrEqualTo(String value) {
            addCriterion("TODOKE_STS <=", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsLike(String value) {
            addCriterion("TODOKE_STS like", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsNotLike(String value) {
            addCriterion("TODOKE_STS not like", value, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsIn(List<String> values) {
            addCriterion("TODOKE_STS in", values, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsNotIn(List<String> values) {
            addCriterion("TODOKE_STS not in", values, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsBetween(String value1, String value2) {
            addCriterion("TODOKE_STS between", value1, value2, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andTodokeStsNotBetween(String value1, String value2) {
            addCriterion("TODOKE_STS not between", value1, value2, "todokeSts");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdIsNull() {
            addCriterion("SYOUHIN_HAISOU_CD is null");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdIsNotNull() {
            addCriterion("SYOUHIN_HAISOU_CD is not null");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdEqualTo(String value) {
            addCriterion("SYOUHIN_HAISOU_CD =", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdNotEqualTo(String value) {
            addCriterion("SYOUHIN_HAISOU_CD <>", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdGreaterThan(String value) {
            addCriterion("SYOUHIN_HAISOU_CD >", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdGreaterThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_HAISOU_CD >=", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdLessThan(String value) {
            addCriterion("SYOUHIN_HAISOU_CD <", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdLessThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_HAISOU_CD <=", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdLike(String value) {
            addCriterion("SYOUHIN_HAISOU_CD like", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdNotLike(String value) {
            addCriterion("SYOUHIN_HAISOU_CD not like", value, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdIn(List<String> values) {
            addCriterion("SYOUHIN_HAISOU_CD in", values, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdNotIn(List<String> values) {
            addCriterion("SYOUHIN_HAISOU_CD not in", values, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdBetween(String value1, String value2) {
            addCriterion("SYOUHIN_HAISOU_CD between", value1, value2, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andSyouhinHaisouCdNotBetween(String value1, String value2) {
            addCriterion("SYOUHIN_HAISOU_CD not between", value1, value2, "syouhinHaisouCd");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoIsNull() {
            addCriterion("HAISOU_DENPYOU_NO is null");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoIsNotNull() {
            addCriterion("HAISOU_DENPYOU_NO is not null");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoEqualTo(String value) {
            addCriterion("HAISOU_DENPYOU_NO =", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoNotEqualTo(String value) {
            addCriterion("HAISOU_DENPYOU_NO <>", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoGreaterThan(String value) {
            addCriterion("HAISOU_DENPYOU_NO >", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoGreaterThanOrEqualTo(String value) {
            addCriterion("HAISOU_DENPYOU_NO >=", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoLessThan(String value) {
            addCriterion("HAISOU_DENPYOU_NO <", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoLessThanOrEqualTo(String value) {
            addCriterion("HAISOU_DENPYOU_NO <=", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoLike(String value) {
            addCriterion("HAISOU_DENPYOU_NO like", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoNotLike(String value) {
            addCriterion("HAISOU_DENPYOU_NO not like", value, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoIn(List<String> values) {
            addCriterion("HAISOU_DENPYOU_NO in", values, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoNotIn(List<String> values) {
            addCriterion("HAISOU_DENPYOU_NO not in", values, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoBetween(String value1, String value2) {
            addCriterion("HAISOU_DENPYOU_NO between", value1, value2, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaisouDenpyouNoNotBetween(String value1, String value2) {
            addCriterion("HAISOU_DENPYOU_NO not between", value1, value2, "haisouDenpyouNo");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouIsNull() {
            addCriterion("HAIDEN_BIKOU is null");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouIsNotNull() {
            addCriterion("HAIDEN_BIKOU is not null");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouEqualTo(String value) {
            addCriterion("HAIDEN_BIKOU =", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouNotEqualTo(String value) {
            addCriterion("HAIDEN_BIKOU <>", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouGreaterThan(String value) {
            addCriterion("HAIDEN_BIKOU >", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouGreaterThanOrEqualTo(String value) {
            addCriterion("HAIDEN_BIKOU >=", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouLessThan(String value) {
            addCriterion("HAIDEN_BIKOU <", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouLessThanOrEqualTo(String value) {
            addCriterion("HAIDEN_BIKOU <=", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouLike(String value) {
            addCriterion("HAIDEN_BIKOU like", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouNotLike(String value) {
            addCriterion("HAIDEN_BIKOU not like", value, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouIn(List<String> values) {
            addCriterion("HAIDEN_BIKOU in", values, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouNotIn(List<String> values) {
            addCriterion("HAIDEN_BIKOU not in", values, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouBetween(String value1, String value2) {
            addCriterion("HAIDEN_BIKOU between", value1, value2, "haidenBikou");
            return (Criteria) this;
        }

        public Criteria andHaidenBikouNotBetween(String value1, String value2) {
            addCriterion("HAIDEN_BIKOU not between", value1, value2, "haidenBikou");
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