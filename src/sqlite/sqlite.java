package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlite {

public static void main(String[] args) throws Exception{
Class.forName("org.sqlite.JDBC");
Connection bd = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
Statement st = bd.createStatement();
//st.execute("create table if not exists 'TABLE1' ('name1' int, 'name2' text, 'name3' text);");
//st.execute("insert into 'TABLE1' ('name1', 'name2', 'name3') values (1, 'name1', 'name2'); ");
//st.execute("insert into 'TABLE1' ('name1', 'name2', 'name3') values (2, 'name3', 'name4'); ");
st.execute("insert into 'TABLE1' ('name1', 'name2', 'name3') values (3, 'name5', 'name6');");
ResultSet rs = st.executeQuery("select * from TABLE1");
while (rs.next())
{
System.out.print (rs.getString(1)+" ");
System.out.print (rs.getString(2)+" ");
System.out.println(rs.getString(3));
}
bd.close();
st.close();
rs.close();

}

}
