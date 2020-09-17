package com.ly.show.model;

import java.util.ArrayList;
import java.util.List;

public class LiteratureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LiteratureExample() {
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

        public Criteria andIndexIsNull() {
            addCriterion("Index is null");
            return (Criteria) this;
        }

        public Criteria andIndexIsNotNull() {
            addCriterion("Index is not null");
            return (Criteria) this;
        }

        public Criteria andIndexEqualTo(Integer value) {
            addCriterion("Index =", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotEqualTo(Integer value) {
            addCriterion("Index <>", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThan(Integer value) {
            addCriterion("Index >", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("Index >=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThan(Integer value) {
            addCriterion("Index <", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThanOrEqualTo(Integer value) {
            addCriterion("Index <=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexIn(List<Integer> values) {
            addCriterion("Index in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotIn(List<Integer> values) {
            addCriterion("Index not in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexBetween(Integer value1, Integer value2) {
            addCriterion("Index between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("Index not between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andPmidIsNull() {
            addCriterion("PMID is null");
            return (Criteria) this;
        }

        public Criteria andPmidIsNotNull() {
            addCriterion("PMID is not null");
            return (Criteria) this;
        }

        public Criteria andPmidEqualTo(String value) {
            addCriterion("PMID =", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotEqualTo(String value) {
            addCriterion("PMID <>", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidGreaterThan(String value) {
            addCriterion("PMID >", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidGreaterThanOrEqualTo(String value) {
            addCriterion("PMID >=", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidLessThan(String value) {
            addCriterion("PMID <", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidLessThanOrEqualTo(String value) {
            addCriterion("PMID <=", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidLike(String value) {
            addCriterion("PMID like", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotLike(String value) {
            addCriterion("PMID not like", value, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidIn(List<String> values) {
            addCriterion("PMID in", values, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotIn(List<String> values) {
            addCriterion("PMID not in", values, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidBetween(String value1, String value2) {
            addCriterion("PMID between", value1, value2, "pmid");
            return (Criteria) this;
        }

        public Criteria andPmidNotBetween(String value1, String value2) {
            addCriterion("PMID not between", value1, value2, "pmid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("Title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("Year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("Year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("Year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("Year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("Year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("Year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("Year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("Year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("Year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("Year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("Year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("Year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("Year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("Year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andJournaltitleIsNull() {
            addCriterion("JournalTitle is null");
            return (Criteria) this;
        }

        public Criteria andJournaltitleIsNotNull() {
            addCriterion("JournalTitle is not null");
            return (Criteria) this;
        }

        public Criteria andJournaltitleEqualTo(String value) {
            addCriterion("JournalTitle =", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleNotEqualTo(String value) {
            addCriterion("JournalTitle <>", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleGreaterThan(String value) {
            addCriterion("JournalTitle >", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleGreaterThanOrEqualTo(String value) {
            addCriterion("JournalTitle >=", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleLessThan(String value) {
            addCriterion("JournalTitle <", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleLessThanOrEqualTo(String value) {
            addCriterion("JournalTitle <=", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleLike(String value) {
            addCriterion("JournalTitle like", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleNotLike(String value) {
            addCriterion("JournalTitle not like", value, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleIn(List<String> values) {
            addCriterion("JournalTitle in", values, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleNotIn(List<String> values) {
            addCriterion("JournalTitle not in", values, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleBetween(String value1, String value2) {
            addCriterion("JournalTitle between", value1, value2, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andJournaltitleNotBetween(String value1, String value2) {
            addCriterion("JournalTitle not between", value1, value2, "journaltitle");
            return (Criteria) this;
        }

        public Criteria andAuthorsIsNull() {
            addCriterion("Authors is null");
            return (Criteria) this;
        }

        public Criteria andAuthorsIsNotNull() {
            addCriterion("Authors is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorsEqualTo(String value) {
            addCriterion("Authors =", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsNotEqualTo(String value) {
            addCriterion("Authors <>", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsGreaterThan(String value) {
            addCriterion("Authors >", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsGreaterThanOrEqualTo(String value) {
            addCriterion("Authors >=", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsLessThan(String value) {
            addCriterion("Authors <", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsLessThanOrEqualTo(String value) {
            addCriterion("Authors <=", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsLike(String value) {
            addCriterion("Authors like", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsNotLike(String value) {
            addCriterion("Authors not like", value, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsIn(List<String> values) {
            addCriterion("Authors in", values, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsNotIn(List<String> values) {
            addCriterion("Authors not in", values, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsBetween(String value1, String value2) {
            addCriterion("Authors between", value1, value2, "authors");
            return (Criteria) this;
        }

        public Criteria andAuthorsNotBetween(String value1, String value2) {
            addCriterion("Authors not between", value1, value2, "authors");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIsNull() {
            addCriterion("SearchType is null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIsNotNull() {
            addCriterion("SearchType is not null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeEqualTo(String value) {
            addCriterion("SearchType =", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotEqualTo(String value) {
            addCriterion("SearchType <>", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThan(String value) {
            addCriterion("SearchType >", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThanOrEqualTo(String value) {
            addCriterion("SearchType >=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThan(String value) {
            addCriterion("SearchType <", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThanOrEqualTo(String value) {
            addCriterion("SearchType <=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLike(String value) {
            addCriterion("SearchType like", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotLike(String value) {
            addCriterion("SearchType not like", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIn(List<String> values) {
            addCriterion("SearchType in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotIn(List<String> values) {
            addCriterion("SearchType not in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeBetween(String value1, String value2) {
            addCriterion("SearchType between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotBetween(String value1, String value2) {
            addCriterion("SearchType not between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andConditionIsNull() {
            addCriterion("Condition is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull() {
            addCriterion("Condition is not null");
            return (Criteria) this;
        }

        public Criteria andConditionEqualTo(String value) {
            addCriterion("Condition =", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotEqualTo(String value) {
            addCriterion("Condition <>", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThan(String value) {
            addCriterion("Condition >", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThanOrEqualTo(String value) {
            addCriterion("Condition >=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThan(String value) {
            addCriterion("Condition <", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThanOrEqualTo(String value) {
            addCriterion("Condition <=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLike(String value) {
            addCriterion("Condition like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotLike(String value) {
            addCriterion("Condition not like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionIn(List<String> values) {
            addCriterion("Condition in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotIn(List<String> values) {
            addCriterion("Condition not in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionBetween(String value1, String value2) {
            addCriterion("Condition between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotBetween(String value1, String value2) {
            addCriterion("Condition not between", value1, value2, "condition");
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