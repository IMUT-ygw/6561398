package com.imut.dao;

import com.imut.entities.YjqOperationLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.boot.json.YamlJsonParser;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/7 9:36
 */
@Mapper
public interface YjqOperationLogDao {


    @Select("select * from yjq_operation_log order by id")
    @Results(id = "yjqLog",value = {
            @Result(property = "yjqDate",column = "yjq_date",jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="id" ,column = "id",jdbcType = JdbcType.INTEGER),
            @Result(property = "yjqDescribe",column = "yjq_describe",jdbcType = JdbcType.VARCHAR )
    })
    List<YjqOperationLog> findAll();

    @Delete("truncate table yjq_operation_log;")
    void deleteLog();

    @Insert("insert into yjq_operation_log(yjq_date,yjq_describe)values(#{yjqDate},#{yjqDescribe})")
    void addLog(YjqOperationLog yjqOperationLog);
}
