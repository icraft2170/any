package com.lannstark.lec07

import java.io.BufferedReader
import java.io.FileReader

class KotlinFilePrinter {
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use {reader ->
            println(reader.readLine())
        }
    }
}