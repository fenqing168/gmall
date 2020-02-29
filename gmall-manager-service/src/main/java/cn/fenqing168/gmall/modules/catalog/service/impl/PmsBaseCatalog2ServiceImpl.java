package cn.fenqing168.gmall.modules.catalog.service.impl;

import cn.fenqing168.gmall.modules.catalog.mapper.PmsBaseCatalog2Mapper;
import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog2;
import cn.fenqing168.gmall.modules.catalog.service.IPmsBaseCatalog2Service;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsBaseCatalog2ServiceImpl implements IPmsBaseCatalog2Service {

    @Autowired
    private PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Override
    public List<PmsBaseCatalog2> getCatalog2(Long catalog1Id) {
        Example example = new Example(PmsBaseCatalog2.class);
        example.createCriteria().andEqualTo("catalog1Id", catalog1Id);
        return pmsBaseCatalog2Mapper.selectByExample(example);
    }
}
