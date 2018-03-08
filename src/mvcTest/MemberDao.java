package mvcTest;


import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


public class MemberDao implements MemberDaoInf{
	// 자기 참조 변수 선언 및 초기화
	private static MemberDao dao = new MemberDao();
	
	// ibatis용 객체 변수 선언
	private SqlMapClient smc;
	
	// 생성자
	private MemberDao(){
		System.out.println("DAO 싱글톤 적용");
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 자기 참조값을 반환하는 메서드
	public static MemberDao getInstance(){
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("member.memInsert", memVo);
			if (obj == null) {// insert메서드는 자료 추가가 성공하였을때 null값 반환함
				cnt = 1;
				System.out.println("sdfsdfsdfsd");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	// 주어진 회원ID에 해당하는 회원 정보를 삭제하는 메서드
	@Override
	public int deleteMember(String memId) {
		return 0;
	}
	
	// 주어진 회원정보로 DB의 회원 정보를 update하는 메서드
	@Override
	public int updateMember(MemberVO memVo) {
		return 0;
	}

	// DB에서 전체 회원 정보를 가져와 List로 담아서 반환하는 메서드
	@Override
	public List<MemberVO> getAllMember() {
		return null;
	}

	// 해당 회원이 있으면 1, 없으면 0을 반환하는 메서드
	@Override
	public int getCountMember(String memId) {
		return 0;
	}

	// 검색하기 메서드
	@Override
	public List<MemberVO> searchMember(MemberVO memVo) {
		
		return null;
	}

}