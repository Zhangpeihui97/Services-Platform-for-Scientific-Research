package com.research.model.Vo;

import java.util.ArrayList;
import java.util.List;

public class PstateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PstateExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Short value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Short value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Short value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Short value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Short value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Short value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Short> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Short> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Short value1, Short value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Short value1, Short value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStateChIsNull() {
            addCriterion("state_ch is null");
            return (Criteria) this;
        }

        public Criteria andStateChIsNotNull() {
            addCriterion("state_ch is not null");
            return (Criteria) this;
        }

        public Criteria andStateChEqualTo(String value) {
            addCriterion("state_ch =", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChNotEqualTo(String value) {
            addCriterion("state_ch <>", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChGreaterThan(String value) {
            addCriterion("state_ch >", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChGreaterThanOrEqualTo(String value) {
            addCriterion("state_ch >=", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChLessThan(String value) {
            addCriterion("state_ch <", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChLessThanOrEqualTo(String value) {
            addCriterion("state_ch <=", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChLike(String value) {
            addCriterion("state_ch like", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChNotLike(String value) {
            addCriterion("state_ch not like", value, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChIn(List<String> values) {
            addCriterion("state_ch in", values, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChNotIn(List<String> values) {
            addCriterion("state_ch not in", values, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChBetween(String value1, String value2) {
            addCriterion("state_ch between", value1, value2, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateChNotBetween(String value1, String value2) {
            addCriterion("state_ch not between", value1, value2, "stateCh");
            return (Criteria) this;
        }

        public Criteria andStateEnIsNull() {
            addCriterion("state_en is null");
            return (Criteria) this;
        }

        public Criteria andStateEnIsNotNull() {
            addCriterion("state_en is not null");
            return (Criteria) this;
        }

        public Criteria andStateEnEqualTo(String value) {
            addCriterion("state_en =", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnNotEqualTo(String value) {
            addCriterion("state_en <>", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnGreaterThan(String value) {
            addCriterion("state_en >", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnGreaterThanOrEqualTo(String value) {
            addCriterion("state_en >=", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnLessThan(String value) {
            addCriterion("state_en <", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnLessThanOrEqualTo(String value) {
            addCriterion("state_en <=", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnLike(String value) {
            addCriterion("state_en like", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnNotLike(String value) {
            addCriterion("state_en not like", value, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnIn(List<String> values) {
            addCriterion("state_en in", values, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnNotIn(List<String> values) {
            addCriterion("state_en not in", values, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnBetween(String value1, String value2) {
            addCriterion("state_en between", value1, value2, "stateEn");
            return (Criteria) this;
        }

        public Criteria andStateEnNotBetween(String value1, String value2) {
            addCriterion("state_en not between", value1, value2, "stateEn");
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