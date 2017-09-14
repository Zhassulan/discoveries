# discoveries
GreetGo task for job candidates

IDE - Eclipse Java EE Oxygen

1. Установить ПО окружения. Скачать и установить следующее ПО Oracle JRE 1.8, Git, Maven, Mysql Community Server.
2. Подготовка БД. Выполнить SQL скрипт "discoveries.sql", находящегося в корне проекта. Создать пользователя mybatis с паролем "4FFQbP12". Предоставить права "CRUD" к БД "discoveries". В случае если сервер СУБД не локальный, указать хост в файле "..\discoveries\src\main\resources\static\file\config.properties" в параметре "mysql.url" заменить слово "localhost" на ваш хост.
3. Скачать проект. В командной строке Git выполнить команду "git clone https://github.com/Zhassulan/discoveries.git".
4. Запустить Maven  командой "clean install" в корне проекта. Запускной класс kz.ztokbayev.greetgo.discoveries.App
