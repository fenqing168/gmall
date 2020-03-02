package cn.fenqing168.gmall.modules.sku.controller;

import cn.fenqing168.gmall.modules.sku.dto.PmsSkuInfoDto;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuInfo;
import cn.fenqing168.gmall.modules.sku.service.IPmsSkuInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fenqing
 */
@RestController
public class PmsSkuInfoController {

    @Reference
    private IPmsSkuInfoService iPmsSkuInfoService;

    @PostMapping("/saveSkuInfo")
    public void saveSkuInfo(@RequestBody PmsSkuInfoDto.Save save){
        iPmsSkuInfoService.saveSkuInfo(save);
    }

}
