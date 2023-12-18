package  com.kfm.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import  com.kfm.shop.model.Goods;
import  com.kfm.shop.service.GoodsService;
import  com.kfm.shop.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2023-12-18 16:02:38
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




