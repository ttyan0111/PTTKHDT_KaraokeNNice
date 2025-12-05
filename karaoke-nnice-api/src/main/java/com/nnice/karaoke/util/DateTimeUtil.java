package com.nnice.karaoke.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Tiện ích xử lý ngày giờ
 */
public class DateTimeUtil {
    
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    /**
     * Format LocalDateTime thành String
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return "";
        return dateTime.format(DEFAULT_FORMATTER);
    }
    
    /**
     * Format LocalDateTime thành ngày (dd/MM/yyyy)
     */
    public static String formatDate(LocalDateTime dateTime) {
        if (dateTime == null) return "";
        return dateTime.format(DATE_FORMATTER);
    }
    
    /**
     * Format LocalDateTime thành giờ (HH:mm:ss)
     */
    public static String formatTime(LocalDateTime dateTime) {
        if (dateTime == null) return "";
        return dateTime.format(TIME_FORMATTER);
    }
    
    /**
     * Parse String thành LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) return null;
        return LocalDateTime.parse(dateTimeStr, DEFAULT_FORMATTER);
    }
    
    /**
     * Tính số giờ giữa hai thời điểm
     */
    public static long calculateHours(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return ChronoUnit.HOURS.between(start, end);
    }
    
    /**
     * Tính số phút giữa hai thời điểm
     */
    public static long calculateMinutes(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return ChronoUnit.MINUTES.between(start, end);
    }
    
    /**
     * Tính số ngày giữa hai thời điểm
     */
    public static long calculateDays(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) return 0;
        return ChronoUnit.DAYS.between(start, end);
    }
    
    /**
     * Kiểm tra xem thời điểm đã qua chưa
     */
    public static boolean isPast(LocalDateTime dateTime) {
        if (dateTime == null) return false;
        return dateTime.isBefore(LocalDateTime.now());
    }
    
    /**
     * Kiểm tra xem thời điểm còn chưa đến
     */
    public static boolean isFuture(LocalDateTime dateTime) {
        if (dateTime == null) return false;
        return dateTime.isAfter(LocalDateTime.now());
    }
    
    /**
     * Lấy thời gian hiện tại
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
