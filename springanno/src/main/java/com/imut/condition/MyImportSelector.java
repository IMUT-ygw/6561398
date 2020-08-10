package com.imut.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author nmtl_ygw
 * @Description  自定义快速注册组件
 * @date 2020/4/28 9:25
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值就是要导入容器的组件全类名
     *  annotationMetadata  : 获取当前标注import注解类的全部注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.imut.pojo.Quick01","com.imut.pojo.Quick02"};
    }
}
