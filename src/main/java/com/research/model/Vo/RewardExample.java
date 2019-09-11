package com.research.model.Vo;

import java.util.ArrayList;
import java.util.List;

public class RewardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RewardExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBaseInfoIsNull() {
            addCriterion("base_info is null");
            return (Criteria) this;
        }

        public Criteria andBaseInfoIsNotNull() {
            addCriterion("base_info is not null");
            return (Criteria) this;
        }

        public Criteria andBaseInfoEqualTo(String value) {
            addCriterion("base_info =", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoNotEqualTo(String value) {
            addCriterion("base_info <>", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoGreaterThan(String value) {
            addCriterion("base_info >", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoGreaterThanOrEqualTo(String value) {
            addCriterion("base_info >=", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoLessThan(String value) {
            addCriterion("base_info <", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoLessThanOrEqualTo(String value) {
            addCriterion("base_info <=", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoLike(String value) {
            addCriterion("base_info like", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoNotLike(String value) {
            addCriterion("base_info not like", value, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoIn(List<String> values) {
            addCriterion("base_info in", values, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoNotIn(List<String> values) {
            addCriterion("base_info not in", values, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoBetween(String value1, String value2) {
            addCriterion("base_info between", value1, value2, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseInfoNotBetween(String value1, String value2) {
            addCriterion("base_info not between", value1, value2, "baseInfo");
            return (Criteria) this;
        }

        public Criteria andBaseClassIsNull() {
            addCriterion("base_class is null");
            return (Criteria) this;
        }

        public Criteria andBaseClassIsNotNull() {
            addCriterion("base_class is not null");
            return (Criteria) this;
        }

        public Criteria andBaseClassEqualTo(String value) {
            addCriterion("base_class =", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassNotEqualTo(String value) {
            addCriterion("base_class <>", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassGreaterThan(String value) {
            addCriterion("base_class >", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassGreaterThanOrEqualTo(String value) {
            addCriterion("base_class >=", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassLessThan(String value) {
            addCriterion("base_class <", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassLessThanOrEqualTo(String value) {
            addCriterion("base_class <=", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassLike(String value) {
            addCriterion("base_class like", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassNotLike(String value) {
            addCriterion("base_class not like", value, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassIn(List<String> values) {
            addCriterion("base_class in", values, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassNotIn(List<String> values) {
            addCriterion("base_class not in", values, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassBetween(String value1, String value2) {
            addCriterion("base_class between", value1, value2, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseClassNotBetween(String value1, String value2) {
            addCriterion("base_class not between", value1, value2, "baseClass");
            return (Criteria) this;
        }

        public Criteria andBaseResultIsNull() {
            addCriterion("base_result is null");
            return (Criteria) this;
        }

        public Criteria andBaseResultIsNotNull() {
            addCriterion("base_result is not null");
            return (Criteria) this;
        }

        public Criteria andBaseResultEqualTo(String value) {
            addCriterion("base_result =", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultNotEqualTo(String value) {
            addCriterion("base_result <>", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultGreaterThan(String value) {
            addCriterion("base_result >", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultGreaterThanOrEqualTo(String value) {
            addCriterion("base_result >=", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultLessThan(String value) {
            addCriterion("base_result <", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultLessThanOrEqualTo(String value) {
            addCriterion("base_result <=", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultLike(String value) {
            addCriterion("base_result like", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultNotLike(String value) {
            addCriterion("base_result not like", value, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultIn(List<String> values) {
            addCriterion("base_result in", values, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultNotIn(List<String> values) {
            addCriterion("base_result not in", values, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultBetween(String value1, String value2) {
            addCriterion("base_result between", value1, value2, "baseResult");
            return (Criteria) this;
        }

        public Criteria andBaseResultNotBetween(String value1, String value2) {
            addCriterion("base_result not between", value1, value2, "baseResult");
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