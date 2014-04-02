package com.kglory.tms.service.account;

import java.util.List;

import com.kglory.tms.bean.account.AccountBean;

/**
 *사용자 관련 서비스
 *@version 1.0
 *@author jrkang
 */
public interface AccountService {
	
    /**
     * 사용자 조회
     * @param AccountBean accountBean
     * @return List<AccountBean>
     * @throws Exception
     * @author jrkang             
     * @date 2014-03-24
     */
	public List<AccountBean> selectAccount(AccountBean accountBean) throws Exception;

    /**
     * 사용자 리스트 조회
     * @param AccountBean accountBean
     * @return List<AccountBean>
     * @throws Exception
     * @author jrkang             
     * @date 2014-03-24
     */
	public List<AccountBean> selectAccountList(AccountBean accountBean) throws Exception;
	
    /**
     * 사용자 추가
     * @param AccountBean accountBean
     * @return Integer
     * @throws Exception
     * @author jrkang             
     * @date 2014-03-24
     */
	public Integer addAccount(AccountBean accountBean) throws Exception;
    
	/**
     * 사용자 삭제
     * @param AccountBean accountBean
     * @return Integer
     * @throws Exception
     * @author jrkang             
     * @date 2014-03-24
     */
	public Integer deleteAccount(AccountBean accountBean) throws Exception;
	
}
