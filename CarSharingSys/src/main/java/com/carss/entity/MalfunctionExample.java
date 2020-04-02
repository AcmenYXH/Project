package com.carss.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MalfunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MalfunctionExample() {
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

        public Criteria andMalidIsNull() {
            addCriterion("MALID is null");
            return (Criteria) this;
        }

        public Criteria andMalidIsNotNull() {
            addCriterion("MALID is not null");
            return (Criteria) this;
        }

        public Criteria andMalidEqualTo(Integer value) {
            addCriterion("MALID =", value, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidNotEqualTo(Integer value) {
            addCriterion("MALID <>", value, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidGreaterThan(Integer value) {
            addCriterion("MALID >", value, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MALID >=", value, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidLessThan(Integer value) {
            addCriterion("MALID <", value, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidLessThanOrEqualTo(Integer value) {
            addCriterion("MALID <=", value, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidIn(List<Integer> values) {
            addCriterion("MALID in", values, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidNotIn(List<Integer> values) {
            addCriterion("MALID not in", values, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidBetween(Integer value1, Integer value2) {
            addCriterion("MALID between", value1, value2, "malid");
            return (Criteria) this;
        }

        public Criteria andMalidNotBetween(Integer value1, Integer value2) {
            addCriterion("MALID not between", value1, value2, "malid");
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

        public Criteria andDescribeIsNull() {
            addCriterion("DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("DESCRIBE =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("DESCRIBE <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("DESCRIBE >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIBE >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("DESCRIBE <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("DESCRIBE <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("DESCRIBE like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("DESCRIBE not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("DESCRIBE in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("DESCRIBE not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("DESCRIBE between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("DESCRIBE not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andReporttimeIsNull() {
            addCriterion("REPORTTIME is null");
            return (Criteria) this;
        }

        public Criteria andReporttimeIsNotNull() {
            addCriterion("REPORTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andReporttimeEqualTo(Date value) {
            addCriterion("REPORTTIME =", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotEqualTo(Date value) {
            addCriterion("REPORTTIME <>", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeGreaterThan(Date value) {
            addCriterion("REPORTTIME >", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REPORTTIME >=", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeLessThan(Date value) {
            addCriterion("REPORTTIME <", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeLessThanOrEqualTo(Date value) {
            addCriterion("REPORTTIME <=", value, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeIn(List<Date> values) {
            addCriterion("REPORTTIME in", values, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotIn(List<Date> values) {
            addCriterion("REPORTTIME not in", values, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeBetween(Date value1, Date value2) {
            addCriterion("REPORTTIME between", value1, value2, "reporttime");
            return (Criteria) this;
        }

        public Criteria andReporttimeNotBetween(Date value1, Date value2) {
            addCriterion("REPORTTIME not between", value1, value2, "reporttime");
            return (Criteria) this;
        }

        public Criteria andRepairstatusIsNull() {
            addCriterion("REPAIRSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andRepairstatusIsNotNull() {
            addCriterion("REPAIRSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRepairstatusEqualTo(String value) {
            addCriterion("REPAIRSTATUS =", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusNotEqualTo(String value) {
            addCriterion("REPAIRSTATUS <>", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusGreaterThan(String value) {
            addCriterion("REPAIRSTATUS >", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusGreaterThanOrEqualTo(String value) {
            addCriterion("REPAIRSTATUS >=", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusLessThan(String value) {
            addCriterion("REPAIRSTATUS <", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusLessThanOrEqualTo(String value) {
            addCriterion("REPAIRSTATUS <=", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusLike(String value) {
            addCriterion("REPAIRSTATUS like", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusNotLike(String value) {
            addCriterion("REPAIRSTATUS not like", value, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusIn(List<String> values) {
            addCriterion("REPAIRSTATUS in", values, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusNotIn(List<String> values) {
            addCriterion("REPAIRSTATUS not in", values, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusBetween(String value1, String value2) {
            addCriterion("REPAIRSTATUS between", value1, value2, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andRepairstatusNotBetween(String value1, String value2) {
            addCriterion("REPAIRSTATUS not between", value1, value2, "repairstatus");
            return (Criteria) this;
        }

        public Criteria andProcesstimeIsNull() {
            addCriterion("PROCESSTIME is null");
            return (Criteria) this;
        }

        public Criteria andProcesstimeIsNotNull() {
            addCriterion("PROCESSTIME is not null");
            return (Criteria) this;
        }

        public Criteria andProcesstimeEqualTo(Date value) {
            addCriterion("PROCESSTIME =", value, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeNotEqualTo(Date value) {
            addCriterion("PROCESSTIME <>", value, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeGreaterThan(Date value) {
            addCriterion("PROCESSTIME >", value, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PROCESSTIME >=", value, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeLessThan(Date value) {
            addCriterion("PROCESSTIME <", value, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeLessThanOrEqualTo(Date value) {
            addCriterion("PROCESSTIME <=", value, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeIn(List<Date> values) {
            addCriterion("PROCESSTIME in", values, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeNotIn(List<Date> values) {
            addCriterion("PROCESSTIME not in", values, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeBetween(Date value1, Date value2) {
            addCriterion("PROCESSTIME between", value1, value2, "processtime");
            return (Criteria) this;
        }

        public Criteria andProcesstimeNotBetween(Date value1, Date value2) {
            addCriterion("PROCESSTIME not between", value1, value2, "processtime");
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