package cn.fenqing168.gmall.modules.attr.service.impl;

import cn.fenqing168.gmall.modules.attr.mapper.PmsBaseAttrValueMapper;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;
import cn.fenqing168.gmall.modules.attr.service.IPmsBaseAttrValueService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsBaseAttrValueServiceImpl implements IPmsBaseAttrValueService {

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        Example example = new Example(PmsBaseAttrValue.class);
        example.createCriteria().andEqualTo("attrId", attrId);
        return pmsBaseAttrValueMapper.selectByExample(example);
    }
}
