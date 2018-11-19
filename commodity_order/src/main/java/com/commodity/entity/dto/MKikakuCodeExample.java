package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MKikakuCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MKikakuCodeExample() {
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

        public Criteria andSikibetsuCdIsNull() {
            addCriterion("SIKIBETSU_CD is null");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdIsNotNull() {
            addCriterion("SIKIBETSU_CD is not null");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdEqualTo(String value) {
            addCriterion("SIKIBETSU_CD =", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdNotEqualTo(String value) {
            addCriterion("SIKIBETSU_CD <>", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdGreaterThan(String value) {
            addCriterion("SIKIBETSU_CD >", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdGreaterThanOrEqualTo(String value) {
            addCriterion("SIKIBETSU_CD >=", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdLessThan(String value) {
            addCriterion("SIKIBETSU_CD <", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdLessThanOrEqualTo(String value) {
            addCriterion("SIKIBETSU_CD <=", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdLike(String value) {
            addCriterion("SIKIBETSU_CD like", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdNotLike(String value) {
            addCriterion("SIKIBETSU_CD not like", value, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdIn(List<String> values) {
            addCriterion("SIKIBETSU_CD in", values, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdNotIn(List<String> values) {
            addCriterion("SIKIBETSU_CD not in", values, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdBetween(String value1, String value2) {
            addCriterion("SIKIBETSU_CD between", value1, value2, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuCdNotBetween(String value1, String value2) {
            addCriterion("SIKIBETSU_CD not between", value1, value2, "sikibetsuCd");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmIsNull() {
            addCriterion("SIKIBETSU_NM is null");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmIsNotNull() {
            addCriterion("SIKIBETSU_NM is not null");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmEqualTo(String value) {
            addCriterion("SIKIBETSU_NM =", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmNotEqualTo(String value) {
            addCriterion("SIKIBETSU_NM <>", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmGreaterThan(String value) {
            addCriterion("SIKIBETSU_NM >", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmGreaterThanOrEqualTo(String value) {
            addCriterion("SIKIBETSU_NM >=", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmLessThan(String value) {
            addCriterion("SIKIBETSU_NM <", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmLessThanOrEqualTo(String value) {
            addCriterion("SIKIBETSU_NM <=", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmLike(String value) {
            addCriterion("SIKIBETSU_NM like", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmNotLike(String value) {
            addCriterion("SIKIBETSU_NM not like", value, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmIn(List<String> values) {
            addCriterion("SIKIBETSU_NM in", values, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmNotIn(List<String> values) {
            addCriterion("SIKIBETSU_NM not in", values, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmBetween(String value1, String value2) {
            addCriterion("SIKIBETSU_NM between", value1, value2, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andSikibetsuNmNotBetween(String value1, String value2) {
            addCriterion("SIKIBETSU_NM not between", value1, value2, "sikibetsuNm");
            return (Criteria) this;
        }

        public Criteria andCodeMemoIsNull() {
            addCriterion("CODE_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andCodeMemoIsNotNull() {
            addCriterion("CODE_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andCodeMemoEqualTo(String value) {
            addCriterion("CODE_MEMO =", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoNotEqualTo(String value) {
            addCriterion("CODE_MEMO <>", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoGreaterThan(String value) {
            addCriterion("CODE_MEMO >", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_MEMO >=", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoLessThan(String value) {
            addCriterion("CODE_MEMO <", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoLessThanOrEqualTo(String value) {
            addCriterion("CODE_MEMO <=", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoLike(String value) {
            addCriterion("CODE_MEMO like", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoNotLike(String value) {
            addCriterion("CODE_MEMO not like", value, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoIn(List<String> values) {
            addCriterion("CODE_MEMO in", values, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoNotIn(List<String> values) {
            addCriterion("CODE_MEMO not in", values, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoBetween(String value1, String value2) {
            addCriterion("CODE_MEMO between", value1, value2, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andCodeMemoNotBetween(String value1, String value2) {
            addCriterion("CODE_MEMO not between", value1, value2, "codeMemo");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgIsNull() {
            addCriterion("TUIKA_KAHI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgIsNotNull() {
            addCriterion("TUIKA_KAHI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgEqualTo(String value) {
            addCriterion("TUIKA_KAHI_FLG =", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgNotEqualTo(String value) {
            addCriterion("TUIKA_KAHI_FLG <>", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgGreaterThan(String value) {
            addCriterion("TUIKA_KAHI_FLG >", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgGreaterThanOrEqualTo(String value) {
            addCriterion("TUIKA_KAHI_FLG >=", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgLessThan(String value) {
            addCriterion("TUIKA_KAHI_FLG <", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgLessThanOrEqualTo(String value) {
            addCriterion("TUIKA_KAHI_FLG <=", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgLike(String value) {
            addCriterion("TUIKA_KAHI_FLG like", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgNotLike(String value) {
            addCriterion("TUIKA_KAHI_FLG not like", value, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgIn(List<String> values) {
            addCriterion("TUIKA_KAHI_FLG in", values, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgNotIn(List<String> values) {
            addCriterion("TUIKA_KAHI_FLG not in", values, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgBetween(String value1, String value2) {
            addCriterion("TUIKA_KAHI_FLG between", value1, value2, "tuikaKahiFlg");
            return (Criteria) this;
        }

        public Criteria andTuikaKahiFlgNotBetween(String value1, String value2) {
            addCriterion("TUIKA_KAHI_FLG not between", value1, value2, "tuikaKahiFlg");
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