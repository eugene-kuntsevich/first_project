package hello.ws;

import hello.service.IUserService;
import hello.ws.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/user")
public class AuthUserController implements WebMvcConfigurer {

    private IUserService userService;

    @Autowired
    public AuthUserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(UserLoginRequest userLoginRequest) {
        boolean isLogin = userService.login(userLoginRequest.getName(), userLoginRequest.getPassword());
        System.out.println("User with name: " + userLoginRequest.getName() + " is logged");
        return userService.login(userLoginRequest.getName(), userLoginRequest.getPassword()) ?
                new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping
    public String showsForm(UserLoginRequest userLoginRequest) {
        return "form";
    }
}
