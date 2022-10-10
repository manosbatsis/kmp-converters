package com.github.manosbatsis.kmm.converters.elide.autoconfigure

import com.github.manosbatsis.kmm.converters.elide.BasePackage
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(
    basePackageClasses = [
        BasePackage::class,
    ]
)
open class AutoConfiguration
