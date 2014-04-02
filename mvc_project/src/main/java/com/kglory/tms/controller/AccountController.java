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

@Controller
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/account/selectAccount", method=RequestMethod.POST)
	@ResponseBody
	public List<AccountBean> selectAccount(@RequestBody AccountBean accountBean) {

		List<AccountBean> resultList = new ArrayList<AccountBean>();
		
		logger.debug("AccountController selectAccount Call");
		
		try {
			resultList = accountService.selectAccount(accountBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("AccountController "+resultList);
		
		return resultList;
		
	}
	
	@RequestMapping(value="/account/selectAccountList", method=RequestMethod.POST)
	@ResponseBody
	public List<AccountBean> selectAccountList() {

		List<AccountBean> resultList = new ArrayList<AccountBean>();
		
		logger.debug("AccountController selectAccountList Call");
		
		try {
			resultList = accountService.selectAccountList(new AccountBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("AccountController "+resultList);
		
		return resultList;
		
	}
	
	@RequestMapping(value="/account/addAccount", method=RequestMethod.POST)
	@ResponseBody
	public void addAccount(@RequestBody AccountBean user) {

		logger.debug("AccountController addAccount Call");
		logger.debug("AccountController "+user);
		
		Integer resultCount = 0;
		
		try {
			resultCount = accountService.addAccount(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("AccountController resultCount["+resultCount+"]");
		
	}
	
	@RequestMapping(value="/account/deleteAccount", method=RequestMethod.POST)
	@ResponseBody
	public void deleteAccount(@RequestBody AccountBean user) {

		logger.debug("AccountController deleteAccount Call");
		logger.debug("AccountController "+user);
		
		Integer resultCount = 0;
		
		try {
			resultCount = accountService.deleteAccount(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("AccountController resultCount["+resultCount+"]");
		
	}
	
}
