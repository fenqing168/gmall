package cn.fenqing168.gmall.modules.catalog.controller;

import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog2;
import cn.fenqing168.gmall.modules.catalog.service.IPmsBaseCatalog2Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsBaseCatalog2Controller {

    @Reference
    private IPmsBaseCatalog2Service iPmsBaseCatalog2Service;

    @PostMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam Long catalog1Id){
        List<PmsBaseCatalog2> pmsBaseCatalog2s = iPmsBaseCatalog2Service.getCatalog2(catalog1Id);
        return pmsBaseCatalog2s;
    }

}
