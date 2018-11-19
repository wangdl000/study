package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TToiawaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TToiawaseExample() {
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

        public Criteria andUketsukeNoIsNull() {
            addCriterion("UKETSUKE_NO is null");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoIsNotNull() {
            addCriterion("UKETSUKE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoEqualTo(Long value) {
            addCriterion("UKETSUKE_NO =", value, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoNotEqualTo(Long value) {
            addCriterion("UKETSUKE_NO <>", value, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoGreaterThan(Long value) {
            addCriterion("UKETSUKE_NO >", value, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoGreaterThanOrEqualTo(Long value) {
            addCriterion("UKETSUKE_NO >=", value, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoLessThan(Long value) {
            addCriterion("UKETSUKE_NO <", value, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoLessThanOrEqualTo(Long value) {
            addCriterion("UKETSUKE_NO <=", value, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoIn(List<Long> values) {
            addCriterion("UKETSUKE_NO in", values, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoNotIn(List<Long> values) {
            addCriterion("UKETSUKE_NO not in", values, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoBetween(Long value1, Long value2) {
            addCriterion("UKETSUKE_NO between", value1, value2, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andUketsukeNoNotBetween(Long value1, Long value2) {
            addCriterion("UKETSUKE_NO not between", value1, value2, "uketsukeNo");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnIsNull() {
            addCriterion("TOIAWASE_KBN is null");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnIsNotNull() {
            addCriterion("TOIAWASE_KBN is not null");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnEqualTo(String value) {
            addCriterion("TOIAWASE_KBN =", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnNotEqualTo(String value) {
            addCriterion("TOIAWASE_KBN <>", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnGreaterThan(String value) {
            addCriterion("TOIAWASE_KBN >", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnGreaterThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_KBN >=", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnLessThan(String value) {
            addCriterion("TOIAWASE_KBN <", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnLessThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_KBN <=", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnLike(String value) {
            addCriterion("TOIAWASE_KBN like", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnNotLike(String value) {
            addCriterion("TOIAWASE_KBN not like", value, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnIn(List<String> values) {
            addCriterion("TOIAWASE_KBN in", values, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnNotIn(List<String> values) {
            addCriterion("TOIAWASE_KBN not in", values, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnBetween(String value1, String value2) {
            addCriterion("TOIAWASE_KBN between", value1, value2, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseKbnNotBetween(String value1, String value2) {
            addCriterion("TOIAWASE_KBN not between", value1, value2, "toiawaseKbn");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoIsNull() {
            addCriterion("TOIAWASE_NAIYO is null");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoIsNotNull() {
            addCriterion("TOIAWASE_NAIYO is not null");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoEqualTo(String value) {
            addCriterion("TOIAWASE_NAIYO =", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoNotEqualTo(String value) {
            addCriterion("TOIAWASE_NAIYO <>", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoGreaterThan(String value) {
            addCriterion("TOIAWASE_NAIYO >", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoGreaterThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_NAIYO >=", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoLessThan(String value) {
            addCriterion("TOIAWASE_NAIYO <", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoLessThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_NAIYO <=", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoLike(String value) {
            addCriterion("TOIAWASE_NAIYO like", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoNotLike(String value) {
            addCriterion("TOIAWASE_NAIYO not like", value, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoIn(List<String> values) {
            addCriterion("TOIAWASE_NAIYO in", values, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoNotIn(List<String> values) {
            addCriterion("TOIAWASE_NAIYO not in", values, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoBetween(String value1, String value2) {
            addCriterion("TOIAWASE_NAIYO between", value1, value2, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andToiawaseNaiyoNotBetween(String value1, String value2) {
            addCriterion("TOIAWASE_NAIYO not between", value1, value2, "toiawaseNaiyo");
            return (Criteria) this;
        }

        public Criteria andKname1IsNull() {
            addCriterion("KNAME_1 is null");
            return (Criteria) this;
        }

        public Criteria andKname1IsNotNull() {
            addCriterion("KNAME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andKname1EqualTo(String value) {
            addCriterion("KNAME_1 =", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1NotEqualTo(String value) {
            addCriterion("KNAME_1 <>", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1GreaterThan(String value) {
            addCriterion("KNAME_1 >", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1GreaterThanOrEqualTo(String value) {
            addCriterion("KNAME_1 >=", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1LessThan(String value) {
            addCriterion("KNAME_1 <", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1LessThanOrEqualTo(String value) {
            addCriterion("KNAME_1 <=", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1Like(String value) {
            addCriterion("KNAME_1 like", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1NotLike(String value) {
            addCriterion("KNAME_1 not like", value, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1In(List<String> values) {
            addCriterion("KNAME_1 in", values, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1NotIn(List<String> values) {
            addCriterion("KNAME_1 not in", values, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1Between(String value1, String value2) {
            addCriterion("KNAME_1 between", value1, value2, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname1NotBetween(String value1, String value2) {
            addCriterion("KNAME_1 not between", value1, value2, "kname1");
            return (Criteria) this;
        }

        public Criteria andKname2IsNull() {
            addCriterion("KNAME_2 is null");
            return (Criteria) this;
        }

        public Criteria andKname2IsNotNull() {
            addCriterion("KNAME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andKname2EqualTo(String value) {
            addCriterion("KNAME_2 =", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2NotEqualTo(String value) {
            addCriterion("KNAME_2 <>", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2GreaterThan(String value) {
            addCriterion("KNAME_2 >", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2GreaterThanOrEqualTo(String value) {
            addCriterion("KNAME_2 >=", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2LessThan(String value) {
            addCriterion("KNAME_2 <", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2LessThanOrEqualTo(String value) {
            addCriterion("KNAME_2 <=", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2Like(String value) {
            addCriterion("KNAME_2 like", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2NotLike(String value) {
            addCriterion("KNAME_2 not like", value, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2In(List<String> values) {
            addCriterion("KNAME_2 in", values, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2NotIn(List<String> values) {
            addCriterion("KNAME_2 not in", values, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2Between(String value1, String value2) {
            addCriterion("KNAME_2 between", value1, value2, "kname2");
            return (Criteria) this;
        }

        public Criteria andKname2NotBetween(String value1, String value2) {
            addCriterion("KNAME_2 not between", value1, value2, "kname2");
            return (Criteria) this;
        }

        public Criteria andKananame1IsNull() {
            addCriterion("KANANAME_1 is null");
            return (Criteria) this;
        }

        public Criteria andKananame1IsNotNull() {
            addCriterion("KANANAME_1 is not null");
            return (Criteria) this;
        }

        public Criteria andKananame1EqualTo(String value) {
            addCriterion("KANANAME_1 =", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1NotEqualTo(String value) {
            addCriterion("KANANAME_1 <>", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1GreaterThan(String value) {
            addCriterion("KANANAME_1 >", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1GreaterThanOrEqualTo(String value) {
            addCriterion("KANANAME_1 >=", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1LessThan(String value) {
            addCriterion("KANANAME_1 <", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1LessThanOrEqualTo(String value) {
            addCriterion("KANANAME_1 <=", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1Like(String value) {
            addCriterion("KANANAME_1 like", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1NotLike(String value) {
            addCriterion("KANANAME_1 not like", value, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1In(List<String> values) {
            addCriterion("KANANAME_1 in", values, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1NotIn(List<String> values) {
            addCriterion("KANANAME_1 not in", values, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1Between(String value1, String value2) {
            addCriterion("KANANAME_1 between", value1, value2, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame1NotBetween(String value1, String value2) {
            addCriterion("KANANAME_1 not between", value1, value2, "kananame1");
            return (Criteria) this;
        }

        public Criteria andKananame2IsNull() {
            addCriterion("KANANAME_2 is null");
            return (Criteria) this;
        }

        public Criteria andKananame2IsNotNull() {
            addCriterion("KANANAME_2 is not null");
            return (Criteria) this;
        }

        public Criteria andKananame2EqualTo(String value) {
            addCriterion("KANANAME_2 =", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2NotEqualTo(String value) {
            addCriterion("KANANAME_2 <>", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2GreaterThan(String value) {
            addCriterion("KANANAME_2 >", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2GreaterThanOrEqualTo(String value) {
            addCriterion("KANANAME_2 >=", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2LessThan(String value) {
            addCriterion("KANANAME_2 <", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2LessThanOrEqualTo(String value) {
            addCriterion("KANANAME_2 <=", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2Like(String value) {
            addCriterion("KANANAME_2 like", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2NotLike(String value) {
            addCriterion("KANANAME_2 not like", value, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2In(List<String> values) {
            addCriterion("KANANAME_2 in", values, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2NotIn(List<String> values) {
            addCriterion("KANANAME_2 not in", values, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2Between(String value1, String value2) {
            addCriterion("KANANAME_2 between", value1, value2, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKananame2NotBetween(String value1, String value2) {
            addCriterion("KANANAME_2 not between", value1, value2, "kananame2");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinIsNull() {
            addCriterion("KNAME_HOUJIN is null");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinIsNotNull() {
            addCriterion("KNAME_HOUJIN is not null");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinEqualTo(String value) {
            addCriterion("KNAME_HOUJIN =", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinNotEqualTo(String value) {
            addCriterion("KNAME_HOUJIN <>", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinGreaterThan(String value) {
            addCriterion("KNAME_HOUJIN >", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinGreaterThanOrEqualTo(String value) {
            addCriterion("KNAME_HOUJIN >=", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinLessThan(String value) {
            addCriterion("KNAME_HOUJIN <", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinLessThanOrEqualTo(String value) {
            addCriterion("KNAME_HOUJIN <=", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinLike(String value) {
            addCriterion("KNAME_HOUJIN like", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinNotLike(String value) {
            addCriterion("KNAME_HOUJIN not like", value, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinIn(List<String> values) {
            addCriterion("KNAME_HOUJIN in", values, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinNotIn(List<String> values) {
            addCriterion("KNAME_HOUJIN not in", values, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinBetween(String value1, String value2) {
            addCriterion("KNAME_HOUJIN between", value1, value2, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andKnameHoujinNotBetween(String value1, String value2) {
            addCriterion("KNAME_HOUJIN not between", value1, value2, "knameHoujin");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNull() {
            addCriterion("TEL_NO is null");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNotNull() {
            addCriterion("TEL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTelNoEqualTo(String value) {
            addCriterion("TEL_NO =", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotEqualTo(String value) {
            addCriterion("TEL_NO <>", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThan(String value) {
            addCriterion("TEL_NO >", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThanOrEqualTo(String value) {
            addCriterion("TEL_NO >=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThan(String value) {
            addCriterion("TEL_NO <", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThanOrEqualTo(String value) {
            addCriterion("TEL_NO <=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLike(String value) {
            addCriterion("TEL_NO like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotLike(String value) {
            addCriterion("TEL_NO not like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoIn(List<String> values) {
            addCriterion("TEL_NO in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotIn(List<String> values) {
            addCriterion("TEL_NO not in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoBetween(String value1, String value2) {
            addCriterion("TEL_NO between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotBetween(String value1, String value2) {
            addCriterion("TEL_NO not between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNull() {
            addCriterion("MAIL_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNotNull() {
            addCriterion("MAIL_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMailAddressEqualTo(String value) {
            addCriterion("MAIL_ADDRESS =", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotEqualTo(String value) {
            addCriterion("MAIL_ADDRESS <>", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThan(String value) {
            addCriterion("MAIL_ADDRESS >", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("MAIL_ADDRESS >=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThan(String value) {
            addCriterion("MAIL_ADDRESS <", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThanOrEqualTo(String value) {
            addCriterion("MAIL_ADDRESS <=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLike(String value) {
            addCriterion("MAIL_ADDRESS like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotLike(String value) {
            addCriterion("MAIL_ADDRESS not like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressIn(List<String> values) {
            addCriterion("MAIL_ADDRESS in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotIn(List<String> values) {
            addCriterion("MAIL_ADDRESS not in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressBetween(String value1, String value2) {
            addCriterion("MAIL_ADDRESS between", value1, value2, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotBetween(String value1, String value2) {
            addCriterion("MAIL_ADDRESS not between", value1, value2, "mailAddress");
            return (Criteria) this;
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

        public Criteria andResponseMailIdIsNull() {
            addCriterion("RESPONSE_MAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdIsNotNull() {
            addCriterion("RESPONSE_MAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdEqualTo(Integer value) {
            addCriterion("RESPONSE_MAIL_ID =", value, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdNotEqualTo(Integer value) {
            addCriterion("RESPONSE_MAIL_ID <>", value, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdGreaterThan(Integer value) {
            addCriterion("RESPONSE_MAIL_ID >", value, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESPONSE_MAIL_ID >=", value, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdLessThan(Integer value) {
            addCriterion("RESPONSE_MAIL_ID <", value, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdLessThanOrEqualTo(Integer value) {
            addCriterion("RESPONSE_MAIL_ID <=", value, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdIn(List<Integer> values) {
            addCriterion("RESPONSE_MAIL_ID in", values, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdNotIn(List<Integer> values) {
            addCriterion("RESPONSE_MAIL_ID not in", values, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdBetween(Integer value1, Integer value2) {
            addCriterion("RESPONSE_MAIL_ID between", value1, value2, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andResponseMailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RESPONSE_MAIL_ID not between", value1, value2, "responseMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdIsNull() {
            addCriterion("NOTIFY_MAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdIsNotNull() {
            addCriterion("NOTIFY_MAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdEqualTo(Integer value) {
            addCriterion("NOTIFY_MAIL_ID =", value, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdNotEqualTo(Integer value) {
            addCriterion("NOTIFY_MAIL_ID <>", value, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdGreaterThan(Integer value) {
            addCriterion("NOTIFY_MAIL_ID >", value, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NOTIFY_MAIL_ID >=", value, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdLessThan(Integer value) {
            addCriterion("NOTIFY_MAIL_ID <", value, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdLessThanOrEqualTo(Integer value) {
            addCriterion("NOTIFY_MAIL_ID <=", value, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdIn(List<Integer> values) {
            addCriterion("NOTIFY_MAIL_ID in", values, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdNotIn(List<Integer> values) {
            addCriterion("NOTIFY_MAIL_ID not in", values, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdBetween(Integer value1, Integer value2) {
            addCriterion("NOTIFY_MAIL_ID between", value1, value2, "notifyMailId");
            return (Criteria) this;
        }

        public Criteria andNotifyMailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NOTIFY_MAIL_ID not between", value1, value2, "notifyMailId");
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