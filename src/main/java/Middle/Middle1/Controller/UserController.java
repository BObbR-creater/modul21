package Middle.Middle1.Controller;

import Middle.Middle1.DTO.RegisterRequest;
import Middle.Middle1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> reg(@RequestBody RegisterRequest registerRequest) {

        return ResponseEntity.ok(userService.register(registerRequest.getLogin(), registerRequest.getPassword()));

    }

}
