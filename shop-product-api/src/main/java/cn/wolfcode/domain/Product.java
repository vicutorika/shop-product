package cn.wolfcode.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuxinyu
 * @date 2023/2/5
 * @apiNote
 */
@Getter
@Setter
@ToString
@TableName("t_product")
public class Product implements Serializable {
    @TableId(type= IdType.AUTO)
    private Long id;//主键
    private String name;//商品名称
    private Double price;//商品价格
    private Integer stock;//库存
}