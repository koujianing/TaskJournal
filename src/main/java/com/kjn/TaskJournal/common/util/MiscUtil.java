package com.kjn.TaskJournal.common.util;


import org.springframework.validation.FieldError;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 18:02
 */
public class MiscUtil {
	static public Result getValidateError(BindingResult bindingResult) {
		if(bindingResult.hasErrors() == false){
			return null;
		}
		Map<String,String> fieldErrors = new HashMap<String,String>();
		for(FieldError error:bindingResult.getFieldErrors()){
			fieldErrors.put(error.getField(), error.getCode() + "|" + error.getDefaultMessage());
		}
		Result ret = new Result(422, "输入错误"); //rfc4918 - 11.2. 422: Unprocessable Entity
		ret.putData("fieldErrors", fieldErrors);

		return ret;
	}
}
