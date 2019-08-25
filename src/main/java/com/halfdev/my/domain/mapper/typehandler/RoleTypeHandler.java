package com.halfdev.my.domain.mapper.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.halfdev.my.domain.TypeHandlerException;
import com.halfdev.my.domain.model.RoleType;

public class RoleTypeHandler<E extends Enum<E>> extends BaseTypeHandler<RoleType> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, RoleType parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public RoleType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return getRoleType(rs.getInt(columnName));
	}

	@Override
	public RoleType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getRoleType(rs.getInt(columnIndex));
	}

	@Override
	public RoleType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getRoleType(cs.getInt(columnIndex));
	}

	// java 12 switch
	private RoleType getRoleType(int type) {
		return switch (type) {
			case 1 -> RoleType.ADMINISTRATOR;
			case 2 -> RoleType.MANAGER;
			case 3 -> RoleType.USER;
			default -> throw new TypeHandlerException();
		};
	}
}
