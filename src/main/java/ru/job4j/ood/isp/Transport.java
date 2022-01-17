package ru.job4j.ood.isp;

public interface Transport {
    public void swim();
    public void fly();
    public void drive();
}
/*
Нарушения принципа ISP, т.к с помощью данного интерфейса мы реализуем разные типа транспорта,
 которые не смогут использовать все типы передвижения*/
