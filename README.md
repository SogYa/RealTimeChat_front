# CatChat
Многопользовательский онлайн чат
![Снимок экрана (2229)](https://user-images.githubusercontent.com/73115406/154502355-541f3080-b407-40d8-ba13-d2ea82a3cfb1.png)
## Описание 
Основной проект, в рамках которого, я отрабатываю полученные навыки и знания. Приложение выступает аналогом известных социальных сетей, по типу телеграм, но отличается отсутствием различных каналов(чатов), при этом сохраняя остальной функционал. Пользователь также заводит аккаунт, в который вносит информацию о себе, а после чего начинает общение со всеми участниками чата. Помимо этого у него есть возможность просмотреть профили всех зарегистрированных пользователей.

В качестве серверной части проекта - используется __Google Firebase__. Приложение построено с использованием паттерна __MVVM__(использую __LiveData__).
## Модули
![Снимок экрана (2227)](https://user-images.githubusercontent.com/73115406/154504629-3acc65df-4b0c-4fe8-8c50-9953a3637a08.png)
Всего в приложении 8 экранов
* Стартовый экран. 
* Экран входа
* Экран регистрации
* Экран востановления пароля
* Главный экран чата
* Экран профиля
* Экран списка пользователей
* Экран профиля пользователя
## Что реализовано
* Регистрация/вход пользователей спомощью Firebase Authentication 
* Востановления пароля по email
* Профиль пользователя * Фотография * Имя * Почта * Возможность смены пароля * Редактирование информации * Выход их аккаунта
* Экран чата с сообщениями (Имя отправителя, текст и дата отправки) 
* Список пользователей (отображается статус активности) 
* Профили пользователей
## Что Планируется реализовать 
* Большее количество чатов
* Переход большей части приложения на фрагменты (_уже в работе_) 
* Локальное кеширование сообщений для нормальной работы уведомлений
* Пункт 'О себе'
* Экран __О чате__
* Голосовые сообщения
* Отправка файлов
