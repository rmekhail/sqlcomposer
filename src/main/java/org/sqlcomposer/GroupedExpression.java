package org.sqlcomposer;

public class GroupedExpression extends SqlExpression {

    public GroupedExpression(StringBuilder sb){
        super(sb);
    }
    public SqlExpression having(String condition){
        queryBuilder.append(" HAVING ").append(condition);
        return this;
    }
}