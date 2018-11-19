package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MCourseExample() {
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

        public Criteria andTwoChoiceFlgIsNull() {
            addCriterion("TWO_CHOICE_FLG is null");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgIsNotNull() {
            addCriterion("TWO_CHOICE_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgEqualTo(String value) {
            addCriterion("TWO_CHOICE_FLG =", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgNotEqualTo(String value) {
            addCriterion("TWO_CHOICE_FLG <>", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgGreaterThan(String value) {
            addCriterion("TWO_CHOICE_FLG >", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgGreaterThanOrEqualTo(String value) {
            addCriterion("TWO_CHOICE_FLG >=", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgLessThan(String value) {
            addCriterion("TWO_CHOICE_FLG <", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgLessThanOrEqualTo(String value) {
            addCriterion("TWO_CHOICE_FLG <=", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgLike(String value) {
            addCriterion("TWO_CHOICE_FLG like", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgNotLike(String value) {
            addCriterion("TWO_CHOICE_FLG not like", value, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgIn(List<String> values) {
            addCriterion("TWO_CHOICE_FLG in", values, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgNotIn(List<String> values) {
            addCriterion("TWO_CHOICE_FLG not in", values, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgBetween(String value1, String value2) {
            addCriterion("TWO_CHOICE_FLG between", value1, value2, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andTwoChoiceFlgNotBetween(String value1, String value2) {
            addCriterion("TWO_CHOICE_FLG not between", value1, value2, "twoChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgIsNull() {
            addCriterion("THREE_CHOICE_FLG is null");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgIsNotNull() {
            addCriterion("THREE_CHOICE_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgEqualTo(String value) {
            addCriterion("THREE_CHOICE_FLG =", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgNotEqualTo(String value) {
            addCriterion("THREE_CHOICE_FLG <>", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgGreaterThan(String value) {
            addCriterion("THREE_CHOICE_FLG >", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgGreaterThanOrEqualTo(String value) {
            addCriterion("THREE_CHOICE_FLG >=", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgLessThan(String value) {
            addCriterion("THREE_CHOICE_FLG <", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgLessThanOrEqualTo(String value) {
            addCriterion("THREE_CHOICE_FLG <=", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgLike(String value) {
            addCriterion("THREE_CHOICE_FLG like", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgNotLike(String value) {
            addCriterion("THREE_CHOICE_FLG not like", value, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgIn(List<String> values) {
            addCriterion("THREE_CHOICE_FLG in", values, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgNotIn(List<String> values) {
            addCriterion("THREE_CHOICE_FLG not in", values, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgBetween(String value1, String value2) {
            addCriterion("THREE_CHOICE_FLG between", value1, value2, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andThreeChoiceFlgNotBetween(String value1, String value2) {
            addCriterion("THREE_CHOICE_FLG not between", value1, value2, "threeChoiceFlg");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameIsNull() {
            addCriterion("WEB_COURSE_HYOUJI_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameIsNotNull() {
            addCriterion("WEB_COURSE_HYOUJI_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameEqualTo(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME =", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameNotEqualTo(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME <>", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameGreaterThan(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME >", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME >=", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameLessThan(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME <", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameLessThanOrEqualTo(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME <=", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameLike(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME like", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameNotLike(String value) {
            addCriterion("WEB_COURSE_HYOUJI_NAME not like", value, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameIn(List<String> values) {
            addCriterion("WEB_COURSE_HYOUJI_NAME in", values, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameNotIn(List<String> values) {
            addCriterion("WEB_COURSE_HYOUJI_NAME not in", values, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameBetween(String value1, String value2) {
            addCriterion("WEB_COURSE_HYOUJI_NAME between", value1, value2, "webCourseHyoujiName");
            return (Criteria) this;
        }

        public Criteria andWebCourseHyoujiNameNotBetween(String value1, String value2) {
            addCriterion("WEB_COURSE_HYOUJI_NAME not between", value1, value2, "webCourseHyoujiName");
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