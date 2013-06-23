package com.h13.cardgame.mercury.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.h13.cardgame.mercury.auth.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate j;

    public List<Object[]> getUserInfo(long userId) {

        final String select = "select r.name,p.name from role r, permission p , roles_permissions rp,user u"
                + " where u.id=? and u.role_id=r.id and rp.role_id= r.id and rp.permission_id=p.id";
        return j.query(select, new Object[]{userId}, new RowMapper() {

            public Object[] mapRow(ResultSet rs, int arg1) throws SQLException {
                Object[] arr = new Object[2];
                arr[0] = rs.getString(1);
                arr[1] = rs.getString(2);
                return arr;
            }
        });
    }

    public UserVO isUserExist(String userName, String userPwd) {
        final String select = "select id,name,pwd from user where name=? and pwd=?";
        List<UserVO> list = j.query(select, new Object[]{userName, userPwd},
                new BeanPropertyRowMapper(UserVO.class));
        if (list == null || list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public List<UserVO> getAllUsers() {
        String sql = "select u.id,u.name,u.pwd,r.id as role_id,r.name as role_name from user u,role r where u.role_id=r.id";
        return j.query(sql, new Object[]{}, new BeanPropertyRowMapper(
                UserVO.class));
    }

    public UserVO getUser(long userId) {
        String sql = "select u.id,u.name,u.pwd,r.id as role_id,r.name as role_name from user u,role r where u.role_id=r.id and u.id=?";
        List<UserVO> userList = j.query(sql, new Object[]{userId},
                new BeanPropertyRowMapper(UserVO.class));
        if (userList == null || userList.size() == 0) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    public void delete(long userId) {
        String sql = "delete from user where id=?";
        j.update(sql, new Object[]{userId});
    }

    public void update(long userId, String name, String pwd, long roleId) {
        String sql = "update user set name=?,pwd=md5(?),role_id=? where id=?";
        j.update(sql, new Object[]{name, pwd, roleId, userId});

    }

    public long create(final String name, final String pwd, final long roleId) {
        KeyHolder kh = new GeneratedKeyHolder();
        final String sql = "insert into user (name,pwd,role_id,create_time) values (?,md5(?),?,now())";
        j.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, pwd);
                pstmt.setLong(3, roleId);
                return pstmt;
            }
        }, kh);

        return kh.getKey().longValue();
    }

    public boolean modifyPassowrd(String name, String oldpwd, String newpwd) {
        String s1 = "select count(1) from user where name = ? and pwd=md5(?)";
        int count = j.queryForInt(s1, new Object[]{name, oldpwd});
        if (count != 1)
            return false;
        String s2 = "update user set pwd=md5(?) where name=? and pwd=md5(?)";
        j.update(s2, new Object[]{newpwd, name, oldpwd});
        return true;
    }
}
