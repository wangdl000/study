package com.commodity.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MWebSyouhinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MWebSyouhinExample() {
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

        public Criteria andItemKeisaiKbnIsNull() {
            addCriterion("ITEM_KEISAI_KBN is null");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnIsNotNull() {
            addCriterion("ITEM_KEISAI_KBN is not null");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnEqualTo(String value) {
            addCriterion("ITEM_KEISAI_KBN =", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnNotEqualTo(String value) {
            addCriterion("ITEM_KEISAI_KBN <>", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnGreaterThan(String value) {
            addCriterion("ITEM_KEISAI_KBN >", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_KEISAI_KBN >=", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnLessThan(String value) {
            addCriterion("ITEM_KEISAI_KBN <", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnLessThanOrEqualTo(String value) {
            addCriterion("ITEM_KEISAI_KBN <=", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnLike(String value) {
            addCriterion("ITEM_KEISAI_KBN like", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnNotLike(String value) {
            addCriterion("ITEM_KEISAI_KBN not like", value, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnIn(List<String> values) {
            addCriterion("ITEM_KEISAI_KBN in", values, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnNotIn(List<String> values) {
            addCriterion("ITEM_KEISAI_KBN not in", values, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnBetween(String value1, String value2) {
            addCriterion("ITEM_KEISAI_KBN between", value1, value2, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andItemKeisaiKbnNotBetween(String value1, String value2) {
            addCriterion("ITEM_KEISAI_KBN not between", value1, value2, "itemKeisaiKbn");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameIsNull() {
            addCriterion("SYOUHIN_HYOUJI_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameIsNotNull() {
            addCriterion("SYOUHIN_HYOUJI_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameEqualTo(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME =", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameNotEqualTo(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME <>", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameGreaterThan(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME >", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME >=", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameLessThan(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME <", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameLessThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME <=", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameLike(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME like", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameNotLike(String value) {
            addCriterion("SYOUHIN_HYOUJI_NAME not like", value, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameIn(List<String> values) {
            addCriterion("SYOUHIN_HYOUJI_NAME in", values, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameNotIn(List<String> values) {
            addCriterion("SYOUHIN_HYOUJI_NAME not in", values, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameBetween(String value1, String value2) {
            addCriterion("SYOUHIN_HYOUJI_NAME between", value1, value2, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andSyouhinHyoujiNameNotBetween(String value1, String value2) {
            addCriterion("SYOUHIN_HYOUJI_NAME not between", value1, value2, "syouhinHyoujiName");
            return (Criteria) this;
        }

        public Criteria andCatchCopyIsNull() {
            addCriterion("CATCH_COPY is null");
            return (Criteria) this;
        }

        public Criteria andCatchCopyIsNotNull() {
            addCriterion("CATCH_COPY is not null");
            return (Criteria) this;
        }

        public Criteria andCatchCopyEqualTo(String value) {
            addCriterion("CATCH_COPY =", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyNotEqualTo(String value) {
            addCriterion("CATCH_COPY <>", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyGreaterThan(String value) {
            addCriterion("CATCH_COPY >", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyGreaterThanOrEqualTo(String value) {
            addCriterion("CATCH_COPY >=", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyLessThan(String value) {
            addCriterion("CATCH_COPY <", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyLessThanOrEqualTo(String value) {
            addCriterion("CATCH_COPY <=", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyLike(String value) {
            addCriterion("CATCH_COPY like", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyNotLike(String value) {
            addCriterion("CATCH_COPY not like", value, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyIn(List<String> values) {
            addCriterion("CATCH_COPY in", values, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyNotIn(List<String> values) {
            addCriterion("CATCH_COPY not in", values, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyBetween(String value1, String value2) {
            addCriterion("CATCH_COPY between", value1, value2, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andCatchCopyNotBetween(String value1, String value2) {
            addCriterion("CATCH_COPY not between", value1, value2, "catchCopy");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiIsNull() {
            addCriterion("ITEM_SYOSAI is null");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiIsNotNull() {
            addCriterion("ITEM_SYOSAI is not null");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiEqualTo(String value) {
            addCriterion("ITEM_SYOSAI =", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiNotEqualTo(String value) {
            addCriterion("ITEM_SYOSAI <>", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiGreaterThan(String value) {
            addCriterion("ITEM_SYOSAI >", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_SYOSAI >=", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiLessThan(String value) {
            addCriterion("ITEM_SYOSAI <", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiLessThanOrEqualTo(String value) {
            addCriterion("ITEM_SYOSAI <=", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiLike(String value) {
            addCriterion("ITEM_SYOSAI like", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiNotLike(String value) {
            addCriterion("ITEM_SYOSAI not like", value, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiIn(List<String> values) {
            addCriterion("ITEM_SYOSAI in", values, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiNotIn(List<String> values) {
            addCriterion("ITEM_SYOSAI not in", values, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiBetween(String value1, String value2) {
            addCriterion("ITEM_SYOSAI between", value1, value2, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemSyosaiNotBetween(String value1, String value2) {
            addCriterion("ITEM_SYOSAI not between", value1, value2, "itemSyosai");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouIsNull() {
            addCriterion("ITEM_NAIYOU is null");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouIsNotNull() {
            addCriterion("ITEM_NAIYOU is not null");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouEqualTo(String value) {
            addCriterion("ITEM_NAIYOU =", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouNotEqualTo(String value) {
            addCriterion("ITEM_NAIYOU <>", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouGreaterThan(String value) {
            addCriterion("ITEM_NAIYOU >", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAIYOU >=", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouLessThan(String value) {
            addCriterion("ITEM_NAIYOU <", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAIYOU <=", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouLike(String value) {
            addCriterion("ITEM_NAIYOU like", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouNotLike(String value) {
            addCriterion("ITEM_NAIYOU not like", value, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouIn(List<String> values) {
            addCriterion("ITEM_NAIYOU in", values, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouNotIn(List<String> values) {
            addCriterion("ITEM_NAIYOU not in", values, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouBetween(String value1, String value2) {
            addCriterion("ITEM_NAIYOU between", value1, value2, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemNaiyouNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAIYOU not between", value1, value2, "itemNaiyou");
            return (Criteria) this;
        }

        public Criteria andItemSantiIsNull() {
            addCriterion("ITEM_SANTI is null");
            return (Criteria) this;
        }

        public Criteria andItemSantiIsNotNull() {
            addCriterion("ITEM_SANTI is not null");
            return (Criteria) this;
        }

        public Criteria andItemSantiEqualTo(String value) {
            addCriterion("ITEM_SANTI =", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiNotEqualTo(String value) {
            addCriterion("ITEM_SANTI <>", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiGreaterThan(String value) {
            addCriterion("ITEM_SANTI >", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_SANTI >=", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiLessThan(String value) {
            addCriterion("ITEM_SANTI <", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiLessThanOrEqualTo(String value) {
            addCriterion("ITEM_SANTI <=", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiLike(String value) {
            addCriterion("ITEM_SANTI like", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiNotLike(String value) {
            addCriterion("ITEM_SANTI not like", value, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiIn(List<String> values) {
            addCriterion("ITEM_SANTI in", values, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiNotIn(List<String> values) {
            addCriterion("ITEM_SANTI not in", values, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiBetween(String value1, String value2) {
            addCriterion("ITEM_SANTI between", value1, value2, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemSantiNotBetween(String value1, String value2) {
            addCriterion("ITEM_SANTI not between", value1, value2, "itemSanti");
            return (Criteria) this;
        }

        public Criteria andItemKigenIsNull() {
            addCriterion("ITEM_KIGEN is null");
            return (Criteria) this;
        }

        public Criteria andItemKigenIsNotNull() {
            addCriterion("ITEM_KIGEN is not null");
            return (Criteria) this;
        }

        public Criteria andItemKigenEqualTo(String value) {
            addCriterion("ITEM_KIGEN =", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenNotEqualTo(String value) {
            addCriterion("ITEM_KIGEN <>", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenGreaterThan(String value) {
            addCriterion("ITEM_KIGEN >", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_KIGEN >=", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenLessThan(String value) {
            addCriterion("ITEM_KIGEN <", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenLessThanOrEqualTo(String value) {
            addCriterion("ITEM_KIGEN <=", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenLike(String value) {
            addCriterion("ITEM_KIGEN like", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenNotLike(String value) {
            addCriterion("ITEM_KIGEN not like", value, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenIn(List<String> values) {
            addCriterion("ITEM_KIGEN in", values, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenNotIn(List<String> values) {
            addCriterion("ITEM_KIGEN not in", values, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenBetween(String value1, String value2) {
            addCriterion("ITEM_KIGEN between", value1, value2, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andItemKigenNotBetween(String value1, String value2) {
            addCriterion("ITEM_KIGEN not between", value1, value2, "itemKigen");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgIsNull() {
            addCriterion("ALLERGIE_TAMAGO_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgIsNotNull() {
            addCriterion("ALLERGIE_TAMAGO_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgEqualTo(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG =", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgNotEqualTo(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG <>", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgGreaterThan(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG >", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG >=", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgLessThan(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG <", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG <=", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgLike(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG like", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgNotLike(String value) {
            addCriterion("ALLERGIE_TAMAGO_FLG not like", value, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgIn(List<String> values) {
            addCriterion("ALLERGIE_TAMAGO_FLG in", values, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgNotIn(List<String> values) {
            addCriterion("ALLERGIE_TAMAGO_FLG not in", values, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgBetween(String value1, String value2) {
            addCriterion("ALLERGIE_TAMAGO_FLG between", value1, value2, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieTamagoFlgNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_TAMAGO_FLG not between", value1, value2, "allergieTamagoFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgIsNull() {
            addCriterion("ALLERGIE_MILK_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgIsNotNull() {
            addCriterion("ALLERGIE_MILK_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgEqualTo(String value) {
            addCriterion("ALLERGIE_MILK_FLG =", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgNotEqualTo(String value) {
            addCriterion("ALLERGIE_MILK_FLG <>", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgGreaterThan(String value) {
            addCriterion("ALLERGIE_MILK_FLG >", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_MILK_FLG >=", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgLessThan(String value) {
            addCriterion("ALLERGIE_MILK_FLG <", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_MILK_FLG <=", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgLike(String value) {
            addCriterion("ALLERGIE_MILK_FLG like", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgNotLike(String value) {
            addCriterion("ALLERGIE_MILK_FLG not like", value, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgIn(List<String> values) {
            addCriterion("ALLERGIE_MILK_FLG in", values, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgNotIn(List<String> values) {
            addCriterion("ALLERGIE_MILK_FLG not in", values, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgBetween(String value1, String value2) {
            addCriterion("ALLERGIE_MILK_FLG between", value1, value2, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieMilkFlgNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_MILK_FLG not between", value1, value2, "allergieMilkFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgIsNull() {
            addCriterion("ALLERGIE_KOMUGI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgIsNotNull() {
            addCriterion("ALLERGIE_KOMUGI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgEqualTo(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG =", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgNotEqualTo(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG <>", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgGreaterThan(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG >", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG >=", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgLessThan(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG <", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG <=", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgLike(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG like", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgNotLike(String value) {
            addCriterion("ALLERGIE_KOMUGI_FLG not like", value, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgIn(List<String> values) {
            addCriterion("ALLERGIE_KOMUGI_FLG in", values, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgNotIn(List<String> values) {
            addCriterion("ALLERGIE_KOMUGI_FLG not in", values, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgBetween(String value1, String value2) {
            addCriterion("ALLERGIE_KOMUGI_FLG between", value1, value2, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKomugiFlgNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_KOMUGI_FLG not between", value1, value2, "allergieKomugiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgIsNull() {
            addCriterion("ALLERGIE_PEANUT_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgIsNotNull() {
            addCriterion("ALLERGIE_PEANUT_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgEqualTo(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG =", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgNotEqualTo(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG <>", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgGreaterThan(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG >", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG >=", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgLessThan(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG <", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG <=", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgLike(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG like", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgNotLike(String value) {
            addCriterion("ALLERGIE_PEANUT_FLG not like", value, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgIn(List<String> values) {
            addCriterion("ALLERGIE_PEANUT_FLG in", values, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgNotIn(List<String> values) {
            addCriterion("ALLERGIE_PEANUT_FLG not in", values, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgBetween(String value1, String value2) {
            addCriterion("ALLERGIE_PEANUT_FLG between", value1, value2, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergiePeanutFlgNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_PEANUT_FLG not between", value1, value2, "allergiePeanutFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgIsNull() {
            addCriterion("ALLERGIE_SOBA_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgIsNotNull() {
            addCriterion("ALLERGIE_SOBA_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgEqualTo(String value) {
            addCriterion("ALLERGIE_SOBA_FLG =", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgNotEqualTo(String value) {
            addCriterion("ALLERGIE_SOBA_FLG <>", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgGreaterThan(String value) {
            addCriterion("ALLERGIE_SOBA_FLG >", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_SOBA_FLG >=", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgLessThan(String value) {
            addCriterion("ALLERGIE_SOBA_FLG <", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_SOBA_FLG <=", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgLike(String value) {
            addCriterion("ALLERGIE_SOBA_FLG like", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgNotLike(String value) {
            addCriterion("ALLERGIE_SOBA_FLG not like", value, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgIn(List<String> values) {
            addCriterion("ALLERGIE_SOBA_FLG in", values, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgNotIn(List<String> values) {
            addCriterion("ALLERGIE_SOBA_FLG not in", values, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgBetween(String value1, String value2) {
            addCriterion("ALLERGIE_SOBA_FLG between", value1, value2, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieSobaFlgNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_SOBA_FLG not between", value1, value2, "allergieSobaFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgIsNull() {
            addCriterion("ALLERGIE_EBI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgIsNotNull() {
            addCriterion("ALLERGIE_EBI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgEqualTo(String value) {
            addCriterion("ALLERGIE_EBI_FLG =", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgNotEqualTo(String value) {
            addCriterion("ALLERGIE_EBI_FLG <>", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgGreaterThan(String value) {
            addCriterion("ALLERGIE_EBI_FLG >", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_EBI_FLG >=", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgLessThan(String value) {
            addCriterion("ALLERGIE_EBI_FLG <", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_EBI_FLG <=", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgLike(String value) {
            addCriterion("ALLERGIE_EBI_FLG like", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgNotLike(String value) {
            addCriterion("ALLERGIE_EBI_FLG not like", value, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgIn(List<String> values) {
            addCriterion("ALLERGIE_EBI_FLG in", values, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgNotIn(List<String> values) {
            addCriterion("ALLERGIE_EBI_FLG not in", values, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgBetween(String value1, String value2) {
            addCriterion("ALLERGIE_EBI_FLG between", value1, value2, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEbiFlgNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_EBI_FLG not between", value1, value2, "allergieEbiFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgIsNull() {
            addCriterion("ALLERGIE_KANI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgIsNotNull() {
            addCriterion("ALLERGIE_KANI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgEqualTo(String value) {
            addCriterion("ALLERGIE_KANI_FLG =", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgNotEqualTo(String value) {
            addCriterion("ALLERGIE_KANI_FLG <>", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgGreaterThan(String value) {
            addCriterion("ALLERGIE_KANI_FLG >", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_KANI_FLG >=", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgLessThan(String value) {
            addCriterion("ALLERGIE_KANI_FLG <", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_KANI_FLG <=", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgLike(String value) {
            addCriterion("ALLERGIE_KANI_FLG like", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgNotLike(String value) {
            addCriterion("ALLERGIE_KANI_FLG not like", value, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgIn(List<String> values) {
            addCriterion("ALLERGIE_KANI_FLG in", values, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgNotIn(List<String> values) {
            addCriterion("ALLERGIE_KANI_FLG not in", values, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgBetween(String value1, String value2) {
            addCriterion("ALLERGIE_KANI_FLG between", value1, value2, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieKaniFlgNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_KANI_FLG not between", value1, value2, "allergieKaniFlg");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextIsNull() {
            addCriterion("ALLERGIE_ETC_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextIsNotNull() {
            addCriterion("ALLERGIE_ETC_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextEqualTo(String value) {
            addCriterion("ALLERGIE_ETC_TEXT =", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextNotEqualTo(String value) {
            addCriterion("ALLERGIE_ETC_TEXT <>", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextGreaterThan(String value) {
            addCriterion("ALLERGIE_ETC_TEXT >", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextGreaterThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_ETC_TEXT >=", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextLessThan(String value) {
            addCriterion("ALLERGIE_ETC_TEXT <", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextLessThanOrEqualTo(String value) {
            addCriterion("ALLERGIE_ETC_TEXT <=", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextLike(String value) {
            addCriterion("ALLERGIE_ETC_TEXT like", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextNotLike(String value) {
            addCriterion("ALLERGIE_ETC_TEXT not like", value, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextIn(List<String> values) {
            addCriterion("ALLERGIE_ETC_TEXT in", values, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextNotIn(List<String> values) {
            addCriterion("ALLERGIE_ETC_TEXT not in", values, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextBetween(String value1, String value2) {
            addCriterion("ALLERGIE_ETC_TEXT between", value1, value2, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andAllergieEtcTextNotBetween(String value1, String value2) {
            addCriterion("ALLERGIE_ETC_TEXT not between", value1, value2, "allergieEtcText");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgIsNull() {
            addCriterion("KIKAN_GENTEI_FLG is null");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgIsNotNull() {
            addCriterion("KIKAN_GENTEI_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgEqualTo(String value) {
            addCriterion("KIKAN_GENTEI_FLG =", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgNotEqualTo(String value) {
            addCriterion("KIKAN_GENTEI_FLG <>", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgGreaterThan(String value) {
            addCriterion("KIKAN_GENTEI_FLG >", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgGreaterThanOrEqualTo(String value) {
            addCriterion("KIKAN_GENTEI_FLG >=", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgLessThan(String value) {
            addCriterion("KIKAN_GENTEI_FLG <", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgLessThanOrEqualTo(String value) {
            addCriterion("KIKAN_GENTEI_FLG <=", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgLike(String value) {
            addCriterion("KIKAN_GENTEI_FLG like", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgNotLike(String value) {
            addCriterion("KIKAN_GENTEI_FLG not like", value, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgIn(List<String> values) {
            addCriterion("KIKAN_GENTEI_FLG in", values, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgNotIn(List<String> values) {
            addCriterion("KIKAN_GENTEI_FLG not in", values, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgBetween(String value1, String value2) {
            addCriterion("KIKAN_GENTEI_FLG between", value1, value2, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andKikanGenteiFlgNotBetween(String value1, String value2) {
            addCriterion("KIKAN_GENTEI_FLG not between", value1, value2, "kikanGenteiFlg");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanIsNull() {
            addCriterion("DISP_GENTEI_KIKAN is null");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanIsNotNull() {
            addCriterion("DISP_GENTEI_KIKAN is not null");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanEqualTo(String value) {
            addCriterion("DISP_GENTEI_KIKAN =", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanNotEqualTo(String value) {
            addCriterion("DISP_GENTEI_KIKAN <>", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanGreaterThan(String value) {
            addCriterion("DISP_GENTEI_KIKAN >", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanGreaterThanOrEqualTo(String value) {
            addCriterion("DISP_GENTEI_KIKAN >=", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanLessThan(String value) {
            addCriterion("DISP_GENTEI_KIKAN <", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanLessThanOrEqualTo(String value) {
            addCriterion("DISP_GENTEI_KIKAN <=", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanLike(String value) {
            addCriterion("DISP_GENTEI_KIKAN like", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanNotLike(String value) {
            addCriterion("DISP_GENTEI_KIKAN not like", value, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanIn(List<String> values) {
            addCriterion("DISP_GENTEI_KIKAN in", values, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanNotIn(List<String> values) {
            addCriterion("DISP_GENTEI_KIKAN not in", values, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanBetween(String value1, String value2) {
            addCriterion("DISP_GENTEI_KIKAN between", value1, value2, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andDispGenteiKikanNotBetween(String value1, String value2) {
            addCriterion("DISP_GENTEI_KIKAN not between", value1, value2, "dispGenteiKikan");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouIsNull() {
            addCriterion("ITEM_HAISOU_HOUHOU is null");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouIsNotNull() {
            addCriterion("ITEM_HAISOU_HOUHOU is not null");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouEqualTo(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU =", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouNotEqualTo(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU <>", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouGreaterThan(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU >", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU >=", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouLessThan(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU <", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouLessThanOrEqualTo(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU <=", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouLike(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU like", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouNotLike(String value) {
            addCriterion("ITEM_HAISOU_HOUHOU not like", value, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouIn(List<String> values) {
            addCriterion("ITEM_HAISOU_HOUHOU in", values, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouNotIn(List<String> values) {
            addCriterion("ITEM_HAISOU_HOUHOU not in", values, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouBetween(String value1, String value2) {
            addCriterion("ITEM_HAISOU_HOUHOU between", value1, value2, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andItemHaisouHouhouNotBetween(String value1, String value2) {
            addCriterion("ITEM_HAISOU_HOUHOU not between", value1, value2, "itemHaisouHouhou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouIsNull() {
            addCriterion("WEB_SYOUHIN_BIKOU is null");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouIsNotNull() {
            addCriterion("WEB_SYOUHIN_BIKOU is not null");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouEqualTo(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU =", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouNotEqualTo(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU <>", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouGreaterThan(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU >", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU >=", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouLessThan(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU <", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouLessThanOrEqualTo(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU <=", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouLike(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU like", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouNotLike(String value) {
            addCriterion("WEB_SYOUHIN_BIKOU not like", value, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouIn(List<String> values) {
            addCriterion("WEB_SYOUHIN_BIKOU in", values, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouNotIn(List<String> values) {
            addCriterion("WEB_SYOUHIN_BIKOU not in", values, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouBetween(String value1, String value2) {
            addCriterion("WEB_SYOUHIN_BIKOU between", value1, value2, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andWebSyouhinBikouNotBetween(String value1, String value2) {
            addCriterion("WEB_SYOUHIN_BIKOU not between", value1, value2, "webSyouhinBikou");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoIsNull() {
            addCriterion("CATALOG_KEISAI_PAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoIsNotNull() {
            addCriterion("CATALOG_KEISAI_PAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoEqualTo(Long value) {
            addCriterion("CATALOG_KEISAI_PAGE_NO =", value, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoNotEqualTo(Long value) {
            addCriterion("CATALOG_KEISAI_PAGE_NO <>", value, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoGreaterThan(Long value) {
            addCriterion("CATALOG_KEISAI_PAGE_NO >", value, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoGreaterThanOrEqualTo(Long value) {
            addCriterion("CATALOG_KEISAI_PAGE_NO >=", value, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoLessThan(Long value) {
            addCriterion("CATALOG_KEISAI_PAGE_NO <", value, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoLessThanOrEqualTo(Long value) {
            addCriterion("CATALOG_KEISAI_PAGE_NO <=", value, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoIn(List<Long> values) {
            addCriterion("CATALOG_KEISAI_PAGE_NO in", values, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoNotIn(List<Long> values) {
            addCriterion("CATALOG_KEISAI_PAGE_NO not in", values, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoBetween(Long value1, Long value2) {
            addCriterion("CATALOG_KEISAI_PAGE_NO between", value1, value2, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andCatalogKeisaiPageNoNotBetween(Long value1, Long value2) {
            addCriterion("CATALOG_KEISAI_PAGE_NO not between", value1, value2, "catalogKeisaiPageNo");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1IsNull() {
            addCriterion("SYOUHIN_IMAGE_1 is null");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1IsNotNull() {
            addCriterion("SYOUHIN_IMAGE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1EqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_1 =", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1NotEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_1 <>", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1GreaterThan(String value) {
            addCriterion("SYOUHIN_IMAGE_1 >", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1GreaterThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_1 >=", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1LessThan(String value) {
            addCriterion("SYOUHIN_IMAGE_1 <", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1LessThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_1 <=", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1Like(String value) {
            addCriterion("SYOUHIN_IMAGE_1 like", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1NotLike(String value) {
            addCriterion("SYOUHIN_IMAGE_1 not like", value, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1In(List<String> values) {
            addCriterion("SYOUHIN_IMAGE_1 in", values, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1NotIn(List<String> values) {
            addCriterion("SYOUHIN_IMAGE_1 not in", values, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1Between(String value1, String value2) {
            addCriterion("SYOUHIN_IMAGE_1 between", value1, value2, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage1NotBetween(String value1, String value2) {
            addCriterion("SYOUHIN_IMAGE_1 not between", value1, value2, "syouhinImage1");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2IsNull() {
            addCriterion("SYOUHIN_IMAGE_2 is null");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2IsNotNull() {
            addCriterion("SYOUHIN_IMAGE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2EqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_2 =", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2NotEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_2 <>", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2GreaterThan(String value) {
            addCriterion("SYOUHIN_IMAGE_2 >", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2GreaterThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_2 >=", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2LessThan(String value) {
            addCriterion("SYOUHIN_IMAGE_2 <", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2LessThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_2 <=", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2Like(String value) {
            addCriterion("SYOUHIN_IMAGE_2 like", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2NotLike(String value) {
            addCriterion("SYOUHIN_IMAGE_2 not like", value, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2In(List<String> values) {
            addCriterion("SYOUHIN_IMAGE_2 in", values, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2NotIn(List<String> values) {
            addCriterion("SYOUHIN_IMAGE_2 not in", values, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2Between(String value1, String value2) {
            addCriterion("SYOUHIN_IMAGE_2 between", value1, value2, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage2NotBetween(String value1, String value2) {
            addCriterion("SYOUHIN_IMAGE_2 not between", value1, value2, "syouhinImage2");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3IsNull() {
            addCriterion("SYOUHIN_IMAGE_3 is null");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3IsNotNull() {
            addCriterion("SYOUHIN_IMAGE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3EqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_3 =", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3NotEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_3 <>", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3GreaterThan(String value) {
            addCriterion("SYOUHIN_IMAGE_3 >", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3GreaterThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_3 >=", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3LessThan(String value) {
            addCriterion("SYOUHIN_IMAGE_3 <", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3LessThanOrEqualTo(String value) {
            addCriterion("SYOUHIN_IMAGE_3 <=", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3Like(String value) {
            addCriterion("SYOUHIN_IMAGE_3 like", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3NotLike(String value) {
            addCriterion("SYOUHIN_IMAGE_3 not like", value, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3In(List<String> values) {
            addCriterion("SYOUHIN_IMAGE_3 in", values, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3NotIn(List<String> values) {
            addCriterion("SYOUHIN_IMAGE_3 not in", values, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3Between(String value1, String value2) {
            addCriterion("SYOUHIN_IMAGE_3 between", value1, value2, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andSyouhinImage3NotBetween(String value1, String value2) {
            addCriterion("SYOUHIN_IMAGE_3 not between", value1, value2, "syouhinImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage1IsNull() {
            addCriterion("MINI_IMAGE_1 is null");
            return (Criteria) this;
        }

        public Criteria andMiniImage1IsNotNull() {
            addCriterion("MINI_IMAGE_1 is not null");
            return (Criteria) this;
        }

        public Criteria andMiniImage1EqualTo(String value) {
            addCriterion("MINI_IMAGE_1 =", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1NotEqualTo(String value) {
            addCriterion("MINI_IMAGE_1 <>", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1GreaterThan(String value) {
            addCriterion("MINI_IMAGE_1 >", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1GreaterThanOrEqualTo(String value) {
            addCriterion("MINI_IMAGE_1 >=", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1LessThan(String value) {
            addCriterion("MINI_IMAGE_1 <", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1LessThanOrEqualTo(String value) {
            addCriterion("MINI_IMAGE_1 <=", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1Like(String value) {
            addCriterion("MINI_IMAGE_1 like", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1NotLike(String value) {
            addCriterion("MINI_IMAGE_1 not like", value, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1In(List<String> values) {
            addCriterion("MINI_IMAGE_1 in", values, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1NotIn(List<String> values) {
            addCriterion("MINI_IMAGE_1 not in", values, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1Between(String value1, String value2) {
            addCriterion("MINI_IMAGE_1 between", value1, value2, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage1NotBetween(String value1, String value2) {
            addCriterion("MINI_IMAGE_1 not between", value1, value2, "miniImage1");
            return (Criteria) this;
        }

        public Criteria andMiniImage2IsNull() {
            addCriterion("MINI_IMAGE_2 is null");
            return (Criteria) this;
        }

        public Criteria andMiniImage2IsNotNull() {
            addCriterion("MINI_IMAGE_2 is not null");
            return (Criteria) this;
        }

        public Criteria andMiniImage2EqualTo(String value) {
            addCriterion("MINI_IMAGE_2 =", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2NotEqualTo(String value) {
            addCriterion("MINI_IMAGE_2 <>", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2GreaterThan(String value) {
            addCriterion("MINI_IMAGE_2 >", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2GreaterThanOrEqualTo(String value) {
            addCriterion("MINI_IMAGE_2 >=", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2LessThan(String value) {
            addCriterion("MINI_IMAGE_2 <", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2LessThanOrEqualTo(String value) {
            addCriterion("MINI_IMAGE_2 <=", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2Like(String value) {
            addCriterion("MINI_IMAGE_2 like", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2NotLike(String value) {
            addCriterion("MINI_IMAGE_2 not like", value, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2In(List<String> values) {
            addCriterion("MINI_IMAGE_2 in", values, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2NotIn(List<String> values) {
            addCriterion("MINI_IMAGE_2 not in", values, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2Between(String value1, String value2) {
            addCriterion("MINI_IMAGE_2 between", value1, value2, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage2NotBetween(String value1, String value2) {
            addCriterion("MINI_IMAGE_2 not between", value1, value2, "miniImage2");
            return (Criteria) this;
        }

        public Criteria andMiniImage3IsNull() {
            addCriterion("MINI_IMAGE_3 is null");
            return (Criteria) this;
        }

        public Criteria andMiniImage3IsNotNull() {
            addCriterion("MINI_IMAGE_3 is not null");
            return (Criteria) this;
        }

        public Criteria andMiniImage3EqualTo(String value) {
            addCriterion("MINI_IMAGE_3 =", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3NotEqualTo(String value) {
            addCriterion("MINI_IMAGE_3 <>", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3GreaterThan(String value) {
            addCriterion("MINI_IMAGE_3 >", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3GreaterThanOrEqualTo(String value) {
            addCriterion("MINI_IMAGE_3 >=", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3LessThan(String value) {
            addCriterion("MINI_IMAGE_3 <", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3LessThanOrEqualTo(String value) {
            addCriterion("MINI_IMAGE_3 <=", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3Like(String value) {
            addCriterion("MINI_IMAGE_3 like", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3NotLike(String value) {
            addCriterion("MINI_IMAGE_3 not like", value, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3In(List<String> values) {
            addCriterion("MINI_IMAGE_3 in", values, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3NotIn(List<String> values) {
            addCriterion("MINI_IMAGE_3 not in", values, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3Between(String value1, String value2) {
            addCriterion("MINI_IMAGE_3 between", value1, value2, "miniImage3");
            return (Criteria) this;
        }

        public Criteria andMiniImage3NotBetween(String value1, String value2) {
            addCriterion("MINI_IMAGE_3 not between", value1, value2, "miniImage3");
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

        public Criteria andTodokeBiSiteiFukaFlgIsNull() {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG is null");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgIsNotNull() {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG is not null");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgEqualTo(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG =", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgNotEqualTo(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG <>", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgGreaterThan(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG >", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgGreaterThanOrEqualTo(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG >=", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgLessThan(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG <", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgLessThanOrEqualTo(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG <=", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgLike(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG like", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgNotLike(String value) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG not like", value, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgIn(List<String> values) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG in", values, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgNotIn(List<String> values) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG not in", values, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgBetween(String value1, String value2) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG between", value1, value2, "todokeBiSiteiFukaFlg");
            return (Criteria) this;
        }

        public Criteria andTodokeBiSiteiFukaFlgNotBetween(String value1, String value2) {
            addCriterion("TODOKE_BI_SITEI_FUKA_FLG not between", value1, value2, "todokeBiSiteiFukaFlg");
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