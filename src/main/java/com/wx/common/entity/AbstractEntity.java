package com.wx.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.google.common.base.Objects;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    private Long id;

    private Date createTime;

    private Date updateTime;

    @Version
    private Integer lockVersion = 0;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getId()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (getId() == null) {
            return false;
        }
        return Objects.equal(getId(), ((AbstractEntity) obj).getId());
    }
}
