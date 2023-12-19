package com.kfm.comm.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class BaseModel implements Serializable {
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     *更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private Integer page = 1;
    @TableField(exist = false)
    private Integer Size = 10;
}
