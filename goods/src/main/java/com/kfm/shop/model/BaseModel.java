package com.kfm.shop.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel implements Serializable {
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
      */
    private Date updateTime;

    @TableField(exist = false)
    private Integer page = 1;
    @TableField(exist = false)
    private Integer Size = 5;
}
