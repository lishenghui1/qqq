package com.hhh.jjj.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.mybatis.spring.annotation.MapperScan;

@Data
public class Product {
    @TableId(type= IdType.AUTO)
    public Integer id;
    public String name;
    public String price;
    public Integer repertory;
}
