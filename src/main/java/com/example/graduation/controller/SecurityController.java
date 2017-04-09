/**
 * @author kale
 * http://www.cxy808.com
 * under the License.
 */
package com.example.graduation.controller;

import com.example.graduation.util.EncryptUtils;
import com.example.graduation.vo.LoginCommand;
import com.example.graduation.vo.LoginValidator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


/**
 * Web MVC controller that handles security-related web requests, such as login and logout.
 */
@Controller
@RequestMapping("/main")
public class SecurityController {

    private LoginValidator loginValidator = new LoginValidator();

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String showLoginForm(Model model, @ModelAttribute LoginCommand command ) {
    	return "main/login";
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(Model model, @ModelAttribute LoginCommand command, BindingResult errors) {
    	loginValidator.validate(command, errors);
    	System.out.println("user property========"+command.getPassword()+command.getUsername()+command.getPosition());
    	
    	//用户身份放入上下文
    	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
    	webApplicationContext.getServletContext().setAttribute("position", command.getPosition());
    	
    	if( errors.hasErrors() ) {
            return showLoginForm(model, command);
        }
        
        UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(), EncryptUtils.encryptMD5(command.getPassword()), false);//记住密码 默认false
        try {
           Subject currentUser= SecurityUtils.getSubject();
        	currentUser.login(token);
        } catch (AuthenticationException e) {
        	
            errors.reject( "error.login.generic", "Invalid username or password.  Please try again." );
        }

        if( errors.hasErrors() ) {
            return showLoginForm(model, command);
        } else {
        	model.addAttribute("currentUser", command);

            return "main/home";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject currentUser= SecurityUtils.getSubject();
     	currentUser.logout();
        return "redirect:/main/login";
    }


}
