package cn.fenqing168.gmall.modules.mumber.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fenqing
 */
@Data
public class UmsMember implements Serializable {
    private Long id;
    private Long memberLevelId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private Long status;
    private Date createTime;
    private String icon;
    private Long gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private Long sourceType;
    private Long integration;
    private Long growth;
    private Long luckeyCount;
    private Long historyIntegration;
}
