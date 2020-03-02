package cn.fenqing168.gmall.modules.product.controller;

import cn.fenqing168.gmall.modules.product.dto.PmsProductInfoDto;
import cn.fenqing168.gmall.modules.product.po.PmsProductInfo;
import cn.fenqing168.gmall.modules.product.serrvice.IPmsProductInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsProductInfoController {

    @Reference
    private IPmsProductInfoService iPmsProductInfoService;

    @GetMapping("/spuList")
    public List<PmsProductInfo> spuList(@RequestParam Long catalog3Id){
        List<PmsProductInfo> pmsProductInfos = iPmsProductInfoService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @PostMapping("/saveSpuInfo")
    public void saveSpuInfo(@RequestBody PmsProductInfoDto pmsProductInfoDto){
        iPmsProductInfoService.saveSpuInfo(pmsProductInfoDto);
    }

}
