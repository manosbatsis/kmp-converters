package com.github.manosbatsis.kmm.converters.springboot.autoconfigure

import com.github.manosbatsis.kmm.converters.jpa.BasePackage
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration

@Configuration
@EntityScan(
    basePackageClasses = [
        BasePackage::class,
    ]
)
open class AutoConfiguration
