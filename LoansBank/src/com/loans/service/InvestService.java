package com.loans.service;

import java.util.ArrayList;
import java.util.List;

import com.loans.dao.imp.InvestDao;
import com.loans.entity.Invest;

public class InvestService {

	private InvestDao investDao = new InvestDao();
	
	public void investService(Invest it) {
		
		if (it == null) {
			throw new RuntimeException("投资申请信息不够完善，请重新输入");
		}
		
		
		Invest in = investDao.findAllByName(it);
		if (in != null) {
			if (in.getInveststatus().equals("批准")) {
				in.setInveststatus("申请状态");
				in.setiMoney(it.getiMoney());
				in.setInvestDate(it.getInvestDate());
				in.setInvestMethod(it.getInvestMethod());
				in.setInvestTime(it.getInvestTime());
				in.setUserName(it.getUserName());
				in.setWithDrawMethod(it.getWithDrawMethod());
				investDao.update(in);
				throw new RuntimeException("投资变更已提交，请等待审批");
			} else {
				throw new RuntimeException("你已提交过申请，请等待审批");
			}
			
		}
		
		try {
			it.setInveststatus("申请状态");
			investDao.add(it);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("投资申请异常");
		}
	}
	
	public List<Invest> investMoney(Invest it) {
		List<Invest> list = new ArrayList<Invest>();
		
		
		if (it == null) {
			throw new  RuntimeException("用户名不能为空");
		}
		
		  try {
			list = investDao.findAllList(it);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("查找失败");
		}
		  
		  return list;
		
	}
	
}
