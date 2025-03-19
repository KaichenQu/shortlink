package com.kelsonq.shortlink.admin.common.serialize;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Strings;
import java.io.IOException;

public class PhoneDesensitizationSerializer extends JsonSerializer<String> {

  @Override
  public void serialize(String phone, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    String phoneDesensitization = maskPhone(phone);
    jsonGenerator.writeString(phoneDesensitization);
  }

  private String maskPhone(String phone) {
    if (Strings.isNullOrEmpty(phone) || phone.length() < 5) {
      return phone; // phone number is too short, no need to mask
    }
    int length = phone.length();
    int maskedNum = Math.min(4, length - 4);
    String maskedPart = Strings.repeat("*", maskedNum);

    return phone.substring(0, 3) + maskedPart + phone.substring(3 + maskedNum);
  }
}