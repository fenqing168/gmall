package cn.fenqing168.gmall.modules.attr.service.impl;

import cn.fenqing168.gmall.modules.attr.dto.PmsBaseAttrInfoDto;
import cn.fenqing168.gmall.modules.attr.mapper.PmsBaseAttrInfoMapper;
import cn.fenqing168.gmall.modules.attr.mapper.PmsBaseAttrValueMapper;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrInfo;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;
import cn.fenqing168.gmall.modules.attr.service.IPmsBaseAttrInfoService;
import cn.fenqing168.gmall.utils.FenqingDataUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsBaseAttrInfoServiceImpl implements IPmsBaseAttrInfoService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(Long catalog3Id) {
        Example example = new Example(PmsBaseAttrInfo.class);
        example.createCriteria().andEqualTo("catalog3Id", catalog3Id);
        return pmsBaseAttrInfoMapper.selectByExample(example);
    }

    @Override
    public void saveAttrInfo(PmsBaseAttrInfoDto pmsBaseAttrInfoDto) {
        Long id = pmsBaseAttrInfoDto.getId();
        PmsBaseAttrInfo pmsBaseAttrInfo = pmsBaseAttrInfoDto;
        if(id != null){
            pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);
            Example delExample = new Example(PmsBaseAttrValue.class);
            delExample.createCriteria().andEqualTo("attrId", pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.deleteByExample(delExample);
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfoDto.getAttrValueList();
            attrValueList.forEach(attrValue -> {
                attrValue.setId(null);
                attrValue.setAttrId(pmsBaseAttrInfo.getId());
            });
            if(!attrValueList.isEmpty()){
                pmsBaseAttrValueMapper.inserts(attrValueList);
            }
        }else{
            pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);

            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfoDto.getAttrValueList();
            attrValueList.forEach(attrValue -> {
                attrValue.setAttrId(pmsBaseAttrInfo.getId());
            });

            if(!attrValueList.isEmpty()){
                pmsBaseAttrValueMapper.inserts(attrValueList);
            }
        }
    }
}
