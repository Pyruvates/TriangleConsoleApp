Инструкция по запуску.

1. Скомпилировать исходные файлы.

2. Собрать из скомпилированных файлов jar-файл.

3. При запуске в командной строке указать "java -jar *имя jar-файла*" и параметры запуска через пробел,
где первый параметр - это имя файла, из которого читаем данные,
а второй - имя файла, в который записываем данные.

*Примечание.*

Программа будет выполенна в том случае, если у пользователя есть права доступа к чтению и записи в файл,
 а так же читаемый файл не повреждён.


Если файла, в который записываем данные, не существует, он будет создан.

Если не нашлось ни одного треугольника, удовлетворяющего условию задачи, в консоль будет выведено 
соответствующее сообщение и будет создан пустой файл.

После выполнения программы в консоль будет выведено сообщение о завершении программы, 
а в файл будут записаны координаты, соответствущие условию задачи.

Если файл, в который записываются данные, уже существует, то после выполнения программы все данные 
в нём будут перезаписаны.

Программа будет прервана и в консоль будет выведено сообщение об ошибке в том случае, если:

1. параметры запуска указаны неверно (например, неправильное количество).

2. не найден файл, из которого считываются данные.