package kr.or.connect.todo.persistence;

import kr.or.connect.todo.domain.Todo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Todo> rowMapper = BeanPropertyRowMapper.newInstance(Todo.class);


	public TodoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("todo")
				.usingGeneratedKeyColumns("id");
	}

	public Integer insert(Todo todo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todo);
		return this.insertAction.executeAndReturnKey(params).intValue();
	}

	public Todo selectById(Integer id) {
		Map<String,Object> params = new HashMap<>();
		params.put("id",id);
		return this.jdbc.queryForObject(TodoSqls.SELECT_BY_ID,params,rowMapper);
	}

	public List<Todo> selectAll() {
		return this.jdbc.query(TodoSqls.SELECT_ALL,rowMapper);
	}

	public int count() {
		Map<String, Object> params = Collections.emptyMap();
		return this.jdbc.queryForObject(TodoSqls.COUNT, params, Integer.class);
	}

	public int deleteById(Integer id) {
		Map<String, Object> params = Collections.singletonMap("id", id);
		return this.jdbc.update(TodoSqls.DELETE_BY_ID,params);
	}

	public int update(Todo todo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todo);
		return this.jdbc.update(TodoSqls.UPDATE,params);
	}



}
