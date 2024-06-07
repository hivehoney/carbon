package com.carbon.emissions.util;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Component
public class ExcelUtil {
    public <T> ByteArrayOutputStream generateExcel(List<T> entities, Class<T> entityType) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(entityType.getSimpleName());

            Field[] fields = entityType.getDeclaredFields();
            String[] columns = new String[fields.length];

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                columns[i] = fields[i].getName();
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Create data rows
            int rowNum = 1;
            for (T entity : entities) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 0; i < fields.length; i++) {
                    Object value = fields[i].get(entity);
                    row.createCell(i).setCellValue(value != null ? value.toString() : "");
                }
            }

            // Resize all columns to fit the content size
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return out;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access entity field", e);
        }
    }

}
