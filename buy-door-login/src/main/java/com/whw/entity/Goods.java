package com.whw.entity;


import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Goods {

        private Long id;

        private String name;

        private Integer price;

        @Version
        private Integer version;

    }

