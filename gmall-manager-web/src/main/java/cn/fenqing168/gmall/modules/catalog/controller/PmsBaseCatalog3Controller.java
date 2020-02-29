package cn.fenqing168.gmall.modules.catalog.controller;

import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog3;
import cn.fenqing168.gmall.modules.catalog.service.IPmsBaseCatalog3Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsBaseCatalog3Controller {

    @Reference
    private IPmsBaseCatalog3Service iPmsBaseCatalog3Service;

    @PostMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam Long catalog2Id){
        List<PmsBaseCatalog3> pmsBaseCatalog3s = iPmsBaseCatalog3Service.getCatalog3(catalog2Id);
        return pmsBaseCatalog3s;
    }

}
