package com.halfdev.my.domain.mapper.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.halfdev.my.domain.TypeHandlerException;
import com.halfdev.my.domain.model.UserStatus;

public class UserStatusTypeHandler<E extends Enum<E>> extends BaseTypeHandler<UserStatus> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, UserStatus parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public UserStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return getUserStatus(rs.getInt(columnName));
	}

	@Override
	public UserStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getUserStatus(rs.getInt(columnIndex));
	}

	@Override
	public UserStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getUserStatus(cs.getInt(columnIndex));
	}

	// java 12 switch
//	private UserStatus getUserStatus(int type) {
//		return switch (type) {
//			case 1 -> UserStatus.ON;
//			case 2 -> UserStatus.BLOCK;
//			case 3 -> UserStatus.DORMANT;
//			case 4 -> UserStatus.LEAVE;
//			default -> throw new TypeHandlerException();
//		};
//	}
	
	// java 8 switch
	private int getUserStatus(int type) {
		switch (type) {
			case ON:  /* ? */ break;
			case BLOCK: break;
			case DORMANT: break;
			case LEAVE: break;
			default: throw new TypeHandlerException();
		};
		return type;
	}
}
