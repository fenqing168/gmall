package cn.fenqing168.gmall.modules.catalog.service;

import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog3;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsBaseCatalog3Service {
    /**
     * 查询
     * @param catalog2Id
     * @return
     */
    List<PmsBaseCatalog3> getCatalog3(Long catalog2Id);
}
