package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMailSpoolingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMailSpoolingExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andMailFromAddressIsNull() {
            addCriterion("MAIL_FROM_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressIsNotNull() {
            addCriterion("MAIL_FROM_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressEqualTo(String value) {
            addCriterion("MAIL_FROM_ADDRESS =", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressNotEqualTo(String value) {
            addCriterion("MAIL_FROM_ADDRESS <>", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressGreaterThan(String value) {
            addCriterion("MAIL_FROM_ADDRESS >", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressGreaterThanOrEqualTo(String value) {
            addCriterion("MAIL_FROM_ADDRESS >=", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressLessThan(String value) {
            addCriterion("MAIL_FROM_ADDRESS <", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressLessThanOrEqualTo(String value) {
            addCriterion("MAIL_FROM_ADDRESS <=", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressLike(String value) {
            addCriterion("MAIL_FROM_ADDRESS like", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressNotLike(String value) {
            addCriterion("MAIL_FROM_ADDRESS not like", value, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressIn(List<String> values) {
            addCriterion("MAIL_FROM_ADDRESS in", values, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressNotIn(List<String> values) {
            addCriterion("MAIL_FROM_ADDRESS not in", values, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressBetween(String value1, String value2) {
            addCriterion("MAIL_FROM_ADDRESS between", value1, value2, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromAddressNotBetween(String value1, String value2) {
            addCriterion("MAIL_FROM_ADDRESS not between", value1, value2, "mailFromAddress");
            return (Criteria) this;
        }

        public Criteria andMailFromNameIsNull() {
            addCriterion("MAIL_FROM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMailFromNameIsNotNull() {
            addCriterion("MAIL_FROM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMailFromNameEqualTo(String value) {
            addCriterion("MAIL_FROM_NAME =", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameNotEqualTo(String value) {
            addCriterion("MAIL_FROM_NAME <>", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameGreaterThan(String value) {
            addCriterion("MAIL_FROM_NAME >", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameGreaterThanOrEqualTo(String value) {
            addCriterion("MAIL_FROM_NAME >=", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameLessThan(String value) {
            addCriterion("MAIL_FROM_NAME <", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameLessThanOrEqualTo(String value) {
            addCriterion("MAIL_FROM_NAME <=", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameLike(String value) {
            addCriterion("MAIL_FROM_NAME like", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameNotLike(String value) {
            addCriterion("MAIL_FROM_NAME not like", value, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameIn(List<String> values) {
            addCriterion("MAIL_FROM_NAME in", values, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameNotIn(List<String> values) {
            addCriterion("MAIL_FROM_NAME not in", values, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameBetween(String value1, String value2) {
            addCriterion("MAIL_FROM_NAME between", value1, value2, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailFromNameNotBetween(String value1, String value2) {
            addCriterion("MAIL_FROM_NAME not between", value1, value2, "mailFromName");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressIsNull() {
            addCriterion("MAIL_REPLYTO_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressIsNotNull() {
            addCriterion("MAIL_REPLYTO_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressEqualTo(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS =", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressNotEqualTo(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS <>", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressGreaterThan(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS >", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS >=", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressLessThan(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS <", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressLessThanOrEqualTo(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS <=", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressLike(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS like", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressNotLike(String value) {
            addCriterion("MAIL_REPLYTO_ADDRESS not like", value, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressIn(List<String> values) {
            addCriterion("MAIL_REPLYTO_ADDRESS in", values, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressNotIn(List<String> values) {
            addCriterion("MAIL_REPLYTO_ADDRESS not in", values, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressBetween(String value1, String value2) {
            addCriterion("MAIL_REPLYTO_ADDRESS between", value1, value2, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailReplytoAddressNotBetween(String value1, String value2) {
            addCriterion("MAIL_REPLYTO_ADDRESS not between", value1, value2, "mailReplytoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressIsNull() {
            addCriterion("MAIL_ERRORTO_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressIsNotNull() {
            addCriterion("MAIL_ERRORTO_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressEqualTo(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS =", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressNotEqualTo(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS <>", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressGreaterThan(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS >", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS >=", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressLessThan(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS <", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressLessThanOrEqualTo(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS <=", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressLike(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS like", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressNotLike(String value) {
            addCriterion("MAIL_ERRORTO_ADDRESS not like", value, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressIn(List<String> values) {
            addCriterion("MAIL_ERRORTO_ADDRESS in", values, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressNotIn(List<String> values) {
            addCriterion("MAIL_ERRORTO_ADDRESS not in", values, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressBetween(String value1, String value2) {
            addCriterion("MAIL_ERRORTO_ADDRESS between", value1, value2, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andMailErrortoAddressNotBetween(String value1, String value2) {
            addCriterion("MAIL_ERRORTO_ADDRESS not between", value1, value2, "mailErrortoAddress");
            return (Criteria) this;
        }

        public Criteria andNowSendingIsNull() {
            addCriterion("NOW_SENDING is null");
            return (Criteria) this;
        }

        public Criteria andNowSendingIsNotNull() {
            addCriterion("NOW_SENDING is not null");
            return (Criteria) this;
        }

        public Criteria andNowSendingEqualTo(String value) {
            addCriterion("NOW_SENDING =", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingNotEqualTo(String value) {
            addCriterion("NOW_SENDING <>", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingGreaterThan(String value) {
            addCriterion("NOW_SENDING >", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingGreaterThanOrEqualTo(String value) {
            addCriterion("NOW_SENDING >=", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingLessThan(String value) {
            addCriterion("NOW_SENDING <", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingLessThanOrEqualTo(String value) {
            addCriterion("NOW_SENDING <=", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingLike(String value) {
            addCriterion("NOW_SENDING like", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingNotLike(String value) {
            addCriterion("NOW_SENDING not like", value, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingIn(List<String> values) {
            addCriterion("NOW_SENDING in", values, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingNotIn(List<String> values) {
            addCriterion("NOW_SENDING not in", values, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingBetween(String value1, String value2) {
            addCriterion("NOW_SENDING between", value1, value2, "nowSending");
            return (Criteria) this;
        }

        public Criteria andNowSendingNotBetween(String value1, String value2) {
            addCriterion("NOW_SENDING not between", value1, value2, "nowSending");
            return (Criteria) this;
        }

        public Criteria andSendedIsNull() {
            addCriterion("SENDED is null");
            return (Criteria) this;
        }

        public Criteria andSendedIsNotNull() {
            addCriterion("SENDED is not null");
            return (Criteria) this;
        }

        public Criteria andSendedEqualTo(String value) {
            addCriterion("SENDED =", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedNotEqualTo(String value) {
            addCriterion("SENDED <>", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedGreaterThan(String value) {
            addCriterion("SENDED >", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedGreaterThanOrEqualTo(String value) {
            addCriterion("SENDED >=", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedLessThan(String value) {
            addCriterion("SENDED <", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedLessThanOrEqualTo(String value) {
            addCriterion("SENDED <=", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedLike(String value) {
            addCriterion("SENDED like", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedNotLike(String value) {
            addCriterion("SENDED not like", value, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedIn(List<String> values) {
            addCriterion("SENDED in", values, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedNotIn(List<String> values) {
            addCriterion("SENDED not in", values, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedBetween(String value1, String value2) {
            addCriterion("SENDED between", value1, value2, "sended");
            return (Criteria) this;
        }

        public Criteria andSendedNotBetween(String value1, String value2) {
            addCriterion("SENDED not between", value1, value2, "sended");
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