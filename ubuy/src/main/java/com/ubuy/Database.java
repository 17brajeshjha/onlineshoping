package com.ubuy;
//https://www.ictdemy.com/java/jdbc/finishing-a-database-wrapper-in-java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
	private Connection con = null;
	//connecting to the database
    protected Connection connection;

    //the Query class instance
    protected Query query;
    public class DBResultSet{
    	public int querryExecuteResult;
    	public ResultSet resultSet;
    }
    /**
    * The Database class constructor
    * @param db
    * @param userName
    * @param password
    * @throws SQLException
    */
    public Database() throws SQLException{

         connection = DriverManager.getConnection(DBConstants.DB_URL, DBConstants.DB_USER, DBConstants.DB_PASS);

    }
    
    /**
    *
    * @param query
    * @param params
    * @return
    * @throws SQLException
    */
   private int query(String query, Object[] params) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(query);
        if (params != null){
          int index = 1;
          for(Object param : params){
            ps.setObject(index, param);
           index++;
          }
        }
        return ps.executeUpdate();
   }
   /**
   *
   * @param query
   * @param params
   * @return
   * @throws SQLException
   */
  private DBResultSet query2(String query, Object[] params) throws SQLException{
       PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
       if (params != null){
         int index = 1;
         for(Object param : params){
           ps.setObject(index, param);
          index++;
         }
       }
       
       int res = ps.executeUpdate();
       
       ResultSet rs=ps.getGeneratedKeys();
       DBResultSet drs = new DBResultSet();
       drs.querryExecuteResult = res;
       drs.resultSet = rs;
       return drs;
  }
   /**
    * Removes data from a database table
    * @param table
    * @param requirement
    * @param param
    * @return
    * @throws SQLException
    */
   public int delete(String table, String requirement, Object[] param) throws SQLException{
       query = new Query();
       query.delete(table)
            .where(requirement);
       return query(query.getQuery(), param);
   }
   
   /**
    * Inserts one row to a database table
    * @param table
    * @param params
    * @return
    * @throws java.sql.SQLException
    */
   public DBResultSet insert(String table, Object[] params) throws SQLException{
       query = new Query();
       query.insert(table)
            .values(params);
       return query2(query.getQuery(), params);
   }
   
   /**
    * Updates data stored in a database table
    * @param table
    * @param columns
    * @param requirement
    * @param params
    * @return
    * @throws SQLException
    */
   public int update(String table, String[] columns, String requirement, Object[] params) throws SQLException{
       query = new Query();

       query.update(table)
            .set(columns)
            .where(requirement);

       return query(query.getQuery(), params);
   }
   
   /**
    * Returns data from a table
    * @param table
    * @param columns
    * @param params
    * @return
    * @throws SQLException
    */
   public ResultSet select(String table, Object[] columns, Object[] params) throws SQLException{
       return this.select(table, columns, "", params);
   }

   /**
    * Returns data from a table
    * @param table
    * @param columns
    * @param requirement
    * @param params
    * @return
    * @throws SQLException
    */
   public ResultSet select(String table, Object[] columns, String requirement, Object[] params) throws SQLException{
       query = new Query();
       query.select(columns)
            .from(table)
            .where(requirement);

       PreparedStatement ps = connection.prepareStatement(query.getQuery());
       if(params != null){
           int index = 1;
           for(Object param : params){
           ps.setObject(index, param);
           index++;
        }
       }

       ResultSet rs = ps.executeQuery();
       return rs;
   }
   
   // Customised functions
   /**
    * Returns data from a table
    * @param table
    * @param columns
    * @return
    * @throws SQLException
    */
   public ResultSet selectAll(String table) throws SQLException{
       query = new Query();
       query.select(null)
            .from(table);

       PreparedStatement ps = connection.prepareStatement(query.getQuery());
       ResultSet rs = ps.executeQuery();
       return rs;
   }
  
	public void close() throws SQLException
	{
		connection.close();
	}
}
