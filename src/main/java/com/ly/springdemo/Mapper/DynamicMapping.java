package com.ly.springdemo.Mapper;

import com.ly.springdemo.Entity.DynamicTable;
import com.ly.springdemo.Mapper.DynamicProvider.DynamicProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicMapping {

    @SelectProvider(type = DynamicProvider.class,method = "getIdByKey1AndKey2")
    public int getIdByKey1AndKey2(DynamicTable dynamicTable);
}
