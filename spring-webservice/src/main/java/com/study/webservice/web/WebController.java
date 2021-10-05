package com.study.webservice.web;

import com.study.webservice.config.auth.LoginUser;
import com.study.webservice.config.auth.dto.SessionUser;
import lombok.AllArgsConstructor;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main(Model model, @LoginUser SessionUser user) {

        // 사용자 정보: 위의 @LoginUser 어노테이션으로 대체
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("guestName", user.getName());
            model.addAttribute("guestImg", user.getPicture());
        }
        return "index";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/mypage")
    public String mypage() { return "mypage"; }

    @GetMapping("/createRoom")
    public String createRoom() { return "createRoom"; }

    @GetMapping("/room")
    public String room() { return "room"; }
}