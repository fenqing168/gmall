package cn.fenqing168.gmall.modules.mumber.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class UmsMemberReceiveAddress implements Serializable {
    private Long id;
    private Long memberId;
    private String name;
    private String phoneNumber;
    private Long defaultStatus;
    private String postCode;
    private String province;
    private String city;
    private String region;
    private String detailAddress;
}
