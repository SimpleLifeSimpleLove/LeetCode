package _0000_study._jdbc.basic.preparedstatementcrud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import _0000_study._jdbc.basic.preparedstatementcrud.bean.Customer;
import _0000_study._jdbc.util.JDBCUtils;
import org.junit.Test;

/**
 * @author shkstart  Email:shkstart@126.com
 * @Description 针对于Customers表的查询操作
 * @date 上午10:04:55
 */
public class CustomerForQuery {

    @Test
    public void testQueryForCustomers() {
        String sql = "select id,name,birth,email from customers where id = ?";
        Customer customer = queryForCustomers(sql, 13);
        System.out.println(customer);

        sql = "select name,email from customers where name = ?";
        Customer customer1 = queryForCustomers(sql, "周杰伦");
        System.out.println(customer1);
    }


    // 针对于customers表的通用的查询操作
    public Customer queryForCustomers(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            // 4.执行,并返回结果集
            rs = ps.executeQuery();
            // 获取结果集的元数据: ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过 ResultSetMetaData 获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                Customer cust = new Customer();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给 cust 对象指定的 columnName 属性，赋值为   columValue：通过反射
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(cust, columValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.资源的关闭
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2.预编译sql语句，返回PreparedStatement的实例
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            ps.setObject(1, 1);

            // 4.执行,并返回结果集
            resultSet = ps.executeQuery();
            // 处理结果集
            if (resultSet.next()) {  // next():判断结果集的下一条是否有数据，如果有数据返回true,并指针下移；如果返回false,指针不会下移。
                // 获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                // 方式一：
                // System.out.println("id = " + id + ",name = " + name + ",email = " + email + ",birth = " + birth);
                // 方式二：
                // Object[] data = new Object[]{id,name,email,birth};

                // 方式三：将数据封装为一个对象（推荐）
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }
}
