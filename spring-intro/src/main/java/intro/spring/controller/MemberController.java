package intro.spring.controller;

import intro.spring.domain.Member;
import intro.spring.dto.MemberForm;
import intro.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final Logger log;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        this.log = Logger.getLogger(this.getClass().getName());
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        log.info("Creating new member: " + form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
