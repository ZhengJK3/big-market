package cn.chaZ.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @program: big-market
 * @description: 规则树节点
 * @author: chaZ
 * @create: 2024-04-26 11:08
 **/

@Data
public class RuleTreeNode {

    /** 自增ID */
    private Long id;
    /** 规则树ID */
    private String treeId;
    /** 规则Key */
    private String ruleKey;
    /** 规则描述 */
    private String ruleDesc;
    /** 规则比值 */
    private String ruleValue;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}

