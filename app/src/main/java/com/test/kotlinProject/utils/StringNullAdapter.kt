package com.test.kotlinProject.utils

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

class StringNullAdapter : TypeAdapter<String>() {
    override fun write(jsonWriter: JsonWriter, value: String?) {
        if (value == null) {
            // jsonWriter.value("")
            jsonWriter.nullValue();
            return
        }
        jsonWriter.value(value)
    }

    override fun read(jsonReader: JsonReader): String? {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull()
            return ""
        }
        return jsonReader.nextString()
    }


}