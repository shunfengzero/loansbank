package com.loans.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.loans.entity.Users;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class UploadAction extends ActionSupport {
	
	private File file;
	private String fileFileName; //文件名
	
	
	
	
	public File getFile() {
		return file;
	}




	public void setFile(File file) {
		this.file = file;
	}




	public String getFileFileName() {
		return fileFileName;
	}




	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}




	public void upload() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
		
				//获取保存文件的路径
				String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
				//System.out.println(realPath);
			
				//目标文件的File对象
				File newFile = new File(realPath,fileFileName);
				JsonBean bean = new JsonBean();
				try {
					//保存文件
					FileUtils.copyFile(file, newFile);
					System.out.println("上传成功");
					String path = "../../upload/" + fileFileName ;
							
					bean.setCode(1);
					bean.setMsg(path);
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					bean.setCode(0);
					bean.setMsg(e.getMessage());
				}
				
				PrintWriter writer = null;
				try {
					writer = response.getWriter();
					System.out.println(JSONObject.fromObject(bean).toString());
					writer.write(JSONObject.fromObject(bean).toString());
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
}
