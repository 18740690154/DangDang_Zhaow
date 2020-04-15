package cn.baizhi.zw.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	static{
		InputStream is = null;
		try {
			//在类加载的时候 只执行一次的配置文件读取！
			is = Resources.getResourceAsStream("mybatis-config.xml");
			//共享同一个工厂对象  重量级资源    类似 ServletContext
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(is!=null)try {is.close();} catch (IOException e) {}
		}
	}
	
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	//获取连接sqlsession
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = tl.get();
		//没有连接对象  创建并绑定在当前线程中！！！
		if(sqlSession==null){
			 sqlSession = sqlSessionFactory.openSession();
			 tl.set(sqlSession);
		}
		return sqlSession;
	}
	
	//资源的关闭  线程的解除绑定
	public static void close(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();tl.remove();
		}
	}
	
	//提交方法  并 关闭
	public static void commit(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.commit();
			close(sqlSession);
		}
	}
	//回滚  并 关闭
	public static void rollback(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.rollback();
			close(sqlSession);
		}
	}
}
