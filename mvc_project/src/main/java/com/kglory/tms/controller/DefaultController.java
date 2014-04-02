package com.kglory.tms.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kglory.tms.bean.account.AccountBean;
import com.kglory.tms.service.account.AccountService;

/**
 * 컨트롤러
 * @version 1.0
 * @author jrkang
 */
@Controller
public class DefaultController {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/login/index", method=RequestMethod.POST)
	@ResponseBody
	public AccountBean index(@RequestBody AccountBean user) {

		List<AccountBean> resultList = new ArrayList<AccountBean>();
		boolean succesYn = false;	// 로그인 성공 여부
		
		logger.debug("DefaultController login Call");
		logger.debug("DefaultController before "+user);
		
		try {
			resultList = accountService.selectAccount(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AccountBean resultUser = new AccountBean(); 
				
		if(resultList.size() > 0) {
			resultUser = resultList.get(0);
			succesYn = true;
		}
		
		String id = user.getId();
		String password = user.getPwd();

		resultUser.setId(id);
		resultUser.setPwd(password);
		resultUser.setSuccessYn(succesYn);

		logger.debug("DefaultController after "+resultUser);
		
		return resultUser;
		
	}
	
}
