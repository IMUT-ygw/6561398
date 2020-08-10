package com.godjob.service;

import com.godjob.entity.HelperImage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/17 14:22
 */
public class HelpImageProvider extends SQL {
    private static final String TABLE_NAME = "helper_image";
    public static String updateApp(@Param("helpImage")HelperImage helperImage){
        return new SQL(){
            {
                UPDATE(TABLE_NAME);
                if (!StringUtils.isEmpty(helperImage.getImage02())) {
                    SET("image02 = #{image02}");
                }
                if (!StringUtils.isEmpty(helperImage.getImage03())) {
                    SET("image03 = #{image03}");
                }
                if (!StringUtils.isEmpty(helperImage.getImage04())) {
                    SET("image04 = #{image04}");
                }
                if (!StringUtils.isEmpty(helperImage.getImage05())) {
                    SET("image05 = #{image05}");
                }
                WHERE("image_id = #{imageId}" );
            }}.toString();
            }
        }

