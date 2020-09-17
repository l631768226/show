package com.ly.show.model;

import java.util.ArrayList;
import java.util.List;

public class AssociationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssociationExample() {
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

        public Criteria andGutmicrobiatancbiidIsNull() {
            addCriterion("GutMicrobiataNCBIID is null");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidIsNotNull() {
            addCriterion("GutMicrobiataNCBIID is not null");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidEqualTo(String value) {
            addCriterion("GutMicrobiataNCBIID =", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidNotEqualTo(String value) {
            addCriterion("GutMicrobiataNCBIID <>", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidGreaterThan(String value) {
            addCriterion("GutMicrobiataNCBIID >", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidGreaterThanOrEqualTo(String value) {
            addCriterion("GutMicrobiataNCBIID >=", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidLessThan(String value) {
            addCriterion("GutMicrobiataNCBIID <", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidLessThanOrEqualTo(String value) {
            addCriterion("GutMicrobiataNCBIID <=", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidLike(String value) {
            addCriterion("GutMicrobiataNCBIID like", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidNotLike(String value) {
            addCriterion("GutMicrobiataNCBIID not like", value, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidIn(List<String> values) {
            addCriterion("GutMicrobiataNCBIID in", values, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidNotIn(List<String> values) {
            addCriterion("GutMicrobiataNCBIID not in", values, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidBetween(String value1, String value2) {
            addCriterion("GutMicrobiataNCBIID between", value1, value2, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiatancbiidNotBetween(String value1, String value2) {
            addCriterion("GutMicrobiataNCBIID not between", value1, value2, "gutmicrobiatancbiid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidIsNull() {
            addCriterion("GutMicrobiotaID is null");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidIsNotNull() {
            addCriterion("GutMicrobiotaID is not null");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidEqualTo(String value) {
            addCriterion("GutMicrobiotaID =", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidNotEqualTo(String value) {
            addCriterion("GutMicrobiotaID <>", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidGreaterThan(String value) {
            addCriterion("GutMicrobiotaID >", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidGreaterThanOrEqualTo(String value) {
            addCriterion("GutMicrobiotaID >=", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidLessThan(String value) {
            addCriterion("GutMicrobiotaID <", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidLessThanOrEqualTo(String value) {
            addCriterion("GutMicrobiotaID <=", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidLike(String value) {
            addCriterion("GutMicrobiotaID like", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidNotLike(String value) {
            addCriterion("GutMicrobiotaID not like", value, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidIn(List<String> values) {
            addCriterion("GutMicrobiotaID in", values, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidNotIn(List<String> values) {
            addCriterion("GutMicrobiotaID not in", values, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidBetween(String value1, String value2) {
            addCriterion("GutMicrobiotaID between", value1, value2, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andGutmicrobiotaidNotBetween(String value1, String value2) {
            addCriterion("GutMicrobiotaID not between", value1, value2, "gutmicrobiotaid");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNull() {
            addCriterion("Classification is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNotNull() {
            addCriterion("Classification is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationEqualTo(String value) {
            addCriterion("Classification =", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotEqualTo(String value) {
            addCriterion("Classification <>", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThan(String value) {
            addCriterion("Classification >", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("Classification >=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThan(String value) {
            addCriterion("Classification <", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThanOrEqualTo(String value) {
            addCriterion("Classification <=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLike(String value) {
            addCriterion("Classification like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotLike(String value) {
            addCriterion("Classification not like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationIn(List<String> values) {
            addCriterion("Classification in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotIn(List<String> values) {
            addCriterion("Classification not in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationBetween(String value1, String value2) {
            addCriterion("Classification between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotBetween(String value1, String value2) {
            addCriterion("Classification not between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andStrainIsNull() {
            addCriterion("Strain is null");
            return (Criteria) this;
        }

        public Criteria andStrainIsNotNull() {
            addCriterion("Strain is not null");
            return (Criteria) this;
        }

        public Criteria andStrainEqualTo(String value) {
            addCriterion("Strain =", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainNotEqualTo(String value) {
            addCriterion("Strain <>", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainGreaterThan(String value) {
            addCriterion("Strain >", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainGreaterThanOrEqualTo(String value) {
            addCriterion("Strain >=", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainLessThan(String value) {
            addCriterion("Strain <", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainLessThanOrEqualTo(String value) {
            addCriterion("Strain <=", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainLike(String value) {
            addCriterion("Strain like", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainNotLike(String value) {
            addCriterion("Strain not like", value, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainIn(List<String> values) {
            addCriterion("Strain in", values, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainNotIn(List<String> values) {
            addCriterion("Strain not in", values, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainBetween(String value1, String value2) {
            addCriterion("Strain between", value1, value2, "strain");
            return (Criteria) this;
        }

        public Criteria andStrainNotBetween(String value1, String value2) {
            addCriterion("Strain not between", value1, value2, "strain");
            return (Criteria) this;
        }

        public Criteria andSampletypeIsNull() {
            addCriterion("Sampletype is null");
            return (Criteria) this;
        }

        public Criteria andSampletypeIsNotNull() {
            addCriterion("Sampletype is not null");
            return (Criteria) this;
        }

        public Criteria andSampletypeEqualTo(String value) {
            addCriterion("Sampletype =", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeNotEqualTo(String value) {
            addCriterion("Sampletype <>", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeGreaterThan(String value) {
            addCriterion("Sampletype >", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeGreaterThanOrEqualTo(String value) {
            addCriterion("Sampletype >=", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeLessThan(String value) {
            addCriterion("Sampletype <", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeLessThanOrEqualTo(String value) {
            addCriterion("Sampletype <=", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeLike(String value) {
            addCriterion("Sampletype like", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeNotLike(String value) {
            addCriterion("Sampletype not like", value, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeIn(List<String> values) {
            addCriterion("Sampletype in", values, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeNotIn(List<String> values) {
            addCriterion("Sampletype not in", values, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeBetween(String value1, String value2) {
            addCriterion("Sampletype between", value1, value2, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSampletypeNotBetween(String value1, String value2) {
            addCriterion("Sampletype not between", value1, value2, "sampletype");
            return (Criteria) this;
        }

        public Criteria andSubstrateIsNull() {
            addCriterion("Substrate is null");
            return (Criteria) this;
        }

        public Criteria andSubstrateIsNotNull() {
            addCriterion("Substrate is not null");
            return (Criteria) this;
        }

        public Criteria andSubstrateEqualTo(String value) {
            addCriterion("Substrate =", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateNotEqualTo(String value) {
            addCriterion("Substrate <>", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateGreaterThan(String value) {
            addCriterion("Substrate >", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateGreaterThanOrEqualTo(String value) {
            addCriterion("Substrate >=", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateLessThan(String value) {
            addCriterion("Substrate <", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateLessThanOrEqualTo(String value) {
            addCriterion("Substrate <=", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateLike(String value) {
            addCriterion("Substrate like", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateNotLike(String value) {
            addCriterion("Substrate not like", value, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateIn(List<String> values) {
            addCriterion("Substrate in", values, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateNotIn(List<String> values) {
            addCriterion("Substrate not in", values, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateBetween(String value1, String value2) {
            addCriterion("Substrate between", value1, value2, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstrateNotBetween(String value1, String value2) {
            addCriterion("Substrate not between", value1, value2, "substrate");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidIsNull() {
            addCriterion("SubstratePubChemCID is null");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidIsNotNull() {
            addCriterion("SubstratePubChemCID is not null");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidEqualTo(String value) {
            addCriterion("SubstratePubChemCID =", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidNotEqualTo(String value) {
            addCriterion("SubstratePubChemCID <>", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidGreaterThan(String value) {
            addCriterion("SubstratePubChemCID >", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidGreaterThanOrEqualTo(String value) {
            addCriterion("SubstratePubChemCID >=", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidLessThan(String value) {
            addCriterion("SubstratePubChemCID <", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidLessThanOrEqualTo(String value) {
            addCriterion("SubstratePubChemCID <=", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidLike(String value) {
            addCriterion("SubstratePubChemCID like", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidNotLike(String value) {
            addCriterion("SubstratePubChemCID not like", value, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidIn(List<String> values) {
            addCriterion("SubstratePubChemCID in", values, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidNotIn(List<String> values) {
            addCriterion("SubstratePubChemCID not in", values, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidBetween(String value1, String value2) {
            addCriterion("SubstratePubChemCID between", value1, value2, "substratepubchemcid");
            return (Criteria) this;
        }

        public Criteria andSubstratepubchemcidNotBetween(String value1, String value2) {
            addCriterion("SubstratePubChemCID not between", value1, value2, "substratepubchemcid");
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

        public Criteria andMetabolitepubchemcidIsNull() {
            addCriterion("MetabolitePubChemCID is null");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidIsNotNull() {
            addCriterion("MetabolitePubChemCID is not null");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidEqualTo(String value) {
            addCriterion("MetabolitePubChemCID =", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidNotEqualTo(String value) {
            addCriterion("MetabolitePubChemCID <>", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidGreaterThan(String value) {
            addCriterion("MetabolitePubChemCID >", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidGreaterThanOrEqualTo(String value) {
            addCriterion("MetabolitePubChemCID >=", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidLessThan(String value) {
            addCriterion("MetabolitePubChemCID <", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidLessThanOrEqualTo(String value) {
            addCriterion("MetabolitePubChemCID <=", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidLike(String value) {
            addCriterion("MetabolitePubChemCID like", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidNotLike(String value) {
            addCriterion("MetabolitePubChemCID not like", value, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidIn(List<String> values) {
            addCriterion("MetabolitePubChemCID in", values, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidNotIn(List<String> values) {
            addCriterion("MetabolitePubChemCID not in", values, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidBetween(String value1, String value2) {
            addCriterion("MetabolitePubChemCID between", value1, value2, "metabolitepubchemcid");
            return (Criteria) this;
        }

        public Criteria andMetabolitepubchemcidNotBetween(String value1, String value2) {
            addCriterion("MetabolitePubChemCID not between", value1, value2, "metabolitepubchemcid");
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

        public Criteria andGeneidIsNull() {
            addCriterion("GeneID is null");
            return (Criteria) this;
        }

        public Criteria andGeneidIsNotNull() {
            addCriterion("GeneID is not null");
            return (Criteria) this;
        }

        public Criteria andGeneidEqualTo(String value) {
            addCriterion("GeneID =", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidNotEqualTo(String value) {
            addCriterion("GeneID <>", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidGreaterThan(String value) {
            addCriterion("GeneID >", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidGreaterThanOrEqualTo(String value) {
            addCriterion("GeneID >=", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidLessThan(String value) {
            addCriterion("GeneID <", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidLessThanOrEqualTo(String value) {
            addCriterion("GeneID <=", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidLike(String value) {
            addCriterion("GeneID like", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidNotLike(String value) {
            addCriterion("GeneID not like", value, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidIn(List<String> values) {
            addCriterion("GeneID in", values, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidNotIn(List<String> values) {
            addCriterion("GeneID not in", values, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidBetween(String value1, String value2) {
            addCriterion("GeneID between", value1, value2, "geneid");
            return (Criteria) this;
        }

        public Criteria andGeneidNotBetween(String value1, String value2) {
            addCriterion("GeneID not between", value1, value2, "geneid");
            return (Criteria) this;
        }

        public Criteria andAlterationIsNull() {
            addCriterion("Alteration is null");
            return (Criteria) this;
        }

        public Criteria andAlterationIsNotNull() {
            addCriterion("Alteration is not null");
            return (Criteria) this;
        }

        public Criteria andAlterationEqualTo(String value) {
            addCriterion("Alteration =", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationNotEqualTo(String value) {
            addCriterion("Alteration <>", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationGreaterThan(String value) {
            addCriterion("Alteration >", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationGreaterThanOrEqualTo(String value) {
            addCriterion("Alteration >=", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationLessThan(String value) {
            addCriterion("Alteration <", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationLessThanOrEqualTo(String value) {
            addCriterion("Alteration <=", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationLike(String value) {
            addCriterion("Alteration like", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationNotLike(String value) {
            addCriterion("Alteration not like", value, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationIn(List<String> values) {
            addCriterion("Alteration in", values, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationNotIn(List<String> values) {
            addCriterion("Alteration not in", values, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationBetween(String value1, String value2) {
            addCriterion("Alteration between", value1, value2, "alteration");
            return (Criteria) this;
        }

        public Criteria andAlterationNotBetween(String value1, String value2) {
            addCriterion("Alteration not between", value1, value2, "alteration");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("Description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("Description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("Description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("Description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("Description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("Description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("Description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("Description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("Description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("Description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("Description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("Description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("Description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andHumanMouseIsNull() {
            addCriterion("human/mouse is null");
            return (Criteria) this;
        }

        public Criteria andHumanMouseIsNotNull() {
            addCriterion("human/mouse is not null");
            return (Criteria) this;
        }

        public Criteria andHumanMouseEqualTo(String value) {
            addCriterion("human/mouse =", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseNotEqualTo(String value) {
            addCriterion("human/mouse <>", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseGreaterThan(String value) {
            addCriterion("human/mouse >", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseGreaterThanOrEqualTo(String value) {
            addCriterion("human/mouse >=", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseLessThan(String value) {
            addCriterion("human/mouse <", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseLessThanOrEqualTo(String value) {
            addCriterion("human/mouse <=", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseLike(String value) {
            addCriterion("human/mouse like", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseNotLike(String value) {
            addCriterion("human/mouse not like", value, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseIn(List<String> values) {
            addCriterion("human/mouse in", values, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseNotIn(List<String> values) {
            addCriterion("human/mouse not in", values, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseBetween(String value1, String value2) {
            addCriterion("human/mouse between", value1, value2, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andHumanMouseNotBetween(String value1, String value2) {
            addCriterion("human/mouse not between", value1, value2, "humanMouse");
            return (Criteria) this;
        }

        public Criteria andExperimentIsNull() {
            addCriterion("Experiment is null");
            return (Criteria) this;
        }

        public Criteria andExperimentIsNotNull() {
            addCriterion("Experiment is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentEqualTo(String value) {
            addCriterion("Experiment =", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotEqualTo(String value) {
            addCriterion("Experiment <>", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentGreaterThan(String value) {
            addCriterion("Experiment >", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentGreaterThanOrEqualTo(String value) {
            addCriterion("Experiment >=", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentLessThan(String value) {
            addCriterion("Experiment <", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentLessThanOrEqualTo(String value) {
            addCriterion("Experiment <=", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentLike(String value) {
            addCriterion("Experiment like", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotLike(String value) {
            addCriterion("Experiment not like", value, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentIn(List<String> values) {
            addCriterion("Experiment in", values, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotIn(List<String> values) {
            addCriterion("Experiment not in", values, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentBetween(String value1, String value2) {
            addCriterion("Experiment between", value1, value2, "experiment");
            return (Criteria) this;
        }

        public Criteria andExperimentNotBetween(String value1, String value2) {
            addCriterion("Experiment not between", value1, value2, "experiment");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNull() {
            addCriterion("Platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("Platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(String value) {
            addCriterion("Platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(String value) {
            addCriterion("Platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(String value) {
            addCriterion("Platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("Platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(String value) {
            addCriterion("Platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(String value) {
            addCriterion("Platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLike(String value) {
            addCriterion("Platform like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotLike(String value) {
            addCriterion("Platform not like", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<String> values) {
            addCriterion("Platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<String> values) {
            addCriterion("Platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(String value1, String value2) {
            addCriterion("Platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(String value1, String value2) {
            addCriterion("Platform not between", value1, value2, "platform");
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