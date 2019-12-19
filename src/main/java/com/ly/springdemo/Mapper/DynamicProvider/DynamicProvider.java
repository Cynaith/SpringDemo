package com.ly.springdemo.Mapper.DynamicProvider;

import com.ly.springdemo.Entity.DynamicTable;
import org.apache.ibatis.jdbc.SQL;

public class DynamicProvider {

    public String getIdByKey1AndKey2(DynamicTable dynamicTable){
        return new SQL(){
            {
                SELECT("u.id");
                FROM("dynamic_table dt");
                INNER_JOIN("user u on dt.id = u.id");
                if(dynamicTable.getKey1()!=null){
                    WHERE("dt.key1 = #{key1}");
                }
                if(dynamicTable.getKey2()!=null){
                    WHERE("dt.key2 = #{key2}");
                }
                WHERE("u.name = name");
            }
        }.toString();
    }
}
