package boilerplate.spring.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private boolean isAuth = false;

    @GetMapping
    ResponseEntity<Void> get() {
//        this.isAuth = !isAuth;
//        if (isAuth) {
//            return ResponseEntity.ok().build();
//        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
    }

    @GetMapping("/token")
    String getToken() {
        return "token";
    }
}
