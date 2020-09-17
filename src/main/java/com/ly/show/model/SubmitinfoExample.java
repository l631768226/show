package com.ly.show.model;

import java.util.ArrayList;
import java.util.List;

public class SubmitinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubmitinfoExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaIsNull() {
            addCriterion("GutMicrobiota is null");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaIsNotNull() {
            addCriterion("GutMicrobiota is not null");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaEqualTo(String value) {
            addCriterion("GutMicrobiota =", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaNotEqualTo(String value) {
            addCriterion("GutMicrobiota <>", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaGreaterThan(String value) {
            addCriterion("GutMicrobiota >", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaGreaterThanOrEqualTo(String value) {
            addCriterion("GutMicrobiota >=", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaLessThan(String value) {
            addCriterion("GutMicrobiota <", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaLessThanOrEqualTo(String value) {
            addCriterion("GutMicrobiota <=", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaLike(String value) {
            addCriterion("GutMicrobiota like", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaNotLike(String value) {
            addCriterion("GutMicrobiota not like", value, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaIn(List<String> values) {
            addCriterion("GutMicrobiota in", values, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaNotIn(List<String> values) {
            addCriterion("GutMicrobiota not in", values, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaBetween(String value1, String value2) {
            addCriterion("GutMicrobiota between", value1, value2, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaNotBetween(String value1, String value2) {
            addCriterion("GutMicrobiota not between", value1, value2, "gutmicrobiota");
            return (Criteria) this;
        }

        public Criteria andMetaboliteIsNull() {
            addCriterion("Metabolite is null");
            return (Criteria) this;
        }

        public Criteria andMetaboliteIsNotNull() {
            addCriterion("Metabolite is not null");
            return (Criteria) this;
        }

        public Criteria andMetaboliteEqualTo(String value) {
            addCriterion("Metabolite =", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteNotEqualTo(String value) {
            addCriterion("Metabolite <>", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteGreaterThan(String value) {
            addCriterion("Metabolite >", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteGreaterThanOrEqualTo(String value) {
            addCriterion("Metabolite >=", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteLessThan(String value) {
            addCriterion("Metabolite <", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteLessThanOrEqualTo(String value) {
            addCriterion("Metabolite <=", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteLike(String value) {
            addCriterion("Metabolite like", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteNotLike(String value) {
            addCriterion("Metabolite not like", value, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteIn(List<String> values) {
            addCriterion("Metabolite in", values, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteNotIn(List<String> values) {
            addCriterion("Metabolite not in", values, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteBetween(String value1, String value2) {
            addCriterion("Metabolite between", value1, value2, "metabolite");
            return (Criteria) this;
        }

        public Criteria andMetaboliteNotBetween(String value1, String value2) {
            addCriterion("Metabolite not between", value1, value2, "metabolite");
            return (Criteria) this;
        }

        public Criteria andGeneIsNull() {
            addCriterion("Gene is null");
            return (Criteria) this;
        }

        public Criteria andGeneIsNotNull() {
            addCriterion("Gene is not null");
            return (Criteria) this;
        }

        public Criteria andGeneEqualTo(String value) {
            addCriterion("Gene =", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneNotEqualTo(String value) {
            addCriterion("Gene <>", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneGreaterThan(String value) {
            addCriterion("Gene >", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneGreaterThanOrEqualTo(String value) {
            addCriterion("Gene >=", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneLessThan(String value) {
            addCriterion("Gene <", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneLessThanOrEqualTo(String value) {
            addCriterion("Gene <=", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneLike(String value) {
            addCriterion("Gene like", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneNotLike(String value) {
            addCriterion("Gene not like", value, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneIn(List<String> values) {
            addCriterion("Gene in", values, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneNotIn(List<String> values) {
            addCriterion("Gene not in", values, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneBetween(String value1, String value2) {
            addCriterion("Gene between", value1, value2, "gene");
            return (Criteria) this;
        }

        public Criteria andGeneNotBetween(String value1, String value2) {
            addCriterion("Gene not between", value1, value2, "gene");
            return (Criteria) this;
        }

        public Criteria andReferencepmidIsNull() {
            addCriterion("referencePMID is null");
            return (Criteria) this;
        }

        public Criteria andReferencepmidIsNotNull() {
            addCriterion("referencePMID is not null");
            return (Criteria) this;
        }

        public Criteria andReferencepmidEqualTo(String value) {
            addCriterion("referencePMID =", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidNotEqualTo(String value) {
            addCriterion("referencePMID <>", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidGreaterThan(String value) {
            addCriterion("referencePMID >", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidGreaterThanOrEqualTo(String value) {
            addCriterion("referencePMID >=", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidLessThan(String value) {
            addCriterion("referencePMID <", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidLessThanOrEqualTo(String value) {
            addCriterion("referencePMID <=", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidLike(String value) {
            addCriterion("referencePMID like", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidNotLike(String value) {
            addCriterion("referencePMID not like", value, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidIn(List<String> values) {
            addCriterion("referencePMID in", values, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidNotIn(List<String> values) {
            addCriterion("referencePMID not in", values, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidBetween(String value1, String value2) {
            addCriterion("referencePMID between", value1, value2, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andReferencepmidNotBetween(String value1, String value2) {
            addCriterion("referencePMID not between", value1, value2, "referencepmid");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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