// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class ex1 {
    public static void main(String[] args) {

        StringBuilder request = new StringBuilder();   
        String[] str = {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"};
           
        for (int i = 0; i < str.length; i++) {
            if (str[i].indexOf("null") == (-1)) {                            
                request.append(str[i].replace(":", "="));
                if (i != str.length - 2) {                                       
                    request.append(" AND ");
                }
            }
        }
        System.out.println(request);                                      
    }
}