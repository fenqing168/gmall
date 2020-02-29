package cn.fenqing168.gmall.modules.catalog.service.impl;

import cn.fenqing168.gmall.modules.catalog.mapper.PmsBaseCatalog3Mapper;
import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog3;
import cn.fenqing168.gmall.modules.catalog.service.IPmsBaseCatalog3Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsBaseCatalog3ServiceImpl implements IPmsBaseCatalog3Service {

    @Autowired
    private PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog3> getCatalog3(Long catalog2Id) {
        Example example = new Example(PmsBaseCatalog3.class);
        example.createCriteria().andEqualTo("catalog2Id", catalog2Id);
        return pmsBaseCatalog3Mapper.selectByExample(example);
    }
}
