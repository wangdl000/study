package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MKikakuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MKikakuExample() {
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

        public Criteria andKikakuNameIsNull() {
            addCriterion("KIKAKU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andKikakuNameIsNotNull() {
            addCriterion("KIKAKU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andKikakuNameEqualTo(String value) {
            addCriterion("KIKAKU_NAME =", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameNotEqualTo(String value) {
            addCriterion("KIKAKU_NAME <>", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameGreaterThan(String value) {
            addCriterion("KIKAKU_NAME >", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameGreaterThanOrEqualTo(String value) {
            addCriterion("KIKAKU_NAME >=", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameLessThan(String value) {
            addCriterion("KIKAKU_NAME <", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameLessThanOrEqualTo(String value) {
            addCriterion("KIKAKU_NAME <=", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameLike(String value) {
            addCriterion("KIKAKU_NAME like", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameNotLike(String value) {
            addCriterion("KIKAKU_NAME not like", value, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameIn(List<String> values) {
            addCriterion("KIKAKU_NAME in", values, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameNotIn(List<String> values) {
            addCriterion("KIKAKU_NAME not in", values, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameBetween(String value1, String value2) {
            addCriterion("KIKAKU_NAME between", value1, value2, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andKikakuNameNotBetween(String value1, String value2) {
            addCriterion("KIKAKU_NAME not between", value1, value2, "kikakuName");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoIsNull() {
            addCriterion("WEB_KAISI_NENDO is null");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoIsNotNull() {
            addCriterion("WEB_KAISI_NENDO is not null");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoEqualTo(String value) {
            addCriterion("WEB_KAISI_NENDO =", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoNotEqualTo(String value) {
            addCriterion("WEB_KAISI_NENDO <>", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoGreaterThan(String value) {
            addCriterion("WEB_KAISI_NENDO >", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_KAISI_NENDO >=", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoLessThan(String value) {
            addCriterion("WEB_KAISI_NENDO <", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoLessThanOrEqualTo(String value) {
            addCriterion("WEB_KAISI_NENDO <=", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoLike(String value) {
            addCriterion("WEB_KAISI_NENDO like", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoNotLike(String value) {
            addCriterion("WEB_KAISI_NENDO not like", value, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoIn(List<String> values) {
            addCriterion("WEB_KAISI_NENDO in", values, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoNotIn(List<String> values) {
            addCriterion("WEB_KAISI_NENDO not in", values, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoBetween(String value1, String value2) {
            addCriterion("WEB_KAISI_NENDO between", value1, value2, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiNendoNotBetween(String value1, String value2) {
            addCriterion("WEB_KAISI_NENDO not between", value1, value2, "webKaisiNendo");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnIsNull() {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN is null");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnIsNotNull() {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN is not null");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnEqualTo(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN =", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnNotEqualTo(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN <>", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnGreaterThan(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN >", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN >=", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnLessThan(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN <", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnLessThanOrEqualTo(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN <=", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnLike(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN like", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnNotLike(String value) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN not like", value, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnIn(List<String> values) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN in", values, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnNotIn(List<String> values) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN not in", values, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnBetween(String value1, String value2) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN between", value1, value2, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebKaisiCyuugenSeiboKbnNotBetween(String value1, String value2) {
            addCriterion("WEB_KAISI_CYUUGEN_SEIBO_KBN not between", value1, value2, "webKaisiCyuugenSeiboKbn");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgIsNull() {
            addCriterion("WEB_SYURYO_FLG is null");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgIsNotNull() {
            addCriterion("WEB_SYURYO_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgEqualTo(String value) {
            addCriterion("WEB_SYURYO_FLG =", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgNotEqualTo(String value) {
            addCriterion("WEB_SYURYO_FLG <>", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgGreaterThan(String value) {
            addCriterion("WEB_SYURYO_FLG >", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_SYURYO_FLG >=", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgLessThan(String value) {
            addCriterion("WEB_SYURYO_FLG <", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgLessThanOrEqualTo(String value) {
            addCriterion("WEB_SYURYO_FLG <=", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgLike(String value) {
            addCriterion("WEB_SYURYO_FLG like", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgNotLike(String value) {
            addCriterion("WEB_SYURYO_FLG not like", value, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgIn(List<String> values) {
            addCriterion("WEB_SYURYO_FLG in", values, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgNotIn(List<String> values) {
            addCriterion("WEB_SYURYO_FLG not in", values, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgBetween(String value1, String value2) {
            addCriterion("WEB_SYURYO_FLG between", value1, value2, "webSyuryoFlg");
            return (Criteria) this;
        }

        public Criteria andWebSyuryoFlgNotBetween(String value1, String value2) {
            addCriterion("WEB_SYURYO_FLG not between", value1, value2, "webSyuryoFlg");
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