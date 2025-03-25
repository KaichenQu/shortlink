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
    if (Strings.isNullOrEmpty(phone)) {
      return phone;
    }

    String digitsOnly = phone.replaceAll("[^0-9]", "");

    if (digitsOnly.length() < 7) {
      return phone;
    }

    String countryCode = "";
    String remainingNumber = digitsOnly;

    if (digitsOnly.startsWith("1") && digitsOnly.length() == 11) {
      countryCode = "+1";
      remainingNumber = digitsOnly.substring(1);
    } else if (digitsOnly.startsWith("86") && digitsOnly.length() == 11) {

      countryCode = "+86";
      remainingNumber = digitsOnly.substring(2);
    } else if (digitsOnly.length() > 10) {
      countryCode = "+" + digitsOnly.substring(0, 3);
      remainingNumber = digitsOnly.substring(3);
    }

    return countryCode + " " +
        remainingNumber.substring(0, 3) + "-***-**" +
        remainingNumber.substring(remainingNumber.length() - 2);

  }


}