package com.nth.demoserver


import org.apache.commons.io.IOUtils
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.InputStream


@RestController
class ControlManager {

    @GetMapping("/")
    fun getHome(): Any {
        return "Nguyễn Tiến Hòa"
    }

    @GetMapping("/api/getImg", produces = arrayOf(MediaType.IMAGE_JPEG_VALUE))
    fun getImg(
            @RequestParam(value = "imgName", required = true) name: String): ByteArray? {
        val input = ClassPathResource("Images/$name").inputStream

        return IOUtils.toByteArray(input)
    }


}