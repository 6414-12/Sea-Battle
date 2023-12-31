# Морской бой по сети

Проект "Морской бой по сети" - это компьютерная игра, которая позволяет играть в классическую игру "Морской бой" с другими игроками через сеть.

## Описание

Этот проект реализует игру "Морской бой", где игроки могут сражаться друг с другом по сети. 
Игра основана на классическом правиле, где каждый игрок размещает свои корабли на игровом поле и пытается обнаружить и уничтожить корабли противника.
Более детальные правила:
### Правила размещения кораблей (флота)
Игровое поле — обычно квадрат 10×10 у каждого игрока, на котором размещается флот кораблей.

Размещаются:
* 1 корабль — ряд из 4 клеток («четырёхпалубный»; линкор)
* 2 корабля — ряд из 3 клеток («трёхпалубные»; крейсера)
* 3 корабля — ряд из 2 клеток («двухпалубные»; эсминцы)
* 4 корабля — 1 клетка («однопалубные»; торпедные катера)

Другой вариант названия кораблей: «…-трубные» (напр. двухтрубные).

При размещении корабли не могут касаться друг друга сторонами и углами.

Рядом со «своим» полем размещается «чужое» такого же размера, только пустое. Это участок моря, где плавают корабли противника.

При попадании в корабль противника — на чужом поле ставится крестик, при холостом выстреле — точка. Попавший стреляет ещё раз.

### Потопление кораблей противника
Перед началом боевых действий игроки бросают жребий или договариваются, кто будет ходить первым.

Игрок, выполняющий ход, совершает выстрел.

1. Если выстрел пришёлся в клетку, не занятую ни одним кораблём противника, то следует ответ «Мимо!» и стрелявший игрок ставит на чужом квадрате в этом месте точку. Право хода переходит к сопернику.
2. Если выстрел пришёлся в клетку, где находится многопалубный корабль (размером больше чем 1 клетка), то следует ответ «Ранил!» или «Попал!», кроме одного случая (см. пункт 3). Стрелявший игрок ставит на чужом поле в эту клетку крестик, а его противник ставит крестик на своём поле также в эту клетку. Стрелявший игрок получает право на ещё один выстрел.
3. Если выстрел пришёлся в клетку, где находится однопалубный корабль, или последнюю непоражённую клетку многопалубного корабля, то следует ответ «Убил!» или «Потопил!». Оба игрока отмечают потопленный корабль на листе. Стрелявший игрок получает право на ещё один выстрел.

Победителем считается тот, кто первым потопит все 10 кораблей противника. Проигравший имеет право попросить изучить после окончания игры у соперника игровое поле. Если проигравший находит какое-нибудь нарушение правил (см. ниже), то победа присуждается ему. Первоначальный победитель в свою очередь может попросить у соперника игровое поле для поиска нарушений. Если он их находит, то игроки сверяют чужие поля друг у друга. Если никаких несоответствий не замечено, то игра не засчитывается (оба проиграли). Тот, у кого чужое поле будет неверным (причём доказуемо неверным), будет проигравшим, а его соперник победителем. Игра также может закончиться раньше, чем будут потоплены все корабли, если нарушение правил будет замечено в течение игры. Проигравшим в этом случае будет считаться тот, у кого обнаружат нарушение правил, хотя он тоже может попросить игровое поле у соперника для поиска нарушений.

## Особенности

- Игра по сети: игроки могут играть друг с другом через сеть.
- Графический интерфейс: игра имеет простой и интуитивно понятный графический интерфейс пользователя.

## Требования

Для запуска проекта необходимо:

## Установка и запуск

1. Клонируйте репозиторий на локальную машину:

```
git clone https://github.com/6414-12/Sea-Battle
```

## Разработчики

- Кажуков П.В. - sanpavkaz@gmail.com
- Поняев Д.А. - my.login26@gmail.com
- Кветкин В.А. - kvetkin-vas@mail.ru
