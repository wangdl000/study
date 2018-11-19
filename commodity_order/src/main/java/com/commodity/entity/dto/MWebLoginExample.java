package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MWebLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MWebLoginExample() {
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

        public Criteria andLoginIdIsNull() {
            addCriterion("LOGIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("LOGIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(String value) {
            addCriterion("LOGIN_ID =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(String value) {
            addCriterion("LOGIN_ID <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(String value) {
            addCriterion("LOGIN_ID >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(String value) {
            addCriterion("LOGIN_ID <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_ID <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLike(String value) {
            addCriterion("LOGIN_ID like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotLike(String value) {
            addCriterion("LOGIN_ID not like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<String> values) {
            addCriterion("LOGIN_ID in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<String> values) {
            addCriterion("LOGIN_ID not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(String value1, String value2) {
            addCriterion("LOGIN_ID between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_ID not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsIsNull() {
            addCriterion("KIKAN_JYUTYU_STS is null");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsIsNotNull() {
            addCriterion("KIKAN_JYUTYU_STS is not null");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsEqualTo(String value) {
            addCriterion("KIKAN_JYUTYU_STS =", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsNotEqualTo(String value) {
            addCriterion("KIKAN_JYUTYU_STS <>", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsGreaterThan(String value) {
            addCriterion("KIKAN_JYUTYU_STS >", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsGreaterThanOrEqualTo(String value) {
            addCriterion("KIKAN_JYUTYU_STS >=", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsLessThan(String value) {
            addCriterion("KIKAN_JYUTYU_STS <", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsLessThanOrEqualTo(String value) {
            addCriterion("KIKAN_JYUTYU_STS <=", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsLike(String value) {
            addCriterion("KIKAN_JYUTYU_STS like", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsNotLike(String value) {
            addCriterion("KIKAN_JYUTYU_STS not like", value, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsIn(List<String> values) {
            addCriterion("KIKAN_JYUTYU_STS in", values, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsNotIn(List<String> values) {
            addCriterion("KIKAN_JYUTYU_STS not in", values, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsBetween(String value1, String value2) {
            addCriterion("KIKAN_JYUTYU_STS between", value1, value2, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanJyutyuStsNotBetween(String value1, String value2) {
            addCriterion("KIKAN_JYUTYU_STS not between", value1, value2, "kikanJyutyuSts");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgIsNull() {
            addCriterion("KIKAN_MUKOU_FLG is null");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgIsNotNull() {
            addCriterion("KIKAN_MUKOU_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgEqualTo(String value) {
            addCriterion("KIKAN_MUKOU_FLG =", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgNotEqualTo(String value) {
            addCriterion("KIKAN_MUKOU_FLG <>", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgGreaterThan(String value) {
            addCriterion("KIKAN_MUKOU_FLG >", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgGreaterThanOrEqualTo(String value) {
            addCriterion("KIKAN_MUKOU_FLG >=", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgLessThan(String value) {
            addCriterion("KIKAN_MUKOU_FLG <", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgLessThanOrEqualTo(String value) {
            addCriterion("KIKAN_MUKOU_FLG <=", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgLike(String value) {
            addCriterion("KIKAN_MUKOU_FLG like", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgNotLike(String value) {
            addCriterion("KIKAN_MUKOU_FLG not like", value, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgIn(List<String> values) {
            addCriterion("KIKAN_MUKOU_FLG in", values, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgNotIn(List<String> values) {
            addCriterion("KIKAN_MUKOU_FLG not in", values, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgBetween(String value1, String value2) {
            addCriterion("KIKAN_MUKOU_FLG between", value1, value2, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andKikanMukouFlgNotBetween(String value1, String value2) {
            addCriterion("KIKAN_MUKOU_FLG not between", value1, value2, "kikanMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgIsNull() {
            addCriterion("WEB_MUKOU_FLG is null");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgIsNotNull() {
            addCriterion("WEB_MUKOU_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgEqualTo(String value) {
            addCriterion("WEB_MUKOU_FLG =", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgNotEqualTo(String value) {
            addCriterion("WEB_MUKOU_FLG <>", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgGreaterThan(String value) {
            addCriterion("WEB_MUKOU_FLG >", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_MUKOU_FLG >=", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgLessThan(String value) {
            addCriterion("WEB_MUKOU_FLG <", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgLessThanOrEqualTo(String value) {
            addCriterion("WEB_MUKOU_FLG <=", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgLike(String value) {
            addCriterion("WEB_MUKOU_FLG like", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgNotLike(String value) {
            addCriterion("WEB_MUKOU_FLG not like", value, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgIn(List<String> values) {
            addCriterion("WEB_MUKOU_FLG in", values, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgNotIn(List<String> values) {
            addCriterion("WEB_MUKOU_FLG not in", values, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgBetween(String value1, String value2) {
            addCriterion("WEB_MUKOU_FLG between", value1, value2, "webMukouFlg");
            return (Criteria) this;
        }

        public Criteria andWebMukouFlgNotBetween(String value1, String value2) {
            addCriterion("WEB_MUKOU_FLG not between", value1, value2, "webMukouFlg");
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