package com.imut.mapper;

import com.imut.pojo.DetailsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/19 12:07
 */
public interface DetailsInfoMapper {

    @Select("select * from details_info order by id")
    List<DetailsInfo> findAll();

    @Insert("insert into details_info(dt_user_telephone,dt_user_address,dt_user_illness,dt_user_image01,dt_user_image02,dt_user_image03,dt_user_image04,dt_user_image05)" +
            "values(#{dtUserTelephone},#{dtUserAddress},#{dtUserIllness},#{dtUserImage01},#{dtUserImage02},#{dtUserImage03},#{dtUserImage04},#{dtUserImage05})")
    void insert(DetailsInfo detailsInfo);

    @Select("select * from where dt_user_telephone = #{dtUserTelephone}")
    DetailsInfo findByTelephone();
}
