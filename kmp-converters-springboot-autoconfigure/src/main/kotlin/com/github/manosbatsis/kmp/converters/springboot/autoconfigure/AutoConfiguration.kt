package com.github.manosbatsis.kmp.converters.springboot.autoconfigure

import com.github.manosbatsis.kmp.converters.jpa.BasePackage
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration

@Configuration
@EntityScan(
    basePackageClasses = [
        BasePackage::class,
    ]
)
open class AutoConfiguration
