package cl.duoc.newrentacar.endpoint;

import cl.duoc.newrentacar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        boolean success=userService.login(request.getEmail(), request.getPassword());
        LoginResponse response = new LoginResponse();
        if (success){
            response.setMessage("OK");
            return ResponseEntity.ok(response);
        }else {
            response.setMessage("NOK");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

    }
}
