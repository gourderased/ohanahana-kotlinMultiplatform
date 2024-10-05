package com.jetbrains.kmpapp

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.refTo
import platform.Foundation.NSBundle
import platform.Foundation.NSData
import platform.Foundation.dataWithContentsOfFile
import platform.posix.memcpy

@OptIn(ExperimentalForeignApi::class)
actual fun loadFontData(fontName: String): ByteArray {
    val bundle = NSBundle.mainBundle
    val path = bundle.pathForResource(fontName, ofType = null)
        ?: throw Exception("Font file $fontName not found in bundle")
    val data = NSData.dataWithContentsOfFile(path)
        ?: throw Exception("Unable to load font data for $fontName")
    val bytes = ByteArray(data.length.toInt())
    memcpy(bytes.refTo(0), data.bytes, data.length)
    return bytes
}