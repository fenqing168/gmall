package cn.fenqing168.gmall.modules.attr.controller;

import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;
import cn.fenqing168.gmall.modules.attr.service.IPmsBaseAttrValueService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsBaseAttrValueController {

    @Reference
    private IPmsBaseAttrValueService iPmsBaseAttrValueService;

    @PostMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(@RequestParam Long attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValues = iPmsBaseAttrValueService.getAttrValueList(attrId);
        return pmsBaseAttrValues;
    }

}
