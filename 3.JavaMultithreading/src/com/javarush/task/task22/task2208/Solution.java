package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
country = 'Ukraine' and city = 'Kiev' and name = 'Ivanov'

Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age","null");

        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        /*String result = "";
        if (params == null) return result.toString();
        StringBuilder whereQuery = new StringBuilder();
        for (Map.Entry<String,String> item: params.entrySet()) {
            if (!item.getValue().equals("null")) {
                if (whereQuery.length()>0) whereQuery.append(" and ");
                whereQuery.append(item.getKey());
                whereQuery.append(" = ");
                whereQuery.append("'");
                whereQuery.append(item.getValue());
                whereQuery.append("'");
                //if (cnt < params.size() - 1) whereQuery.append(" and ");
            }
        }
        result = whereQuery.toString().trim();
        return result;*/
        String result = "";
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : params.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(value!=null){
                if(sb.length()>0)sb.append(" and ");
                sb.append(key);
                sb.append(" = '");
                sb.append(value);
                sb.append("'");
            }
        }
        return sb.toString();
    }
}
