package com.example.graduation.util;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by DongChenchen on 2017/4/5.
 */
public class ToExcelUtils {

    /**
     *
     * @param data 要保存的集合
     * @param path  保存路径
     * @param title 文件标题
     * @param inline  对象内的对象属性
     * @param <T>
     * @param <K>   对象内的对象
     */
    public static <T,K> HSSFWorkbook toExcelFile(Collection<T> data,String title, K inline) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(title);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //设置值表头
        HSSFCell cell = null;
        Object[] objects = data.toArray();
        int len=objects.length;
        if (len>0&&!StringUtils.isEmpty(objects[0])) {
            T t = (T)objects[0];
            Field[] fields = t.getClass().getDeclaredFields();
            String[] head = new String[fields.length];
            short j = 0;
            for (Field field : fields) {
                String name = field.getName();
                if (!StringUtils.isEmpty(name)) {
                    head[j++] = name;
                }
            }
            short idx = 0;
            for (String col : head) {
                cell = row.createCell(idx++);
                cell.setCellValue(col);
                cell.setCellStyle(style);
            }
        }

    // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
    for(int i=0;i<len;i++){
        row = sheet.createRow(i + 1);
        T entity = (T)objects[i];
        // 第四步，创建单元格，并设置值
        Field[] fields = entity.getClass().getDeclaredFields();
        short j = 0;
        for (Field field : fields) {
            String name = field.getName();
            Object value = null;
            if (!StringUtils.isEmpty(name)) {
                value = getFieldValue(entity,name);
            }

            Class<K> inline1=(Class<K>)inline;
            String str = inline1.getSimpleName();
            String fieldValue=" ";
            if(!StringUtils.isEmpty(value)){
                String simpleName = value.getClass().getSimpleName();
                if(simpleName.equals(str)) {//---------------1.对象属性------------------
                    Field[] fields1 = inline1.getDeclaredFields();
                    //查找含有姓名的字段
                    Field res = null;
                    for (Field field1 : fields1) {
                        String name1 = field1.getName();
                        String[] split = name1.split("^[a-z|A-Z]*[n|N]ame$");
                        if (split.length ==0) { //匹配时，返回空数组
                            res = field1;
                            break;
                        }
                    }
                    //获取name值
                    if(res!=null) {
                        String teName=res.getName();
                        Object obj = getFieldValue((K)value, teName);
                        if(obj!=null) {
                            fieldValue = getFieldValue((K)value, teName).toString();
                        }
                    }
                }else{  //---------------2.普通属性------------------
                    fieldValue=value.toString();
                }
            }
            row.createCell(j++).setCellValue(fieldValue);
        }
    }
    // 第六步，将文件存到指定位置
//    try {
//        FileOutputStream fout = new FileOutputStream(path);
//        wb.write(fout);
//        fout.close();
//    }catch(Exception e){
//        e.printStackTrace();
//    }
        return wb;

}

    /**
     * 通过反射，用属性名称获得属性值
     * @param thisClass 需要获取属性值的类
     * @param fieldName 该类的属性名称
     * @return
     */
    private static Object getFieldValue(Object thisClass, String fieldName)
    {
        Object value = new Object();
        Method method = null;
        try {
            String methodName = "get"+fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
            method = thisClass.getClass().getMethod(methodName);
            value = method.invoke(thisClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
