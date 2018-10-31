package org.sqlcomposer;

public class JoinableExpression extends SqlExpression{

    public JoinableExpression(StringBuilder sb){
        super(sb);
    }
    public SqlExpression join(SqlSubject joined, String leftColumn, String rightColumn){
        queryBuilder.append(" JOIN ")
                    .append(joined.getName())
                    .append(" ON ")
                    .append(leftColumn)
                    .append(" = ")
                    .append(rightColumn);
        return this;
    }
}