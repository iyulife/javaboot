package io.javaboot.starter.cloud.feign;

import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static io.javaboot.core.contants.DateConstants.*;

/**
 * Description: 解决时间格式入参和出参问题
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
public class CustomFeignFormatterRegistrar implements FeignFormatterRegistrar {

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addConverter(Date.class, String.class, new Date2StringConverter());
        registry.addConverter(LocalDateTime.class, String.class, new LocalDateTime2StringConverter());
        registry.addConverter(LocalDate.class, String.class, new LocalDate2StringConverter());
        registry.addConverter(LocalTime.class, String.class, new LocalTime2StringConverter());
    }

    private static class Date2StringConverter implements Converter<Date, String> {
        @Override
        public String convert(Date source) {
            if (source == null) {
                return null;
            }
            return new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT).format(source);
        }
    }

    private static class LocalDateTime2StringConverter implements Converter<LocalDateTime, String> {
        @Override
        public String convert(LocalDateTime source) {
            if (source == null) {
                return null;
            }
            return source.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
        }
    }

    private static class LocalDate2StringConverter implements Converter<LocalDate, String> {
        @Override
        public String convert(LocalDate source) {
            if (source == null) {
                return null;
            }
            return source.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
        }
    }

    private static class LocalTime2StringConverter implements Converter<LocalTime, String> {
        @Override
        public String convert(LocalTime source) {
            if (source == null) {
                return null;
            }
            return source.format(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
        }
    }
}
