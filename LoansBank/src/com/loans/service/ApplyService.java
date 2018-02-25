package com.loans.service;

import com.loans.dao.imp.ApplyDao;
import com.loans.entity.Apply;

public class ApplyService {
	
	private ApplyDao applyDao = new ApplyDao();
	
	public void Apply2(Apply apply) {
		
		if (apply == null) {
			throw new RuntimeException("贷款申请信息不够完善，请重新输入");
		}
		
		try {
			apply.setStatus("申请状态");
			applyDao.add(apply);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("贷款申请异常");
		}
		
	}
}
