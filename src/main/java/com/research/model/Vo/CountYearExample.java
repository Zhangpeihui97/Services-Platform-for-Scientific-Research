package com.research.model.Vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CountYearExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CountYearExample() {
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

        public Criteria andPnumyIsNull() {
            addCriterion("pNumy is null");
            return (Criteria) this;
        }

        public Criteria andPnumyIsNotNull() {
            addCriterion("pNumy is not null");
            return (Criteria) this;
        }

        public Criteria andPnumyEqualTo(Long value) {
            addCriterion("pNumy =", value, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyNotEqualTo(Long value) {
            addCriterion("pNumy <>", value, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyGreaterThan(Long value) {
            addCriterion("pNumy >", value, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyGreaterThanOrEqualTo(Long value) {
            addCriterion("pNumy >=", value, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyLessThan(Long value) {
            addCriterion("pNumy <", value, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyLessThanOrEqualTo(Long value) {
            addCriterion("pNumy <=", value, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyIn(List<Long> values) {
            addCriterion("pNumy in", values, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyNotIn(List<Long> values) {
            addCriterion("pNumy not in", values, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyBetween(Long value1, Long value2) {
            addCriterion("pNumy between", value1, value2, "pnumy");
            return (Criteria) this;
        }

        public Criteria andPnumyNotBetween(Long value1, Long value2) {
            addCriterion("pNumy not between", value1, value2, "pnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyIsNull() {
            addCriterion("omNumy is null");
            return (Criteria) this;
        }

        public Criteria andOmnumyIsNotNull() {
            addCriterion("omNumy is not null");
            return (Criteria) this;
        }

        public Criteria andOmnumyEqualTo(BigDecimal value) {
            addCriterion("omNumy =", value, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyNotEqualTo(BigDecimal value) {
            addCriterion("omNumy <>", value, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyGreaterThan(BigDecimal value) {
            addCriterion("omNumy >", value, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("omNumy >=", value, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyLessThan(BigDecimal value) {
            addCriterion("omNumy <", value, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("omNumy <=", value, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyIn(List<BigDecimal> values) {
            addCriterion("omNumy in", values, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyNotIn(List<BigDecimal> values) {
            addCriterion("omNumy not in", values, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("omNumy between", value1, value2, "omnumy");
            return (Criteria) this;
        }

        public Criteria andOmnumyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("omNumy not between", value1, value2, "omnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyIsNull() {
            addCriterion("cNumy is null");
            return (Criteria) this;
        }

        public Criteria andCnumyIsNotNull() {
            addCriterion("cNumy is not null");
            return (Criteria) this;
        }

        public Criteria andCnumyEqualTo(Long value) {
            addCriterion("cNumy =", value, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyNotEqualTo(Long value) {
            addCriterion("cNumy <>", value, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyGreaterThan(Long value) {
            addCriterion("cNumy >", value, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyGreaterThanOrEqualTo(Long value) {
            addCriterion("cNumy >=", value, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyLessThan(Long value) {
            addCriterion("cNumy <", value, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyLessThanOrEqualTo(Long value) {
            addCriterion("cNumy <=", value, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyIn(List<Long> values) {
            addCriterion("cNumy in", values, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyNotIn(List<Long> values) {
            addCriterion("cNumy not in", values, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyBetween(Long value1, Long value2) {
            addCriterion("cNumy between", value1, value2, "cnumy");
            return (Criteria) this;
        }

        public Criteria andCnumyNotBetween(Long value1, Long value2) {
            addCriterion("cNumy not between", value1, value2, "cnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyIsNull() {
            addCriterion("imNumy is null");
            return (Criteria) this;
        }

        public Criteria andImnumyIsNotNull() {
            addCriterion("imNumy is not null");
            return (Criteria) this;
        }

        public Criteria andImnumyEqualTo(BigDecimal value) {
            addCriterion("imNumy =", value, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyNotEqualTo(BigDecimal value) {
            addCriterion("imNumy <>", value, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyGreaterThan(BigDecimal value) {
            addCriterion("imNumy >", value, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("imNumy >=", value, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyLessThan(BigDecimal value) {
            addCriterion("imNumy <", value, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("imNumy <=", value, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyIn(List<BigDecimal> values) {
            addCriterion("imNumy in", values, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyNotIn(List<BigDecimal> values) {
            addCriterion("imNumy not in", values, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("imNumy between", value1, value2, "imnumy");
            return (Criteria) this;
        }

        public Criteria andImnumyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("imNumy not between", value1, value2, "imnumy");
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