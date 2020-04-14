package com.kjn.TaskJournal.Controller;

import com.kjn.TaskJournal.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import com.kjn.TaskJournal.Class.Student;

@RestController
public class HelloController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello (@RequestParam(value = "id") Integer id) {
		String sql = "SELECT name FROM user WHERE id = ?";
		String user = (String) jdbcTemplate.queryForObject(
				sql, new Object[]{id}, String.class);
		return user;
	}
	@RequestMapping(value="/hello2",method = RequestMethod.GET)
	public String index(@RequestParam(value = "id") Integer id) {
		String sql = "SELECT name FROM user WHERE id = ?";
		String mobile = (String) jdbcTemplate.queryForObject(
				sql, new Object[]{id}, String.class);
		return "Hello " + mobile;
	}
	@RequestMapping(value="/hello3",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Result> hello(@RequestParam(value="bad",required = false,defaultValue = "false")boolean bad){
		Result res = new Result(200,"ok");
		if(bad) {
			res.setStatus(400);
			res.setMessage("Bad request");
			return new ResponseEntity<Result>(res, HttpStatus.BAD_REQUEST);
		}
		res.putData("words","Hello world!");
		return ResponseEntity.ok(res);
	}
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	public String insertUser (
//			@RequestParam(value = "name") String name,
//			@RequestParam(value = "age") Integer age
//	) {
//
//		return "Hello" + name + age;
//	}
}
