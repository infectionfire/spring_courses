package spring_introduction;

import org.springframework.context.annotation.*;

/*
Способ не использует сканирование пакетов и поиск бинов
Бины описываются в конфиг классе
Не использует @Autowired
Название метода-бин идентификатор
Аннотация @Bean перехватывает обращение к бину и регулирует его создание
 */

@Configuration
//@ComponentScan("spring_introduction") //скан имя пакета
@PropertySource("classpath:myApp.properties")
public class MyConfig {
        @Bean
        //если тут будет прототайп, то будет создаваться каждый раз новый бин
        @Scope("singleton")
        public Pet catBean(){
            //bean перехватывает запрос и этот код выполняется 1 раз
            return new Cat();
        }


        @Bean
        public Person personBean(){
            //bean catbean перехватывает запрос и либо создает либо возвращает созданный
            return new Person(catBean());

        }



}
