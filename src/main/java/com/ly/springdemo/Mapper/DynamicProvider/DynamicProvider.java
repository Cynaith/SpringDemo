package com.ly.springdemo.Mapper.DynamicProvider;

import com.ly.springdemo.Entity.DynamicTable;
import org.apache.ibatis.jdbc.SQL;

public class DynamicProvider {

    public String getIdByKey1AndKey2(DynamicTable dynamicTable){
        return new SQL(){
            {
                SELECT("id");
                FROM("dynamic_table");
                if(dynamicTable.getKey1()!=null){
                    WHERE("key1 = #{key1}");
                }
                if(dynamicTable.getKey2()!=null){
                    WHERE("key2 = #{key2}");
                }
            }
        }.toString();
    }
}
