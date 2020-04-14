package com.kjn.TaskJournal.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kjn.TaskJournal.common.util.MiscUtil;
import com.kjn.TaskJournal.common.util.Result;
import com.kjn.TaskJournal.model.RegisterRequest;
/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 18:02
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping(value = "/register",method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Result> register(
			@Valid @RequestBody RegisterRequest register,
			BindingResult bindingResult
	){
		if(bindingResult.hasErrors()){
			Result res1 = MiscUtil.getValidateError(bindingResult);
			return new ResponseEntity<Result>(res1,HttpStatus.UNPROCESSABLE_ENTITY);
		}
		Result res = new Result(200,"ok");
		return ResponseEntity.ok(res);
	}
}
