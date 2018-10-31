package org.sqlcomposer;

import java.util.StringJoiner;

public class SqlSubject {
    StringBuilder queryBuilder = new StringBuilder();

    String name;

    public SqlSubject(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return queryBuilder.toString();
    }

    public SqlExpression select(){
        return select("*");
    }

    public SqlExpression select(String... columns) {
        queryBuilder.append("SELECT ")
                    .append(String.join(", " , columns))
                    .append(" FROM ")
                    .append(name);
        return new SqlExpression(queryBuilder);
    }
	public SqlExpression delete() {
        queryBuilder.append("DELETE FROM ")
                    .append(name);
        return new SqlExpression(queryBuilder);
	}
	public SqlExpression insert(String... values) {
        queryBuilder.append("INSERT INTO ")
                    .append(name)
                    .append(" VALUES (");
        for(int i = 0; i < values.length - 1; i++){
            queryBuilder.append("'")
                        .append(values[i])
                        .append("'")
                        .append(", ");
        }
        queryBuilder.append("'")
                    .append(values[values.length - 1])
                    .append("'")
                    .append(')');
        return new SqlExpression(queryBuilder);
	}
}