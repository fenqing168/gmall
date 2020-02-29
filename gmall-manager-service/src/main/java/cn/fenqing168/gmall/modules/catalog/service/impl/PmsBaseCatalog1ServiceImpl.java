package cn.fenqing168.gmall.modules.catalog.service.impl;

import cn.fenqing168.gmall.modules.catalog.mapper.PmsBaseCatalog1Mapper;
import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog1;
import cn.fenqing168.gmall.modules.catalog.service.IPmsBaseCatalog1Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsBaseCatalog1ServiceImpl implements IPmsBaseCatalog1Service {

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }
}
