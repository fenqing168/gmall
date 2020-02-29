package cn.fenqing168.gmall.modules.mumber.controller;

import cn.fenqing168.gmall.modules.mumber.po.UmsMemberReceiveAddress;
import cn.fenqing168.gmall.modules.mumber.service.IUmsMemberReceiveAddressService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class UmsMemberReceiveAddressController {

    @Reference
    private IUmsMemberReceiveAddressService iUmsMemberReceiveAddressService;

    @GetMapping("/getByMemberId")
    public List<UmsMemberReceiveAddress> getByMemberId(@RequestParam Integer memberId){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = iUmsMemberReceiveAddressService.getByMemberId(memberId);
        return umsMemberReceiveAddresses;

    }

}
