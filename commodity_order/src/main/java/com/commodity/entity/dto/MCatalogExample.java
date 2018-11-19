package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MCatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MCatalogExample() {
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

        public Criteria andCatalogNameIsNull() {
            addCriterion("CATALOG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIsNotNull() {
            addCriterion("CATALOG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogNameEqualTo(String value) {
            addCriterion("CATALOG_NAME =", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotEqualTo(String value) {
            addCriterion("CATALOG_NAME <>", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThan(String value) {
            addCriterion("CATALOG_NAME >", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("CATALOG_NAME >=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThan(String value) {
            addCriterion("CATALOG_NAME <", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("CATALOG_NAME <=", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameLike(String value) {
            addCriterion("CATALOG_NAME like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotLike(String value) {
            addCriterion("CATALOG_NAME not like", value, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameIn(List<String> values) {
            addCriterion("CATALOG_NAME in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotIn(List<String> values) {
            addCriterion("CATALOG_NAME not in", values, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameBetween(String value1, String value2) {
            addCriterion("CATALOG_NAME between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogNameNotBetween(String value1, String value2) {
            addCriterion("CATALOG_NAME not between", value1, value2, "catalogName");
            return (Criteria) this;
        }

        public Criteria andKikakuCdIsNull() {
            addCriterion("KIKAKU_CD is null");
            return (Criteria) this;
        }

        public Criteria andKikakuCdIsNotNull() {
            addCriterion("KIKAKU_CD is not null");
            return (Criteria) this;
        }

        public Criteria andKikakuCdEqualTo(String value) {
            addCriterion("KIKAKU_CD =", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdNotEqualTo(String value) {
            addCriterion("KIKAKU_CD <>", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdGreaterThan(String value) {
            addCriterion("KIKAKU_CD >", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdGreaterThanOrEqualTo(String value) {
            addCriterion("KIKAKU_CD >=", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdLessThan(String value) {
            addCriterion("KIKAKU_CD <", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdLessThanOrEqualTo(String value) {
            addCriterion("KIKAKU_CD <=", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdLike(String value) {
            addCriterion("KIKAKU_CD like", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdNotLike(String value) {
            addCriterion("KIKAKU_CD not like", value, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdIn(List<String> values) {
            addCriterion("KIKAKU_CD in", values, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdNotIn(List<String> values) {
            addCriterion("KIKAKU_CD not in", values, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdBetween(String value1, String value2) {
            addCriterion("KIKAKU_CD between", value1, value2, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andKikakuCdNotBetween(String value1, String value2) {
            addCriterion("KIKAKU_CD not between", value1, value2, "kikakuCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdIsNull() {
            addCriterion("COURSE_CD is null");
            return (Criteria) this;
        }

        public Criteria andCourseCdIsNotNull() {
            addCriterion("COURSE_CD is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCdEqualTo(String value) {
            addCriterion("COURSE_CD =", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdNotEqualTo(String value) {
            addCriterion("COURSE_CD <>", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdGreaterThan(String value) {
            addCriterion("COURSE_CD >", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_CD >=", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdLessThan(String value) {
            addCriterion("COURSE_CD <", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdLessThanOrEqualTo(String value) {
            addCriterion("COURSE_CD <=", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdLike(String value) {
            addCriterion("COURSE_CD like", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdNotLike(String value) {
            addCriterion("COURSE_CD not like", value, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdIn(List<String> values) {
            addCriterion("COURSE_CD in", values, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdNotIn(List<String> values) {
            addCriterion("COURSE_CD not in", values, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdBetween(String value1, String value2) {
            addCriterion("COURSE_CD between", value1, value2, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCourseCdNotBetween(String value1, String value2) {
            addCriterion("COURSE_CD not between", value1, value2, "courseCd");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromIsNull() {
            addCriterion("CATALOG_YUUKOU_FROM is null");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromIsNotNull() {
            addCriterion("CATALOG_YUUKOU_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM =", value, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromNotEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM <>", value, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromGreaterThan(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM >", value, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM >=", value, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromLessThan(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM <", value, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM <=", value, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromIn(List<Date> values) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM in", values, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromNotIn(List<Date> values) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM not in", values, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM between", value1, value2, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouFromNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_FROM not between", value1, value2, "catalogYuukouFrom");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToIsNull() {
            addCriterion("CATALOG_YUUKOU_TO is null");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToIsNotNull() {
            addCriterion("CATALOG_YUUKOU_TO is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO =", value, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToNotEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO <>", value, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToGreaterThan(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO >", value, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO >=", value, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToLessThan(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO <", value, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO <=", value, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToIn(List<Date> values) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO in", values, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToNotIn(List<Date> values) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO not in", values, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO between", value1, value2, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogYuukouToNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CATALOG_YUUKOU_TO not between", value1, value2, "catalogYuukouTo");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenIsNull() {
            addCriterion("CATALOG_SHIYOU_NEN is null");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenIsNotNull() {
            addCriterion("CATALOG_SHIYOU_NEN is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenEqualTo(String value) {
            addCriterion("CATALOG_SHIYOU_NEN =", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenNotEqualTo(String value) {
            addCriterion("CATALOG_SHIYOU_NEN <>", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenGreaterThan(String value) {
            addCriterion("CATALOG_SHIYOU_NEN >", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenGreaterThanOrEqualTo(String value) {
            addCriterion("CATALOG_SHIYOU_NEN >=", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenLessThan(String value) {
            addCriterion("CATALOG_SHIYOU_NEN <", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenLessThanOrEqualTo(String value) {
            addCriterion("CATALOG_SHIYOU_NEN <=", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenLike(String value) {
            addCriterion("CATALOG_SHIYOU_NEN like", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenNotLike(String value) {
            addCriterion("CATALOG_SHIYOU_NEN not like", value, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenIn(List<String> values) {
            addCriterion("CATALOG_SHIYOU_NEN in", values, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenNotIn(List<String> values) {
            addCriterion("CATALOG_SHIYOU_NEN not in", values, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenBetween(String value1, String value2) {
            addCriterion("CATALOG_SHIYOU_NEN between", value1, value2, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCatalogShiyouNenNotBetween(String value1, String value2) {
            addCriterion("CATALOG_SHIYOU_NEN not between", value1, value2, "catalogShiyouNen");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnIsNull() {
            addCriterion("CYUUGEN_SEIBO_KBN is null");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnIsNotNull() {
            addCriterion("CYUUGEN_SEIBO_KBN is not null");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnEqualTo(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN =", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnNotEqualTo(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN <>", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnGreaterThan(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN >", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnGreaterThanOrEqualTo(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN >=", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnLessThan(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN <", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnLessThanOrEqualTo(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN <=", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnLike(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN like", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnNotLike(String value) {
            addCriterion("CYUUGEN_SEIBO_KBN not like", value, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnIn(List<String> values) {
            addCriterion("CYUUGEN_SEIBO_KBN in", values, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnNotIn(List<String> values) {
            addCriterion("CYUUGEN_SEIBO_KBN not in", values, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnBetween(String value1, String value2) {
            addCriterion("CYUUGEN_SEIBO_KBN between", value1, value2, "cyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andCyuugenSeiboKbnNotBetween(String value1, String value2) {
            addCriterion("CYUUGEN_SEIBO_KBN not between", value1, value2, "cyuugenSeiboKbn");
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