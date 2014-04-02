package com.kglory.tms.mapper.account;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kglory.tms.bean.account.AccountBean;

/**
 *사용자 관련 Dto
 *@version 1.0
 *@author jrkang
 */
@Repository
public interface AccountMapper {

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
     * 사용자 조회
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
