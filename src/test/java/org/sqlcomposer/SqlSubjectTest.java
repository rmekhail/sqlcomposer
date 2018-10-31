package org.sqlcomposer;

import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.sqlcomposer.SqlExpression;
import org.sqlcomposer.SqlSubject;

/**
 * Unit test for simple App.
 */
public class SqlSubjectTest extends TestCase {

    private String name = "TEST";
    private SqlSubject sqlSubject;

    @Override
    protected void setUp() {
        sqlSubject = new SqlSubject(name);
    }

    /**
     * Rigorous Test.
     */
    @Test
    public void testSqlSubject() {
        SqlSubject sqlSubject = new SqlSubject("");
        assertTrue(true);
    }

    @Test
    public void testGetSqlSubjectString(){
        SqlSubject sqlSubject = new SqlSubject(null);
        String subject = sqlSubject.toString();
        assertEquals("", subject);
    }

    @Test
    public void testSelect(){
        SqlSubject sqlSubject = new SqlSubject(name);
        SqlExpression sqlClause = sqlSubject.select();
        assertEquals("SELECT * FROM TEST;", sqlClause.toString());
    }

    @Test
    public void testSelectColumns(){
        SqlExpression sqlClause = sqlSubject.select("foo", "bar");
        assertEquals("SELECT foo, bar FROM TEST;", sqlClause.toString());
    }

    @Test
    public void testWhere(){
        String expected = "SELECT name, age FROM TEST WHERE age > 18;";
        String actual = sqlSubject.select("name", "age").where("age > 18").toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testDelete(){
        String expected = "DELETE FROM TEST;";
        String actual = sqlSubject.delete().toString();
        assertEquals(expected, actual);

    }

    @Test
    public void testDeleteWhere(){
        String expected = "DELETE FROM TEST WHERE id <> 'abc123';";
        String actual = sqlSubject.delete().where("id <> 'abc123'").toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testInsert(){
        String expected = "INSERT INTO TEST VALUES ('hello', '1234', '9.822', '20120903T23:01:34.2345');";
        String actual = sqlSubject.insert("hello", "1234", "9.822", "20120903T23:01:34.2345").toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGroupBy(){
        String expected = "SELECT * FROM TEST GROUP BY Department;";
        String actual = sqlSubject.select().group("Department").toString();
        assertEquals(expected, actual);

    }

    @Test
    public void testHaving(){
        String expected = "SELECT DepartmentID, Amount FROM TEST GROUP BY RegionId HAVING RegionId > 5;";
        String actual = sqlSubject.select("DepartmentID", "Amount").group("RegionId").having("RegionId > 5").toString();
        assertEquals(expected, actual);

    }
}
