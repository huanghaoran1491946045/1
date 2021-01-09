package cn.edu.jsu.hhr.frm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.jsu.hhr.dbc.DatabaseConnectionSqlserver;

public class PageController {
	private static Vector<Vector> bigList ; // 大集合，从外界获取数据
	private Vector<Vector> smallList = new Vector<Vector>(); // 小集合，返回给调用它的类
	private static int curentPageIndex = 1; // 当前页码
	private static int  countPerpage = 5; // 每页显示条数 
	private int pageCount; // 总页数
	private int recordCount; // 总记录条数
	{// 初始化代码块
		if(PageController.bigList==null) {
			PageController.bigList=getSelectAll("select * from Tableplayer");// 调用查询数据库的方法，返回所有的行
		}
		//获取总页数
		if(bigList.size()%countPerpage==0) {
			pageCount=bigList.size()/countPerpage;
		}else {
			pageCount=bigList.size()/countPerpage+1; 
		} 
	}
	public PageController() {}//无参构造方法

	public PageController(int curentPageIndex) {//构造方法设置当前页
		this.curentPageIndex = curentPageIndex;
	}
	public void setCountPerpage(int countPerpage) {//设置每页显示的记录数 
		this.countPerpage=countPerpage;
	}
	public Vector<Vector> getPaegData() {// 根据当前页数，筛选记录
		recordCount = bigList.size();//定义记录数为数据库中表的所有数据
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {//取得当前页数的记录，curentPageIndex当前页数，countPerpage每页显示的记录数
			smallList.add(bigList.get(i));//将记录加入到小集合中
		}
		return smallList;//返回小集合（当前页的数据）
	}
	public Vector<Vector> nextPage(){//下一页
		if(curentPageIndex<pageCount) { 
			curentPageIndex++;
		}else { 
			curentPageIndex=1;
		}
		return getPaegData();//返回下一页的数据
	}
	public Vector<Vector> prePage(){//上一页
		if(curentPageIndex>1) {
			curentPageIndex--;
		}else {
			curentPageIndex=pageCount; 
		}
		return getPaegData();//返回上一页的数据
	}
	
	
	public static Vector<Vector> Find(String sql,String key){
		Vector<Vector> rows=new Vector<Vector>();
		DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();
		try(Connection conn=dbcs.getConnection();Statement stm=conn.createStatement();) {
			ResultSet rs=stm.executeQuery(sql); 
			while(rs.next()) { 
				Vector row=new Vector();//定义行数据 
				if((key).equals(rs.getString(1))){
					row.add(rs.getString(1));//获取第一个字段姓名
	    			row.add(rs.getString(2));//获取第二个字段身高
	    			row.add(rs.getString(3)); 
	    			row.add(rs.getString(4));
	    			row.add(rs.getString(5));
	    			row.add(rs.getString(6)); 
	    			row.add(rs.getString(7));
					
				}    			
    			rows.add(row);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  
		return rows;
	}
	
	
	 public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnectionSqlserver dbcs=new DatabaseConnectionSqlserver();//使用1中定义的连接数据库的类 
	    	try(Connection conn=dbcs.getConnection();//获取数据库接 
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据 
	    			row.add(rs.getString(1));//获取第一个字段姓名
	    			row.add(rs.getString(2));//获取第二个字段身高 
	    			row.add(rs.getString(3)); 
	    			row.add(rs.getString(4));
	    			row.add(rs.getString(5));
	    			row.add(rs.getString(6));
	    			row.add(rs.getString(7));
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }
	}
