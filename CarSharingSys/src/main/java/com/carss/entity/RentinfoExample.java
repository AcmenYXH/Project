package com.carss.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentinfoExample() {
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

        public Criteria andRentidIsNull() {
            addCriterion("RENTID is null");
            return (Criteria) this;
        }

        public Criteria andRentidIsNotNull() {
            addCriterion("RENTID is not null");
            return (Criteria) this;
        }

        public Criteria andRentidEqualTo(Integer value) {
            addCriterion("RENTID =", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidNotEqualTo(Integer value) {
            addCriterion("RENTID <>", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidGreaterThan(Integer value) {
            addCriterion("RENTID >", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RENTID >=", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidLessThan(Integer value) {
            addCriterion("RENTID <", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidLessThanOrEqualTo(Integer value) {
            addCriterion("RENTID <=", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidIn(List<Integer> values) {
            addCriterion("RENTID in", values, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidNotIn(List<Integer> values) {
            addCriterion("RENTID not in", values, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidBetween(Integer value1, Integer value2) {
            addCriterion("RENTID between", value1, value2, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidNotBetween(Integer value1, Integer value2) {
            addCriterion("RENTID not between", value1, value2, "rentid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCaridIsNull() {
            addCriterion("CARID is null");
            return (Criteria) this;
        }

        public Criteria andCaridIsNotNull() {
            addCriterion("CARID is not null");
            return (Criteria) this;
        }

        public Criteria andCaridEqualTo(Integer value) {
            addCriterion("CARID =", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridNotEqualTo(Integer value) {
            addCriterion("CARID <>", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridGreaterThan(Integer value) {
            addCriterion("CARID >", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridGreaterThanOrEqualTo(Integer value) {
            addCriterion("CARID >=", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridLessThan(Integer value) {
            addCriterion("CARID <", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridLessThanOrEqualTo(Integer value) {
            addCriterion("CARID <=", value, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridIn(List<Integer> values) {
            addCriterion("CARID in", values, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridNotIn(List<Integer> values) {
            addCriterion("CARID not in", values, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridBetween(Integer value1, Integer value2) {
            addCriterion("CARID between", value1, value2, "carid");
            return (Criteria) this;
        }

        public Criteria andCaridNotBetween(Integer value1, Integer value2) {
            addCriterion("CARID not between", value1, value2, "carid");
            return (Criteria) this;
        }

        public Criteria andRentaltimeIsNull() {
            addCriterion("RENTALTIME is null");
            return (Criteria) this;
        }

        public Criteria andRentaltimeIsNotNull() {
            addCriterion("RENTALTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRentaltimeEqualTo(Date value) {
            addCriterion("RENTALTIME =", value, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeNotEqualTo(Date value) {
            addCriterion("RENTALTIME <>", value, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeGreaterThan(Date value) {
            addCriterion("RENTALTIME >", value, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RENTALTIME >=", value, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeLessThan(Date value) {
            addCriterion("RENTALTIME <", value, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeLessThanOrEqualTo(Date value) {
            addCriterion("RENTALTIME <=", value, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeIn(List<Date> values) {
            addCriterion("RENTALTIME in", values, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeNotIn(List<Date> values) {
            addCriterion("RENTALTIME not in", values, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeBetween(Date value1, Date value2) {
            addCriterion("RENTALTIME between", value1, value2, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andRentaltimeNotBetween(Date value1, Date value2) {
            addCriterion("RENTALTIME not between", value1, value2, "rentaltime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNull() {
            addCriterion("RETURNTIME is null");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNotNull() {
            addCriterion("RETURNTIME is not null");
            return (Criteria) this;
        }

        public Criteria andReturntimeEqualTo(Date value) {
            addCriterion("RETURNTIME =", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotEqualTo(Date value) {
            addCriterion("RETURNTIME <>", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThan(Date value) {
            addCriterion("RETURNTIME >", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RETURNTIME >=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThan(Date value) {
            addCriterion("RETURNTIME <", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThanOrEqualTo(Date value) {
            addCriterion("RETURNTIME <=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIn(List<Date> values) {
            addCriterion("RETURNTIME in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotIn(List<Date> values) {
            addCriterion("RETURNTIME not in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeBetween(Date value1, Date value2) {
            addCriterion("RETURNTIME between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotBetween(Date value1, Date value2) {
            addCriterion("RETURNTIME not between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andStartlngIsNull() {
            addCriterion("STARTLNG is null");
            return (Criteria) this;
        }

        public Criteria andStartlngIsNotNull() {
            addCriterion("STARTLNG is not null");
            return (Criteria) this;
        }

        public Criteria andStartlngEqualTo(String value) {
            addCriterion("STARTLNG =", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngNotEqualTo(String value) {
            addCriterion("STARTLNG <>", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngGreaterThan(String value) {
            addCriterion("STARTLNG >", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngGreaterThanOrEqualTo(String value) {
            addCriterion("STARTLNG >=", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngLessThan(String value) {
            addCriterion("STARTLNG <", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngLessThanOrEqualTo(String value) {
            addCriterion("STARTLNG <=", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngLike(String value) {
            addCriterion("STARTLNG like", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngNotLike(String value) {
            addCriterion("STARTLNG not like", value, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngIn(List<String> values) {
            addCriterion("STARTLNG in", values, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngNotIn(List<String> values) {
            addCriterion("STARTLNG not in", values, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngBetween(String value1, String value2) {
            addCriterion("STARTLNG between", value1, value2, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlngNotBetween(String value1, String value2) {
            addCriterion("STARTLNG not between", value1, value2, "startlng");
            return (Criteria) this;
        }

        public Criteria andStartlatIsNull() {
            addCriterion("STARTLAT is null");
            return (Criteria) this;
        }

        public Criteria andStartlatIsNotNull() {
            addCriterion("STARTLAT is not null");
            return (Criteria) this;
        }

        public Criteria andStartlatEqualTo(String value) {
            addCriterion("STARTLAT =", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatNotEqualTo(String value) {
            addCriterion("STARTLAT <>", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatGreaterThan(String value) {
            addCriterion("STARTLAT >", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatGreaterThanOrEqualTo(String value) {
            addCriterion("STARTLAT >=", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatLessThan(String value) {
            addCriterion("STARTLAT <", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatLessThanOrEqualTo(String value) {
            addCriterion("STARTLAT <=", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatLike(String value) {
            addCriterion("STARTLAT like", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatNotLike(String value) {
            addCriterion("STARTLAT not like", value, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatIn(List<String> values) {
            addCriterion("STARTLAT in", values, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatNotIn(List<String> values) {
            addCriterion("STARTLAT not in", values, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatBetween(String value1, String value2) {
            addCriterion("STARTLAT between", value1, value2, "startlat");
            return (Criteria) this;
        }

        public Criteria andStartlatNotBetween(String value1, String value2) {
            addCriterion("STARTLAT not between", value1, value2, "startlat");
            return (Criteria) this;
        }

        public Criteria andEndlngIsNull() {
            addCriterion("ENDLNG is null");
            return (Criteria) this;
        }

        public Criteria andEndlngIsNotNull() {
            addCriterion("ENDLNG is not null");
            return (Criteria) this;
        }

        public Criteria andEndlngEqualTo(String value) {
            addCriterion("ENDLNG =", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngNotEqualTo(String value) {
            addCriterion("ENDLNG <>", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngGreaterThan(String value) {
            addCriterion("ENDLNG >", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngGreaterThanOrEqualTo(String value) {
            addCriterion("ENDLNG >=", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngLessThan(String value) {
            addCriterion("ENDLNG <", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngLessThanOrEqualTo(String value) {
            addCriterion("ENDLNG <=", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngLike(String value) {
            addCriterion("ENDLNG like", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngNotLike(String value) {
            addCriterion("ENDLNG not like", value, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngIn(List<String> values) {
            addCriterion("ENDLNG in", values, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngNotIn(List<String> values) {
            addCriterion("ENDLNG not in", values, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngBetween(String value1, String value2) {
            addCriterion("ENDLNG between", value1, value2, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlngNotBetween(String value1, String value2) {
            addCriterion("ENDLNG not between", value1, value2, "endlng");
            return (Criteria) this;
        }

        public Criteria andEndlatIsNull() {
            addCriterion("ENDLAT is null");
            return (Criteria) this;
        }

        public Criteria andEndlatIsNotNull() {
            addCriterion("ENDLAT is not null");
            return (Criteria) this;
        }

        public Criteria andEndlatEqualTo(String value) {
            addCriterion("ENDLAT =", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatNotEqualTo(String value) {
            addCriterion("ENDLAT <>", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatGreaterThan(String value) {
            addCriterion("ENDLAT >", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatGreaterThanOrEqualTo(String value) {
            addCriterion("ENDLAT >=", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatLessThan(String value) {
            addCriterion("ENDLAT <", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatLessThanOrEqualTo(String value) {
            addCriterion("ENDLAT <=", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatLike(String value) {
            addCriterion("ENDLAT like", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatNotLike(String value) {
            addCriterion("ENDLAT not like", value, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatIn(List<String> values) {
            addCriterion("ENDLAT in", values, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatNotIn(List<String> values) {
            addCriterion("ENDLAT not in", values, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatBetween(String value1, String value2) {
            addCriterion("ENDLAT between", value1, value2, "endlat");
            return (Criteria) this;
        }

        public Criteria andEndlatNotBetween(String value1, String value2) {
            addCriterion("ENDLAT not between", value1, value2, "endlat");
            return (Criteria) this;
        }

        public Criteria andIsplayIsNull() {
            addCriterion("ISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andIsplayIsNotNull() {
            addCriterion("ISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andIsplayEqualTo(String value) {
            addCriterion("ISPLAY =", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayNotEqualTo(String value) {
            addCriterion("ISPLAY <>", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayGreaterThan(String value) {
            addCriterion("ISPLAY >", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayGreaterThanOrEqualTo(String value) {
            addCriterion("ISPLAY >=", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayLessThan(String value) {
            addCriterion("ISPLAY <", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayLessThanOrEqualTo(String value) {
            addCriterion("ISPLAY <=", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayLike(String value) {
            addCriterion("ISPLAY like", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayNotLike(String value) {
            addCriterion("ISPLAY not like", value, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayIn(List<String> values) {
            addCriterion("ISPLAY in", values, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayNotIn(List<String> values) {
            addCriterion("ISPLAY not in", values, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayBetween(String value1, String value2) {
            addCriterion("ISPLAY between", value1, value2, "isplay");
            return (Criteria) this;
        }

        public Criteria andIsplayNotBetween(String value1, String value2) {
            addCriterion("ISPLAY not between", value1, value2, "isplay");
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