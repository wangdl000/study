package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MKikakuGenreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MKikakuGenreExample() {
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

        public Criteria andGenreNoIsNull() {
            addCriterion("GENRE_NO is null");
            return (Criteria) this;
        }

        public Criteria andGenreNoIsNotNull() {
            addCriterion("GENRE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andGenreNoEqualTo(String value) {
            addCriterion("GENRE_NO =", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoNotEqualTo(String value) {
            addCriterion("GENRE_NO <>", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoGreaterThan(String value) {
            addCriterion("GENRE_NO >", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoGreaterThanOrEqualTo(String value) {
            addCriterion("GENRE_NO >=", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoLessThan(String value) {
            addCriterion("GENRE_NO <", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoLessThanOrEqualTo(String value) {
            addCriterion("GENRE_NO <=", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoLike(String value) {
            addCriterion("GENRE_NO like", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoNotLike(String value) {
            addCriterion("GENRE_NO not like", value, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoIn(List<String> values) {
            addCriterion("GENRE_NO in", values, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoNotIn(List<String> values) {
            addCriterion("GENRE_NO not in", values, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoBetween(String value1, String value2) {
            addCriterion("GENRE_NO between", value1, value2, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNoNotBetween(String value1, String value2) {
            addCriterion("GENRE_NO not between", value1, value2, "genreNo");
            return (Criteria) this;
        }

        public Criteria andGenreNameIsNull() {
            addCriterion("GENRE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGenreNameIsNotNull() {
            addCriterion("GENRE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGenreNameEqualTo(String value) {
            addCriterion("GENRE_NAME =", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameNotEqualTo(String value) {
            addCriterion("GENRE_NAME <>", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameGreaterThan(String value) {
            addCriterion("GENRE_NAME >", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameGreaterThanOrEqualTo(String value) {
            addCriterion("GENRE_NAME >=", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameLessThan(String value) {
            addCriterion("GENRE_NAME <", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameLessThanOrEqualTo(String value) {
            addCriterion("GENRE_NAME <=", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameLike(String value) {
            addCriterion("GENRE_NAME like", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameNotLike(String value) {
            addCriterion("GENRE_NAME not like", value, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameIn(List<String> values) {
            addCriterion("GENRE_NAME in", values, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameNotIn(List<String> values) {
            addCriterion("GENRE_NAME not in", values, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameBetween(String value1, String value2) {
            addCriterion("GENRE_NAME between", value1, value2, "genreName");
            return (Criteria) this;
        }

        public Criteria andGenreNameNotBetween(String value1, String value2) {
            addCriterion("GENRE_NAME not between", value1, value2, "genreName");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNull() {
            addCriterion("SORT_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNotNull() {
            addCriterion("SORT_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andSortOrderEqualTo(Long value) {
            addCriterion("SORT_ORDER =", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotEqualTo(Long value) {
            addCriterion("SORT_ORDER <>", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThan(Long value) {
            addCriterion("SORT_ORDER >", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            addCriterion("SORT_ORDER >=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThan(Long value) {
            addCriterion("SORT_ORDER <", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Long value) {
            addCriterion("SORT_ORDER <=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderIn(List<Long> values) {
            addCriterion("SORT_ORDER in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotIn(List<Long> values) {
            addCriterion("SORT_ORDER not in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderBetween(Long value1, Long value2) {
            addCriterion("SORT_ORDER between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotBetween(Long value1, Long value2) {
            addCriterion("SORT_ORDER not between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlIsNull() {
            addCriterion("GENRE_HEADER_IMAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlIsNotNull() {
            addCriterion("GENRE_HEADER_IMAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlEqualTo(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL =", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlNotEqualTo(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL <>", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlGreaterThan(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL >", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL >=", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlLessThan(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL <", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlLessThanOrEqualTo(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL <=", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlLike(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL like", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlNotLike(String value) {
            addCriterion("GENRE_HEADER_IMAGE_URL not like", value, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlIn(List<String> values) {
            addCriterion("GENRE_HEADER_IMAGE_URL in", values, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlNotIn(List<String> values) {
            addCriterion("GENRE_HEADER_IMAGE_URL not in", values, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlBetween(String value1, String value2) {
            addCriterion("GENRE_HEADER_IMAGE_URL between", value1, value2, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreHeaderImageUrlNotBetween(String value1, String value2) {
            addCriterion("GENRE_HEADER_IMAGE_URL not between", value1, value2, "genreHeaderImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlIsNull() {
            addCriterion("GENRE_LINK_IMAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlIsNotNull() {
            addCriterion("GENRE_LINK_IMAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlEqualTo(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL =", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlNotEqualTo(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL <>", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlGreaterThan(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL >", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL >=", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlLessThan(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL <", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlLessThanOrEqualTo(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL <=", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlLike(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL like", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlNotLike(String value) {
            addCriterion("GENRE_LINK_IMAGE_URL not like", value, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlIn(List<String> values) {
            addCriterion("GENRE_LINK_IMAGE_URL in", values, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlNotIn(List<String> values) {
            addCriterion("GENRE_LINK_IMAGE_URL not in", values, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlBetween(String value1, String value2) {
            addCriterion("GENRE_LINK_IMAGE_URL between", value1, value2, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andGenreLinkImageUrlNotBetween(String value1, String value2) {
            addCriterion("GENRE_LINK_IMAGE_URL not between", value1, value2, "genreLinkImageUrl");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgIsNull() {
            addCriterion("MENU_HYOUJI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgIsNotNull() {
            addCriterion("MENU_HYOUJI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgEqualTo(String value) {
            addCriterion("MENU_HYOUJI_FLG =", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgNotEqualTo(String value) {
            addCriterion("MENU_HYOUJI_FLG <>", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgGreaterThan(String value) {
            addCriterion("MENU_HYOUJI_FLG >", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_HYOUJI_FLG >=", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgLessThan(String value) {
            addCriterion("MENU_HYOUJI_FLG <", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgLessThanOrEqualTo(String value) {
            addCriterion("MENU_HYOUJI_FLG <=", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgLike(String value) {
            addCriterion("MENU_HYOUJI_FLG like", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgNotLike(String value) {
            addCriterion("MENU_HYOUJI_FLG not like", value, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgIn(List<String> values) {
            addCriterion("MENU_HYOUJI_FLG in", values, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgNotIn(List<String> values) {
            addCriterion("MENU_HYOUJI_FLG not in", values, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgBetween(String value1, String value2) {
            addCriterion("MENU_HYOUJI_FLG between", value1, value2, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andMenuHyoujiFlgNotBetween(String value1, String value2) {
            addCriterion("MENU_HYOUJI_FLG not between", value1, value2, "menuHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgIsNull() {
            addCriterion("GENRE_ICON_HYOUJI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgIsNotNull() {
            addCriterion("GENRE_ICON_HYOUJI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgEqualTo(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG =", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgNotEqualTo(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG <>", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgGreaterThan(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG >", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgGreaterThanOrEqualTo(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG >=", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgLessThan(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG <", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgLessThanOrEqualTo(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG <=", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgLike(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG like", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgNotLike(String value) {
            addCriterion("GENRE_ICON_HYOUJI_FLG not like", value, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgIn(List<String> values) {
            addCriterion("GENRE_ICON_HYOUJI_FLG in", values, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgNotIn(List<String> values) {
            addCriterion("GENRE_ICON_HYOUJI_FLG not in", values, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgBetween(String value1, String value2) {
            addCriterion("GENRE_ICON_HYOUJI_FLG between", value1, value2, "genreIconHyoujiFlg");
            return (Criteria) this;
        }

        public Criteria andGenreIconHyoujiFlgNotBetween(String value1, String value2) {
            addCriterion("GENRE_ICON_HYOUJI_FLG not between", value1, value2, "genreIconHyoujiFlg");
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