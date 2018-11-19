package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MWebKikakuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MWebKikakuExample() {
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

        public Criteria andBaseDirectoryIsNull() {
            addCriterion("BASE_DIRECTORY is null");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryIsNotNull() {
            addCriterion("BASE_DIRECTORY is not null");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryEqualTo(String value) {
            addCriterion("BASE_DIRECTORY =", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryNotEqualTo(String value) {
            addCriterion("BASE_DIRECTORY <>", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryGreaterThan(String value) {
            addCriterion("BASE_DIRECTORY >", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryGreaterThanOrEqualTo(String value) {
            addCriterion("BASE_DIRECTORY >=", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryLessThan(String value) {
            addCriterion("BASE_DIRECTORY <", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryLessThanOrEqualTo(String value) {
            addCriterion("BASE_DIRECTORY <=", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryLike(String value) {
            addCriterion("BASE_DIRECTORY like", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryNotLike(String value) {
            addCriterion("BASE_DIRECTORY not like", value, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryIn(List<String> values) {
            addCriterion("BASE_DIRECTORY in", values, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryNotIn(List<String> values) {
            addCriterion("BASE_DIRECTORY not in", values, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryBetween(String value1, String value2) {
            addCriterion("BASE_DIRECTORY between", value1, value2, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andBaseDirectoryNotBetween(String value1, String value2) {
            addCriterion("BASE_DIRECTORY not between", value1, value2, "baseDirectory");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitIsNull() {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT is null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitIsNotNull() {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT is not null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT =", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitNotEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT <>", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitGreaterThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT >", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitGreaterThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT >=", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitLessThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT <", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitLessThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT <=", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT like", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitNotLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT not like", value, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT in", values, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitNotIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT not in", values, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT between", value1, value2, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdSplitNotBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_CD_SPLIT not between", value1, value2, "hagakiSyouhinCdSplit");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatIsNull() {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT is null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatIsNotNull() {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT is not null");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT =", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatNotEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT <>", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatGreaterThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT >", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatGreaterThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT >=", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatLessThan(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT <", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatLessThanOrEqualTo(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT <=", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT like", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatNotLike(String value) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT not like", value, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT in", values, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatNotIn(List<String> values) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT not in", values, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT between", value1, value2, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andHagakiSyouhinCdFormatNotBetween(String value1, String value2) {
            addCriterion("HAGAKI_SYOUHIN_CD_FORMAT not between", value1, value2, "hagakiSyouhinCdFormat");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgIsNull() {
            addCriterion("TOIAWASE_YUUKOU_FLG is null");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgIsNotNull() {
            addCriterion("TOIAWASE_YUUKOU_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgEqualTo(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG =", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgNotEqualTo(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG <>", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgGreaterThan(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG >", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgGreaterThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG >=", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgLessThan(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG <", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgLessThanOrEqualTo(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG <=", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgLike(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG like", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgNotLike(String value) {
            addCriterion("TOIAWASE_YUUKOU_FLG not like", value, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgIn(List<String> values) {
            addCriterion("TOIAWASE_YUUKOU_FLG in", values, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgNotIn(List<String> values) {
            addCriterion("TOIAWASE_YUUKOU_FLG not in", values, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgBetween(String value1, String value2) {
            addCriterion("TOIAWASE_YUUKOU_FLG between", value1, value2, "toiawaseYuukouFlg");
            return (Criteria) this;
        }

        public Criteria andToiawaseYuukouFlgNotBetween(String value1, String value2) {
            addCriterion("TOIAWASE_YUUKOU_FLG not between", value1, value2, "toiawaseYuukouFlg");
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