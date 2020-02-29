package cn.fenqing168.gmall.modules.attr.controller;

import cn.fenqing168.gmall.modules.attr.dto.PmsBaseAttrInfoDto;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrInfo;
import cn.fenqing168.gmall.modules.attr.service.IPmsBaseAttrInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsBaseAttrInfoController {

    @Reference
    private IPmsBaseAttrInfoService iPmsBaseAttrInfoService;

    @GetMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(@RequestParam Long catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = iPmsBaseAttrInfoService.attrInfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

    @PostMapping("/saveAttrInfo")
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfoDto pmsBaseAttrInfoDto){
        iPmsBaseAttrInfoService.saveAttrInfo(pmsBaseAttrInfoDto);
    }

}
