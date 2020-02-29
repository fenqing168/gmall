package cn.fenqing168.gmall.modules.mumber.controller;

import cn.fenqing168.gmall.modules.mumber.service.IUmsMemberService;
import cn.fenqing168.gmall.modules.mumber.po.UmsMember;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class UmsMemberController {

    @Reference
    private IUmsMemberService iUmsMemberService;

    @GetMapping("/index")
    public String index(){
        return "hello world";
    }

    @GetMapping("/getAllUser")
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers = iUmsMemberService.getAllUser();
        return umsMembers;
    }

}
