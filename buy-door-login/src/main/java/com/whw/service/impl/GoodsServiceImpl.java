package com.whw.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whw.entity.Goods;
import com.whw.mapper.GoodsMapper;
import com.whw.service.GoodsService;
import org.springframework.stereotype.Service;

@DS("slave_1")
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
