package unp.student.work.manager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import unp.student.work.manager.domain.counsellor;
import unp.student.work.manager.domain.student_counsellor;
import unp.student.work.manager.service.CounsellorService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("counsellorAction")
@Scope("prototype")
public class CounsellorAction extends ActionSupport implements RequestAware,SessionAware,ModelDriven<counsellor>{
	private Map<String,Object> request=null;
	private  Map<String,Object> session=null;
	private counsellor counsellor=new counsellor();
	private float[] singlescore;
	private int select;
	
	@Resource
	private CounsellorService counsellorService;
	public counsellor getModel() {
		// TODO Auto-generated method stub
		return this.counsellor;
	}
	



	public float[] getSinglescore() {
		return singlescore;
	}




	public void setSinglescore(float[] singlescore) {
		this.singlescore = singlescore;
	}




	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
		
	}
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
		
	}
	
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public String get(){
		
		String studentid=(String)session.get("user");
		request.put("counsellor", counsellorService.findCounsellorByStudent(studentid));
		return "select";
	}
	
	public String select(){
		String studentid=(String)session.get("user");
		List sc=counsellorService.findResult(studentid, select);
		List problem=counsellorService.findProblem();
		request.put("problem", problem);
		request.put("record", sc);
		request.put("teacher", select);
		return "test";
	}
	
	public String result(){//��ɲ��Ժ���
		String studentid=(String)session.get("user");
		System.out.println(select);
		counsellorService.addRecord(studentid, singlescore, select);
		
		List sc=counsellorService.findResult(studentid, select);
		List problem=counsellorService.findProblem();
		request.put("problem", problem);
		request.put("record", sc);
		request.put("teacher", select);
		
		return "test";
	}
}