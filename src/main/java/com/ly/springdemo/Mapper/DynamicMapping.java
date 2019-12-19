package com.ly.springdemo.Mapper;

import com.ly.springdemo.Entity.DynamicTable;
import com.ly.springdemo.Mapper.DynamicProvider.DynamicProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheNamespace
public interface DynamicMapping {


    @SelectProvider(type = DynamicProvider.class,method = "getIdByKey1AndKey2")
    public int getIdByKey1AndKey2(DynamicTable dynamicTable);

    @Insert({"insert into dynamic_table(key1,key2) values(#{key1},#{key2})"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int saveDynamic(DynamicTable dynamicTable);
}
