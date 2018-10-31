package org.sqlcomposer;

public class SqlExpression {
    protected StringBuilder queryBuilder;

    public SqlExpression(){
        queryBuilder = new StringBuilder();
    }

    public SqlExpression(StringBuilder sb){
        queryBuilder = sb;
    }

    public String toString(){
        String s = queryBuilder.append(";").toString();
        queryBuilder.deleteCharAt(queryBuilder.length() - 1);
        return s;
    }

    public SqlExpression where(String condition){
        queryBuilder.append(" WHERE ")
                    .append(condition);
        return this;
    }

	public GroupedExpression group(String string) {
        queryBuilder.append(" GROUP BY ")
                    .append(string);
        return new GroupedExpression(queryBuilder);
    }
}