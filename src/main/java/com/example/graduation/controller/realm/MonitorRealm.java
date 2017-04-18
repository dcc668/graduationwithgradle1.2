package com.example.graduation.controller.realm;

import com.example.graduation.vo.Manage;
import com.example.graduation.model.Student;
import com.example.graduation.model.Teacher;
import com.example.graduation.service.StudentService;
import com.example.graduation.service.TeacherService;
import com.example.graduation.util.EncryptUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("monitorRealm")
public class MonitorRealm extends AuthorizingRealm {

	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TeacherService teacherService;
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		/* 这里编写授权代码 */
		

		
        //上下文中获取用户身份(学生，教师，评审人，管理)
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
    	 String position = (String) webApplicationContext.getServletContext().getAttribute("position");

		    	if(position.equals("student")){
				    		Set<String> roleNames = new HashSet<String>();
				    	    Set<String> permissions = new HashSet<String>();
				    	    roleNames.add("student");
				    	    permissions.add("student:read");
				    	    permissions.add("student:write");
				    	    permissions.add("student:all");
				    		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
				    	    info.setStringPermissions(permissions);
				    		return info;
		        	
		        }
		    	
		        if(position.equals("teacher")){
		    		Set<String> roleNames = new HashSet<String>();
		    	    Set<String> permissions = new HashSet<String>();
		    	    roleNames.add("teacher");
		    	    permissions.add("teacher:read");
		    	    permissions.add("teacher:write");
		    	    permissions.add("teacher:all");
		    		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		    	    info.setStringPermissions(permissions);
		    		return info;
		        	
		        }
		        
		        if(position.equals("reviewer")){
		    		Set<String> roleNames = new HashSet<String>();
		    	    Set<String> permissions = new HashSet<String>();
		    	    roleNames.add("reviewer");
		    	    permissions.add("reviewer:read");
		    	    permissions.add("reviewer:write");
		    	    permissions.add("reviewer:all");
		    		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		    	    info.setStringPermissions(permissions);
		    		return info;
		        	
		        	
		        	
		        	
		        }
		        
		        if(position.equals("manage")){
		    		Set<String> roleNames = new HashSet<String>();
		    	    Set<String> permissions = new HashSet<String>();
		    	    roleNames.add("manage");
		    	    permissions.add("manage:read");
		    	    permissions.add("manage:write");
		    	    permissions.add("manage:all");
		    	    permissions.add("teacher:read");
		    	    permissions.add("teacher:write");
		    	    permissions.add("teacher:all");
		    	    permissions.add("student:all");
		    	    permissions.add("reviewer:all");
		    		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		    	    info.setStringPermissions(permissions);
		    		return info;
		        }
				return null;
		
		
		
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		/* 这里编写认证代码 */
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
	
        //上下文中获取用户身份(学生，教师，评审人，管理)
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
    	 String position = (String) webApplicationContext.getServletContext().getAttribute("position");

    	if(position.equals("student")){
        	Student user = studentService.findByName(token.getUsername().trim()).get(0);
    		
        	if (user != null) {
    			return new SimpleAuthenticationInfo(user.getsId(),
    					EncryptUtils.encryptMD5(user.getPassword()), getName());
    		
    		}else{
    			return null;
    		}
        	
        }
    	
        if(position.equals("teacher")){

        	List<Teacher> users=teacherService.findByName(token.getUsername().trim());
    		Teacher te=users.get(0);
        	if (te != null) {
    			return new SimpleAuthenticationInfo(te.getTeId(),
    					EncryptUtils.encryptMD5(te.getTePassword()), getName());
    		
    		}else{
    			return null;
    		}
        	
        }
        

        if(position.equals("manage")){
    		Manage user = new Manage();
    		user.setId("122701");
    		user.setUserName("admin");
    		user.setPassword(EncryptUtils.encryptMD5("123"));
//    		if (user != null) {
    		return new SimpleAuthenticationInfo(user.getId(),
    				user.getPassword(), getName());

        	
        }
		return null;
        
        
	}

	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

}
