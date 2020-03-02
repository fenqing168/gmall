package cn.fenqing168.gmall.modules.attr.service.impl;

import cn.fenqing168.gmall.modules.attr.dto.PmsBaseAttrInfoDto;
import cn.fenqing168.gmall.modules.attr.mapper.PmsBaseAttrInfoMapper;
import cn.fenqing168.gmall.modules.attr.mapper.PmsBaseAttrValueMapper;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrInfo;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;
import cn.fenqing168.gmall.modules.attr.service.IPmsBaseAttrInfoService;
import cn.fenqing168.gmall.modules.attr.vo.PmsBaseAttrInfoVo;
import cn.fenqing168.gmall.utils.FenqingDataUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<PmsBaseAttrInfoVo.Values> attrInfoList(Long catalog3Id) {
        Example example = new Example(PmsBaseAttrInfo.class);
        example.createCriteria().andEqualTo("catalog3Id", catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.selectByExample(example);
        List<PmsBaseAttrInfoVo.Values> values = FenqingDataUtil
                .parentsToChilds(pmsBaseAttrInfos, PmsBaseAttrInfoVo.Values.class);
        Set<Long> ids = values.stream().map(PmsBaseAttrInfoVo.Values::getId).collect(Collectors.toSet());

        Example inIds = new Example(PmsBaseAttrValue.class);
        inIds.createCriteria().andIn("attrId", ids);

        List<PmsBaseAttrValue> pmsBaseAttrValues = ids.isEmpty() ? new ArrayList<>()
                : pmsBaseAttrValueMapper.selectByExample(inIds);

        FenqingDataUtil.pairingO2m(values, pmsBaseAttrValues
                , (item, o) -> item.setAttrValueList((List)o)
                , PmsBaseAttrInfoVo.Values::getId
                , PmsBaseAttrValue::getAttrId
                , List.class);
        return values;
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
